package com.schoolmanagement.controller.teachers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.schoolmanagement.model.students.Student;
import com.schoolmanagement.model.students.StudentModel;
import com.schoolmanagement.model.teachers.Teacher;
import com.schoolmanagement.model.teachers.TeacherModel;

/**
 * Servlet implementation class AddTeacherServlet
 */
@WebServlet("/AddTeacherController")
public class AddTeacherController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTeacherController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		String action = request.getParameter("action");
		
		if(action.equalsIgnoreCase("maxId")) {
			Teacher teacher = TeacherModel.getMaxId();
			PrintWriter out = response.getWriter();
			Gson json = new Gson();
			out.print(json.toJson(teacher));
			out.flush();
			out.close();
		}else if(action.equalsIgnoreCase("add")) {
			System.out.println("Add");
			PrintWriter out = response.getWriter();
			
			Teacher teacher = new Teacher();
			teacher.setId(Integer.parseInt(request.getParameter("id")));
			teacher.setFullName(request.getParameter("fullName"));
			teacher.setDob(request.getParameter("dob"));
			teacher.setNic(request.getParameter("nic"));
			teacher.setJoinDate(request.getParameter("joinDate"));
			teacher.setGender(request.getParameter("gender") == "1" ? "Male": "Female");
			
			int state = TeacherModel.registerTeacher(teacher);
			boolean responseStatus = true;
			
			Gson json = new Gson();
			
			if(state!= 0) {
				System.out.println("Succesfully Inserted to teacher!");
				out.print(json.toJson(responseStatus));
				out.flush();
				out.close();
			}else {
				System.out.println("Error in Insert to teacher!");
				responseStatus = false;
				out.print(json.toJson(responseStatus));
				out.flush();
				out.close();
			}
			
		}else if(action.equalsIgnoreCase("addTeacherQualification")) {
			System.out.println("Teacher Qualification");
			PrintWriter out = response.getWriter();
			
			int teacherId = Integer.parseInt(request.getParameter("id"));
			String description = request.getParameter("description");
			
			Gson json = new Gson();
			
			int state = TeacherModel.addTeacherQualification(teacherId, description);
			boolean responseStatus = true;
			
			if(state!= 0) {
				System.out.println("Succesfully Inserted to teacher qualification!");
				out.print(json.toJson(responseStatus));
				out.flush();
				out.close();
			}else {
				System.out.println("Error in Insert to teacher qualification!");
				responseStatus = false;
				out.print(json.toJson(responseStatus));
				out.flush();
				out.close();
			}
		}
		
		doGet(request, response);
	}

}
