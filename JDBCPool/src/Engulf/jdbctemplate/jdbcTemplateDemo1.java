package Engulf.jdbctemplate;

import Engulf.utils.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * jdbcTemplateDemo1
 */

public class jdbcTemplateDemo1 {
    public static void main(String[] args) {
        //1.导入jar包
        //2.创建JDBCTemplate
        JdbcTemplate temp = new JdbcTemplate(JDBCUtils.getDataSource());
        //3.调用方法
        String sql = "update stu set score = 95 where id = ?";
        int count = temp.update(sql,3);  //第一个参数为要执行的sql语句，第二个参数对应第一个?,多个?以此类推
        System.out.println(count);
    }
}
