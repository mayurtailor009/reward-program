package com.reward.controller;

import com.reward.domain.RewardPoint;
import com.reward.service.RewardPointService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RewardPointControllerTest {

    @InjectMocks
    private RewardPointController rewardPointController;

    @Mock
    private RewardPointService rewardPointService;

    @BeforeEach
    public void setUp() {
    }

    @Test
    public void rewardPointFetch_Test() {
        when(rewardPointService.fetchRewardPoints(3)).thenReturn(new ArrayList<>());
        ResponseEntity<List<RewardPoint>> responseEntity = rewardPointController.fetchRewardPoint(3);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
