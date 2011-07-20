package com.pgu.games.server.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Menu extends HttpServlet {

    private static final long serialVersionUID = 3229502287401335162L;

    @Override
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException,
                    IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        final PrintWriter out = response.getWriter();
        out.print("{"
                        + //
                        "\"rank\":01,"
                        + //
                        "\"title\":\"Games\","
                        + //
                        "\"img\":\"img/games_header.png\","
                        + //
                        "\"entries\":["
                        + //
                        "{\"title\": \"Memo\", \"img\":\"img/games_memo.png\", \"url\": \"#MemoPlace:\"},"
                        + // 
                        "{\"title\": \"Destroyer\", \"img\":\"img/games_destroyer.png\", \"url\": \"#DestroyerPlace:\"}"
                        + //
                        "]" + //
                        "}");
    }

}
