package com.sample.org;

public interface LoginActionDAO {

	public String insert(String Username, String Password);
	public String search(String Username, String Password);
}
