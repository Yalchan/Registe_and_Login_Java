<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="model.beans.User"%>
    <%@page import="repository.UserRepositoryImpl"%>
    <%@page import="model.enums.SkillType"%>
    <%@page import="java.util.List"%>
    <%@page import="model.UserSkill"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="style/user_page.css">
<title>Edit profile</title>
</head>
<body>
<script src="js/dynamic_text.js">
        </script>
<%int id=Integer.parseInt( request.getParameter("id"));
User user = UserRepositoryImpl.getUserById(id);
List<UserSkill> skills =(List<UserSkill>) user.getSkills();
%>
<header class="header">
<h1>Edit Profile</h1>
</header>
<form action="user" method="post">
	<main class="main">
		<div class="shell">
			<div class="profile">
	

				<div class="profile-info">
					<h2 class="heading">User information</h2>
					<span class="text">Name: 
					<input id="first" type="text" name="first_name" value="<%=user.getFirstName()%>" placeholder="First name">
					<input id="second" type="text" name="second_name" value="<%=user.getSecondName()%>" placeholder="Second name">
					<input id="last" type="text" name="last_name" value="<%=user.getFamilyName()%>" placeholder="Family name">
					  </span>
					<span class="text">Position: 
				<input id="position" type="text" name="position" value="<%=user.getJob().getPosition() %>" placeholder="Your position">
					</span>
					<span class="text">Company name: 
					<input id="company-name" type="text" name="company_name" value="<%=user.getJob().getCompany().getCompanyName() %>" placeholder="Company name">
					</span>
					<span class="text">Company type: 
			  <input id="company-type" type="text" name="company_type" value="<%=user.getJob().getCompany().getCompanytype() %>" placeholder="Company type">
					</span>
					<span class="text">Company Address: 
					 <input id="company-city" type="text" name="company_city" value="<%=user.getJob().getCompany().getLocation().getCity() %>" placeholder="City">
					 <input id="company-street" type="text" name="company_street" value="<%=user.getJob().getCompany().getLocation().getStreet() %>" placeholder="Street">
					</span>
					<span class="text profile-text">Description: 
					 <input id="description" style="width: 100%;height:200px;" type="text" name="description" value="<%=user.getDescription()%>" placeholder="About you">
					</span>
				</div>
			</div>
			
			<h1 class="heading centered">Skills</h1>
			<div class="info-box2">
				<div class="pro-skills">
					<h2 class="heading left">Professional</h2>
					<div class="text" id="prof-container">
			<%for(int i = 0; i<skills.size();i++){
						if(skills.get(i).getSkillType().equals(SkillType.PROFESSIONAL)){%>
						<span><input type="text" name="professional" value="<%=skills.get(i).getSkillName() %>"></span>
				
					
					<% }
					}
					%>
					</div> 	
				</div>
				<div class="pers-skills" >
					<h2 class="heading left">Social</h2>
					<div class="text" id="social-container">
					
					 	
					 		<% for(int i = 0; i<skills.size();i++){
						if(skills.get(i).getSkillType().equals(SkillType.SOCIAL)){%>
							<span><input type="text" name="social" value="<%=skills.get(i).getSkillName() %>"></span>		
					 		
					<% }
					}
					%>
			
				</div>
			</div>

			<div class="input-skill">
		<div><input type="text" id="text-field" ></div>	        
<div>
	
 		<input type="button" value="add-professional" id="add-prof" onclick="addProSkill()">
        <input type="button" value="add-social" id="add-social" onclick="addSocSkill()">

		</div>
	</div>
</div>

			<h1 class="heading centered contact-heading">Contacts </h1>
			<div class="info-box2">
				
					<div class="contact-box">
					<span class="text">Gender: 
					  <select id="gender" name="gender">
                <option value="Male" <%if(user.isMale()){%>selected<%} %>>Male</option>
                <option value="Female"<%if(!user.isMale()){%>selected<%} %>>Female</option>
            </select>
					</span>
				
					<a href="localhost" class="contact-text"> </a>
				</div>
				
				<div class="contact-box">
					<span class="text">City: 
					<input id="city" type="text" name="city" value="<%= user.getAddress().getCity()%>" placeholder="City">
					</span>
					<span class="contact-text"></span>
				</div>

				<div class="contact-box">
					<span class="text">Phone number:
					 <input id="phone" type="text" name="phone_number" value="<%=user.getPhoneNumber()%>" placeholder="Mobile phone">
					</span>
					<span class="contact-text"></span>
				</div>

				<div class="contact-box">	
					<span class="text">Street:
					<input id="street" type="text" name="street" value="<%= user.getAddress().getStreet() %>" placeholder="Street">
					 </span>
					<span class="contact-text">
					</span>
				</div>
			</div>
		</div>
	</main>
<input type="hidden" id="id" name="id" value="<%=Integer.toString(user.getId())%>">
	<input type="submit" id="submit_button" value="Confirm">
	</form>
	<footer class="footer"></footer>
</body>
</html>