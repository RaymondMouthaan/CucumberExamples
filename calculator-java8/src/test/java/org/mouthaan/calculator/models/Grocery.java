package org.mouthaan.calculator.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Grocery {
    private String name;
    private Price price;
}
