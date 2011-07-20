package com.pgu.games.client;

import com.pgu.fw.client.ClientFactoryBaseImpl;
import com.pgu.games.client.ui.DestroyerView;
import com.pgu.games.client.ui.DestroyerViewImpl;
import com.pgu.games.client.ui.MemoView;
import com.pgu.games.client.ui.MemoViewImpl;

public class ClientFactoryImpl extends ClientFactoryBaseImpl implements ClientFactory {

    private final MemoView memo = new MemoViewImpl();
    private final DestroyerView destroyer = new DestroyerViewImpl();

    @Override
    public DestroyerView getDestroyerView() {
        return destroyer;
    }

    @Override
    public MemoView getMemoView() {
        return memo;
    }

}
