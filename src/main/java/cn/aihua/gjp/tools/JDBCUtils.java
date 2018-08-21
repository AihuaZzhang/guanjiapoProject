package cn.aihua.gjp.tools;

//获取数据库连接的工具类
//实现连接池

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;

public class JDBCUtils {
    private static BasicDataSource dataSource = new BasicDataSource();

    static {
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/gjp?useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("88888888");
    }

    public static DataSource getDataSource(){
        return dataSource;
    }
}
