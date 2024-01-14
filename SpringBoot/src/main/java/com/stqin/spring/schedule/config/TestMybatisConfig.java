package com.stqin.spring.schedule.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
@MapperScan(basePackages = {"com.stqin.spring.schedule.dao"}, sqlSessionFactoryRef = "sqlSessionFactoryTest")
public class TestMybatisConfig {
    @Autowired
    @Qualifier(value = "dataSourceTest")
    private DataSource dataSource;

    @Bean
    public SqlSessionFactory sqlSessionFactoryTest() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath:mapper/*.xml"));
        return factoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplateTest() throws Exception {
        return  new SqlSessionTemplate(sqlSessionFactoryTest());
    }

}
