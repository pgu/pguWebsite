package com.pgu.games.client.mvp;

import com.google.gwt.place.shared.WithTokenizers;
import com.pgu.fw.client.mvp.AppPlaceHistoryMapperBase;
import com.pgu.games.client.place.DestroyerPlace;
import com.pgu.games.client.place.MemoPlace;

@WithTokenizers({ // 
MemoPlace.Tokenizer.class, //
                DestroyerPlace.Tokenizer.class //
})
public interface AppPlaceHistoryMapper extends AppPlaceHistoryMapperBase {

}
