package com.pgu.fw.client;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.pgu.fw.client.ui.WelcomeView;

public interface ClientFactoryBase {
    EventBus getEventBus();

    PlaceController getPlaceController();

    WelcomeView getWelcomeView();

}
