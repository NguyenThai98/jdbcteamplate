package com.example.demo.service;

import com.example.demo.domain.AccountData;
import com.example.demo.domain.Accounts;
import com.example.demo.mapper.AccountMapper;
import com.example.demo.mapper.DynamicTypeMapper;
import com.example.demo.reposytory.AccountReposytory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * Date: 5/12/2023<br/>
 * Time: 9:46 AM<br/>
 */
@Service
public class AccountService {

    @Autowired
    private AccountReposytory accountReposytory;

    public AccountData getAccount(int id, String username)  {

        Object [] objects = new Object[]{id};

        //String sql = "select * from db.getAccountById(?)";
        //String sql = "select * from getAccountById(?)";
        String sql = "select\n" +
                "user_id ,\n" +
                "username ,\n" +
                "password,\n" +
                "email, \n" +
                "roles, \n" +
                "short_info \n" +
                "from batch.accounts\n" +
                "where\n" +
                "user_id  = ?";
        return accountReposytory.getData(
                sql,
                new DynamicTypeMapper<>(AccountData.class),
                objects
        );
    }

    public List<Accounts> getListAccount(){
        //String sql = "select * from db.accounts";
        String sql = "select * from accounts";
        return  accountReposytory.getMulData(
                sql,
                new AccountMapper()
        );
    }
}
