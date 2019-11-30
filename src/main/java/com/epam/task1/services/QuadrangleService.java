package com.epam.task1.services;

import com.epam.task1.entity.Quadrangle;

public interface QuadrangleService {

    double calculateArea(Quadrangle quadrangle);
    double calculatePerimeter(Quadrangle quadrangle);
    boolean isQuadrangle(Quadrangle quadrangle);
    boolean isConvex(Quadrangle quadrangle);
    boolean isSquare(Quadrangle quadrangle);
    boolean isRhombus(Quadrangle quadrangle);
    boolean isTrapeze(Quadrangle quadrangle);

}
