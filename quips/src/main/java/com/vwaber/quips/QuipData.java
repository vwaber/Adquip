package com.vwaber.quips;

public class QuipData {

    private String setup;
    private String punchline;

    QuipData(String setup, String punchline){
        this.setup = setup;
        this.punchline = punchline;
    }

    public String getSetup() {
        return setup;
    }
    public void setSetup(String setup) { this.setup = setup; }

    public String getPunchline() {
        return punchline;
    }
    public void setPunchline(String punchline) { this.punchline = punchline; }
}
