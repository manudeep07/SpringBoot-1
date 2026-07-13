package com.Manudeep.demo.DependencyInjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderService {

   // @Autowired
    PaymentService paymentService;

    //if there is only one constructor no need to write autowired
    OrderService(PaymentService paymentService){
        this.paymentService=paymentService;
    }

    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void placeOrder(){
        paymentService.payment();
        System.out.println("Order placed");
    }



}
