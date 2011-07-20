package com.pgu.games.client.activity;

import com.google.gwt.place.shared.PlaceController;
import com.pgu.fw.client.activity.AbstractActivityBase;
import com.pgu.fw.client.ui.ViewBase;
import com.pgu.games.client.ui.MemoView;

public class MemoActivity extends AbstractActivityBase implements MemoView.Presenter {

    public MemoActivity(final ViewBase viewBase, final PlaceController placeController) {
        super(viewBase, placeController);
    }

}
