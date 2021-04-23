package com.concordia.mealplanner.Adapter;

public class userData {

    private String recipe;
    private String name;
    private String movie;
    String[] bSet = new String[7];


    public userData(String recipe, String name, String movie) {
        this.recipe = recipe;
        this.name = name;
        this.movie = movie;
    }

    public String getRecipe() {
        return recipe;
    }

    public String getName() {
        return name;
    }

    public String getMovie() {
        return movie;
    }
    public void setB(String[] bSett){
        bSet = bSett;
    };

    public String [] getB(){
        return bSet;};
}
