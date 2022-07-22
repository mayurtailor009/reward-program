package com.reward.utility;

import com.reward.domain.Customer;
import com.reward.domain.Transaction;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This is utils class contains the commonly used method.
 * @author Mayur
 */
public class Utils {

    /**
     * Get the month deference between to dates.
     * @param startDateTime The start date
     * @param endDateTime The end date
     * @return The number of month difference.
     */
    public static long monthDifferenceDates(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        return ChronoUnit.MONTHS.between(startDateTime, endDateTime);
    }

    /**
     * It calculates the reward points based on amount supplied.
     * @param amount
     * @return The reward point
     */
    public static int calculateRewardPoint(int amount) {
        int point = 0;
        if (amount < 50) {
            return point;
        }
        point = amount - 50;
        if (amount > 100) {
            point += amount - 100;
        }
        return point;
    }

    /**
     * Creating static data for customers.
     * @return
     */
    public static Map<String, Customer> buildCustomerMap()  {
        final Map<String, Customer> customerMap = new HashMap<>();
        customerMap.put("1001", new Customer().withId("1001").withName("Mayur"));
        customerMap.put("1002", new Customer().withId("1002").withName("Mack"));
        customerMap.put("1003", new Customer().withId("1003").withName("Jack"));
        customerMap.put("1004", new Customer().withId("1004").withName("Rose"));
        return customerMap;
    }

    /**
     * Creating static data for transactions.
     * @return List of transactions.
     */
    public static List<Transaction> buildTransactionList() {
        final List<Transaction> transactionList = new ArrayList<>();
        transactionList.add(buildTransaction("001", 15, "1001", "2022-05-20 10:30:25"));
        transactionList.add(buildTransaction("002", 60, "1001", "2022-05-21 10:30:25"));
        transactionList.add(buildTransaction("003", 105, "1001", "2022-05-22 10:30:25"));
        transactionList.add(buildTransaction("004", 5, "1001", "2022-06-20 10:30:25"));
        transactionList.add(buildTransaction("005", 55, "1001", "2022-06-25 10:30:25"));
        transactionList.add(buildTransaction("006", 70, "1001", "2022-06-26 10:30:25"));
        transactionList.add(buildTransaction("007", 90, "1001", "2022-06-29 10:30:25"));
        transactionList.add(buildTransaction("008", 10, "1002", "2022-05-21 10:30:25"));
        transactionList.add(buildTransaction("009", 45, "1002", "2022-05-22 10:30:25"));
        transactionList.add(buildTransaction("010", 40, "1002", "2022-05-23 10:30:25"));
        transactionList.add(buildTransaction("011", 30, "1002", "2022-05-24 10:30:25"));
        transactionList.add(buildTransaction("012", 100, "1003", "2022-06-25 10:30:25"));
        transactionList.add(buildTransaction("013", 50, "1003", "2022-06-27 10:30:25"));
        transactionList.add(buildTransaction("014", 150, "1004", "2022-07-20 10:30:25"));
        return transactionList;
    }

    private static Transaction buildTransaction(String id, int amount, String customerId, String transactionDate) {
        return new Transaction().withId(id).withAmount(amount).withCustomerId(customerId)
                .withTransactionDate(LocalDateTime.parse(transactionDate, Constants.DATE_FORMAT));
    }
}
