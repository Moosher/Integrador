package model.dao.bd;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseService {

    static String url = "jdbc:oracle:thin:@localhost:1521:XE";

    static String user = "integrador";

    static String passwd = "123456";

    public static Connection getConnection() {
	Connection conn = null;

	try {

	    conn = DriverManager.getConnection( url, user, passwd );

	} catch ( Exception e ) {
	    e.printStackTrace();
	}

	return conn;

    }
}