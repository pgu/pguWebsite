package com.pgu.news.server.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Menu extends HttpServlet {

    private static final long serialVersionUID = -8359329132512757716L;

    @Override
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException,
                    IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        final PrintWriter out = response.getWriter();
        out.print("[" + //

                        "{" + //
                        "\"rank\":10," + //
                        "\"title\":\"News\"," + //
                        "\"img\":\"img/news_header.png\"," + //
                        "\"entries\":[" + //
                        "{\"title\": \"News by hour\", \"entries\":[" + //
                        "{\"title\": \" 0 - 12\", \"img\":\"img/news_by_hour_am.png\", \"url\": \"/news#ham\"}," + //
                        "{\"title\": \"13 - 24\", \"img\":\"img/news_by_hour_pm.png\", \"url\": \"/news#hpm\"}" + //
                        "]} , " + //
                        "{\"title\": \"News by area\", \"entries\":[" + //
                        "{\"title\": \"A - M\", \"img\":\"img/news_by_area_am.png\", \"url\": \"/news#aam\"}," + //
                        "{\"title\": \"N - Z\", \"img\":\"img/news_by_area_nz.png\", \"url\": \"/news#anz\"}" + //
                        "]} " + //
                        "]" + //
                        "}," + //

                        "{" + //
                        "\"rank\":11," + //
                        "\"title\":\"News2\"," + //
                        "\"img\":\"img/news_header_2.png\"," + //
                        "\"entries\":[" + //
                        "{\"title\": \"go 1\", \"img\":\"img/news_by_hour_2.png\", \"url\": \"/news#hpm2\"}," + //
                        "{\"title\": \"go 2\", \"img\":\"img/news_by_area_2.png\", \"url\": \"/news#anz2\"}" + //
                        "]" + //
                        "}" + //

                        "]" //
        );

    }

}
