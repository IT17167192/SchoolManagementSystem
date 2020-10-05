package com.schoolmanagement.model.students;

import com.schoolmanagement.model.DataAccess;
import java.sql.Connection;
import java.sql.DriverManager;
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
}
