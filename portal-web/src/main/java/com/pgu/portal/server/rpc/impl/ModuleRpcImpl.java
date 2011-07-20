package com.pgu.portal.server.rpc.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;

import javax.servlet.ServletContext;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.pgu.portal.client.rpc.ModuleRpc;

public class ModuleRpcImpl extends RemoteServiceServlet implements ModuleRpc {

    private static final long serialVersionUID = -617423300238870518L;

    @Override
    public HashSet<String> getModules() {
        final ServletContext servletContext = getServletContext();
        final InputStream is = servletContext.getResourceAsStream(servletContext.getInitParameter("modules"));
        final BufferedReader reader = new BufferedReader(new InputStreamReader(is));

        final HashSet<String> modules = new HashSet<String>();
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                modules.add(line.trim());
            }
        } catch (final IOException e) {
            e.printStackTrace();
        }
        return modules;
    }

}
