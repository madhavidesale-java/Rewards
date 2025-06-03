package com.homework.rewards.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.homework.rewards.dto.RewardResponseDto;
import com.homework.rewards.service.RewardService;

@RestController
@RequestMapping("/api/rewards")
public class RewardsController {

	@Autowired
	private RewardService rewardService;

	@GetMapping("/customer/{customerId}")
	public ResponseEntity<?> getRewardDetail(@PathVariable Long customerId,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to) {

		RewardResponseDto rewardResponseDto = rewardService.calculateRewardForCustomer(customerId, from, to);
		return ResponseEntity.ok(rewardResponseDto);

	}
}
