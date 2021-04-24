package com.concordia.mealplanner.localVariables;

import androidx.annotation.NonNull;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

public class Ingredients {
    @Getter @Setter (AccessLevel.PROTECTED)
    private int ID;
    @Getter @Setter (AccessLevel.PROTECTED)
    private String name;

    @Getter @Setter (AccessLevel.PROTECTED)
    private int quantity;
    private int images;
    public Ingredients(@NonNull int ID){
        this.ID = ID;
    }

}
