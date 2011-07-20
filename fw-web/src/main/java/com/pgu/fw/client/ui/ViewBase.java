package com.pgu.fw.client.ui;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;

public interface ViewBase extends IsWidget {

    void setPresenter(Presenter listener);

    interface Presenter {
        void goTo(Place place);
    }

}
