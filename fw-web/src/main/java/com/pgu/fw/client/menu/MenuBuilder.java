package com.pgu.fw.client.menu;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.TreeMap;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.RepeatingCommand;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.URL;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Event.NativePreviewEvent;
import com.google.gwt.user.client.Event.NativePreviewHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.StackLayoutPanel;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class MenuBuilder {

    private StackLayoutPanel stackPanel;
    private Panel container;
    private final EventBus eventBus;

    private int nbRequestsSent = 0;
    private int nbResponses = 0;
    private final HashSet<String> moduleNames = new HashSet<String>();
    private final TreeMap<Integer, Widget> rank2header = new TreeMap<Integer, Widget>(); // sorts the widget by their rank
    private final HashMap<Integer, Tree> rank2body = new HashMap<Integer, Tree>();

    public MenuBuilder(final EventBus eventBus) {
        this.eventBus = eventBus;
    }

    public MenuBuilder(final HashSet<String> modules, final Panel w, final EventBus eventBus) {
        this(eventBus);
        moduleNames.addAll(modules);
        container = w;
    }

    public void incResponseReceived() {
        nbResponses++;
    }

    public void put(final Integer rank, final Widget header, final Tree body) {
        if (rank2header.containsKey(rank)) {
            throw new IllegalArgumentException("The rank is already used! " + rank);
        }
        rank2header.put(rank, header);
        rank2body.put(rank, body);
    }

    public void send() {
        nbRequestsSent = 0;

        // init gui container
        stackPanel = new StackLayoutPanel(Unit.EM);
        stackPanel.setSize("100%", "100%");

        // send requests
        if (!moduleNames.isEmpty()) {

            final String baseUrl = Window.Location.getProtocol() + "//" + Window.Location.getHost() + "/";
            nbRequestsSent = moduleNames.size();

            for (final String moduleName : moduleNames) {
                send(baseUrl + moduleName + "/");
            }
        } else {
            nbRequestsSent = 1;
            send(GWT.getHostPageBaseURL());
        }
        Scheduler.get().scheduleFixedPeriod(new RepeatingCommand() {

            @Override
            public boolean execute() {
                return !isMenuDisplayed(); // re-executes until the menu is displayed
            }
        }, 500);
    }

    private boolean isMenuDisplayed() {
        GWT.log("showMenu " + (nbResponses == nbRequestsSent) + ", resp: " + nbResponses + ", req: " + nbRequestsSent);

        final boolean areAllResponsesBack = nbResponses == nbRequestsSent;
        if (areAllResponsesBack) {
            //
            // add the entries to the stackpanel according to the order of their respective rank
            for (final Entry<Integer, Widget> entry : rank2header.entrySet()) {
                stackPanel.add(rank2body.get(entry.getKey()), entry.getValue(), 4);
            }

            //
            // add the stackpanel to the appropriate container
            if (null != container) {
                container.add(stackPanel);
            } else {
                setMenuAsPopup(); // sets the alternative menu: presents the stackPanel inside a popup menu
            }
        }
        return areAllResponsesBack;
    }

    private void send(final String baseUrl) {

        final RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, URL.encode(baseUrl + "menu"));
        try {
            builder.sendRequest(null, new MenuCallback(baseUrl, this, eventBus));
        } catch (final RequestException e) {
            nbResponses++;
            GWT.log(e.getMessage(), e); // don't break the application because of an unreachable module 
        }
    }

    private void setMenuAsPopup() {
        final int height = 450;
        final DialogBox menuBox = new DialogBox();
        menuBox.setPixelSize(250, height);
        menuBox.add(stackPanel);
        menuBox.setGlassEnabled(true);
        menuBox.setAnimationEnabled(true);

        final Button closeBtn = new Button("X");
        closeBtn.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(final ClickEvent event) {
                menuBox.hide();
            }
        });

        final VerticalPanel v = new VerticalPanel();
        v.setPixelSize(250, height);
        stackPanel.setHeight(height + "px");
        v.add(stackPanel);
        v.add(closeBtn);
        v.setCellHorizontalAlignment(closeBtn, HasHorizontalAlignment.ALIGN_RIGHT);

        menuBox.add(v);
        menuBox.hide();

        // ctrl+L to display the popup menu
        Event.addNativePreviewHandler(new NativePreviewHandler() {

            @Override
            public void onPreviewNativeEvent(final NativePreviewEvent event) {
                final NativeEvent ne = event.getNativeEvent();
                if (ne.getCtrlKey() && (ne.getKeyCode() == 'l' || ne.getKeyCode() == 'L')) {
                    ne.preventDefault();
                    Scheduler.get().scheduleDeferred(new ScheduledCommand() {

                        @Override
                        public void execute() {
                            menuBox.center();
                            menuBox.show();
                        }
                    });
                }
            }
        });
    }
}
