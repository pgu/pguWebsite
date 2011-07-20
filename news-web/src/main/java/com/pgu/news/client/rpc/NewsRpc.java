package com.pgu.news.client.rpc;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.pgu.news.domain.NewsItem;

@RemoteServiceRelativePath("service")
public interface NewsRpc extends RemoteService {

    ArrayList<NewsItem> getAll();

}
