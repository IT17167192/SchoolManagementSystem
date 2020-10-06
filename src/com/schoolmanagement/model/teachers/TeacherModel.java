package com.schoolmanagement.model.teachers;

import com.schoolmanagement.model.DataAccess;
import com.schoolmanagement.model.students.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TeacherModel {
	public static Teacher getMaxId() {
		String sql = "select max(id) as max from teacher_details";
		Connection con = DataAccess.connect();

		// preparedStatemen
		PreparedStatement ps = null;

		// result set
		ResultSet rs = null;
		Teacher teacher = new Teacher();

		try {
			ps = con.prepareStatement(sql);
			rs = (ResultSet) ps.executeQuery();

			if (rs.first()) {
				teacher.setId(rs.getInt("max"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return teacher;
	}

	public static int registerTeacher(Teacher teacher) {

		int i = 0;
		Connection con = DataAccess.connect();
		String sql = "insert into teacher_details values(?,?,?,?,?,?,?)";

		try {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, teacher.getId());
			ps.setString(2, teacher.getFullName());
			ps.setString(3, teacher.getGender());
			ps.setString(4, teacher.getDob());
			ps.setString(5, teacher.getNic());
			ps.setString(6, teacher.getJoinDate());
			ps.setInt(7, 1);

			i = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return i;

	}
	
	public static int addTeacherQualification(int teacherId, String description) {

		int i = 0;
		Connection con = DataAccess.connect();
		String sql = "insert into teacher_qualification values(?,?,?)";

		try {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, null);
			ps.setString(2, description);
			ps.setInt(3, teacherId);
			i = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return i;

	}
}
