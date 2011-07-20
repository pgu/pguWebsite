package com.pgu.portal.client;

import java.util.HashSet;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Frame;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.SplitLayoutPanel;
import com.pgu.fw.client.ClientFactoryBase;
import com.pgu.fw.client.content.ModuleContainer;
import com.pgu.fw.client.event.MenuChangeEvent;
import com.pgu.fw.client.menu.MenuBuilder;
import com.pgu.portal.client.rpc.ModuleRpc;
import com.pgu.portal.client.rpc.ModuleRpcAsync;

public class PortalEntryPoint implements EntryPoint {

    private EventBus eventBus;

    private final ModuleRpcAsync moduleRpc = GWT.create(ModuleRpc.class);

    @Override
    public void onModuleLoad() {
        GWT.log(" portal is loaded...");

        final ClientFactoryBase clientFactory = GWT.create(ClientFactoryBase.class);
        eventBus = clientFactory.getEventBus();

        final SplitLayoutPanel splitPanel = new SplitLayoutPanel(5);

        int w = Window.getClientWidth();
        w -= 50;
        int h = Window.getClientHeight();
        h -= 25;

        splitPanel.setPixelSize(w, h);
        splitPanel.getElement().getStyle().setProperty("border", "3px solid #e7e7e7");

        splitPanel.addNorth(getMenuBar(), 35);
        splitPanel.addSouth(getFooter(), 35);

        //
        // menu of available applications
        final SimplePanel p = new SimplePanel();
        p.setSize("100%", "100%");
        setMenuApp(p);
        splitPanel.addWest(p, 250);

        // 
        // content of the applications
        final Frame frame = new Frame("welcome.html");
        frame.setWidth("100%");
        final ModuleContainer container = new ModuleContainer(frame);
        eventBus.addHandler(MenuChangeEvent.TYPE, container);
        final ScrollPanel centerScrollable = new ScrollPanel(container);
        splitPanel.add(centerScrollable);

        RootPanel.get().add(splitPanel);

        // TODO PGU height and width
        //        frame.setHeight(container.getOffsetHeight() - 50 + "px");
    }

    private MenuBar getMenuBar() {
        final MenuBar menu = new MenuBar();
        menu.setAutoOpen(true);
        menu.setWidth("100%");
        menu.setAnimationEnabled(true);

        final MenuBar entryAction1 = new MenuBar(true);
        entryAction1.setAnimationEnabled(true);
        entryAction1.addItem("Do something...", menuCommand);
        menu.addItem(new MenuItem("Action 1", entryAction1));

        return menu;
    }

    private final Command menuCommand = new Command() {
        @Override
        public void execute() {
            Window.alert("You've done something!");
        }
    };

    private Label getFooter() {
        return new Label("Stock quotes defiling...");
    }

    private void setMenuApp(final Panel panel) {
        moduleRpc.getModules(new AsyncCallback<HashSet<String>>() {

            @Override
            public void onSuccess(final HashSet<String> moduleNames) {
                new MenuBuilder(moduleNames, panel, eventBus).send();
            }

            @Override
            public void onFailure(final Throwable caught) {
                GWT.log(caught.getMessage(), caught);
            }
        });

    }

}
