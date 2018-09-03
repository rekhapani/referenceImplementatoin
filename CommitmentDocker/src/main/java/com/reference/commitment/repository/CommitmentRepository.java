package com.reference.commitment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reference.commitment.entity.CommitmentEntity;

//@Repository
public interface CommitmentRepository extends JpaRepository<CommitmentEntity, Integer> {

}
