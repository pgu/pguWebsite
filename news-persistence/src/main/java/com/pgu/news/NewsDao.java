package com.pgu.news;

import java.util.List;

import com.pgu.news.domain.NewsItem;

public interface NewsDao {

    List<NewsItem> getAll();

}
