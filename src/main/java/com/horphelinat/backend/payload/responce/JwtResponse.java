package com.horphelinat.backend.payload.responce;

import java.util.Optional;

import com.horphelinat.backend.model.Users;


public class JwtResponse {
	
	private String token;
	private String type = "Bearer";
	private Optional<Users>  user;

	 
	public JwtResponse(String token, Optional<Users>  user) {
		this.token = token;
		this.user = user;
	}
	

	public String getAccessToken() {
		return token;
	}

	public void setAccessToken(String accessToken) {
		this.token = accessToken;
	}

	public String getTokenType() {
		return type;
	}

	public void setTokenType(String tokenType) {
		this.type = tokenType;
	}


	public String getToken() {
		return token;
	}


	public void setToken(String token) {
		this.token = token;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public Optional<Users>  getUser() {
		return user;
	}


	public void setUser(Optional<Users>  user) {
		this.user = user;
	}

	
}
