package repository;

import java.util.Set;
import java.util.TreeSet;

import model.beans.User;

public class UserRepositoryImpl {
	private static Set<User> users = new TreeSet<>();

	public UserRepositoryImpl() {

	}


	public static void addUser(User user) {
		user.setId(users.size()+1);
		users.add(user);
		
	}


	public static  User getUser(User user) {
		for (User repoUser : users) {
			if (repoUser.getEmail().equals(user.getEmail()) 
					&& repoUser.getPassword().equals(user.getPassword()))
				return repoUser;
		}
		return null;
	}

	public static User getUserById(int id) {
		for (User repoUser : users) {
			if (repoUser.getId()==id) 
				return repoUser;
		}
		return null;
	}
	
	public static User getLoginUser(String email, String password) {
		for (User repoUser : users) {
			if (repoUser.getEmail().equals(email) 
					&& repoUser.getPassword().equals(password))
				return repoUser;
		}
		return null;
	}
	public static boolean contains(User user) {
		for (User repoUser : users) {
			if (repoUser.equals(user))
				return true;
		}
		return false;
	}
	
	
	public static boolean usernameContains(String username) {
		for (User repoUser : users) {
			if (repoUser.getEmail().equals(username))
				return true;
		}
		return false;
	}
	public static boolean updateUser(User editedUser) {
		User user=getUserById(editedUser.getId()); 
		if(user!=null) {
			user.setFirstName(editedUser.getFirstName());
			user.setSecondName(editedUser.getSecondName());
			user.setFamilyName(editedUser.getFamilyName());
			user.setJob(editedUser.getJob());
			user.setDescription(editedUser.getDescription());
			user.setMale(editedUser.isMale());
			user.setPhoneNumber(editedUser.getPhoneNumber());
			user.setSkills(editedUser.getSkills());
			user.setAddress(editedUser.getAddress());
			return true;
		}
		return false;
	}
	}


