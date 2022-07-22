package com.reward.service;

import com.reward.domain.Customer;
import com.reward.domain.RewardPoint;
import com.reward.domain.Transaction;
import com.reward.utility.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Service class contains the business logic for reward points
 * @author Mayur
 *
 */
@Service
public class RewardPointService {

    @Autowired
    private Map<String, Customer> customerMap;

    @Autowired
    private List<Transaction> transactionList;

    /**
     * Method will fetch/calculate the rewards point based on the amount spend for each transaction.
     * @return List of reward points
     */
    public List<RewardPoint> fetchRewardPoints(int month) {

        // grouping the transaction list based on customer.
        Map<String, List<Transaction>> transactionMap = transactionList.stream().
                collect(Collectors.groupingBy(Transaction::getCustomerId));
        Map<String, RewardPoint> rewardPointMap = new HashMap<>();
        LocalDateTime now = LocalDateTime.now();
        for (Map.Entry<String,List<Transaction>> entry : transactionMap.entrySet()) {
            RewardPoint rewardPoint = rewardPointMap.get(entry.getKey());
            if (rewardPoint == null) {
                rewardPoint = new RewardPoint();
                rewardPoint.setName(customerMap.get(entry.getKey()).getName());
                rewardPointMap.put(entry.getKey(), rewardPoint);
            }
            // filter transactions latest with last 3 months by default
            List<Transaction> filteredList = entry.getValue().stream().
                    filter(x-> Utils.monthDifferenceDates(x.getTransactionDate(), now) <= month).
                    collect(Collectors.toList());

            for(Transaction transaction : filteredList) {
                rewardPoint.setRewardPoints(rewardPoint.getRewardPoints() +
                        Utils.calculateRewardPoint(transaction.getAmount()));
            }
        }
        return rewardPointMap.values().stream().collect(Collectors.toList());
    }

    public void setCustomerMap(Map<String, Customer> customerMap) {
        this.customerMap = customerMap;
    }

    public void setTransactionList(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }
}
