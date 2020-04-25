package com.imooc.springbootrestful;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "商品API") // 类文档显示内容
@RestController
public class GoodsController {
	@Autowired
	private GoodsService goodsService;

	@ApiOperation(value = "根据id获取商品信息") // 接口文档显示内容
	@GetMapping("/goods/{id}")
	public GoodsDo getOne(@PathVariable("id") long id) {
		return goodsService.getGoodsById(id);
	}

	@ApiOperation(value = "获取商品列表") // 接口文档显示内容
	@GetMapping("/goods")
	public List<GoodsDo> getList() {
		return goodsService.getGoodsList();
	}

	@ApiOperation(value = "新增商品") // 接口文档显示内容
	@PostMapping("/goods")
	public void add(@RequestBody GoodsDo goods) {
		goodsService.addGoods(goods);
	}

	@ApiOperation(value = "根据id修改商品信息") // 接口文档显示内容
	@PutMapping("/goods/{id}")
	public void update(@PathVariable("id") long id, @RequestBody GoodsDo goods) {
		goods.setId(id);
		goodsService.editGoods(goods);
	}

	@ApiOperation(value = "根据id删除商品") // 接口文档显示内容
	@DeleteMapping("/goods/{id}")
	public void delete(@PathVariable("id") long id) {
		goodsService.removeGoods(id);
	}
}
