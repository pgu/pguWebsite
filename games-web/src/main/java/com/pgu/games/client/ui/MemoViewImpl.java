package com.pgu.games.client.ui;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.pgu.fw.client.place.WelcomePlace;
import com.pgu.fw.client.ui.ViewBaseImpl;

public class MemoViewImpl extends ViewBaseImpl implements MemoView {

    private final Button goDefault = new Button("Game Home");
    private final Label label = new Label("Memo...");

    public MemoViewImpl() {
        final HorizontalPanel hp = new HorizontalPanel();
        hp.add(label);
        hp.add(goDefault);
        initWidget(hp);

        goDefault.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(final ClickEvent event) {
                getListener().goTo(new WelcomePlace());
            }
        });

    }

}
