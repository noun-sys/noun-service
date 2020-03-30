package org.nounsys.nounservice.base.config.datasource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author:gaoxu
 * @create:2020-03-16 15:56
 **/
@Configuration
@MapperScan(basePackages = MysqlContractDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "ContractSqlSessionTemplate")
public class MysqlContractDataSourceConfig {

    static final String PACKAGE = "org.nounsys.nounservice.datasource.account.mapper";
    private static final String MAPPER_PATH = "classpath*:/mapper/contract/*Mapper.xml";
    private static final String ENTITY_PACKAGE = "org.nounsys.nounservice.datasource.contract.entity";

    @Bean(name = "contractDataSource")
    @Qualifier("contractDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.second")
    public DataSource getMyDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "secondTransactionManager")
    public DataSourceTransactionManager clusterTransactionManager() {
        return new DataSourceTransactionManager(getMyDataSource());
    }

    @Bean(name = "ContractSqlSessionTemplate")
    //@Primary
    public SqlSessionFactory devSqlSessionFactory(
            @Qualifier("contractDataSource") DataSource dataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sessionFactory.setMapperLocations(resolver.getResources(MAPPER_PATH));
        sessionFactory.setTypeAliasesPackage(ENTITY_PACKAGE);
        return sessionFactory.getObject();
    }
}
