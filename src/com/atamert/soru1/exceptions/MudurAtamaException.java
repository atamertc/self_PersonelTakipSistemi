package com.atamert.soru1.exceptions;

public class MudurAtamaException extends Exception {
    @Override
    public String getMessage() {
        return "Bu departman zaten bir Mudur'e sahip!";
    }
}
