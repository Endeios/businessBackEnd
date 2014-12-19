package business

import javax.persistence.EntityManagerFactory;
import javax.transaction.TransactionManager;

import org.apache.log4j.Logger;
import org.h2.Driver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource
import org.springframework.core.io.Resource
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.SimpleDriverDataSource
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

@Configuration
@EnableJpaRepositories(basePackages="business.api",entityManagerFactoryRef="entityManagerFactory")
class BusinessConfig {
	
	private static Logger log = Logger.getLogger("Configuration");
	
	@Value('${db.url}')
	private String dbUrl;
	
	@Bean
	public static PropertyPlaceholderConfigurer properties(){
	  PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
	  Resource[] resources = [new ClassPathResource( "business.properties" ) ];
	  ppc.setLocations( resources );
	  ppc.setIgnoreUnresolvablePlaceholders( true );
	  return ppc;
	}
	
	@Bean
	public javax.sql.DataSource getDS(){
		log.info("DBURl is $dbUrl")
		def ds = new SimpleDriverDataSource()
		ds.setDriverClass(Driver.class)
		ds.setUrl(dbUrl)
		ds.setUsername("sa")
		ds.setPassword("sa")
		return ds;
	}
	
	@Bean(name="entityManagerFactory")
	public EntityManagerFactory getEMF(){
		def emf = new LocalContainerEntityManagerFactoryBean();
		emf.dataSource = getDS()
		emf.setPersistenceUnitName("business")
	}
	
	
	@Bean(name="jpaTransactionManager")
	public TransactionManager getJPATXM(){
		def jpatxm = new JpaTransactionManager()
		jpatxm.dataSource = getDS()
		jpatxm.entityManagerFactory = getEMF()
	}
}
