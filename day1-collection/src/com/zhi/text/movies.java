package com.zhi.text;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class movies {
    private String name;
    private double score;
    private String actor;
    private double price;
}
