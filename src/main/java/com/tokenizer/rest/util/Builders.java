package com.tokenizer.rest.util;

import com.tokenizer.rest.model.AuthModel;
import com.tokenizer.rest.request.AuthRequest;

public class Builders {
    private Builders() {

    }
    public static AuthModel build(AuthRequest request) {
        return new AuthModel()
            .setCardNumber(request.getCardNumber())
            .setExpirationDate(request.getExpirationDate())
            .setCardCVC(request.getCardCVC());
    }
}
