package com.example.demo;

import com.example.demo.service.ActivitiesStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Date: 5/11/2023<br/>
 * Time: 9:28 PM<br/>
 */
@RestController
@RequestMapping("/api")
public class HomeCtl {

    @Autowired
    private HomeService homeService;

    @Autowired
    private ActivitiesStream activitiesStream;

    @GetMapping("/getRoom")
    public ResponseData<Room> getData(){
        return ResponseData.getSuccessData(homeService.getInforRoom());
    }

    @GetMapping("/checkAnonation")
    public ResponseData<String> checkAnonation(){
        return ResponseData.getSuccessData(activitiesStream.checkAnonation());
    }
}
