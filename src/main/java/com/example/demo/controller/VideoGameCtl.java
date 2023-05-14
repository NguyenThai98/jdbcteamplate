package com.example.demo.controller;

import com.example.demo.ResponseData;
import com.example.demo.domain.AccountData;
import com.example.demo.domain.Accounts;
import com.example.demo.domain.VideoSaleGame;
import com.example.demo.service.AccountService;
import com.example.demo.service.VideoGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Date: 5/12/2023<br/>
 * Time: 9:52 AM<br/>
 */
@RestController
@RequestMapping("/api/videogame")
public class VideoGameCtl {


    @Autowired
    private VideoGameService videoGameService;

    @GetMapping("/getVideoSaleGame")
    public ResponseData<VideoSaleGame> getVideoSaleGame(@RequestParam int rank) {
        VideoSaleGame videoSaleGame = videoGameService.getVideoSaleGame(rank);
        return ResponseData.getSuccessData(videoSaleGame);
    }


}
