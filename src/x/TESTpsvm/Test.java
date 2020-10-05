package x.TESTpsvm;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Test {
public static void main(String[] args) {
	Timestamp ts = new Timestamp(System.currentTimeMillis());
	System.out.println(ts);
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	String format = sdf.format(ts);
	System.out.println(format);
	

}
}
