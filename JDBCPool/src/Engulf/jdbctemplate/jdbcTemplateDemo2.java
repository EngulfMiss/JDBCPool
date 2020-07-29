package Engulf.jdbctemplate;

import Engulf.utils.JDBCUtils;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 1.修改stu表中 id为1的score为99
 * 2.添加一条数据
 * 3.删除刚才添加的数据
 * 4.查询id为1的记录，将其封装为Map集合
 * 5.查询所有记录，将其封装为List
 * 6.查询所有记录，将其封装为Stu对象的List集合
 * 7.查询总的记录数
 */

public class jdbcTemplateDemo2 {

    //1.获取JdbcTemplate对象
    private JdbcTemplate temp = new JdbcTemplate(JDBCUtils.getDataSource());
    //1.修改stu表中 id为1的score为99
    @Test
    public void test1(){
        //2.定义sql
        String sql = "update stu set score = 99 where id = 1";
        //3.执行sql
        int count = temp.update(sql);
        System.out.println(count);
    }
    //2.添加一条记录
    @Test
    public void test2(){
        String sql = "insert into stu(id,name,age) values(?,?,?)";
        int count = temp.update(sql,4,"QSJ",22);
        System.out.println(count);
    }
    //3.删除刚刚添加的记录
    @Test
    public void test3(){
        String sql = "delete from stu where id = ?";
        int count = temp.update(sql,4);
        System.out.println(count);
    }
    //4.查询id为1的记录，将其封装为Map集合
    //这个方法查询出来的长度只能是1
    @Test
    public void test4(){
        String sql = "select * from stu where id = ?";
        Map<String, Object> map = temp.queryForMap(sql, 1);
        System.out.println(map);
    }
    //5.查询所有的记录，将其封装为List
    @Test
    public void test5(){
        String sql = "select * from stu";
        List<Map<String,Object>> list =  temp.queryForList(sql);
        for(Map<String,Object> m : list){
            System.out.println(m);
        }
    }
    @Test
    //6.查询所有记录，将其封装为Stu对象的List集合
    public void test6(){
        String sql = "select * from stu";
        List<Stu> list = temp.query(sql,new RowMapper<Stu>(){

            @Override
            public Stu mapRow(ResultSet rs, int i) throws SQLException {
                Stu stu = new Stu();
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                double score = rs.getDouble("score");
                Date date = rs.getDate("birth");

                stu.setAge(age);
                stu.setBirth(date);
                stu.setId(id);
                stu.setName(name);
                stu.setScore(score);

                return stu;
            }
        });

        for(Stu s: list){
            System.out.println(s);
        }
    }


    @Test
    //6.查询所有记录，将其封装为Stu对象的List集合
    public void test6_2() {
        String sql = "select * from stu";
        List<Stu> list = temp.query(sql,new BeanPropertyRowMapper<Stu>(Stu.class));
        for(Stu s : list){
            System.out.println(s);
        }
    }
    //7.查询总记录数
    @Test
    public void test7(){
        String sql = "select count(id) from stu";
        long total = temp.queryForObject(sql,Long.class);
        System.out.println(total);
    }
}
