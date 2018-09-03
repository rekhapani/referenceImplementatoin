package com.reference.commitment.dal;

import java.util.List;

import com.reference.commitment.entity.CommitmentEntity;

public interface CommitmentService {

	List<CommitmentEntity> getAllEntity();

	CommitmentEntity getEntityByCommitmentId(Integer commitmentId);
}
