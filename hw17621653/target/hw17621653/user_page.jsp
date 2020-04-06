<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="model.beans.User"%>
<%@page import="model.Job"%>
<%@page import="model.Company"%>
<%@page import="model.UserSkill"%>
<%@page import="java.util.List"%>
<%@page import="model.enums.SkillType"%>
<%@page import="model.Address"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="style/user_page.css">
<meta charset="ISO-8859-1">
<title>Profile page</title>
</head>
<body>

<% User user = (User)request.getAttribute("user");
	request.setAttribute("userID",user.getId());%>
<header class="header">
<form action="EditProfile.jsp">
	<div>
	<input type="hidden" id="id" name="id" value="<%=Integer.toString(user.getId())%>">
	<button type="submit" id="edit_button">Edit profile</button><br>
	<button type="submit" id="logout_button"formaction="login.html">Log out</button>
	</div>
</form>
</header>
	
	<main class="main">
		<div class="shell">
			<div class="profile">
			<% if(user.isMale()){%>
				<img class="profile-image" src="images/user.jpg" />
			<% }
			else {%>
			<img class="profile-image" src="images/woman.jpg" />
			<%} %>
				<div class="profile-info">
					<h2 class="heading">User information</h2>
					<span class="text">Name: 
					<%=user.getFirstName() %>
					<%=user.getSecondName() %>
					<%=user.getFamilyName() %>
					  </span>
					<span class="text">Position: 
				<%=user.getJob().getPosition() %>
					</span>
					<span class="text">Company name: 
					<%=user.getJob().getCompany().getCompanyName() %>
					</span>
					<span class="text">Company type: 
				<%=user.getJob().getCompany().getCompanytype() %>
					</span>
					<span class="text">Company Address: 
					<%=user.getJob().getCompany().getLocation().getCity() %>
					<%=user.getJob().getCompany().getLocation().getStreet() %>
					</span>
					<span class="text profile-text">Description: 
					<%=user.getDescription()%>
					</span>
				</div>
			</div>
			
			<h1 class="heading centered">Skills</h1>
			<div class="info-box">
				<div class="pro-skills">
					<h2 class="heading centered">Professional</h2>
						<span class="text"></span>
					 	<div class="bar bar-java"></div>
					 	
					 	<%List<UserSkill> skills =(List<UserSkill>) user.getSkills(); 
					for(int i = 0; i<skills.size();i++){
						if(skills.get(i).getSkillType().equals(SkillType.PROFESSIONAL)){%>
						<span class="text"><%=skills.get(i).getSkillName() %></span>
					 	<div class="bar bar-java"></div>
					
					<% }
					}
					%>
					
					
					 	
				</div>
				<div class="pers-skills">
					<h2 class="heading centered">Social</h2>
					<span class="text"></span>
					 	<div class="bar bar-java"></div>
					<% for(int i = 0; i<skills.size();i++){
						if(skills.get(i).getSkillType().equals(SkillType.SOCIAL)){%>
							<span class="text"><%=skills.get(i).getSkillName() %></span>
					 		<div class="bar bar-java"></div>
					 		
					<% }
					}
					%>
				</div>
			</div>

			<h1 class="heading centered contact-heading">Contacts </h1>
			<div class="info-box">
				<div class="contact-box">
					<span class="text">E-mail: 
					<%=user.getEmail()%>
					</span>
				
					<a href="localhost" class="contact-text"> </a>
				</div>

				<div class="contact-box">
				
			
				
					<span class="text">City: 
					<%= user.getAddress().getCity() %>
					</span>
					<span class="contact-text"></span>
				</div>

				<div class="contact-box">
					<span class="text">Phone number:
					<%=user.getPhoneNumber()%>
					</span>
					<span class="contact-text"></span>
				</div>

				<div class="contact-box">	
					<span class="text">Street:
					<%= user.getAddress().getStreet() %>
					 </span>
					<span class="contact-text">
					</span>
				</div>
			</div>
		</div>
	</main>
	
	<footer class="footer"></footer>
</body>
</html>