package com.pgu.news.client;

import java.util.ArrayList;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.pgu.news.client.rpc.NewsRpc;
import com.pgu.news.client.rpc.NewsRpcAsync;
import com.pgu.news.domain.NewsItem;

public class NewsEntryPoint implements EntryPoint {

    @Override
    public void onModuleLoad() {
        GWT.log(" News loaded  !! ");

        final NewsRpcAsync serviceNews = GWT.create(NewsRpc.class);
        serviceNews.getAll(new AsyncCallback<ArrayList<NewsItem>>() {

            @Override
            public void onFailure(final Throwable caught) {
                GWT.log("failure...");
            }

            @Override
            public void onSuccess(final ArrayList<NewsItem> result) {
                GWT.log("success...");
            }

        });
    }

}
