package com.pgu.games.client.mvp;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.Place;
import com.pgu.fw.client.mvp.AppActivityMapperBase;
import com.pgu.games.client.ClientFactory;
import com.pgu.games.client.activity.DestroyerActivity;
import com.pgu.games.client.activity.MemoActivity;
import com.pgu.games.client.place.DestroyerPlace;
import com.pgu.games.client.place.MemoPlace;

public class AppActivityMapper extends AppActivityMapperBase {
    private final ClientFactory clientFactory;

    public AppActivityMapper(final ClientFactory clientFactory) {
        super(clientFactory);
        this.clientFactory = clientFactory;
    }

    @Override
    public Activity getActivityModule(final Place place) {
        if (place instanceof MemoPlace) {
            return new MemoActivity(clientFactory.getMemoView(), clientFactory.getPlaceController());
        } else if (place instanceof DestroyerPlace) {
            return new DestroyerActivity(clientFactory.getDestroyerView(), clientFactory.getPlaceController());
        }
        return null;
    }

}
