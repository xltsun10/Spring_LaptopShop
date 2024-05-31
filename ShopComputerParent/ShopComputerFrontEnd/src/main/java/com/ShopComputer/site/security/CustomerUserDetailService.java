package com.ShopComputer.site.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.ShopComputer.EntityCommon.Customer;
import com.ShopComputer.site.customer.CustomerRepository;

public class CustomerUserDetailService implements UserDetailsService{
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Customer customer=null;
		if(customerRepository.findByEmail(username).isEmpty()) {
			throw new UsernameNotFoundException("Không tìm thấy tài khoản với email "+username);
		}else {
		    customer= customerRepository.findByEmail(username).get();
		    return new CustomerUserDetail(customer);
		}

	}

}
