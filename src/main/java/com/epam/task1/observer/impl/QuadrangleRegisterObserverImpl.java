package com.epam.task1.observer.impl;

import com.epam.task1.entity.Quadrangle;
import com.epam.task1.observer.Observer;
import com.epam.task1.services.impl.QuadrangleServiceImpl;

public class QuadrangleRegisterObserverImpl implements Observer<Quadrangle> {

    private QuadrangleServiceImpl quadrangleService = QuadrangleServiceImpl.getInstance();
    private double area;
    private double perimeter;

    public QuadrangleRegisterObserverImpl(Quadrangle quadrangle){
        area = quadrangleService.calculateArea(quadrangle);
        perimeter = quadrangleService.calculatePerimeter(quadrangle);
    }


    @Override
    public void update(Quadrangle event) {
        area = quadrangleService.calculateArea(event);
        perimeter = quadrangleService.calculatePerimeter(event);
    }
}
