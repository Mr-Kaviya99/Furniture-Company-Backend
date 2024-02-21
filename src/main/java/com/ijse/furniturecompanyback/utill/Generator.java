package com.ijse.furniturecompanyback.utill;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class Generator {

    private final Random RANDOM = new Random();
    private final String NUMERIC = "0123456789";
    private final String NUMERIC2 = "123456789";
    public final static String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public final static String CHARACTORS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    //=====================================

    public String generatePrefix(){
        int randomLength = new Random().nextInt((14-6) +1)+6;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < randomLength; i++) {
            builder.append(ALPHABET.charAt(new Random().nextInt(25)));
        }
        return builder.toString();
    }



}
