package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Address;
import model.Company;
import model.Job;
import model.UserSkill;
import model.beans.User;
import model.enums.SkillType;
import repository.UserRepositoryImpl;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/user")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		User user = UserRepositoryImpl.getUserById(id);
		request.setAttribute("user", user);
		RequestDispatcher rd=request.getRequestDispatcher("user_page.jsp");  
        rd.forward(request,response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = this.editUser(request, response);
		UserRepositoryImpl.updateUser(user);
		response.sendRedirect("user?id="+user.getId());

	}
	private User editUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		User user = new User();
		Address address = new Address();
		user.setId(Integer.parseInt(request.getParameter("id")));
		user.setFirstName(request.getParameter("first_name"));
		user.setSecondName(request.getParameter("second_name"));
		user.setFamilyName(request.getParameter("last_name"));
		
		if(request.getParameter("gender").equals("Male"))
		user.setMale(true);
		else
			user.setMale(false);
		
		address.setCity(request.getParameter("city"));
		address.setStreet(request.getParameter("street"));
		user.setAddress(address);
		
		user.setJob(this.makeJob(request, response));
		user.setDescription(request.getParameter("description"));
		user.setPhoneNumber(request.getParameter("phone_number"));
		user.setSkills(makeSkillList(request,response));
		return user;
	}
	
	private Job makeJob(HttpServletRequest request, HttpServletResponse response) {
	
		Company company = new Company();
		Address companyAddress = new Address();
		Job job = new Job();
		
		company.setCompanyName(request.getParameter("company_name"));
		company.setCompanytype(request.getParameter("company_type"));
		companyAddress.setCity(request.getParameter("company_city"));
		companyAddress.setStreet(request.getParameter("company_street"));
		company.setLocation(companyAddress);
		job.setPosition(request.getParameter("position"));
		job.setCompany(company);
		return job;
	}
	private List<UserSkill> makeSkillList(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException{
			List<UserSkill> skillList = new ArrayList<>();	
			String []socialSkills = request.getParameterValues("social");
			String [] professionlaSkills = request.getParameterValues("professional");
	
	
			
			for(String skill:socialSkills) {
				UserSkill socialSkill=new UserSkill();
				 socialSkill.setSkillName(skill);
				 socialSkill.setSkillType(SkillType.SOCIAL);
				skillList.add(socialSkill);
			}
			
			for(String skill:professionlaSkills) {
				UserSkill professionalSkill = new UserSkill();
				professionalSkill.setSkillName(skill);
				professionalSkill.setSkillType(SkillType.PROFESSIONAL);
				skillList.add(professionalSkill);
			}
		return skillList;
	}

	
}
