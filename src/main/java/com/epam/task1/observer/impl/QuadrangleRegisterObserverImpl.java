package com.epam.task1.observer.impl;

import com.epam.task1.entity.Quadrangle;
import com.epam.task1.observer.Observer;
import com.epam.task1.services.QuadrangleService;

public class QuadrangleRegisterObserverImpl implements Observer<Quadrangle> {

    private QuadrangleService quadrangleService;
    private double area;
    private double perimeter;

    public QuadrangleRegisterObserverImpl(Quadrangle quadrangle){
        quadrangleService = new QuadrangleService(quadrangle);
        area = quadrangleService.calculateArea();
        perimeter = quadrangleService.calculatePerimeter();
    }


    @Override
    public void update(Quadrangle event) {
        quadrangleService = new QuadrangleService(event);
        area = quadrangleService.calculateArea();
        perimeter = quadrangleService.calculatePerimeter();
    }
}
