package Engulf.jdbctemplate;

import java.util.Date;

/**
 * 封装stu表数据的javaBean
 *
 */

public class Stu {
    private Integer id;
    private String name;
    private Integer age;
    private Double score;
    private Date birth;

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Stu{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                ", birth=" + birth +
                '}';
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

}

