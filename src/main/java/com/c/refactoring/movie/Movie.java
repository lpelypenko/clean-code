package com.c.refactoring.movie;

import com.c.refactoring.StringUtils;

import java.util.HashSet;
import java.util.Set;

public class Movie {

    String rating;
    private static final Set<String> VALID_B_RATING = new HashSet<String>() {{
        add("B1");
        add("B2");
        add("B3");
        add("B4");
    }};
    public Movie(String rating) {
        super();
        this.rating = rating;
    }

    public String getRating() {
        return rating;
    }

    /*Axx or By
    Where x represents any digit between 0 and 9, and y represents 
    any digit between 1 and 4*/
    public boolean isValidRating() {
        if (getRating() == null) {
            return false;
        }
        return isValidBRating() || isValidARating();
    }

    private boolean isValidBRating() {
        return VALID_B_RATING.contains(getRating());
    }

    private boolean isValidARating() {
        String rating = this.getRating();
        String firstCharacter = rating.substring(0, 1);
        return firstCharacter.equalsIgnoreCase("A")
                && rating.length() == 3 && StringUtils.isNumeric(rating.substring(1, 3));
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
