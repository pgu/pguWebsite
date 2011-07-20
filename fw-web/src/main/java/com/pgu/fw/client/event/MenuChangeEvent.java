package com.pgu.fw.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class MenuChangeEvent extends GwtEvent<MenuChangeEventHandler> {

    public static Type<MenuChangeEventHandler> TYPE = new Type<MenuChangeEventHandler>();

    private final String url;

    public MenuChangeEvent(final String url) {
        this.url = url;
    }

    @Override
    public Type<MenuChangeEventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(final MenuChangeEventHandler handler) {
        handler.onMenuChange(this);
    }

    public String getUrl() {
        return url;
    }

}
