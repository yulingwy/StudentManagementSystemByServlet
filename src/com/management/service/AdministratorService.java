package com.management.service;

import java.util.List;

import com.management.entities.Administrator;

public interface AdministratorService {
	
	public void regiest(Administrator admin);
	
	public void alertAdministrator(Administrator admin);
	
	public void deleteAdministrator(Integer id);
	
	public Integer countAllAdministrator();
	
	public boolean login(String user,String password);
	
	public List<Administrator> getAllAdministrator();

}