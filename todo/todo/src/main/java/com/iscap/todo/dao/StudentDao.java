package com.iscap.todo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public void createTable(){
        String query = "CREATE TABLE IF NOT EXISTS Student(id SERIAL PRIMARY KEY, name varchar(255) NOT NULL, city VARCHAR(255) )";
        int update = this.jdbcTemplate.update(query);
        System.out.println(update);
    }
    public void insertData(String name, String city){
        String query = "insert into Student(name,city) values(?,?)";
        int update = this.jdbcTemplate.update(query,name,city);
        System.out.println(update);
    }

    public void updateData(Integer id, String name, String city){
        String query = "UPDATE Student SET name ='"+name+"' ,city='" +city+ "' WHERE id ="+id;
        System.out.println(query);
        int update = jdbcTemplate.update(query);
        System.out.println(update);
    }
    public void deleteData(Integer id){
        String query = "DELETE FROM Student WHERE id="+id;
        int update = jdbcTemplate.update(query);
        System.out.println("update: "+update);
    }
}
