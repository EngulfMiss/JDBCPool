package Engulf.datasource.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * c3p0演示
 */

public class C3P0Demo2 {
    public static void main(String[] args) throws SQLException {
        //1.获取DataSource
        DataSource ds = new ComboPooledDataSource();
        //2.获取连接
        for (int i = 1; i <= 11; i++) {
            Connection conn = ds.getConnection();
            System.out.println(i+":"+conn);
            if(i==5){
                conn.close();
            }
        }
    }

    public void testNamedConfig() throws SQLException {
        //1.获取指定名称的配置
        DataSource ds2 = new ComboPooledDataSource("otherc3p0");
        //2.获取连接
        for (int i = 1; i <= 11; i++) {
            Connection conn = ds2.getConnection();
            System.out.println(i+":"+conn);
        }
    }

}
