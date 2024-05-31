package com.ShopComputer.site.security.oauth;

import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import com.ShopComputer.EntityCommon.Customer;
import com.ShopComputer.site.customer.CustomerService;

public class CustomerOauth2User implements OAuth2User{
	
	
	private OAuth2User oauth2User;
	private String clientName;

	

	public CustomerOauth2User(OAuth2User user, String clientName) {
		this.oauth2User=user;
		this.clientName= clientName;
	}

	@Override
	public Map<String, Object> getAttributes() {
		return this.oauth2User.getAttributes();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.oauth2User.getAuthorities();
	}

	@Override
	public String getName() {
		return this.oauth2User.getAttribute("name");
	}
	
	public String getFullName() {
		return this.oauth2User.getAttribute("name");
	}
	
	public String getEmail() {
		return this.oauth2User.getAttribute("email");
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}


	

}
