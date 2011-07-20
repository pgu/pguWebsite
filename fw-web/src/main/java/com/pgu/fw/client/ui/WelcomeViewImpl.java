package com.pgu.fw.client.ui;

import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;

public class WelcomeViewImpl extends ViewBaseImpl implements WelcomeView {

    //    private final Button goMemo = new Button("Memo game");
    //    private final Button goDestroyer = new Button("Destroyer game");

    public WelcomeViewImpl() {
        final HorizontalPanel hp = new HorizontalPanel();
        hp.add(new Label("Welcome!"));
        //        hp.add(goMemo);
        //        hp.add(goDestroyer);
        initWidget(hp);

        //        goMemo.addClickHandler(new ClickHandler() {
        //
        //            @Override
        //            public void onClick(final ClickEvent event) {
        //                listener.goTo(new MemoPlace());
        //            }
        //        });
        //        goDestroyer.addClickHandler(new ClickHandler() {
        //
        //            @Override
        //            public void onClick(final ClickEvent event) {
        //                listener.goTo(new DestroyerPlace());
        //            }
        //        });

    }

}
