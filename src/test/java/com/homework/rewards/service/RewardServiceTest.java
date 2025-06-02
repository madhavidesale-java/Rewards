package com.homework.rewards.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.homework.rewards.dto.RewardResponseDto;
import com.homework.rewards.entity.Transactions;
import com.homework.rewards.repository.RewardsRepository;

@ExtendWith(MockitoExtension.class)
class RewardServiceTest {

	@Mock
	private RewardsRepository rewardRepository;
	
	@InjectMocks
	private RewardService rewardService;

	@Test
	public void testCalculateRewardForCustomer() throws Exception
	{
		Long custId =1L;
		LocalDate from= LocalDate.of(2025, 1, 1);
		LocalDate to= LocalDate.of(2025, 3,3);
		
		Transactions t1 = new Transactions(1L,custId,"Sam",40,100.0,LocalDate.of(2025, 1, 1));
		Transactions t2 = new Transactions(2L,custId,"Pam",40,100.0,LocalDate.of(2025, 2, 1));
		
		List<Transactions> li= Arrays.asList(t1,t2);
		
		when(rewardRepository.findByCustomerIdAndTransactionsDateBetween(custId, from, to)).thenReturn(li);
		
		RewardResponseDto dto= rewardService.calculateRewardForCustomer(custId, from, to);
		
		assertNotNull(dto);
		assertEquals(1L, dto.getCustomerId());
		assertEquals(40,dto.getCustomerAge());
		assertEquals("Sam", dto.getCustomerName());
		
	}
	
	@Test
	public void testCalculateRewardForCustomer_Exception() throws Exception
	{
		Long custId =1L;
		LocalDate from= LocalDate.of(2025, 1, 1);
		LocalDate to= LocalDate.of(2025, 3,3);
		
		
		when(rewardRepository.findByCustomerIdAndTransactionsDateBetween(custId, from, to)).thenReturn(Arrays.asList());
		
		Exception e= assertThrows(Exception.class, () -> 
		{rewardService.calculateRewardForCustomer(custId, from, to);});
		
		assertEquals("Customer transaction not found", e.getMessage());
		
	}
	
}
