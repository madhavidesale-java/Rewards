package com.homework.rewards.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.homework.rewards.entity.Transactions;

@Repository
public interface RewardsRepository extends JpaRepository<Transactions, Long> {

	List<Transactions> findByCustomerIdAndTransactionsDateBetween(Long customerId, LocalDate from, LocalDate to);

}
