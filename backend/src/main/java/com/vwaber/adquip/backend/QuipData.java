package com.vwaber.adquip.backend;

/**
 * The object model for the data we are sending through endpoints
 */
public class QuipData {

    private String setup;
    private String punchline;

    public String getSetup() { return setup; }
    public void setSetup(String setup) { this.setup = setup; }

    public String getPunchline() { return punchline; }
    public void setPunchline(String punchline) { this.punchline = punchline; }

}