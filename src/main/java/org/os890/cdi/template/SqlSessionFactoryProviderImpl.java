package org.os890.cdi.template;

import java.io.IOException;
import java.io.InputStream;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

//@Named
public class SqlSessionFactoryProviderImpl implements SqlSessionFactoryProvider {
    @Produces
    @ApplicationScoped
    @Override
    public SqlSessionFactory produceFactory() throws IOException {
        String resource = "org/os890/cdi/template/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory;
    }
	/*@Inject
    @InjectableResource(location = "/org/os890/cdi/template/mybatis-config.xml")
	private InputStream is;
	@Produces
    @ApplicationScoped
    @Override
    public SqlSessionFactory produceFactory() throws IOException {
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        return sqlSessionFactory;
    }*/
}
