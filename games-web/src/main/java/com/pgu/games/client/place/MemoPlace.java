package com.pgu.games.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class MemoPlace extends Place {
    public static class Tokenizer implements PlaceTokenizer<MemoPlace> {

        @Override
        public String getToken(final MemoPlace place) {
            return "";
        }

        @Override
        public MemoPlace getPlace(final String token) {
            return new MemoPlace();
        }

    }

}
