package com.epam.task1.comparator;

import com.epam.task1.entity.Point;
import java.util.Comparator;

public class PointYComparator implements Comparator<Point> {


    @Override
    public int compare(Point p1, Point p2) {

        double p1Y = p1.getY();
        double p2Y = p2.getY();

        if (p1Y < p2Y) {
            return -1;
        } else if (p1Y == p2Y) {
            return 0;
        } else {
            return 1;
        }

    }
}
