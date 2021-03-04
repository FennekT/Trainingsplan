package com.example.trainingsplan;

import java.util.ArrayList;
import java.util.List;

class Trainingsplan {
    String name;

    int id;

    Trainingsplan(String name, String age, int ids) {
        this.name = name;
        this.id = ids;
    }


    private List<Trainingsplan> plan;

    // This method creates an ArrayList that has three Person objects
// Checkout the project associated with this tutorial on Github if
// you want to use the same images.
    public List<Trainingsplan> initializeData(){
        plan = new ArrayList<>();
        plan.add(new Trainingsplan("1","test",1));
        plan.add(new Trainingsplan("2","test2",2));
        plan.add(new Trainingsplan("3","test",1));
        plan.add(new Trainingsplan("4","test2",2));
        plan.add(new Trainingsplan("5","test",1));
        plan.add(new Trainingsplan("6","test2",2));
        plan.add(new Trainingsplan("7","test",1));
        plan.add(new Trainingsplan("8","test2",2));
        plan.add(new Trainingsplan("9","test",1));
        plan.add(new Trainingsplan("10","test2",2));
        return plan;
    }}