package repository;

import model.beans.User;

public interface UserRepository {
	
	void addUser(User user);
	User getUser(User user);
	boolean contains(User user);
	boolean usernameContains(String username);
}
