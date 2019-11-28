package com.epam.task1.repository.specification.specificationImpl;

import com.epam.task1.entity.Point;
import com.epam.task1.entity.Quadrangle;
import com.epam.task1.repository.specification.Specification;

public class QuadrangleAtFirstQuadrantSpecification implements Specification {

    private boolean isPointAtFirstQuadrant(Point point){

        double x = point.getX();
        double y = point.getY();

        return x >= 0 && y >= 0;
    }

    @Override
    public boolean specify(Quadrangle quadrangle) {

        Point a = quadrangle.getA();
        Point b = quadrangle.getB();
        Point c = quadrangle.getC();
        Point d = quadrangle.getD();

        return isPointAtFirstQuadrant(a) && isPointAtFirstQuadrant(b) &&
                isPointAtFirstQuadrant(c) && isPointAtFirstQuadrant(d);
    }
}
