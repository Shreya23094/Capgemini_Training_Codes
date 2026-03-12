package com.gal;

import com.gal.algo.Calc;
import com.gal.algo.MyCalc;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class MyBeansConfig {
    //will create beans and provide to spring context, then onwards context will manage
    @Bean
    @Scope("prototype")         //every time create a new object
//    @Scope("request")          every time a request, creates a new object
//    @Scope("session")          every time a session created, create a new object
//    @Scope("application")      every time new application create a new object

    StringBuilder getStringBuilder(){
        return new StringBuilder("bean from Configuration");
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/testdb");
        ds.setUsername("root");
        ds.setPassword("sa@02@272820");

        return ds;
    }

    @Bean
    @Primary
    Calc getCalc(){
        return new MyCalc();
    }
    @Bean(name="getCalcNamedBean")
    Calc getCalc2(){
        return new MyCalc();
    }
}
