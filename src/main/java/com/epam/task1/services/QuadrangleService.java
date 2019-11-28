package com.epam.task1.services;

import com.epam.task1.creator.QuadrangleCreator;
import com.epam.task1.entity.Point;
import com.epam.task1.entity.Quadrangle;
import com.epam.task1.exceptions.ReaderException;
import com.epam.task1.exceptions.IllegalDataException;
import com.epam.task1.exceptions.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class QuadrangleService implements IQuadrangleService {

    private static Logger logger = LogManager.getLogger();
    Quadrangle quadrangle;
    private Lines lines;

    public QuadrangleService(File file) throws ServiceException {
        try {
            QuadrangleCreator creator = new QuadrangleCreator();
            this.quadrangle = creator.createQuadrangle(file);
        } catch (IllegalDataException | ReaderException e){
            logger.error("The quadrangle is not created");
            throw new ServiceException(e);
        }

        logger.info("Quadrangle created");
        lines = new Lines();
    }

    public QuadrangleService(Quadrangle quadrangle){
        this.quadrangle = quadrangle;
        this.lines = new Lines();
        logger.info("Quadrangle created");
    }

    @Override
    public double calculateArea() {

        double p = calculatePerimeter() / 2;
        double area = Math.sqrt((p - lines.ab) * (p - lines.bc) * (p - lines.cd) * (p - lines.da));
        return area;

    }

    @Override
    public double calculatePerimeter() {

        return lines.ab + lines.bc + lines.cd + lines.da;

    }

    @Override
    public boolean isQuadrangle() {

        Point pointA = quadrangle.getA();
        Point pointB = quadrangle.getB();
        Point pointC = quadrangle.getC();
        Point pointD = quadrangle.getD();

        double xA = pointA.getX();
        double xB = pointB.getX();
        double xC = pointC.getX();
        double xD = pointD.getX();
        double yA = pointA.getY();
        double yB = pointB.getY();
        double yC = pointC.getY();
        double yD = pointD.getY();

        return (xC - xA) / (xB - xA) != (yC - yA) / (yB - yA) && (xD - xA) / (xB - xA) != (yD - yA) / (yB - yA);

    }

    @Override
    public boolean isConvex() {

        double pDAB = (lines.da + lines.ab + lines.bd) / 2;
        double pDBC = (lines.bd + lines.bc + lines.cd) / 2;
        double pDCA = (lines.cd + lines.ac + lines.da) / 2;
        double pABC = (lines.ab + lines.bc + lines.ac) / 2;

        double squareDAB = Math.sqrt(pDAB * (pDAB - lines.ab) * (pDAB - lines.da) * (pDAB - lines.bd));
        double squareDBC = Math.sqrt(pDBC * (pDBC - lines.bc) * (pDBC - lines.cd) * (pDBC - lines.bd));
        double squareDCA = Math.sqrt(pDCA * (pDCA - lines.cd) * (pDCA - lines.ac) * (pDCA - lines.da));
        double squareABC = Math.sqrt(pABC * (pABC - lines.ab) * (pABC - lines.bc) * (pABC - lines.ac));

        return squareDAB + squareDBC + squareDCA > squareABC;

    }

    @Override
    public boolean isSquare() {

        if (isQuadrangle()) {

            return lines.ab == lines.bc && lines.bc == lines.cd && lines.cd == lines.da;

        }

        return false;
    }

    @Override
    public boolean isRhombus() {

        return lines.ab == lines.bc && lines.bc == lines.cd && lines.cd == lines.ab;

    }

    @Override
    public boolean isTrapeze() {

        Point pointA = quadrangle.getA();
        Point pointB = quadrangle.getB();
        Point pointC = quadrangle.getC();
        Point pointD = quadrangle.getD();

        double xA = pointA.getX();
        double xB = pointB.getX();
        double xC = pointC.getX();
        double xD = pointD.getX();

        if (isQuadrangle() && isConvex()){

            return xA == xD && xB == xC;

        }

        return false;
    }

    private class Lines {

        double ab = createLine(quadrangle.getA(), quadrangle.getB());
        double bc = createLine(quadrangle.getB(), quadrangle.getC());
        double cd = createLine(quadrangle.getC(), quadrangle.getD());
        double da = createLine(quadrangle.getD(), quadrangle.getA());
        double ac = createLine(quadrangle.getA(), quadrangle.getC());
        double bd = createLine(quadrangle.getB(), quadrangle.getD());

        public double createLine(Point num1, Point num2){

            double x1 = num1.getX();
            double y1 = num1.getY();

            double x2 = num2.getX();
            double y2 = num2.getY();

            double res = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

            return res;
        }

    }

}
