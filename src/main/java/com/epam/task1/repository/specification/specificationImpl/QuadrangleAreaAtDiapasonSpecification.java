package com.epam.task1.repository.specification.specificationImpl;

import com.epam.task1.entity.Quadrangle;
import com.epam.task1.repository.specification.Specification;
import com.epam.task1.services.impl.QuadrangleServiceImpl;

public class QuadrangleAreaAtDiapasonSpecification implements Specification {

    private double minArea;
    private double maxArea;

    public QuadrangleAreaAtDiapasonSpecification(double minArea, double maxArea){
        this.minArea = minArea;
        this.maxArea = maxArea;
    }


    @Override
    public boolean specify(Quadrangle quadrangle) {
        QuadrangleServiceImpl quadrangleService = new QuadrangleServiceImpl(quadrangle);
        double area = quadrangleService.calculateArea();
        return minArea <= area && area <= maxArea;
    }
}
