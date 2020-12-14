package com.academy.news.db.dao.impl;

public class DaoException extends Exception {

	private static final long serialVersionUID = 2925283896162896562L;

	public DaoException () {
		super();
	}
	
	public DaoException (String message) {
		super(message);
	}
	
	public DaoException (Exception e) {
		super(e);
	}
	
	public DaoException (String message, Exception e) {
		super(message, e);
	}
	
}
