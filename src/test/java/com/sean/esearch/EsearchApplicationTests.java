package com.sean.esearch;

import com.sean.esearch.model.Item;
import com.sean.esearch.service.ItemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableElasticsearchRepositories(basePackages = "com.sean.esearch")
public class EsearchApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    private ItemService itemService;

    /**
     * @Description:定义新增方法
     * @Author: https://blog.csdn.net/chen_2890
     */
    @Test
    public void insert() {
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

        itemService.saveAll(list);
    }

}
