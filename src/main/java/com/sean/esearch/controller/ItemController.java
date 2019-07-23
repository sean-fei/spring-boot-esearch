package com.sean.esearch.controller;

import com.sean.esearch.model.Item;
import com.sean.esearch.model.Search;
import com.sean.esearch.service.ItemService;
import io.swagger.annotations.ApiOperation;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sean (yunfei_li@qq.com)
 * @version 1.0
 * @date 2019/7/18 13:27
 */
@Controller
@ResponseBody
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping("/init")
    @ApiOperation(value = "初始化基础数据", notes = "初始化基础数据")
    public Iterable<Item> init() {
        List<Item> list = new ArrayList<>();
        list.add(new Item(1L, "小米1", " 手机", "小米", 1999.00, "http://i1.mifile.cn/f/i/2019/mi9/specs/phone-1.png"));
        list.add(new Item(2L, "小米2", " 手机", "小米", 1999.00, "http://i1.mifile.cn/f/i/2019/mi9/specs/phone-1.png"));
        list.add(new Item(3L, "小米青春版", " 手机", "小米", 1699.00, "http://i1.mifile.cn/f/i/2019/mi9/specs/phone-1.png"));
        list.add(new Item(4L, "小米3", " 手机", "小米", 1799.00, "http://i1.mifile.cn/f/i/2019/mi9/specs/phone-1.png"));
        list.add(new Item(5L, "小米4", " 手机", "小米", 1899.00, "http://i1.mifile.cn/f/i/2019/mi9/specs/phone-1.pngg"));
        list.add(new Item(6L, "小米5", " 手机", "小米", 2099.00, "http://i1.mifile.cn/f/i/2019/mi9/specs/phone-1.png"));
        list.add(new Item(7L, "小米6", " 手机", "小米", 2199.00, "http://i1.mifile.cn/f/i/2019/mi9/specs/phone-1.png"));
        list.add(new Item(8L, "小米7", " 手机", "小米", 2299.00, "http://i1.mifile.cn/f/i/2019/mi9/specs/phone-1.png"));
        list.add(new Item(9L, "小米8", " 手机", "小米", 2399.00, "http://i1.mifile.cn/f/i/2019/mi9/specs/phone-1.png"));
        list.add(new Item(10L, "小米9", " 手机", "小米", 2499.00, "http://i1.mifile.cn/f/i/2019/mi9/specs/phone-1.png"));
        list.add(new Item(11L, "小米CC9", " 手机", "小米", 2599.00, "http://i1.mifile.cn/f/i/2019/mi9/specs/phone-1.png"));
        list.add(new Item(12L, "小米MIX3", " 手机", "小米", 2699.00, "http://i1.mifile.cn/f/i/2019/mi9/specs/phone-1.png"));

        return itemService.saveAll(list);
    }

    /**
     * 插入
     */
    @PostMapping("/create")
    @ApiOperation(value = "新增item对象", notes = "新增item对象")
    public Item create(@RequestBody Item item) {
        return itemService.save(item);
    }

    /**
     * 批量新增
     */
    @PostMapping("/cretae/all")
    @ApiOperation(value = "新增items对象", notes = "新增items对象")
    public Iterable<Item> insertList(@RequestBody List<Item> items) {
        return itemService.saveAll(items);
    }

    /**
     * 修改
     */
    @PostMapping("/update")
    @ApiOperation(value = "更新item对象", notes = "更新item对象")
    public void update(@RequestBody Item item){
        itemService.save(item);
    }

    /**
     * 查找所有
     */
    @GetMapping("/query/all")
    @ApiOperation(value = "查找所有", notes = "查找所有")
    public Iterable<Item> testQueryAll(){
        // 查找所有
        //Iterable<Item> list = this.itemRepository.findAll();
        // 对某字段排序查找所有 Sort.by("price").descending() 降序
        // Sort.by("price").ascending():升序
        return this.itemService.findAll(Sort.by("price").ascending());
    }

    /**
     * 按照价格区间查询
     */
    @GetMapping("/between")
    @ApiOperation(value = "按照价格区间查询", notes = "按照价格区间查询")
    public List<Item> queryByPriceBetween(@RequestParam(name = "price1") double price1, @RequestParam(name = "price2") double price2){
        return this.itemService.findByPriceBetween(price1, price2);
    }

    /**
     * 自定义查询
     */
    @GetMapping("/match/query")
    @ApiOperation(value = "自定义查询", notes = "自定义查询")
    public Page<Item> testMatchQuery(Search search){
        return this.itemService.search(search);
    }

    /**
     * 利用NativeSearchQueryBuilder可以方便的实现分页
     */
    @GetMapping("/search/page")
    @ApiOperation(value = "分页查询", notes = "分页查询")
    public Page<Item> searchByPage(@RequestParam(name = "page") int page, @RequestParam(name = "size") int size, Search search){
        return this.itemService.searchByPage(page, size, search);
    }

}
