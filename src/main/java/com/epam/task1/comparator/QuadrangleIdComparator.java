package com.epam.task1.comparator;
import com.epam.task1.entity.Quadrangle;

import java.util.Comparator;

public class QuadrangleIdComparator implements Comparator<Quadrangle> {

    @Override
    public int compare(Quadrangle q1, Quadrangle q2) {

        int q1Id = q1.getId();
        int q2Id = q2.getId();

        if (q1Id < q2Id){
            return -1;
        } else if (q1Id == q2Id){
            return 0;
        } else {
            return 1;
        }
    }

}
