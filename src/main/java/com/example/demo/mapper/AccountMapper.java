package com.example.demo.mapper;

import com.example.demo.domain.Accounts;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Date: 5/12/2023<br/>
 * Time: 9:48 AM<br/>
 */
public class AccountMapper implements RowMapper<Accounts> {
    @Override
    public Accounts mapRow(ResultSet rs, int rowNum) throws SQLException {
        Accounts accounts = new Accounts(
                Long.valueOf(rs.getInt("T_ACCOUNT")),
                rs.getString("T_USERNAME"),
                rs.getString("T_PASSWORD"),
                rs.getString("T_EMAIL")
        );
        return accounts;
    }
}
