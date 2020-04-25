
# 使用JdbcTemplate快速访问数据库

## 1. 实战场景

如果我们的项目非常简单，仅仅是对数据库几张表进行简单的增删改查操作，那么实际上直接使用JDBC操作数据库就可以了。

由于JDBC中有很多模板代码，每次都是加载驱动-建立数据库连接-查询或操作数据库-关闭数据库连接这样的模板代码，Spring提供了JdbcTemplate对原生JDBC进行了简单的封装。

本篇文章，我们就从头到尾，实现一个完整的、基于Spring Boot+JdbcTemplate+MySQL的商品管理系统。

## 2. 架构选型

数据库使用MySQL，商品信息存储到商品表内即可。

后端项目使用Spring Boot，通过控制器暴露Restful风格的接口供前端调用，通过JdbcTemplate实现对数据库的操作。

前端项目使用Bootstrap开发，通过jQuery提供的$.ajax方法访问后端接口。

## 3. 数据库模块实现

只需要一张商品表，保存商品相关的信息即可。我们使用Navicat新建数据库shop，并在其中新建数据表goods。
```sql
CREATE TABLE `goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一编号',
  `name` varchar(255) DEFAULT '' COMMENT '商品名称',
  `price` decimal(10,2) DEFAULT '0.00' COMMENT '商品价格',
  `pic` varchar(255) DEFAULT '' COMMENT '图片文件名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```
> **Tips:** 默认值最好不要采用NULL，NULL会影响索引的效率，而且在查询时需要用is null或is not null筛选，容易被忽略。

## 4. Spring Boot后端应用实现

我们新建一个Spring Boot项目，通过JdbcTemplate访问数据库，同时接口依旧采用Restful风格。
 
### 4.1 使用Spring Initializr创建项目

Spring Boot版本选择2.2.5，Group为`com.imooc`，Artifact为`spring-boot-jdbctemplate`，生成项目后导入Eclipse开发环境。

### 4.2 引入项目依赖

我们引入web项目依赖、热部署依赖。由于本项目需要访问数据库，所以引入`spring-boot-starter-jdbc`依赖和`mysql-connector-java`依赖。pom.xml文件中依赖项如下：
```xml
	    <!-- 热部署 -->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
		</dependency>
		<!-- web -->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		<!-- jdbc -->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-jdbc</artifactId>
		</dependency>
		<!-- myql驱动 -->
		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
		</dependency>
```

### 4.3 建立项目结构

依次新建以下类结构

 - GoodsDo，商品类，对应goods商品表。
 - GoodsDao，商品数据访问类，用于访问数据库。
 - GoodsService，商品服务类，用于封装对商品的操作。
 - GoodsController，商品控制器类，用于对外提供Http接口。

此时项目目录如下：

