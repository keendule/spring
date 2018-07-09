package mvc.configuration;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:config.properties")
public class DataConfig {

    @Value("${database.password}")
    private String password;

    @Value("${database.username}")
    private String userName;

    @Value("${database.modelPackage}")
    private String modelPackage;

    @Value("${database.driver}")
    private String driver;

    @Value("${database.connectionString}")
    private String connectionString;

    @Value("${database.hibernateDialect}")
    private String hibernateDialect;

    @Value("${database.showSql}")
    private String showSql;



  @Bean
  public LocalSessionFactoryBean sessionFactory() {
    LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
    sessionFactory.setDataSource(dataSource());
    sessionFactory.setPackagesToScan(modelPackage);
    sessionFactory.setHibernateProperties(hibernateProperties());

    return sessionFactory;
  }

  @Bean
  public DataSource dataSource() {
    BasicDataSource dataSource = new BasicDataSource();
    dataSource.setDriverClassName(driver);
    dataSource.setUrl(connectionString);
    dataSource.setUsername(userName);
    dataSource.setPassword(password);

    return dataSource;
  }

  @Bean
  public PlatformTransactionManager hibernateTransactionManager() {
    HibernateTransactionManager transactionManager
            = new HibernateTransactionManager();
    transactionManager.setSessionFactory(sessionFactory().getObject());
    return transactionManager;
  }

  private Properties hibernateProperties() {
    Properties hibernateProperties = new Properties();
    hibernateProperties.setProperty(
            "hibernate.show_sql", showSql);
    hibernateProperties.setProperty(
            "hibernate.dialect", hibernateDialect);

    return hibernateProperties;
  }
}
