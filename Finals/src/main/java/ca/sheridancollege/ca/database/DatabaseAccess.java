package ca.sheridancollege.ca.database;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;
@Repository
public class DatabaseAccess {

	@Autowired
	NamedParameterJdbcTemplate jdbc;

	
	public void registration( String firstname, String lastname, String email,  String phone,  String pass)
	{
		String query="INSERT INTO customers (Firstname, lastname, email, phone, pass) values"
				+ "("+firstname+","+lastname+","+email+","+phone+","+pass+");";
		jdbc.update(query, new HashMap());
	}
}
