package com.sample.org;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class TweetAction {

	static JdbcTemplate jdbcTemplate;
	private DataSource dataSource;
	
	public DataSource getDataSource() {
		return dataSource;
	}

	@SuppressWarnings("static-access")
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public static void insert(TGetsSets st) {
		// TODO Auto-generated method stub
		
		System.out.println("im in insert function of login");
		String sql = "SELECT * FROM usercomments ";
		
			if (st.getComment()!=null){
				sql = "INSERT into usercomments(username, comments, date) values('"+st.getUsername()+"','"+st.getComment()+"','"+st.getDate()+"')";
				jdbcTemplate.update(sql);
				
			}
			
			
	}
	public static List<TGetsSets> findall(){
		
		String sql = "SELECT * FROM usercomments order by date desc";
		@SuppressWarnings("unchecked")
		List <TGetsSets> tgs = jdbcTemplate.query(sql, new blogRows());	
		
		return tgs;

	}
	
	

}
