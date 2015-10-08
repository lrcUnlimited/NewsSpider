package com.spider;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cn.edu.hfut.dmic.webcollector.extract.Extractors;
import cn.edu.hfut.dmic.webcollector.net.HttpRequest;

public class SpiderTest {
	public static void main(String[] args) {
		
		String regex = "[\"|(\" \")+|\\||:]";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher("okaa\"|:LetmeAseeaaaaabooa");
		String s = matcher.replaceAll("");
		System.out.println(s);
		
		String a="\"\"";
		System.out.println(a);
	}

}
