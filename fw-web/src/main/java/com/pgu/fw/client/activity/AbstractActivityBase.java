package com.pgu.fw.client.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.pgu.fw.client.ui.ViewBase;

public class AbstractActivityBase extends AbstractActivity implements ViewBase.Presenter {

    private final ViewBase viewBase;
    private final PlaceController placeController;

    public AbstractActivityBase(final ViewBase viewBase, final PlaceController placeController) {
        this.viewBase = viewBase;
        this.placeController = placeController;
    }

    @Override
    public void start(final AcceptsOneWidget panel, final EventBus eventBus) {
        viewBase.setPresenter(this);
        panel.setWidget(viewBase.asWidget());
    }

    @Override
    public void goTo(final Place place) {
        placeController.goTo(place);
    }

}
