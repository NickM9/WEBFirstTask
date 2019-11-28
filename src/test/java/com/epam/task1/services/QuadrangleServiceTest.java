package com.epam.task1.services;

import com.epam.task1.entity.Point;
import com.epam.task1.entity.Quadrangle;
import com.epam.task1.exceptions.ServiceException;
import org.junit.*;
import static org.junit.Assert.*;
import java.io.File;

public class QuadrangleServiceTest {
// Points (3, 3) (2, 4) (3, 5) (4, 4)

    private static File file;
    private static QuadrangleService quadrangleService;
    private static double AB;
    private static double BC;

    public static double createLine(Point num1, Point num2){
        double x1 = num1.getX();
        double y1 = num1.getY();

        double x2 = num2.getX();
        double y2 = num2.getY();

        double res = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

        return res;
    }

    @BeforeClass
    public static void init() throws ServiceException {
        file = new File("src/test/resources/testData.txt");
        quadrangleService = new QuadrangleService(file);
        Quadrangle quadrangle = quadrangleService.quadrangle;
        Point A = quadrangle.getA();
        Point B = quadrangle.getB();
        Point C = quadrangle.getC();
        AB = createLine(A, B);
        BC = createLine(B, C);
    }

    @Test
    public void calculateAreaTest() {
        double expected = AB * BC;
        double actual = quadrangleService.calculateArea();
        assertEquals(expected, actual, 0.01);
    }

    @Test
    public void calculatePerimeterTest() {
        double expected = (AB + BC) * 2;
        double actual = quadrangleService.calculatePerimeter();
        assertEquals(expected, actual, 0.01);
    }

    @Test
    public void isQuadrangleTest() {
        boolean isQuadrangle = quadrangleService.isQuadrangle();
        assertTrue(isQuadrangle);
    }

    @Test
    public void isConvexTest() {
        boolean isConvex = quadrangleService.isConvex();
        assertTrue(isConvex);
    }

    @Test
    public void isSquareTest(){
        boolean isSquare = quadrangleService.isSquare();
        assertTrue(isSquare);
    }

    @Test
    public void isRhombusTest(){
        boolean isRhombus = quadrangleService.isRhombus();
        assertTrue(isRhombus);
    }

    @Test
    public void isTrapezeTest(){
        boolean isTrapeze = quadrangleService.isTrapeze();
        assertTrue(isTrapeze);
    }

}