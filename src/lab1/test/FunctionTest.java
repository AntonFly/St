package lab1.test;

import lab1.main.Arccos;
import org.junit.Test;


import static java.lang.StrictMath.*;
import static org.junit.Assert.*;

public class FunctionTest {

    Arccos Arc = new Arccos();
    @Test
    public void testRightBorder(){
        assertEquals( "Правая граница не верна. Тест: acos(1.0)",acos(1.0), Arc.get_arccos(1.0),0.00001);
    }

    @Test
    public void testLeftBorder(){
        assertEquals( "Левая граница не верна. Тест: acos(-1.0)",acos(-1.0), Arc.get_arccos(-1.0),0.00001);
    }
    @Test
    public void testYIntercept(){
        assertEquals( "Пересечение с осью ордина не верно. Тест: acos(0.0)",acos(0), Arc.get_arccos(0),0.00001);
    }

    @Test
    public void testLeftPartOfThePositiveSegment(){
        assertEquals( "Левая часть положительного отрезка не верна. Тест: acos(0.33)" ,acos(0.33), Arc.get_arccos(0.33),0.00001);
    }

    @Test
    public void testRightPartOfThePositiveSegment() {
        assertEquals( "Правая часть положительного отрезка не верна. Тест: acos(0.67)" ,acos(0.67), Arc.get_arccos(0.67),0.00001);
    }

    @Test
    public void testLeftPartOfTheNegativeSegment() {
        assertEquals( "Левая часть отрицательного отрезка не верна. Тест: acos(-0.67)" ,acos(-0.67), Arc.get_arccos(-0.67),0.00001);
    }

    @Test
    public void testRightPartOfTheNegativeSegment() {
        assertEquals( "Правая часть отрицательного отрезка не верна. Тест: acos(-0.33)" ,acos(-0.33), Arc.get_arccos(-0.33),0.00001);
    }

    @Test
    public void testOutOfBoundsOnTheRight(){
        assertTrue("Тест на выход за границы справа.", Double.isNaN(Arc.get_arccos(2)) );
    }

    @Test
    public void testOutOfBoundsOnTheLeft(){
        assertTrue("Тест на выход за границы слева.", Double.isNaN(Arc.get_arccos(2)) );
    }
}