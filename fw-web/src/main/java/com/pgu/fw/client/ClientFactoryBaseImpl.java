package com.pgu.fw.client;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.PlaceController;
import com.pgu.fw.client.ui.WelcomeView;
import com.pgu.fw.client.ui.WelcomeViewImpl;

public class ClientFactoryBaseImpl implements ClientFactoryBase {

    private final WelcomeView welcome = new WelcomeViewImpl();
    private static final EventBus eventBus = new SimpleEventBus();
    private static final PlaceController placeController = new PlaceController(eventBus);

    @Override
    public WelcomeView getWelcomeView() {
        return welcome;
    }

    @Override
    public EventBus getEventBus() {
        return eventBus;
    }

    @Override
    public PlaceController getPlaceController() {
        return placeController;
    }

}
