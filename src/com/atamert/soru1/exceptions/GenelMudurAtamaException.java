package com.atamert.soru1.exceptions;

public class GenelMudurAtamaException extends Exception {

    @Override
    public String getMessage() {
        return "Bu departman zaten bir Genel Mudur'e sahip!";
    }

}
