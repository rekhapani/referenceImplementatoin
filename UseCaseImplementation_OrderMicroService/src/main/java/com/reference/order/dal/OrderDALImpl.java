package com.reference.order.dal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.reference.order.entity.OrderEntity;

public class OrderDALImpl implements OrderDAL {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public List<OrderEntity> getAllEntity() {
		return mongoTemplate.findAll(OrderEntity.class);
	}

	@Override
	public OrderEntity getEntityByOrderId(Integer orderId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("orderId").is(orderId));
		return mongoTemplate.findOne(query, OrderEntity.class);
	}

}
