package com.example.demo.service;

import com.example.demo.aop.ActivitiStreamAlias;
import org.springframework.stereotype.Service;


/**
 * Date: 5/29/2023<br/>
 * Time: 1:50 PM<br/>
 */
@Service
public class ActivitiesStream {

    @ActivitiStreamAlias(action = "CHECK-BAD-CUSTOMER")
    public String checkAnonation() {
        return "OK";
    }
}
