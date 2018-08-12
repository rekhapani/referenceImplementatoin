package com.reference.order.repository;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

import com.reference.order.entity.OrderEntity;
//@Transactional
@Document
public interface OrderMongoRepository extends MongoRepository<OrderEntity,Integer>{

}
