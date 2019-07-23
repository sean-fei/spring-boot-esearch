package com.sean.esearch.service;

import com.sean.esearch.model.Item;
import com.sean.esearch.model.Search;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;

import java.util.List;

/**
 * @author sean (yunfei_li@qq.com)
 * @version 1.0
 * @date 2019/7/18 11:06
 */
public interface ItemService {

    Item save(Item item);

    Iterable<Item> saveAll(List<Item> items);

    Iterable<Item> findAll(Sort sort);

    List<Item> findByPriceBetween(double price1, double price2);

    Page<Item> search(NativeSearchQuery searchQuery);

    Page<Item> search(Search search);

    Page<Item> searchByPage(int page, int size, Search search);

}
