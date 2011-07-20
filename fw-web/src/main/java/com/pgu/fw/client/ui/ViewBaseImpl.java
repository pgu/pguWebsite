package com.pgu.fw.client.ui;

import com.google.gwt.user.client.ui.Composite;

public class ViewBaseImpl extends Composite implements ViewBase {

    private Presenter listener;

    @Override
    public void setPresenter(final Presenter listener) {
        this.listener = listener;
    }

    public Presenter getListener() {
        return listener;
    }

}
