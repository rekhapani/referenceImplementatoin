package com.reference.order.dal;

import java.util.List;

import com.reference.order.entity.OrderEntity;

public interface OrderDAL {

	List<OrderEntity> getAllEntity();

	OrderEntity getEntityByOrderId(Integer orderId);
}
