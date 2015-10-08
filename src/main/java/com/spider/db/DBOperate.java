package com.spider.db;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBOperate {
	/**
	 * 
	 * @param sql
	 * @param title
	 * @param content
	 */

	public static void insert(String title, String content) {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		try {
			conn = DataSource.getInstance().getConnection();
			preparedStatement = conn
					.prepareStatement("insert into news(title,content) values(?,?)");
			preparedStatement.setString(1, title);
			preparedStatement.setString(2, content);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
