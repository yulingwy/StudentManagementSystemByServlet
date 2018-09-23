package com.management.dao;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.management.entities.Administrator;

public interface AdministratorDao {

	public boolean existAdministrator(Administrator admin) throws SQLException, IOException;
	
	public boolean loginAdministrator(String userName,String password) throws IOException, SQLException;
	
	public void registerAdministrator(Administrator admin) throws IOException, SQLException;
	
	public ResultSet queryAllAdministrator() throws IOException;
	
	public void alertAdministrator(Administrator admin) throws IOException, SQLException;
	
	public void deleteAdministrator(Administrator admin) throws SQLException;
	
}
