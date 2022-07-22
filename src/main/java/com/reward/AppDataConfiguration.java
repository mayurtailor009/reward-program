package com.reward;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.reward.domain.Customer;
import com.reward.domain.Transaction;
import com.reward.utility.Utils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.util.List;
import java.util.Map;

@Configuration
public class AppDataConfiguration {
    @Bean
    @Primary
    public ObjectMapper objectMapper(Jackson2ObjectMapperBuilder builder) {
        ObjectMapper objectMapper = builder.createXmlMapper(false).build();
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        return objectMapper;
    }

    /**
     * I have not integrated batabase, so creating static customer list.
     * @return List of customers.
     */
    @Bean
    public Map<String, Customer> customerMap()  {
        return Utils.buildCustomerMap();
    }

    /**
     * I have not integrated batabase, so creating static transaction list.
     * @return
     */
    @Bean
    public List<Transaction> transactionList() {
        return Utils.buildTransactionList();
    }
}
