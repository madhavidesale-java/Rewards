package com.homework.rewards.service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homework.rewards.dto.RewardResponseDto;
import com.homework.rewards.entity.Transactions;
import com.homework.rewards.exception.TransactionNotFoundException;
import com.homework.rewards.repository.RewardsRepository;

@Service
public class RewardService {

	@Autowired
	private RewardsRepository rewardRepository;

	public RewardResponseDto calculateRewardForCustomer(Long customerID, LocalDate from, LocalDate to) {

		List<Transactions> listTransactions = rewardRepository.findByCustomerIdAndTransactionsDateBetween(customerID,
				from, to);
		int totalReward = 0;
		if (listTransactions.isEmpty()) {
			throw new TransactionNotFoundException("Customer transaction not found");

		}

		Map<String, Integer> monthlyRewards = new HashMap<>();
		for (Transactions t : listTransactions) {
			int point = calculateReward(t.getAmount());
			monthlyRewards.put(t.getTransactionsDate().getMonth().toString(), calculateReward(t.getAmount()));
			totalReward += point;

		}
		System.out.println("Total Reward " + totalReward);
		return RewardResponseDto.builder().customerId(customerID).customerAge(listTransactions.get(0).getCustomerAge())
				.monthlyRewards(monthlyRewards).customerName(listTransactions.get(0).getCustomerName())
				.totalRewardPoints(totalReward).transactions(listTransactions).build();

	}

	private int calculateReward(double amount) {
		int reward = 0;
		if (amount > 100) {
			reward += Math.round((amount - 100) * 2) + 50;
		}
		if (amount > 50 && amount < 100) {
			reward += amount - 50;
		}

		return reward;
	}

}
