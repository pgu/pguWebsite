package com.pgu.portal.client.rpc;

import java.util.HashSet;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("service/module")
public interface ModuleRpc extends RemoteService {

    HashSet<String> getModules();

}
