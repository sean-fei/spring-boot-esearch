package com.sean.esearch.repository;

import com.sean.esearch.model.Item;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *  @Description:定义ItemRepository 接口
 *  @Param:
 *   	Item:为实体类
 *   	Long:为Item实体类中主键的数据类型
 * @author sean (yunfei_li@qq.com)
 * @version 1.0
 * @date 2019/7/16 10:45
 */
//@Repository
public interface ItemRepository extends ElasticsearchRepository<Item, Long> {

    /**
     * @Description:根据价格区间查询
     * @Param price1
     * @Param price2
     * @Author: https://blog.csdn.net/chen_2890
     */
    List<Item> findByPriceBetween(double price1, double price2);

}
