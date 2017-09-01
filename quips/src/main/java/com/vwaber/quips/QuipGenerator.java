package com.vwaber.quips;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuipGenerator {

    private List<Quip> quips = new ArrayList<>();

    public QuipGenerator(){
        quips.add(new Quip("Why are plants green?", "To better absorb sunlight"));
        quips.add(new Quip("What did the turtle say to the rock?", "Nothing"));
        quips.add(new Quip("Why did the chicken cross the road", "Primitive thought processes"));
    }

    public Quip getNext(){
        Random random = new Random();
        int n = random.nextInt(quips.size());
        return quips.get(n);
    }


}
