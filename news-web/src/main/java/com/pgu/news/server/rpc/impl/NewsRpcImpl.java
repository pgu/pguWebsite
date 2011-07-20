package com.pgu.news.server.rpc.impl;

import java.util.ArrayList;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.pgu.news.client.rpc.NewsRpc;
import com.pgu.news.domain.NewsItem;

public class NewsRpcImpl extends RemoteServiceServlet implements NewsRpc {

    private static final long serialVersionUID = 4658455253700663537L;

    @Override
    public ArrayList<NewsItem> getAll() {
        return new ArrayList<NewsItem>();
    }

}
