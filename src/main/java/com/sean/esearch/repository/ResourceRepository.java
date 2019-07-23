package com.sean.esearch.repository;

import com.sean.esearch.model.Resource;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @author sean (yunfei_li@qq.com)
 * @version 1.0
 * @date 2019/7/16 10:44
 */
//@Repository
public interface ResourceRepository extends ElasticsearchRepository<Resource, Long> {
}
