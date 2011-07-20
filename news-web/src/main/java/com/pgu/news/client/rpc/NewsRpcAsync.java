package com.pgu.news.client.rpc;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.pgu.news.domain.NewsItem;

public interface NewsRpcAsync {

    void getAll(AsyncCallback<ArrayList<NewsItem>> callback);

}
