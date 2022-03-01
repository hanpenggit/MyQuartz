package cn.hanpeng.quartz.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置多数据源
 *
 * @author hanpeng
 */
@Configuration
public class DataSourceConfig {


    @Bean
    @ConfigurationProperties("spring.datasource.druid")
    public DruidDataSource postgresqlDataSource() {
        return new DruidDataSource();
    }

}
