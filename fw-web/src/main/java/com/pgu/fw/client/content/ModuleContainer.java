package com.pgu.fw.client.content;

import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Frame;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.pgu.fw.client.event.MenuChangeEvent;
import com.pgu.fw.client.event.MenuChangeEventHandler;

public class ModuleContainer extends Composite implements MenuChangeEventHandler {

    private Frame frame;

    public ModuleContainer(final Widget widget) {
        if (widget instanceof Frame) {
            frame = (Frame) widget;
            initWidget(frame);
        } else {
            RootPanel.get().add(widget);
        }
    }

    @Override
    public void onMenuChange(final MenuChangeEvent event) {
        final String url = event.getUrl();
        if (null == frame) {
            History.newItem(url.split("#")[1]);
        } else {
            frame.setUrl(url);
        }
    }

}
