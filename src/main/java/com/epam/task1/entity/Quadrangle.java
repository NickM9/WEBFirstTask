package com.epam.task1.entity;

import com.epam.task1.observer.impl.QuadrangleEventManager;

public class Quadrangle implements Figure {

    private final int id;
    private Point a;
    private Point b;
    private Point c;
    private Point d;

    private QuadrangleEventManager quadrangleEventManager;

    public Quadrangle(int id, Point a, Point b, Point c, Point d) {
        this.id = id;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.quadrangleEventManager = new QuadrangleEventManager(this);
    }

    public int getId() {
        return id;
    }

    public Point getA() {
        return a;
    }

    public void setA(Point a) {
        this.a = a;
        quadrangleEventManager.notifyObserver();
    }

    public Point getB() {
        return b;
    }

    public void setB(Point b) {
        this.b = b;
        quadrangleEventManager.notifyObserver();
    }

    public Point getC() {
        return c;
    }

    public void setC(Point c) {
        this.c = c;
        quadrangleEventManager.notifyObserver();
    }

    public Point getD() {
        return d;
    }

    public void setD(Point d) {
        this.d = d;
        quadrangleEventManager.notifyObserver();
    }
}
