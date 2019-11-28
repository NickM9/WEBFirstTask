package com.epam.task1.repository;

import com.epam.task1.entity.Quadrangle;
import com.epam.task1.observer.impl.QuadrangleEventManager;
import com.epam.task1.observer.impl.QuadrangleRegisterObserverImpl;
import com.epam.task1.repository.specification.Specification;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuadrangleRepository {

    private List<Quadrangle> quadrangleList;
    private Map<Integer, QuadrangleRegisterObserverImpl> quadrangleRegisterMap;

    public QuadrangleRepository(){
        quadrangleList = new ArrayList<>();
        quadrangleRegisterMap = new HashMap<>();
    }

    public void addQuadrangle(Quadrangle quadrangle){
        quadrangleList.add(quadrangle);
        QuadrangleRegisterObserverImpl quadrangleRegisterObserver = new QuadrangleRegisterObserverImpl(quadrangle);
        QuadrangleEventManager quadrangleEventManager = new QuadrangleEventManager(quadrangle);
        quadrangleEventManager.registerObserver(quadrangleRegisterObserver);
        quadrangleRegisterMap.put(quadrangle.getId(), quadrangleRegisterObserver);
    }

    public void removeQuadrangle(Quadrangle quadrangle){
        quadrangleList.remove(quadrangle);
        quadrangleRegisterMap.remove(quadrangle.getId());
    }

    public List<Quadrangle> query(Specification specification){
        List<Quadrangle> specificationList = new ArrayList<>();

        for (Quadrangle quadrangle : quadrangleList){

            if (specification.specify(quadrangle)){
                specificationList.add(quadrangle);
            }

        }

        return specificationList;
    }

    public Map<Integer, QuadrangleRegisterObserverImpl> getQuadrangleRegisterMap() {
        return quadrangleRegisterMap;
    }

    public QuadrangleRegisterObserverImpl getParameters(Quadrangle quadrangle){
        return quadrangleRegisterMap.get(quadrangle.getId());
    }
}
