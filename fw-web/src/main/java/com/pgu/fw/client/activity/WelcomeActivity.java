package com.pgu.fw.client.activity;

import com.google.gwt.place.shared.PlaceController;
import com.pgu.fw.client.ui.ViewBase;
import com.pgu.fw.client.ui.WelcomeView;

public class WelcomeActivity extends AbstractActivityBase implements WelcomeView.Presenter {

    public WelcomeActivity(final ViewBase viewBase, final PlaceController placeController) {
        super(viewBase, placeController);
    }

}
