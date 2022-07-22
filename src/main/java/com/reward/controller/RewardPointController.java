package com.reward.controller;

import com.reward.domain.RewardPoint;
import com.reward.service.RewardPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * RewardPointController class expose the endpoints relates to reward points
 * @author Mayur Tailor
 *
 */
@RestController
@RequestMapping("/reward-point")
public class RewardPointController {

    @Autowired
    private RewardPointService rewardPointService;

    /**
     * Health check endpoint
     * @return
     */
    @GetMapping("/health-check")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("Service is up");
    }

    /**
     * Fetch the list of reward points/
     * @param month default value is 3, month is use for filter the transaction.
     * @return List of reward point
     */
    @GetMapping("/fetch")
    public ResponseEntity<List<RewardPoint>> fetchRewardPoint(@RequestParam(required = false,
            defaultValue = "3") int month) {

        return ResponseEntity.ok(rewardPointService.fetchRewardPoints(month));
    }
}
