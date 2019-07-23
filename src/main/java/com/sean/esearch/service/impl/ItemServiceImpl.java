package com.sean.esearch.service.impl;

import com.sean.esearch.model.Item;
import com.sean.esearch.model.Search;
import com.sean.esearch.repository.ItemRepository;
import com.sean.esearch.service.ItemService;
import com.sean.esearch.utils.Constants;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author sean (yunfei_li@qq.com)
 * @version 1.0
 * @date 2019/7/18 11:08
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Item save(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public Iterable<Item> saveAll(List<Item> items) {
        return itemRepository.saveAll(items);
    }

    @Override
    public Iterable<Item> findAll(Sort sort) {
        return itemRepository.findAll(sort);
    }

    @Override
    public List<Item> findByPriceBetween(double price1, double price2) {
        return itemRepository.findByPriceBetween(price1, price2);
    }

    @Override
    public Page<Item> search(NativeSearchQuery searchQuery) {
        return itemRepository.search(searchQuery);
    }

    @Override
    public Page<Item> search(Search search) {
        NativeSearchQueryBuilder queryBuilder = this.buildQueryBuilder(search);
        // 搜索，获取结果
        return this.search(queryBuilder.build());
    }

    @Override
    public Page<Item> searchByPage(int page, int size, Search search) {
        NativeSearchQueryBuilder queryBuilder = this.buildQueryBuilder(search);
        queryBuilder.withPageable(PageRequest.of(page, size));
        // 搜索，获取结果
        return this.search(queryBuilder.build());
    }

    public NativeSearchQueryBuilder buildQueryBuilder(Search search) {
        // 构建查询条件
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        // 添加基本分词查询
        if(null != search && !StringUtils.isEmpty(search.getKey() ) && !StringUtils.isEmpty(search.getValue())) {
            if (Constants.MATCH_QUERY.equals(search.getCondition()) || StringUtils.isEmpty(search.getCondition())) {
                queryBuilder.withQuery(QueryBuilders.matchQuery(search.getKey(), search.getValue()));
            }
            if (Constants.FUZZY_QUERY.equals(search.getCondition())) {
                queryBuilder.withQuery(QueryBuilders.fuzzyQuery(search.getKey(), search.getValue()));
            }
        }
        return queryBuilder;
    }

}
