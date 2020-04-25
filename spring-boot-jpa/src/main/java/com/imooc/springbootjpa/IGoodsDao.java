package com.imooc.springbootjpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * 商品数据操作接口
 */
@Repository
public interface IGoodsDao extends CrudRepository<GoodsDo, Long> {
}