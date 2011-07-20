package com.pgu.fw.client.menu;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HasHandlers;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.pgu.fw.client.event.MenuChangeEvent;
import com.pgu.fw.client.util.StringHelper;

public class MenuEntry extends Composite implements HasHandlers {

    private final EventBus eventBus;
    private final HorizontalPanel hPanel = new HorizontalPanel();

    public MenuEntry(final String html, final String imageUrl, final EventBus eventBus) {
        this.eventBus = eventBus;

        hPanel.setHeight("100%");
        hPanel.setSpacing(0);
        hPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);

        boolean hasContent = false;
        if (!StringHelper.isBlank(imageUrl)) {
            hPanel.add(new Image(imageUrl));
            hasContent = true;
        }
        if (!StringHelper.isBlank(html)) {
            hPanel.add(new HTML(html));
            hasContent = true;
        }
        if (!hasContent) {
            throw new IllegalArgumentException("Review the menu: the entry has no content!");
        }

        initWidget(hPanel);
    }

    public void setContentUrl(final String contentUrl) {
        if (null == contentUrl) {
            throw new IllegalArgumentException("the content url must point to something!");
        }

        hPanel.addDomHandler(new ClickHandler() {

            @Override
            public void onClick(final ClickEvent event) {
                GWT.log(" click entry " + contentUrl);
                eventBus.fireEvent(new MenuChangeEvent(contentUrl));
            }

        }, ClickEvent.getType());
    }

}
