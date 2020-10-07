package com.news.services.impl;

import com.news.model.News;

public class NewsValidationService {
	private String title;
	private String brief;
	private String content;
	
	public NewsValidationService(News news) {
		this.title=news.getTitle();
		this.brief=news.getBrief();
		this.content=news.getContent();
	}
	

	
	public boolean titleValidation() {
		if (this.title.length()<10 || this.title.length()>500) {
			return false;
		}
		return true;
	}
	public boolean briefValidation() {
		if (this.brief.length()<10 || this.brief.length()>3000) {
			return false;
		}
		return true;
	}
	public boolean contentValidation() {
		if (this.content.length()<10) {
			return false;
		}
		return true;
		
	}
	

}
