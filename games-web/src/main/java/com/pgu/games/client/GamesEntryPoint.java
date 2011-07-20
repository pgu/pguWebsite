package com.pgu.games.client;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.SimplePanel;
import com.pgu.fw.client.content.ModuleContainer;
import com.pgu.fw.client.event.MenuChangeEvent;
import com.pgu.fw.client.place.WelcomePlace;
import com.pgu.games.client.mvp.AppActivityMapper;
import com.pgu.games.client.mvp.AppPlaceHistoryMapper;

public class GamesEntryPoint implements EntryPoint {

    @Override
    public void onModuleLoad() {
        GWT.log(" games is loaded...");

        // appli
        final ClientFactory clientFactory = GWT.create(ClientFactory.class);
        final EventBus eventBus = clientFactory.getEventBus();
        final PlaceController placeController = clientFactory.getPlaceController();

        final ActivityMapper activityMapper = new AppActivityMapper(clientFactory);
        final ActivityManager activityManager = new ActivityManager(activityMapper, eventBus);

        final SimplePanel panel = new SimplePanel();
        activityManager.setDisplay(panel);

        final ModuleContainer container = new ModuleContainer(panel);
        eventBus.addHandler(MenuChangeEvent.TYPE, container);

        final AppPlaceHistoryMapper historyMapper = GWT.create(AppPlaceHistoryMapper.class);
        final PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
        historyHandler.register(placeController, eventBus, new WelcomePlace());

        historyHandler.handleCurrentHistory();

    }

}
