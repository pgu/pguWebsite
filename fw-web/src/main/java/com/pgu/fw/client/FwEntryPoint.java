package com.pgu.fw.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.RootPanel;
import com.pgu.fw.client.menu.MenuBuilder;

public class FwEntryPoint implements EntryPoint {

    @Override
    public void onModuleLoad() {
        GWT.log(" fw is loaded...");

        final boolean isPortalWebapp = null != RootPanel.get("pgu_portal");
        final boolean isInPortalWebapp = isInPortalWebapp();

        // if  this is not the portal webapp 
        // |__ then 
        //           if  this is a standalone webapp 
        //           |__ then  make the alternative menu
        //           |__ else  it is accessed through the portal, do not make the alternative menu
        // |__  else  this is the portal webapp, do not make the alternative menu (portal has no menu for itself)

        if (!isPortalWebapp && !isInPortalWebapp) {
            final ClientFactoryBase clientFactory = GWT.create(ClientFactoryBase.class);
            final EventBus eventBus = clientFactory.getEventBus();
            new MenuBuilder(eventBus).send();
        }

    }

    private static native boolean isInPortalWebapp() /*-{
		return $wnd != $wnd.parent;
    }-*/;

}
