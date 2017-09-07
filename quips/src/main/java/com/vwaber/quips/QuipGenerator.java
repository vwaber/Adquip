package com.vwaber.quips;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuipGenerator {

    private final List<QuipData> quipDatas = new ArrayList<>();

    public QuipGenerator(){
        quipDatas.add(new QuipData("I went to a really emotional wedding the other day", "Even the cake was in tiers"));
        quipDatas.add(new QuipData("I tried to catch fog yesterday", "Mist"));
        quipDatas.add(new QuipData("What do you call a dog with no legs?", "It don't matter, its not going to come"));
        quipDatas.add(new QuipData("I have a genetic predisposition for diarrhea", "Runs in my jeans"));
        quipDatas.add(new QuipData("Someone stole my mood ring", "I don't know how I feel about it"));
        quipDatas.add(new QuipData("Why does a chicken coop have two doors? ", "If it had four doors it would be a chicken sedan"));
    }

    public QuipData getNext(){
        Random random = new Random();
        int n = random.nextInt(quipDatas.size());
        return quipDatas.get(n);
    }


}
