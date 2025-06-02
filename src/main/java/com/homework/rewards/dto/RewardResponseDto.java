package com.homework.rewards.dto;

import java.util.Map;

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
	private Map<String,Double> monthlyTransactions;
	private int totalRewardPoints;
	
	
}
