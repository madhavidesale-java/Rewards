package com.homework.rewards.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homework.rewards.dto.RewardResponseDto;
import com.homework.rewards.entity.Transactions;
import com.homework.rewards.repository.RewardsRepository;

@Service
public class RewardService {

	@Autowired
	RewardsRepository rewardRepository;

	public RewardResponseDto calculateRewardForCustomer(Long customerID, LocalDate from, LocalDate to)
			throws Exception {

		List<Transactions> listTransactions = rewardRepository.findByCustomerIdAndTransactionsDateBetween(customerID,
				from, to);
		int totalReward = 0;

		if (listTransactions.isEmpty()) {
			throw new Exception("Customer transaction not found");

		}

		for (Transactions t : listTransactions) {
			totalReward += calculateReward(t.getAmount());

		}
		System.out.println("Reward " + totalReward);
		return RewardResponseDto.builder().customerId(customerID)
				.customerName(listTransactions.get(0).getCustomerName()).totalRewardPoints(totalReward).build();

	}

	private int calculateReward(double amount) {
		int reward = 0;
		if (amount > 100) {
			reward += (int) ((amount - 100) * 2) + 50;
		}
		if (amount > 50 && amount < 100) {
			reward += amount;
		}

		return reward;
	}

}
