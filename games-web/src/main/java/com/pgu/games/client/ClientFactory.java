package com.pgu.games.client;

import com.pgu.fw.client.ClientFactoryBase;
import com.pgu.games.client.ui.DestroyerView;
import com.pgu.games.client.ui.MemoView;

public interface ClientFactory extends ClientFactoryBase {

    DestroyerView getDestroyerView();

    MemoView getMemoView();

}
