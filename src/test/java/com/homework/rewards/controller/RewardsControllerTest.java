package com.homework.rewards.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.homework.rewards.dto.RewardResponseDto;
import com.homework.rewards.exception.TransactionNotFoundException;
import com.homework.rewards.service.RewardService;

import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class RewardsControllerTest {

	@Mock
	private MockMvc mockMvc;

	@Mock
	private RewardService rewardService;

	@InjectMocks
	private RewardsController rewardsController;

	@BeforeEach
	void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(rewardsController).build();
	}

	@Test
	void testRedwardEndpoint() throws Exception {
		Long custId = 1L;
		LocalDate from = LocalDate.of(2025, 1, 1);
		LocalDate to = LocalDate.of(2025, 3, 3);

		RewardResponseDto rewardResponse = new RewardResponseDto();
		rewardResponse.setCustomerId(custId);
		rewardResponse.setTotalRewardPoints(150);

		when(rewardService.calculateRewardForCustomer(custId, from, to)).thenReturn(rewardResponse);

		mockMvc.perform(
				get("/api/rewards/customer/{customerId}", custId).param("from", "2025-01-01").param("to", "2025-03-03"))
				.andExpect(status().isOk()).andExpect(jsonPath("$.customerId").value(custId))
				.andExpect(jsonPath("$.totalRewardPoints").value(150));

	}

	@Test
	void testRedwardEndpoint_NotFound() throws Exception {
		Long custId = 2L;

		when(rewardService.calculateRewardForCustomer(Mockito.eq(custId), Mockito.any(LocalDate.class),
				Mockito.any(LocalDate.class)))
				.thenThrow(new TransactionNotFoundException("Customer transaction not found"));

		mockMvc.perform(
				get("/api/rewards/customer/{customerId}", custId).param("from", "2025-01-01").param("to", "2025-03-03"))
				.andExpect(status().isNotFound())
				.andExpect(content().string(Matchers.containsString("Customer Transaction not found")));

	}

	@Test
	void testGetRewardDetail() throws Exception {
		Long custId = 1L;
		LocalDate from = LocalDate.of(2025, 1, 1);
		LocalDate to = LocalDate.of(2025, 3, 3);

		RewardResponseDto rewardResponse = new RewardResponseDto();

		when(rewardService.calculateRewardForCustomer(custId, from, to)).thenReturn(rewardResponse);

		ResponseEntity<?> res = rewardsController.getRewardDetail(custId, from, to);

		assertEquals(HttpStatus.OK, res.getStatusCode());
		assertEquals(rewardResponse, res.getBody());

	}

}
