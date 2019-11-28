package com.epam.task1.creator.util;

import com.epam.task1.exceptions.ReaderException;
import com.epam.task1.exceptions.IllegalDataException;
import com.epam.task1.creator.util.PointParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InfoReader {

    private static final Logger logger = LogManager.getLogger();

    public List<Double> getPoints(File file) throws ReaderException, IllegalDataException {

        List<Double> points = readFile(file);

        if (points.isEmpty()){
            logger.warn("Illegal data");
            throw new IllegalDataException("Неверные данные на входе");
        }

        logger.info("Data uploaded");
        return points;
    }

    private List<Double> readFile(File file) throws ReaderException {
        List<Double> points = new ArrayList<>();

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
            while (bufferedReader.ready()){
                String str = bufferedReader.readLine();
                PointParser parser = new PointParser();
                points = parser.parsePoints(str);
            }
        } catch (IOException e){
            logger.warn(e);
            throw new ReaderException(e);
        }

        return points;
    }

}
