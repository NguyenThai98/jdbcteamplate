package com.example.demo.service;

import com.example.demo.domain.AccountData;
import com.example.demo.domain.Accounts;
import com.example.demo.domain.VideoSaleGame;
import com.example.demo.mapper.AccountMapper;
import com.example.demo.mapper.DynamicTypeMapper;
import com.example.demo.reposytory.AccountReposytory;
import com.example.demo.reposytory.VideoGameReposytory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Date: 5/12/2023<br/>
 * Time: 9:46 AM<br/>
 */
@Service
public class VideoGameService {

    @Autowired
    private VideoGameReposytory videoGameReposytory;

    public VideoSaleGame getVideoSaleGame(int rank)  {

        Object [] objects = new Object[]{rank};
        String sql = "select * from video_sale_games where rank = ?";
        return videoGameReposytory.getData(
                sql,
                new DynamicTypeMapper<>(VideoSaleGame.class),
                objects
        );
    }

}
