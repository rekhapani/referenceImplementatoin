package com.reference.order.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.reference.order.entity.OrderEntity;
import com.reference.order.repository.OrderMongoRepository;

@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {

	OrderController orderControllerMock;

	@Mock
	OrderMongoRepository orderRepositoryMock;
	@Before
	public void init() {
		//setUp("commitments");
		orderControllerMock = new OrderController(orderRepositoryMock);
	}
	@Test
	public void testAddOrder() throws Exception {

		OrderEntity orderEntity = new OrderEntity();
		orderEntity.setOrderId(123456);
		orderEntity.setBusinessUnit("Credit");
		orderEntity.setCorporateAccountId(1234567890);
		orderEntity.setDestinationArea("USA");
		orderEntity.setLineOfBusinessId(123456789);
		orderEntity.setOriginArea("INDIA");
		orderEntity.setServiceOffering("TRADING");

		OrderEntity locObj = new OrderEntity();
		locObj = orderEntity;

		when(orderRepositoryMock.save(orderEntity)).thenReturn(locObj);
		orderControllerMock.addOrder(orderEntity);

		assertEquals("Add Order Result: ", orderEntity.getOrderId(), locObj.getOrderId());
	}
	
	@Test
	public void testAddOrderFail() throws Exception {

		OrderEntity orderEntity = new OrderEntity();
		orderEntity.setOrderId(123456);
		orderEntity.setBusinessUnit("Credit");
		orderEntity.setCorporateAccountId(1234567890);
		orderEntity.setDestinationArea("USA");
		orderEntity.setLineOfBusinessId(123456789);
		orderEntity.setOriginArea("INDIA");
		orderEntity.setServiceOffering("TRADING");

		OrderEntity locObj = new OrderEntity();

//		when(orderRepositoryMock.save(orderEntity)).thenReturn(locObj);
		orderControllerMock.addOrder(locObj);

		assertNotEquals("Add Order Fail Result: ", orderEntity.getOrderId(), locObj.getOrderId());
	}

	@Test
	public void testGetOrder() throws Exception {

		OrderEntity orderEntity = new OrderEntity();
		orderEntity.setOrderId(123456);
		orderEntity.setBusinessUnit("Credit");
		orderEntity.setCorporateAccountId(1234567890);
		orderEntity.setDestinationArea("USA");
		orderEntity.setLineOfBusinessId(123456789);
		orderEntity.setOriginArea("INDIA");
		orderEntity.setServiceOffering("TRADING");

		Optional<OrderEntity> locObj = Optional.of(orderEntity);

		when(orderRepositoryMock.findById(orderEntity.getOrderId())).thenReturn(locObj);
		orderControllerMock.getOrder(orderEntity.getOrderId());

		assertEquals("Get Order Result: ", orderEntity.getOrderId(), locObj.get().getOrderId());
	}

	@Test
	public void testGetOrderFail() throws Exception {

		OrderEntity orderEntity = new OrderEntity();
		orderEntity.setOrderId(123456);
		orderEntity.setBusinessUnit("Credit");
		orderEntity.setCorporateAccountId(1234567890);
		orderEntity.setDestinationArea("USA");
		orderEntity.setLineOfBusinessId(123456789);
		orderEntity.setOriginArea("INDIA");
		orderEntity.setServiceOffering("TRADING");

		Optional<OrderEntity> locObj = Optional.of(orderEntity);
		locObj.get().setOrderId(654321);
		
		when(orderRepositoryMock.findById(orderEntity.getOrderId())).thenReturn(locObj);
		orderControllerMock.getOrder(orderEntity.getOrderId());

		assertEquals("Get Order Fail Result: ", orderEntity.getOrderId(), locObj.get().getOrderId());
		assertNotEquals(orderEntity, locObj);
	}
	
	@Test
	public void testUpdateOrder() throws Exception {

		OrderEntity orderEntity = new OrderEntity();
		orderEntity.setOrderId(123456);
		orderEntity.setBusinessUnit("Credit");
		orderEntity.setCorporateAccountId(1234567890);
		orderEntity.setDestinationArea("USA");
		orderEntity.setLineOfBusinessId(123456789);
		orderEntity.setOriginArea("INDIA");
		orderEntity.setServiceOffering("TRADING");

		OrderEntity locObj = new OrderEntity();
		locObj = orderEntity;
		locObj.setOrderId(654321);
		locObj.setBusinessUnit("Banking");

		when(orderRepositoryMock.save(orderEntity)).thenReturn(locObj);
		orderControllerMock.updateOrder(locObj);

		assertEquals("Update Order Result: ", "654321", locObj.getOrderId().toString());
	}
	
	@Test
	public void testUpdateOrderFail() throws Exception {

		OrderEntity orderEntity = new OrderEntity();
		orderEntity.setOrderId(123456);
		orderEntity.setBusinessUnit("Credit");
		orderEntity.setCorporateAccountId(1234567890);
		orderEntity.setDestinationArea("USA");
		orderEntity.setLineOfBusinessId(123456789);
		orderEntity.setOriginArea("INDIA");
		orderEntity.setServiceOffering("TRADING");

		OrderEntity locObj = new OrderEntity();
		locObj = orderEntity;
		locObj.setOrderId(654321);

		OrderEntity locObj2 = new OrderEntity();
//		when(orderRepositoryMock.save(orderEntity)).thenReturn(locObj);
		orderControllerMock.updateOrder(locObj2);

		//assertNotEquals("Update Order Fail Result: ", "654321", locObj.getOrderId().toString());
		assertNotEquals(locObj2, orderEntity);
	}

	@Test
	public void testDeleteOrder() throws Exception {

		OrderEntity orderEntity = new OrderEntity();
		orderEntity.setOrderId(123456);
		orderEntity.setBusinessUnit("Credit");
		orderEntity.setCorporateAccountId(1234567890);
		orderEntity.setDestinationArea("USA");
		orderEntity.setLineOfBusinessId(123456789);
		orderEntity.setOriginArea("INDIA");
		orderEntity.setServiceOffering("TRADING");

		OrderEntity locObj = new OrderEntity();
		locObj = orderEntity;

		orderRepositoryMock.deleteById(orderEntity.getOrderId());
		orderControllerMock.deleteOrder(locObj.getOrderId());

		assertEquals("Delete Order Result: ", orderEntity.getOrderId(), locObj.getOrderId());
	}

}
