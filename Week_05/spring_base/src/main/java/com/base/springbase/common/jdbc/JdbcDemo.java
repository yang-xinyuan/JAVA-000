package com.base.springbase.common.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;

@Component("JdbcDemo")
public class JdbcDemo {
    @Autowired
    private JdbcTemplate template;

    @Autowired
    private DataSourceTransactionManager dataSourceTransactionManager;
    @Autowired
    private TransactionDefinition transactionDefinition;
    public void jdbcRun() {
        //开启事务
        TransactionStatus transactionStatus = dataSourceTransactionManager.getTransaction(transactionDefinition);
        try{
            template.query("SHOW PROCESSLIST" , rs -> {
                if (rs.next()) {
                    System.out.println("id:" + rs.getString(1) + ",user:" + rs.getString(2) + ",host:" + rs.getString(3)
                            + ",db:" + rs.getString(4) + ",command:" + rs.getString(5) + ",time:" + rs.getString(6) + ",state:" + rs.getString(7));
                }
            });
            //提交事务
            dataSourceTransactionManager.commit(transactionStatus);
        }catch(Exception e){
            //回滚事务
            dataSourceTransactionManager.rollback(transactionStatus);
        }
    }
}
