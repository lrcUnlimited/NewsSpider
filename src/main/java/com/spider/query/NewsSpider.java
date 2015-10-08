package com.spider.query;

import org.jsoup.nodes.Document;

import com.spider.db.DBOperate;
import com.spider.db.DataSource;
import com.spider.db.FileOperate;

import cn.edu.hfut.dmic.webcollector.crawler.BreadthCrawler;
import cn.edu.hfut.dmic.webcollector.model.Links;
import cn.edu.hfut.dmic.webcollector.model.Page;

public class NewsSpider extends BreadthCrawler {

	public NewsSpider(String crawlPath, boolean autoParse) {
		super(crawlPath, autoParse);
		// 开始地址
		this.addSeed("http://news.163.com/domestic/");
		// 添加抓取网页的正则表达式
		this.addRegex("http://news.163.com/[0-9]+/[0-9]{4}/[0-9]+/.*.html#f=dlist");
		this.addRegex("http://news.163.com/special/0001124J/guoneinews_[0-9]+.html#headList");
		// 不抓取网页的正则表达式
		this.addRegex("-.*\\.(jpg|png|gif).*");

	}

	@Override
	public void visit(Page page, Links nextLinks) {
		if (page.getUrl().matches(
				"http://news.163.com/[0-9]+/[0-9]{4}/[0-9]+/.*.html#f=dlist")) {
			Document doc = page.getDoc();
			String title = doc.select("#h1title").text();
			String content = doc.select("#endText").text();
			// DBOperate.insert(title, content);
			// 保存内容到文件
			if (content != null && content.length() != 0) {
				FileOperate.saveContentToFile(title, content);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		NewsSpider crawler = new NewsSpider("crawl", true);
		crawler.setThreads(50);
		crawler.setTopN(100);
		// crawler.setResumable(true);
		/* start crawl with depth of 4 */
		crawler.start(10);

	}
}
