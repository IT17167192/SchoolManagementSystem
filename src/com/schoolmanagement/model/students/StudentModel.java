package com.schoolmanagement.model.students;

import com.schoolmanagement.model.DataAccess;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentModel {
	public static int registerStudent(Student student) {
		
		int i = 0;
		Connection con = DataAccess.connect();
		String sql = "insert into student_details values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, null);
			ps.setString(2, student.getFullName());
			ps.setString(3, student.getFirstName());
			ps.setString(4, student.getLastName());
			ps.setString(5, student.getGender());
			ps.setString(6, student.getDob());
			ps.setString(7, student.getAddress());
			ps.setString(8, student.getGuardianName());
			ps.setString(9, student.getCno());
			ps.setString(10, student.getOccupation());
			ps.setString(11, student.getAdmissionDate());
			ps.setString(12, student.getAddmissionNo());
			ps.setInt(13, 1);
			
			i = ps.executeUpdate();
			 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return i;
		
	}
	
	public static ArrayList<Student> retrieveAllUsers(){
		ArrayList<Student> students = new ArrayList<>();
		Student student = null;
		
		Connection con = DataAccess.connect();
		String sql = "select * from student_details";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ResultSet resultset = ps.executeQuery();
			
			while(resultset.next()) {
				student = new Student();
				
				student.setId(resultset.getInt("id"));
				student.setFullName(resultset.getString("fullName"));
				student.setFirstName(resultset.getString("firstName"));
				student.setLastName(resultset.getString("lastName"));
				student.setDob(resultset.getString("dob"));
				student.setGender(resultset.getString("gender"));
				student.setAddress(resultset.getString("address"));
				student.setGuardianName(resultset.getString("guardianName"));
				student.setCno(resultset.getString("contactNo"));
				student.setOccupation(resultset.getString("occupation"));
				student.setAdmissionDate(resultset.getString("admissionDate"));
				student.setAddmissionNo(resultset.getString("admissionNo"));
				student.setStatus(resultset.getInt("status"));
				
				students.add(student);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		return students;
		
	}
	
	public static boolean changeStudentStatus(int id, int status) {
		Connection connection = DataAccess.connect();
		//sql
		String sqlUpdate = "update student_details set status=? where id=?";
		
		//execute
		try {
			//ps
			PreparedStatement psUpdate= (PreparedStatement)connection.prepareStatement(sqlUpdate);
			psUpdate.setInt(1, status);
			psUpdate.setInt(2, id);
			psUpdate.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return true;
	}
}
