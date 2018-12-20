package org.mouthaan.examples;

import lombok.AllArgsConstructor;

import java.util.Date;

@AllArgsConstructor
public class DateCalculator {
    private Date now;

    public String isDateInThePast(Date date) {
        return (date.before(now)) ? "yes" : "no";
    }
}
