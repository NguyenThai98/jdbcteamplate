package com.example.demo.controller;

import com.example.demo.ResponseData;
import com.example.demo.domain.AccountData;
import com.example.demo.domain.Accounts;
import com.example.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * Date: 5/12/2023<br/>
 * Time: 9:52 AM<br/>
 */
@RestController
@RequestMapping("/api/account")
public class AccountCtl {


    @Autowired
    private AccountService accountService;

    @GetMapping("/getInfo")
    public ResponseData<AccountData> getAccount(@RequestParam int id,
                                             @RequestParam String username) {
        AccountData accounts = accountService.getAccount(id, username);
        return ResponseData.getSuccessData(accounts);
    }

    @GetMapping("/getAllInfo")
    public ResponseData<List<Accounts>> getAccount(){
        List<Accounts> listInfo = accountService.getListAccount();
        return ResponseData.getSuccessData(listInfo);
    }
}
