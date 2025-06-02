package com.homework.rewards.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.homework.rewards.dto.RewardResponseDto;
import com.homework.rewards.service.RewardService;

import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class RewardsControllerTest {
	
	@Mock
	private RewardService rewardService;
	
	
	@InjectMocks
	private RewardsController rewardsController;
	
	@Test
	void testGetRewardDetail() throws Exception
	{
		Long custId =1L;
		LocalDate from= LocalDate.of(2025, 1, 1);
		LocalDate to= LocalDate.of(2025, 3,3);
		
		RewardResponseDto rewardResponse = new RewardResponseDto();
		
		when(rewardService.calculateRewardForCustomer(custId, from, to)).thenReturn(rewardResponse);
				
		ResponseEntity<?> res= rewardsController.getRewardDetail(custId, from, to);
		
		assertEquals(HttpStatus.OK, res.getStatusCode());
		assertEquals(rewardResponse, res.getBody());
	
	}
	
	@Test
	void testGetRewardDetail_Exception() throws Exception
	{
		Long custId =2L;
		LocalDate from= LocalDate.of(2025, 1, 1);
		LocalDate to= LocalDate.of(2025, 3,3);
				
		when(rewardService.calculateRewardForCustomer(custId, from, to)).thenThrow(new RuntimeException("Exception Not Found"));
				
		ResponseEntity<?> res= rewardsController.getRewardDetail(custId, from, to);
		
		assertEquals(HttpStatus.NOT_FOUND, res.getStatusCode());
		assertTrue(res.getBody().toString().contains("Not Found"));
	
	}


}
