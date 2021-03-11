package com.example.trainingsplan;

import java.util.ArrayList;
import java.util.List;

class Trainingsplan {
    String name;

    int id;
    int image;

    Trainingsplan(String name, String age, int ids,int images) {
        this.name = name;
        this.id = ids;
        this.image = images;
    }


    private List<Trainingsplan> plan;

    // This method creates an ArrayList that has three Person objects
// Checkout the project associated with this tutorial on Github if
// you want to use the same images.
    public List<Trainingsplan> initializeData(){
        plan = new ArrayList<>();

        plan.add(new Trainingsplan("1","test2",2,R.drawable.ph));
        plan.add(new Trainingsplan("2","test2",2,R.drawable.ic_launcher_foreground));
        plan.add(new Trainingsplan("3","test2",2,R.drawable.ic_launcher_foreground));
        plan.add(new Trainingsplan("4","test2",2,R.drawable.ic_launcher_background));
        plan.add(new Trainingsplan("4","test2",2,R.drawable.ic_launcher_foreground));
        plan.add(new Trainingsplan("4","test2",2,R.drawable.ic_launcher_background));
        return plan;
    }}