package com.epam.task1.observer.impl;

import com.epam.task1.entity.Quadrangle;
import com.epam.task1.observer.Observable;
import com.epam.task1.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class QuadrangleEventManager implements Observable {

    private Quadrangle quadrangle;
    private List<Observer> observers = new ArrayList<>();

    public QuadrangleEventManager(Quadrangle quadrangle){
        this.quadrangle = quadrangle;
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observers){
            observer.update(quadrangle);
        }
    }
}
