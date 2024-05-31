package com.ShopComputer.site.setting;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ShopComputer.EntityCommon.Setting;

import javax.servlet.http.HttpServletRequest;
@Component
public class SettingFilter implements Filter{
	
	@Autowired
	private SettingService settingService;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest=(HttpServletRequest) request;
		String url=httpServletRequest.getRequestURL().toString();
		if(url.endsWith(".css") || url.endsWith(".js") || url.endsWith(".png") || url.endsWith(".jpg")) {
			chain.doFilter(httpServletRequest, response);
			return;
		}
		List<Setting> listSetting=settingService.findBySettingForSite();
		for(Setting s: listSetting) {
//			System.out.println(s);
			request.setAttribute(s.getSettingKey(), s.getSettingValue());
		}

		chain.doFilter(httpServletRequest, response);
		
	}

}
