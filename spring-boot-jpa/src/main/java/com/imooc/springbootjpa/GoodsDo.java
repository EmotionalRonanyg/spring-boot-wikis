package com.imooc.springbootjpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 商品类
 */
@Entity // 表示这是一个数据对象类
@Table(name = "goods") // 对应数据库中的goods表
public class GoodsDo {
	/**
	 * 商品id
	 */
	@Id // 该字段对应数据库中的列为主键
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 主键自增长
	@Column(name = "id") // 对应goods表中的id列
	private Long id;
	/**
	 * 商品名称
	 */
	@Column(name = "name") // 对应goods表中的name列
	private String name;
	/**
	 * 商品价格
	 */
	@Column(name = "price") // 对应goods表中的price列
	private String price;
	/**
	 * 商品图片
	 */
	@Column(name = "pic") // 对应goods表中的pic列
	private String pic;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
