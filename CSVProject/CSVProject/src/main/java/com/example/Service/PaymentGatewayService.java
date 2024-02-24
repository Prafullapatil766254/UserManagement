package com.example.Service;

import com.example.Model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PaymentGatewayService {

    @Autowired
    private RestTemplate restTemplate;


    public String getOrderById(String id) {
        String result = restTemplate.getForObject("http://localhost:8081/api/v1/stripe/order/id/"+id , String.class);
        System.out.println(result);
        return result;
    }

    public String postOrder(Order order) {
        String result = restTemplate.postForObject("http://localhost:8081/api/v1/stripe/order" , order , String.class);
        System.out.println(result);
        return result;
    }
}
