package com.schoolmanagement.controller.students;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.schoolmanagement.model.students.Student;
import com.schoolmanagement.model.students.StudentModel;

/**
 * Servlet implementation class StudentController
 */
@WebServlet("/AddStudentController")
public class AddStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudentController() {
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
		// TODO Auto-generated method stub
		Student student = new Student();
		student.setFullName(request.getParameter("fullName"));
		student.setFirstName(request.getParameter("firstName"));
		student.setLastName(request.getParameter("lastName"));
		student.setGender(request.getParameter("gender") == "1" ? "Male": "Female");
		student.setDob(request.getParameter("dob"));
		student.setAddress(request.getParameter("address"));
		student.setGuardianName(request.getParameter("guardian"));
		student.setCno(request.getParameter("cNumber"));
		student.setOccupation(request.getParameter("occupation"));
		student.setAdmissionDate(request.getParameter("addmissionDate"));
		student.setAddmissionNo(request.getParameter("admissionNo"));
		
		int state = StudentModel.registerStudent(student);
		
		boolean responseStatus = true;
		PrintWriter out = response.getWriter();
		Gson json = new Gson();
		
		if(state!= 0) {
			System.out.println("Succesfully Inserted!");
			out.print(json.toJson(responseStatus));
			out.flush();
			out.close();
		}else {
			System.out.println("Error in Insert!");
			responseStatus = false;
			out.print(json.toJson(responseStatus));
			out.flush();
			out.close();
		}
		
		doGet(request, response);
	}

}
