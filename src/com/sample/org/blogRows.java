package com.sample.org;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

@SuppressWarnings("rawtypes")
public class blogRows implements RowMapper{
	
	public TGetsSets mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		TGetsSets tsetrow = new TGetsSets();
		
		tsetrow.setUsername(rs.getString("username"));
		tsetrow.setComment(rs.getString("comments"));
		tsetrow.setDate(rs.getString("date"));
		
		return tsetrow;
	}

}
