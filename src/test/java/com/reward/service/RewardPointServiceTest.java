package com.reward.service;

import com.reward.domain.RewardPoint;
import com.reward.utility.Utils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class RewardPointServiceTest {


    @InjectMocks
    private RewardPointService rewardPointService;

    @BeforeEach
    public void setUp() {
        rewardPointService.setCustomerMap(Utils.buildCustomerMap());
        rewardPointService.setTransactionList(Utils.buildTransactionList());
    }

    @Test
    public void rewardPointFetch_Test() {
        List<RewardPoint> rewardPointList = rewardPointService.fetchRewardPoints(3);
        assertThat(rewardPointList.size()).isEqualTo(4);
    }
}
