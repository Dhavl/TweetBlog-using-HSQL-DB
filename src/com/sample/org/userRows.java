package com.sample.org;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

@SuppressWarnings("rawtypes")
public class userRows implements RowMapper{

	public GetsSets mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		GetsSets setrow = new GetsSets();
		
		setrow.setUsername(rs.getString("username"));
		setrow.setPassword(rs.getString("password"));
	
		return setrow;
	}

}
