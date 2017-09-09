package com.quanglinhit.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import javax.naming.spi.DirStateFactory.Result;

import com.quanglinhit.entity.Student;



public class StudentModel {
	private static ArrayList<Student> listStudent;
	public static void main(String[] args) {
		StudentModel stuModel=new StudentModel();
		Student stu1=new Student(12301, "Đức", "ducdm@gmail.com", "123","C1702G",1);
		stuModel.insert(stu1);
		
		Student stu2=stuModel.getById(1);
		System.out.println(stu2.toString());
		
	}
	public ArrayList<Student> getList() {
		if (listStudent==null) {
			listStudent=new ArrayList<Student>();
		}
		return listStudent;
	}

	public void insert(Student student) {
		long startTime=System.currentTimeMillis();
		try {
            Connection cnn = DAO.getConnection();
            PreparedStatement preStt=cnn.prepareStatement("INSERT INTO student (id, name, email, roll_number, class_name, status) VALUE (?,?,?,?,?,?);");
            preStt.setInt(1, (int)student.getId());
            preStt.setString(2, student.getName());
            preStt.setString(3, student.getEmail());
            preStt.setString(4, student.getRollNumber());
            preStt.setString(5, student.getClassName());
            preStt.setInt(6, (int)student.getStatus());
            
            if (preStt.execute()) {
				System.out.println("insert thanh cong!");
			}else{
				System.out.println("insert ko thanh cong!");
			}
        } 
		catch (SQLException e) {
            System.err.println("ERROR" + e.getMessage());
        }
	}

	public void update(Student student) {
		try {
			Connection conn=DAO.getConnection();
			PreparedStatement preStt=conn.prepareStatement("UPDATE student name=?, email=?, roll_number=?, class_name=?, status=? where id=?");
            preStt.setString(1, student.getName());
            preStt.setString(2, student.getEmail());
            preStt.setString(3, student.getRollNumber());
            preStt.setString(4, student.getClassName());
            preStt.setInt(5, (int)student.getStatus());
            preStt.setInt(6, (int)student.getId());
            if (preStt.executeUpdate()>0) {
				System.out.println("Update danh cong");
			}else{
				System.out.println("Khong co ban ghi nao duoc Update");
			}
		} catch (Exception e) {
			System.err.println("ERROR" + e.getMessage());
		}
	}

	public void delete(Integer id) {
		try {
			Connection conn=DAO.getConnection();
			PreparedStatement preStt=conn.prepareStatement("DELETE FROM student where id=?");
            preStt.setInt(1, id);
            if (preStt.executeUpdate()>0) {
				System.out.println("DELETE danh cong");
			}else{
				System.out.println("Khong co ban ghi nao duoc DELETE");
			}
		} catch (Exception e) {
			System.err.println("ERROR" + e.getMessage());
		}
	}
	
	public Student getById(int id){
		
		try {
	        Connection cnn = DAO.getConnection();
	        PreparedStatement preStt=cnn.prepareStatement("SELECT * FROM student WHERE id=?");
	        preStt.setInt(1, id);
	        ResultSet rs=preStt.executeQuery();
	        if (rs.next()) {
				Student stu=new Student();
				stu.setId(rs.getInt("id"));
				stu.setName(rs.getString("name"));
				stu.setEmail(rs.getString("email"));
				stu.setRollNumber(rs.getString("roll_number"));
				stu.setClassName(rs.getString("class_name"));
				stu.setStatus(rs.getInt("status"));
				return stu;
			} else {
				System.out.println("NO Data!!!");
			}
	    }catch (SQLException e) {
	            System.err.println("ERROR" + e.getMessage());
	    }
		
		return null;
	}
	
	
}
