package com.vwaber.quips;

public class Quip {

    private String setup;
    private String punchline;

    Quip(String setup, String punchline){
        this.setup = setup;
        this.punchline = punchline;
    }

    public String getSetup() {
        return setup;
    }

    public String getPunchline() {
        return punchline;
    }
}
