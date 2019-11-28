package com.epam.task1.creator;

import com.epam.task1.creator.util.InfoReader;
import com.epam.task1.exceptions.IllegalDataException;
import com.epam.task1.exceptions.ReaderException;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.File;
import java.util.List;

public class InfoReaderTest {

    private static File file;
    private static InfoReader infoReader;

    @BeforeClass
    public static void init(){
        file = new File("src/test/resources/testData.txt");
        infoReader = new InfoReader();
    }

    @Test
    public void getPointsNotNullTest() throws IllegalDataException, ReaderException {
        List<Double> actual = infoReader.getPoints(file);
        assertNotNull(actual);
    }

    @Test
    public void getPointsTest() throws IllegalDataException, ReaderException {
        List<Double> points = infoReader.getPoints(file);
        int expected = 8;
        int actual = points.size();
        assertEquals(expected, actual);
    }

}
