package x.TESTpsvm;


import java.util.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.news.db.dao.NewsDAO;
import com.news.db.dao.impl.DaoException;
import com.news.db.dao.impl.SqlNewsDaoImpl;
import com.news.model.News;

public class Teest {
	public static void main(String[] args) {
	    News news = new News();
	    news.setId(17);
		news.setTitle("rtret17");
		news.setBrief("brief17");
		news.setContent("17");
		NewsDAO<News> newsDao = new SqlNewsDaoImpl();
		News newsF=null;
		try {
			newsF = newsDao.find(1);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(newsF.getId() + " " + newsF.getTitle()+ " " +newsF.getDatetime() + " " + newsF.getBrief() + " " +newsF.getContent() );
	
		    
		   
//			try {
//				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
//				 Date parsedDate =  dateFormat.parse("2020-09-30 17:27:00.0");
//				  Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
//				    System.out.println(timestamp);
//			} catch (ParseException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		  
	
		
		
	}

}
