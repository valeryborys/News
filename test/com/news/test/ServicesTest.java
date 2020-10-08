package com.news.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.news.model.News;
import com.news.services.NewsService;
import com.news.services.ServiceProvider;
import com.news.services.ServicesException;

public class ServicesTest {

	@Test
	public void servicesTest() {
		String title = "Зеленский подписал указ о привлечении белорусских айтишников в Украину";
		ServiceProvider provider = ServiceProvider.getInstance();
		NewsService service = provider.getNewsService();
		try {
			News newsFromDb = service.find(31);
			assertEquals(title, newsFromDb.getTitle());
		} catch (ServicesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
