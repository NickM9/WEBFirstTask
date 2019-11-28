package com.epam.task1.creator.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PointParser {

    private static Logger logger = LogManager.getLogger();

    private final String pointRegEx  = "(\\-?\\d+\\.?\\d*)\\s(\\-?\\d+\\.?\\d*)\\s(\\-?\\d+\\.?\\d*)\\s(\\-?\\d+\\.?\\d*)\\s+" +
            "(\\-?\\d+\\.?\\d*)\\s(\\-?\\d+\\.?\\d*)\\s(\\-?\\d+\\.?\\d*)\\s(\\-?\\d+\\.?\\d*)$";

    public List<Double> parsePoints(String str){
        Pattern pat = Pattern.compile(pointRegEx);
        List<Double> result = new ArrayList<>();
        Matcher mat = pat.matcher(str);

        if (mat.find()){
            logger.info("Input a correct line " + str);
            String[] points = str.split(" ");

            for (String s : points){
                result.add(Double.valueOf(s));
            }

        } else {
            logger.info("Input incorrect line " + str);
        }

        return result;
    }

}
