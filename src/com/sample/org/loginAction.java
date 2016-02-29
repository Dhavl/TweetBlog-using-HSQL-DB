package com.sample.org;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class loginAction implements LoginActionDAO{
	
	@Autowired
	
	JdbcTemplate jdbcTemplate;
	private DataSource dataSource;
	
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}


	public loginAction() {

		// TODO Auto-generated constructor stub
	    
	    //create table
	}

	
		/*public List<GetsSets> findAll(){
		
		String sql = "SELECT * FROM users order by id desc ";
		
		return this.jdbcTemplate.query(sql, new userRows());
      } */
		
	@SuppressWarnings("unchecked")
	public String insert(String Username, String Password) {
		// TODO Auto-generated method stub
		 

		System.out.println("im in insert function of login");
		String sql = "SELECT * FROM users ";
		
		List <GetsSets> gs = jdbcTemplate.query(sql, new userRows());
		
		Boolean temp=true;
		for (GetsSets r: gs)
		{
			System.out.println("im in for loop "+ r.getUsername());
			if(Username.equalsIgnoreCase(r.getUsername()))
			{
				System.out.println("Username Already Exists");
				
				temp=false;
				return "AlreadyExists";
			}
		}
		
			if (temp&&Username!=null && Password != null){
			sql = "INSERT into users(username, password) values('"+Username+"','"+Password+"')";
			jdbcTemplate.update(sql);
			
			return "Success";
			}
		
			else{
				return "Failed";
			}
		
	}
	

	@Override
	public String search(String username, String password) {
		// TODO Auto-generated method stub
		
		
		String sql = "SELECT * FROM users";
		
		@SuppressWarnings("unchecked")
		List <GetsSets> gs = jdbcTemplate.query(sql, new userRows());
		
		//Boolean temp=true;
		
		for (GetsSets r: gs)
		{
			
			if(username.equalsIgnoreCase(r.getUsername())&& password.equalsIgnoreCase(r.getPassword()))
			{
				System.out.println("Username search Exists");
			//	temp=false;
				return "ValidUser";
			}	
		}
		//if(temp)
	//	{
			System.out.println("failed......");
		//}
		return "Failed";
	}

}
