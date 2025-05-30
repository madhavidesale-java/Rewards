package com.homework.rewards.dto;

import java.util.Map;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RewardResponseDto {
	
	private Long customerId;
	private String customerName;
	private int customerAge;
	private Map<String,Integer> monthlyRewards;
	private int totalRewardPoints;
	
	
}
