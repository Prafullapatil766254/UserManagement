package com.example.Controller;

import com.example.Model.Order;
import com.example.Service.PaymentGatewayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PaymentGatewayController {


    @Autowired
    private PaymentGatewayService paymentGatewayService;




    @GetMapping("order/id")
    public String getOrderById(@RequestParam String id){
        return paymentGatewayService.getOrderById(id);
    }

    @PostMapping("order")
    public String postOrder(@RequestBody Order order){
        return paymentGatewayService.postOrder(order);
    }
}
