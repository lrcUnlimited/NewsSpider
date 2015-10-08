package com.spider.db;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileOperate {
	/**
	 * 保存数据到文件
	 * 
	 * @param title
	 * @param content
	 */
	private static final String BASEPATH = "D:/news/";
	private static String regex = "[\"|(\" \")+|\\||:]";
	private static Pattern pattern = Pattern.compile(regex);

	public static void saveContentToFile(String title, String content) {
		Matcher matcher = pattern.matcher(title);
		title = matcher.replaceAll("");
		File f = new File(BASEPATH + title + ".txt");
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(f));
			writer.write(content);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	}

}
