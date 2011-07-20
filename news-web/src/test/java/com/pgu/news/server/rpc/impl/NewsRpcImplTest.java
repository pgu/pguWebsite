package com.pgu.news.server.rpc.impl;

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Test;

import com.pgu.news.domain.NewsItem;

public class NewsRpcImplTest {

    private final NewsRpcImpl rpc = new NewsRpcImpl();

    @Test
    public void getAll() {
        //given
        // when
        final ArrayList<NewsItem> news = rpc.getAll();
        // then
        Assert.assertNotNull(news);
    }

}
