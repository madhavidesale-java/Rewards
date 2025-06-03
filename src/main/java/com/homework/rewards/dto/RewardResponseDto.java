package com.homework.rewards.dto;

import java.util.List;
import java.util.Map;

import com.homework.rewards.entity.Transactions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RewardResponseDto {

	private Long customerId;
	private String customerName;
	private int customerAge;
	private Map<String, Double> monthlyTransactions;
	private int totalRewardPoints;
	private List<Transactions> transactions;

}
