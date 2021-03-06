package Engulf.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Druid连接池的工具类
 */

public class JDBCUtils {
    //1.定义一个成员变量 DataSource
    private static DataSource ds;
    static{
        try {
            //1.加载配置文件
            Properties pro = new Properties();
            pro.load(JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
            //2.获取DataSource
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 获取连接的方法
     */
    public static Connection getConn() throws SQLException {
        return ds.getConnection();
    }

    /**
     * 释放资源
     */
    public static void closeRes(Statement state,Connection conn){
        if(state != null){
            try {
                state.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(conn != null){
            try {
                conn.close(); //归还连接
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public static void closeRes(ResultSet rs,Statement state,Connection conn){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(state != null){
            try {
                state.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 获取连接池的方法
     */

    public static DataSource getDataSource(){
        return ds;
    }
}
