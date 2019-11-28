package com.epam.task1.comparator;

import com.epam.task1.entity.Point;
import java.util.Comparator;

public class PointIdComparator implements Comparator<Point> {

    @Override
    public int compare(Point p1, Point p2) {

        int p1Id = p1.getId();
        int p2Id = p2.getId();

        if (p1Id < p2Id){
            return -1;
        } else if (p1Id == p2Id){
            return 0;
        } else {
            return 1;
        }
    }

}
