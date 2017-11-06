package HelloSpringMvc.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.eclipse.jetty.server.session.Session;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * Created by yuhan.shen on 2017/11/6.
 */
public class BaseDao {

    /**
     * SqlSessionFactory是用来创建SqlSession的工厂，SqlSession会执行映射的语句，进行事物提交、回滚等。
     * @return
     */
    public SqlSessionFactory getSqlSessionFactory() {
        Reader reader = null;
        SqlSessionFactory sqlSessionFactory = null;
        try {
            reader = Resources.getResourceAsReader("mybatis/mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sqlSessionFactory;
    }

    public Object selectOne(String statement){
        SqlSession session = getSqlSessionFactory().openSession();
        Object result = session.selectOne(statement);
        session.close();
        return result;
    }

    public Object selectOne(String statement,Object param){
        SqlSession session = getSqlSessionFactory().openSession();
        Object result = session.selectOne(statement,param);
        session.close();
        return result;
    }

    public <T> List<T> selectList(String statement,Object param){
        SqlSession session = getSqlSessionFactory().openSession();
        List<T> resultList = session.selectList(statement,param);
        session.close();
        return resultList;
    }

    public Integer selectCount(String statement,Object param){
        SqlSession session = getSqlSessionFactory().openSession();
        Integer count = session.selectOne(statement,param);
        session.close();
        return count;
    }

    public int insert(String statement,Object param){
        SqlSession session = getSqlSessionFactory().openSession();
        System.out.println(statement);
        int resultCount = session.insert(statement,param);
        session.commit();
        session.close();
        return resultCount;
    }

}
