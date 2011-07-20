package com.pgu.fw.client.mvp;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.pgu.fw.client.ClientFactoryBase;
import com.pgu.fw.client.activity.WelcomeActivity;
import com.pgu.fw.client.place.WelcomePlace;

public class AppActivityMapperBase implements ActivityMapper {
    private final ClientFactoryBase clientFactory;

    public AppActivityMapperBase(final ClientFactoryBase clientFactory) {
        this.clientFactory = clientFactory;
    }

    @Override
    public final Activity getActivity(final Place place) {
        if (place instanceof WelcomePlace) {
            return new WelcomeActivity(clientFactory.getWelcomeView(), clientFactory.getPlaceController());
        }
        return getActivityModule(place);
    }

    /**
     * Hook for modules
     */
    public Activity getActivityModule(final Place place) {
        return null;
    }
}
