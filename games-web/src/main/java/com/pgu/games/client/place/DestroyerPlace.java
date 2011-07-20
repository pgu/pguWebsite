package com.pgu.games.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class DestroyerPlace extends Place {
    public static class Tokenizer implements PlaceTokenizer<DestroyerPlace> {

        @Override
        public String getToken(final DestroyerPlace place) {
            return "";
        }

        @Override
        public DestroyerPlace getPlace(final String token) {
            return new DestroyerPlace();
        }

    }

}
