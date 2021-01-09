package me.kevsal.minecraft.skyblockminions.utilities;

import java.security.InvalidParameterException;

public class H2GeometryPointParser {

    /**
     * Parse a H2 Point or Point Z into a 3 element double array
     * @param s formatted as POINT (7 52) or POINT Z (7 52 15)
     * @return 3 element double array representing the point
     */
    public static double[] parse(String s) {
        double[] out = {0.0,0.0,0.0};
        if ( (!s.contains("POINT")) || (!s.contains("(")) || (!s.contains(")") )) {
            throw new InvalidParameterException("String must follow POINT (1 2) or POINT Z (1 2 3) format");
        }

        /*
         THIS IS SO HORRIBLE I AM SO SORRY TO WHOEVER READS THIS
         IDFK WHAT I WAS THINKING AT THE START AND IT JUST KEPT GETTING WORSE
         TODO: Replace this with not this
         */
        int index = 0;
        while (s.length() > 0) {
            s = s.substring(s.indexOf("(") + 1);
            char endSearchChar = ' ';
            if (!s.contains(" ")) endSearchChar = ')';
            double d = Double.parseDouble(s.substring(0, s.indexOf(endSearchChar)));
            out[index] = d;
            index++;
            s = s.substring(s.indexOf(endSearchChar) + 1);
        }
        return out;
    }
}
