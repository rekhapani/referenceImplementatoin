package com.reference.commitment.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.reference.commitment.entity.CommitmentEntity;
import com.reference.commitment.repository.CommitmentRepository;

@RunWith(SpringJUnit4ClassRunner.class)
public class CommitmentControllerTest {

	CommitmentsController commitmentControllerMock;

	@MockBean
	CommitmentRepository commitmentRepositoryMock;

	@Before
	public void init() {
		//setUp("commitments");
		commitmentControllerMock = new CommitmentsController(commitmentRepositoryMock);
	}
	
	@Test
	public void testAddCommitment() throws Exception {

		CommitmentEntity commitmentEntity = new CommitmentEntity();
		commitmentEntity.setCommitmentId(123456);
		commitmentEntity.setCorporateAccountId(1234567890);
		commitmentEntity.setLineofBusineeId(123456789);
		commitmentEntity.setBusinessUnit("Credit");
		commitmentEntity.setServiceOffering("TRADING");
		commitmentEntity.setOriginArea("INDIA");
		commitmentEntity.setDestinationArea("USA");

		CommitmentEntity locObj = new CommitmentEntity();
		locObj = commitmentEntity;

		when(commitmentRepositoryMock.save(commitmentEntity)).thenReturn(locObj);
		commitmentControllerMock.addCommitment(commitmentEntity);

		assertEquals("Add Commitment Result: ", commitmentEntity.getCommitmentId(), locObj.getCommitmentId());
	}

	@Test
	public void testAddCommitmentFail() throws Exception {

		CommitmentEntity commitmentEntity = new CommitmentEntity();
		commitmentEntity.setCommitmentId(123456);
		commitmentEntity.setCorporateAccountId(1234567890);
		commitmentEntity.setLineofBusineeId(123456789);
		commitmentEntity.setBusinessUnit("Credit");
		commitmentEntity.setServiceOffering("TRADING");
		commitmentEntity.setOriginArea("INDIA");
		commitmentEntity.setDestinationArea("USA");

		CommitmentEntity locObj = new CommitmentEntity();

		commitmentControllerMock.addCommitment(locObj);

		assertNotEquals("Add Commitment Fail Result: ", commitmentEntity.getCommitmentId(), locObj.getCommitmentId());
	}

	@Test
	public void testGetCommitment() throws Exception {

		CommitmentEntity commitmentEntity = new CommitmentEntity();
		commitmentEntity.setCommitmentId(123456);
		commitmentEntity.setCorporateAccountId(1234567890);
		commitmentEntity.setLineofBusineeId(123456789);
		commitmentEntity.setBusinessUnit("Credit");
		commitmentEntity.setServiceOffering("TRADING");
		commitmentEntity.setOriginArea("INDIA");
		commitmentEntity.setDestinationArea("USA");

		Optional<CommitmentEntity> locObj = Optional.of(commitmentEntity);

		when(commitmentRepositoryMock.findById(commitmentEntity.getCommitmentId())).thenReturn(locObj);
		commitmentControllerMock.getCommitment(commitmentEntity.getCommitmentId());

		assertEquals("Get Commitment Result: ", commitmentEntity.getCommitmentId(), locObj.get().getCommitmentId());
	}

	@Test
	public void testGetCommitmentFail() throws Exception {

		CommitmentEntity commitmentEntity = new CommitmentEntity();
		commitmentEntity.setCommitmentId(123456);
		commitmentEntity.setCorporateAccountId(1234567890);
		commitmentEntity.setLineofBusineeId(123456789);
		commitmentEntity.setBusinessUnit("Credit");
		commitmentEntity.setServiceOffering("TRADING");
		commitmentEntity.setOriginArea("INDIA");
		commitmentEntity.setDestinationArea("USA");

		Optional<CommitmentEntity> locObj = Optional.of(commitmentEntity);
		locObj.get().setCommitmentId(654321);

		when(commitmentRepositoryMock.findById(commitmentEntity.getCommitmentId())).thenReturn(locObj);
		commitmentControllerMock.getCommitment(commitmentEntity.getCommitmentId());

		assertEquals("Get Order Fail Result: ", commitmentEntity.getCommitmentId(), locObj.get().getCommitmentId());
		assertNotEquals(commitmentEntity, locObj);
	}

	@Test
	public void testUpdateCommitment() throws Exception {

		CommitmentEntity commitmentEntity = new CommitmentEntity();
		commitmentEntity.setCommitmentId(123456);
		commitmentEntity.setCorporateAccountId(1234567890);
		commitmentEntity.setLineofBusineeId(123456789);
		commitmentEntity.setBusinessUnit("Credit");
		commitmentEntity.setServiceOffering("TRADING");
		commitmentEntity.setOriginArea("INDIA");
		commitmentEntity.setDestinationArea("USA");

		CommitmentEntity locObj = new CommitmentEntity();
		locObj = commitmentEntity;
		locObj.setCommitmentId(654321);
		locObj.setBusinessUnit("Banking");

		when(commitmentRepositoryMock.save(commitmentEntity)).thenReturn(locObj);
		commitmentControllerMock.updateCommitment(locObj);

		assertEquals("Update Order Result: ", "654321", locObj.getCommitmentId().toString());
	}

	@Test
	public void testUpdateCommitmentFail() throws Exception {

		CommitmentEntity commitmentEntity = new CommitmentEntity();
		commitmentEntity.setCommitmentId(123456);
		commitmentEntity.setCorporateAccountId(1234567890);
		commitmentEntity.setLineofBusineeId(123456789);
		commitmentEntity.setBusinessUnit("Credit");
		commitmentEntity.setServiceOffering("TRADING");
		commitmentEntity.setOriginArea("INDIA");
		commitmentEntity.setDestinationArea("USA");

		CommitmentEntity locObj = new CommitmentEntity();
		locObj = commitmentEntity;
		locObj.setCommitmentId(654321);

		CommitmentEntity locObj2 = new CommitmentEntity();

		commitmentControllerMock.updateCommitment(locObj2);

		// assertNotEquals("Update Commitment Fail Result: ", "654321",
		// locObj.getCommitmentId().toString());
		assertNotEquals(locObj2, commitmentEntity);
	}

	@Test
	public void testDeleteCommitment() throws Exception {

		CommitmentEntity commitmentEntity = new CommitmentEntity();
		commitmentEntity.setCommitmentId(123456);
		commitmentEntity.setCorporateAccountId(1234567890);
		commitmentEntity.setLineofBusineeId(123456789);
		commitmentEntity.setBusinessUnit("Credit");
		commitmentEntity.setServiceOffering("TRADING");
		commitmentEntity.setOriginArea("INDIA");
		commitmentEntity.setDestinationArea("USA");

		CommitmentEntity locObj = new CommitmentEntity();
		locObj = commitmentEntity;

		commitmentRepositoryMock.deleteById(commitmentEntity.getCommitmentId());
		commitmentControllerMock.deleteCommitment(locObj.getCommitmentId());

		assertEquals("Delete Commitment Result: ", commitmentEntity.getCommitmentId(), locObj.getCommitmentId());
	}

	@Test
	public void testCreateCommitment() throws Exception {

	}
}
