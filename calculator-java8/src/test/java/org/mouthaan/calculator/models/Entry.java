package org.mouthaan.calculator.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Entry {
    private Integer first;
    private Integer second;
    private String operation;
}
