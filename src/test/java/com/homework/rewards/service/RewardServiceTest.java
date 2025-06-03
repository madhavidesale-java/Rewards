package com.homework.rewards.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.lang.reflect.Method;
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
import com.homework.rewards.exception.TransactionNotFoundException;
import com.homework.rewards.repository.RewardsRepository;

@ExtendWith(MockitoExtension.class)
class RewardServiceTest {

	@Mock
	private RewardsRepository rewardRepository;

	@InjectMocks
	private RewardService rewardService;

	@Test
	public void testCalculateRewardForCustomer() throws Exception {
		Long custId = 1L;
		LocalDate from = LocalDate.of(2025, 1, 1);
		LocalDate to = LocalDate.of(2025, 3, 3);

		Transactions t1 = new Transactions(1L, custId, "Sam", 40, 100.0, LocalDate.of(2025, 1, 1));
		Transactions t2 = new Transactions(2L, custId, "Pam", 40, 100.0, LocalDate.of(2025, 2, 1));

		List<Transactions> li = Arrays.asList(t1, t2);

		when(rewardRepository.findByCustomerIdAndTransactionsDateBetween(custId, from, to)).thenReturn(li);

		RewardResponseDto dto = rewardService.calculateRewardForCustomer(custId, from, to);

		assertNotNull(dto);
		assertEquals(1L, dto.getCustomerId());
		assertEquals(40, dto.getCustomerAge());
		assertEquals("Sam", dto.getCustomerName());

	}

	@Test
	public void testCalculateRewardForCustomer_Exception() {
		Long custId = 1L;
		LocalDate from = LocalDate.of(2025, 1, 1);
		LocalDate to = LocalDate.of(2025, 3, 3);

		when(rewardRepository.findByCustomerIdAndTransactionsDateBetween(custId, from, to)).thenReturn(Arrays.asList());

		TransactionNotFoundException e = assertThrows(TransactionNotFoundException.class, () -> {
			rewardService.calculateRewardForCustomer(custId, from, to);
		});

		assertEquals("Customer transaction not found", e.getMessage());

	}

	@Test
	public void testCalculateReward() throws Exception {
		Method method = RewardService.class.getDeclaredMethod("calculateReward", double.class);
		method.setAccessible(true);

		assertEquals(90, method.invoke(rewardService, 120.0));
		assertEquals(30, method.invoke(rewardService, 80.0));
		assertEquals(0, method.invoke(rewardService, 44.0));
		assertEquals(0, method.invoke(rewardService, 50.0));
		assertEquals(54, method.invoke(rewardService, 102.0));
	}

}
