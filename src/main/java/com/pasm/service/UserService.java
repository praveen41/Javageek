/**
 * 
 */
package com.pasm.service;

import java.util.List;

import com.pasm.model.User;

/**
 * @author Peter
 * 
 */
public interface UserService {

	public void addPerson(User p);

	public void updatePerson(User p);

	public List<User> listPersons();

	public User getPersonById(int id);

	public void removePerson(int id);

}
