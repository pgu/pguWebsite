package com.pgu.news.impl;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import com.pgu.news.domain.NewsItem;
import com.pgu.news.impl.NewsDaoImpl;

public class NewsDaoImplTest {

    private final NewsDaoImpl dao = new NewsDaoImpl();

    @Test
    public void getAll() {
        // given
        // when
        final List<NewsItem> news = dao.getAll();
        // then
        Assert.assertNotNull(news);
    }
}
