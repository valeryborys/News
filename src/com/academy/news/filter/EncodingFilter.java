package com.academy.news.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter{
	private String encoding;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain)
			throws IOException, ServletException {
		req.setCharacterEncoding(encoding);
		resp.setCharacterEncoding(encoding);
		filterChain.doFilter(req, resp);
		System.out.println("filter works!!!");
	}

	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		encoding = fConfig.getInitParameter("characterEncoding");
		
	}

}
