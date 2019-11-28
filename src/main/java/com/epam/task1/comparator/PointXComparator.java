package com.epam.task1.comparator;

import com.epam.task1.entity.Point;
import java.util.Comparator;

public class PointXComparator implements Comparator<Point> {

    @Override
    public int compare(Point p1, Point p2) {

        double p1X = p1.getX();
        double p2X = p2.getX();

        if (p1X < p2X) {
            return -1;
        } else if (p1X == p2X) {
            return 0;
        } else {
            return 1;
        }

    }

}
