package com.news.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.news.db.dao.impl.DaoException;
import com.news.db.dao.impl.SqlNewsDaoImpl;
import com.news.model.News;

public class DaoTest {

	@Test
	public void findTest() {
		String title = "Зеленский подписал указ о привлечении белорусских айтишников в Украину";
		SqlNewsDaoImpl newsDao = new SqlNewsDaoImpl();
		News newsFromDB;
		try {
			newsFromDB = newsDao.find(31);
			assertEquals(title, newsFromDB.getTitle());
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}


}
