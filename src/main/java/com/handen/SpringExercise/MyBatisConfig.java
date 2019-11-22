package com.handen.SpringExercise;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
@MapperScan("com.handen.SpringExercise")
class MyBatisConfig {
    @Bean
    public DataSource mDataSource() {
        System.out.println("INSIDE MYBATISCONFIG");
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("init.sql")
                .addScript("testData.sql")
                .build();
    }

    @Bean
    public SqlSessionFactory mSqlSessionFactory() throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(mDataSource());
        return sqlSessionFactoryBean.getObject();
    }
}
