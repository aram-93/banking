package com.hcc.hccbanking.utils;

import java.awt.*;

public class ColorConverter {

    public static String convertFromHEXToRGBA(String hexColor, Integer percent) {
        Color colorRGB = Color.decode(hexColor);

        String newColor = "rgba(" + colorRGB.getRed() + "," + colorRGB.getGreen() + "," + colorRGB.getBlue() + "," + percent + "%)";
        return newColor;
    }
}
