/**
 * 
 */
package com.pasm.service;

import org.springframework.stereotype.Service;

import com.pasm.dao.ContactDAO;

/**
 * @author Peter
 *
 */
@Service
public class ContactServiceImpl implements ContactService {
	
	private ContactDAO contactDAO;

	public ContactDAO getContactDAO() {
		return contactDAO;
	}

	public void setContactDAO(ContactDAO contactDAO) {
		this.contactDAO = contactDAO;
	}

}
