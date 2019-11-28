package com.epam.task1.creator;


import com.epam.task1.entity.Point;
import com.epam.task1.entity.Quadrangle;
import com.epam.task1.exceptions.ReaderException;
import com.epam.task1.exceptions.IllegalDataException;
import com.epam.task1.creator.util.InfoReader;

import java.io.File;
import java.util.List;

public class QuadrangleCreator {

    public Quadrangle createQuadrangle(File file) throws ReaderException, IllegalDataException {
        InfoReader infoReader = new InfoReader();
        List<Double> points = infoReader.getPoints(file);

        Point a = new Point(points.get(0), points.get(1));
        Point b = new Point(points.get(2), points.get(3));
        Point c = new Point(points.get(4), points.get(5));
        Point d = new Point(points.get(6), points.get(7));

        return new Quadrangle(a, b, c, d);
    }

}
