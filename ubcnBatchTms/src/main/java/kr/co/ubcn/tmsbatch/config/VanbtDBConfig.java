package kr.co.ubcn.tmsbatch.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

//@PropertySource("file:../config/system.properties")
@Configuration
@MapperScan(basePackages = "kr.co.ubcn.tmsbatch.mapper.vanbt" , sqlSessionFactoryRef = "SqlSessionFactoryVanbt")
@EnableTransactionManagement
public class VanbtDBConfig {

	@Autowired
	private ApplicationContext applicationContext;


	@Bean(name = "DataSourceVanbt")
	@ConfigurationProperties(prefix = "spring.datasource.vanbt")

	@Primary
	public DataSource DataSourceVanbt() {
		return DataSourceBuilder.create().type(HikariDataSource.class).build();
	}

	@Bean(name = "SqlSessionFactoryVanbt")
	@Primary
	public SqlSessionFactory SqlSessionFactoryVanbt( @Qualifier("DataSourceVanbt")DataSource DataSourceVanbt) throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(DataSourceVanbt);
		sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:/mapper/vanbt/*.xml"));
		return sqlSessionFactoryBean.getObject();
	}

	@Bean(name = "TransactionManagerVanbt")
	@Primary
	public PlatformTransactionManager transactionManager() {
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(DataSourceVanbt());
		transactionManager.setGlobalRollbackOnParticipationFailure(false);
		return transactionManager;
	}

	@Bean(name = "SqlSessionTemplateVanbt")
	@Primary
	public SqlSessionTemplate SqlSessionTemplateVanbt( @Qualifier("SqlSessionFactoryVanbt") SqlSessionFactory SqlSessionFactoryVanbt) {
		return new SqlSessionTemplate(SqlSessionFactoryVanbt);
	}
}
