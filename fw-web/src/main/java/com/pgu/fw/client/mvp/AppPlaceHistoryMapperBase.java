package com.pgu.fw.client.mvp;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;
import com.pgu.fw.client.place.WelcomePlace;

@WithTokenizers({ // 
//
WelcomePlace.Tokenizer.class //
})
public interface AppPlaceHistoryMapperBase extends PlaceHistoryMapper {

}
