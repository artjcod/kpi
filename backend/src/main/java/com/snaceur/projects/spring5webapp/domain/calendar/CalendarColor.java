package com.snaceur.projects.spring5webapp.domain.calendar;

public enum CalendarColor {

     BROWN("#a52a2a"),
     DARK_GOLDEN_ROD("#b8860b"),
     DARK_GREEN("#006400"),
     CYAN("#00eeee"),
     DARK_ORANGE("#ff8c00"),
     DARK_ORCHID("#bf3eff"),
     GOLD("#ffd700"),
     LIGHT_CORAL("#f08080"),
     WHITE("#ffffff"),
     BLACK("#000000"),
     WHITE_SMOKE("#f5f5f5"),
     GRAY("#bebebe");


    private String hexCode;
       
     CalendarColor(String hexCode) {
        this.hexCode=hexCode;
    }

    public String getHexCode() {
        return hexCode;
    }
}