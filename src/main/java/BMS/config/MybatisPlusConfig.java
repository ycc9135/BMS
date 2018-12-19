package BMS.config;

import javax.sql.DataSource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;

@Configuration
@MapperScan("BMS.system.mapper")
public class MybatisPlusConfig {

	/*
	 * 分页插件，自动识别数据库类型
	 */
	@Bean
	public PaginationInterceptor paginationInterceptor() {
		return new PaginationInterceptor();
	}
	/**
	 * 数据源的配置，在application.yml里面
	 * @return
	 */
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource dataSource() {
		return new DruidDataSource();
	}

	/*
	 * oracle数据库配置JdbcTypeForNull
	 * 参考：https://gitee.com/baomidou/mybatisplus-boot-starter/issues/IHS8X
	 * 不需要这样配置了，参考 yml: mybatis-plus: confuguration dbc-type-for-null: 'null'
	 * 
	 * @Bean public ConfigurationCustomizer configurationCustomizer(){ return new
	 * MybatisPlusCustomizers(); }
	 * 
	 * class MybatisPlusCustomizers implements ConfigurationCustomizer {
	 * 
	 * @Override public void customize(org.apache.ibatis.session.Configuration
	 * configuration) { configuration.setJdbcTypeForNull(JdbcType.NULL); } }
	 */

}
