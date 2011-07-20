package com.pgu.news.service.impl;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import com.pgu.news.domain.NewsItem;

public class NewsServiceImplTest {

	private final NewsServiceImpl service = new NewsServiceImpl();

	@Test
	public void getAll() {
		// given
		// when
		final List<NewsItem> news = service.getAll();
		// then
		Assert.assertNotNull(news);
	}

}
