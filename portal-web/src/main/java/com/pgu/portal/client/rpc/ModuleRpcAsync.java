package com.pgu.portal.client.rpc;

import java.util.HashSet;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ModuleRpcAsync {

    void getModules(AsyncCallback<HashSet<String>> callback);

}
