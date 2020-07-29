package Engulf.datasource.Druid;

import Engulf.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 使用新的工具类
 */

public class DruidDemo2 {
    public static void main(String[] args) {
        /**
         * 完成添加操作
         */
        Connection conn = null;
        PreparedStatement pstate = null;
        //1.获取连接
        try {
            conn = JDBCUtils.getConn();
            //2.定义sql
            String sql = "insert into stu (id,name,age,score) values(?,?,?,?)";
            //3.获取pstate对象
            pstate = conn.prepareStatement(sql);
            //4.赋值
            pstate.setInt(1,3);
            pstate.setString(2,"Tian");
            pstate.setInt(3,20);
            pstate.setDouble(4,90);
            //5.执行sql
            int count = pstate.executeUpdate();
            System.out.println(count);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeRes(pstate,conn);
        }
    }
}