![图片描述](//img.mukewang.com/wiki/5e9403900993382607000201.jpg)

### 4.4 开发商品类

开发商品类GoodsDo，代码如下：
```java
/**
 * 商品类
 */
public class GoodsDo {
	/**
	 * 商品id
	 */
	private Long id;
	/**
	 * 商品名称
	 */
	private String name;
	/**
	 * 商品价格
	 */
	private String price;
	/**
	 * 商品图片
	 */
	private String pic;
	// 省略get set方法
```
### 4.5 新建商品数据访问类

商品数据访问类GoodsDao是本篇的重点，通过注入JdbcTemplate类型的组件，实现数据库操作。注入代码如下：
```java
/**
 * 商品数据库访问类
 */
@Repository // 标注数据访问类
public class GoodsDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
}
```
由于我们已经引入了`spring-boot-starter-jdbc`依赖，所以Spring Boot项目已经为我们自动配置了JdbcTemplate组件，我们拿来即用即可，这就是Spring Boot的强大之处！

此时我们启动应用，发现报错信息：
```java
***************************
APPLICATION FAILED TO START
***************************
Description:
Failed to configure a DataSource: 'url' attribute is not specified and no embedded datasource could be configured.
Reason: Failed to determine a suitable driver class
```
此处我们可以再度体会Spring Boot强大之处，Spring Boot在为我们自动配置了JdbcTemplate之余，还在尝试自动为我们配置数据源DataSource，即JdbcTemplate要操作的真实数据库信息。报错信息已经提示我们，没有合适的数据库驱动、也没有合适的url属性。

### 4.6 配置数据源信息

我们只需要通过配置文件指定数据源信息，Spring Boot就可以识别配置，并加载到数据源组件中。JdbcTemplate也可以自动识别该数据源，从而实现对数据库的操作。配置文件信息如下：
```properties
# 配置数据库驱动
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
# 配置数据库url
spring.datasource.url=jdbc:mysql://127.0.0.1:3306/shop?useUnicode=true&characterEncoding=utf-8
# 配置数据库用户名
spring.datasource.username=root
# 配置数据库密码
spring.datasource.password=123456

```
需要注意的是，我们在url配置中指定了编码方式，这样可以防止出现数据库中文乱码情况。

此时再次启动Spring Boot应用，正常运行，说明我们的数据源配置生效了。

### 4.7 通过JdbcTemplate操作数据库

通过JdbcTemplate进行增删改查操作非常简洁，Spring官方封装了原生JDBC中冗余的模板代码，使数据库访问操作更加简洁，代码如下：
```java
/**
 * 商品数据库访问类
 */
@Repository // 标注数据访问类
public class GoodsDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * 新增
	 */
	public void insert(GoodsDo goods) {
		jdbcTemplate.update("insert into goods(name,price,pic)values(?,?,?)", goods.getName(), goods.getPrice(),
				goods.getPic());
	}

	/**
	 * 删除
	 */
	public void delete(Long id) {
		jdbcTemplate.update("delete from goods where id =?", id);
	}

	/**
	 * 更新
	 */
	public void update(GoodsDo goods) {
		jdbcTemplate.update("update goods set name=?,price=?,pic=? where id=?", goods.getName(), goods.getPrice(),
				goods.getPic(), goods.getId());
	}

	/**
	 * 按id查询
	 */
	public GoodsDo getById(Long id) {
		return jdbcTemplate.queryForObject("select * from goods where id=?", new RowMapper<GoodsDo>() {
			@Override
			public GoodsDo mapRow(ResultSet rs, int rowNum) throws SQLException {
				GoodsDo goods = new GoodsDo();
				goods.setId(rs.getLong("id"));
				goods.setName(rs.getString("name"));
				goods.setPrice(rs.getString("price"));
				goods.setPic(rs.getString("pic"));
				return goods;
			}
		}, id);
	}

	/**
	 * 查询商品列表
	 */
	public List<GoodsDo> getList() {
		return jdbcTemplate.query("select * from goods", new RowMapper<GoodsDo>() {
			@Override
			public GoodsDo mapRow(ResultSet rs, int rowNum) throws SQLException {
				GoodsDo goods = new GoodsDo();
				goods.setId(rs.getLong("id"));
				goods.setName(rs.getString("name"));
				goods.setPrice(rs.getString("price"));
				goods.setPic(rs.getString("pic"));
				return goods;
			}
		});
	}
}
```
getById和getList方法中使用了匿名内部类，如果不了解的可以先去学习下相关知识。

### 4.8 开发商品服务类

商品服务类比较简单，直接调用GoodsDao完成商品服务方法封装即可。

```java
/**
 * 商品服务类
 */
@Service
public class GoodsService {
	@Autowired
	private GoodsDao goodsDao;
  
	/**
	 * 新增商品
	 */
	public void add(GoodsDo goods) {
		goodsDao.insert(goods);
	}

	/**
	 * 删除商品
	 */
	public void remove(Long id) {
		goodsDao.delete(id);
	}

	/**
	 * 编辑商品信息
	 */
	public void edit(GoodsDo goods) {
		goodsDao.update(goods);
	}

	/**
	 * 按id获取商品信息
	 */
	public GoodsDo getById(Long id) {
		return goodsDao.getById(id);
	}

	/**
	 * 获取商品信息列表
	 */
	public List<GoodsDo> getList() {
		return goodsDao.getList();
	}
}
```

### 4.9 开发商品控制器类

我们还是遵循之前的Restful风格，制定后端访问接口如下：

| 动词 | 接口含义 | 接口地址 | 
|-|-|-|
| GET  | 查询商品(id=1)信息| http://127.0.0.1:8080/goods/1  |
| GET | 查询商品列表信息| http://127.0.0.1:8080/goods |
| POST  | 新增商品| http://127.0.0.1:8080/goods |
| PUT | 修改商品(id=1)信息| http://127.0.0.1:8080/goods/1 |
| DELETE| 删除商品(id=1)| http://127.0.0.1:8080/goods/1 |

我们根据上面的接口列表，实现控制器类代码如下：
```java
/**
 * 商品控制器类
 */
@RestController
public class GoodsController {
	@Autowired
	private GoodsService goodsService;
	/**
	 * 按id获取商品信息
	 */
	@GetMapping("/goods/{id}")
	public GoodsDo getOne(@PathVariable("id") long id) {
		return goodsService.getById(id);
	}
	/**
	 * 获取商品列表
	 */
	@GetMapping("/goods")
	public List<GoodsDo> getList() {
		return goodsService.getList();
	}
	/**
	 * 新增商品
	 */
	@PostMapping("/goods")
	public void add(@RequestBody GoodsDo goods) {
		goodsService.add(goods);
	}
	/**
	 * 编辑商品
	 */
	@PutMapping("/goods/{id}")
	public void update(@PathVariable("id") long id, @RequestBody GoodsDo goods) {
		// 修改指定id的博客信息
		goods.setId(id);
		goodsService.edit(goods);
	}
	/**
	 * 移除商品
	 */
	@DeleteMapping("/goods/{id}")
	public void delete(@PathVariable("id") long id) {
		goodsService.remove(id);
	}
}
```