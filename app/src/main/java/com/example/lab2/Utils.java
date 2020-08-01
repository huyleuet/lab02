package com.example.lab2;


import static com.example.lab2.Constants.*;

public class Utils {
    public static int getFont(int type) {
        switch (type) {
            case BOLD: return R.font.opensans_bold;
            case ITALIC: return R.font.opensans_italic;
            case SEMIBOLD: return R.font.opensans_semibold;
            default: return R.font.opensans_regular;
        }
    }
}
