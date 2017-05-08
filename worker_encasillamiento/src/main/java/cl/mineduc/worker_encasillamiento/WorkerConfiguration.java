/**
 * 
 */
package cl.mineduc.worker_encasillamiento;

import java.util.Properties;

import javax.mail.Session;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.XADataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import cl.mineduc.worker_encasillamiento.mappers.ProcesoMapper;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

/**
 * @author Rodrigo Alvarez, Alvaro Tellez
 *
 */
@Configuration
@EnableAutoConfiguration(exclude={XADataSourceAutoConfiguration.class})
@ComponentScan(basePackages = {"cl.mineduc.worker_encasillamiento.controllers","cl.mineduc.worker_encasillamiento.listeners","cl.mineduc.worker_encasillamiento.services","cl.mineduc.worker_encasillamiento.repo"})
@EnableRabbit
public class WorkerConfiguration {
	@Autowired 
	private Environment env;
	

	
	@Bean
	@Primary
	public DataSource dataSourcePostGres(){
		HikariConfig config = new HikariConfig();
		
		config.setDriverClassName(env.getProperty("postgres.datasource.driver-class-name"));
		config.setJdbcUrl(env.getProperty("postgres.datasource.url"));
		config.setUsername(env.getProperty("postgres.datasource.username"));
		config.setPassword(env.getProperty("postgres.datasource.password"));
		config.addDataSourceProperty("cachePrepStmts", "true");
		config.addDataSourceProperty("prepStmtCacheSize", "250");
		config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
		config.setMinimumIdle(1);
		config.setMaximumPoolSize(20);

		return new HikariDataSource(config);
	}
	
	
	
	@Bean
	@Primary
	public SqlSessionFactory sqlSessionFactory() throws Exception {
	    SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
	    sessionFactory.setDataSource(dataSourcePostGres());
	    Resource[] arrResource = new PathMatchingResourcePatternResolver().getResources("classpath:maps/postgresql/*.xml");
	    sessionFactory.setMapperLocations(arrResource);	    
	    return sessionFactory.getObject();
	}
	

	
	@Bean(name="MapperFactoryPostgres")
  public MapperFactoryBean<ProcesoMapper> mapperFactorydbTest() throws Exception{
      MapperFactoryBean<ProcesoMapper> mapperFactory = new MapperFactoryBean<ProcesoMapper>();
      /** binding de la interface con sqlsession **/
      mapperFactory.setMapperInterface(cl.mineduc.worker_encasillamiento.mappers.ProcesoMapper.class);
      mapperFactory.setSqlSessionFactory(sqlSessionFactory());
      return mapperFactory;
  }
	
	@Bean
	public PlatformTransactionManager transactionManagerPostgres(){
		return new DataSourceTransactionManager(dataSourcePostGres());
	}
	
	
	
}
