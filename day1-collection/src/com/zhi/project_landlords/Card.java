package com.zhi.project_landlords;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Card {
    private String color;
    private String number;
    private int value;

    @Override
    public String toString() {
        return color+number;
    }
}
