package org.example;

import org.junit.jupiter.api.*;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @BeforeAll
    public static void startTest (){
        System.out.println("Начал тест");
    }

    @AfterAll
    public static void finishTest (){
        System.out.println("Закончил тест");
    }

    @Test
    void testSortPositive() {
        //given
        int[] team = {9, 8, 80, 10, 5, 10, 5, 0, 0, 0};
        int[] result = {80, 10, 10, 9, 8, 5, 5, 0, 0, 0};
        //when
        int[] actual = Main.sort(team);
        Assertions.assertTrue(Arrays.equals(result, actual));
    }


    @Test
    void mergePositive() {
        //given
        int[] teamA = {90, 85, 80, 10, 10, 10, 5, 0, 0, 0};
        int[] teamB = {100, 90, 20, 1, 1, 1, 1, 1, 1, 1};
        int[] result = {100, 90, 90, 85, 80, 20, 10, 10, 10, 5};
        //when
        int[] actual = Main.merge(teamA, teamB);
        //then
        Assertions.assertTrue(Arrays.equals(result, actual));
    }
    @Test
    void mergeNegative() {
        //given
        int[] teamA = {100, 100, 80, 10, 10, 10, 5, 0, 0, 0};
        int[] teamB = {100, 100, 20, 1, 1, 1, 1, 1, 1, 1};
        int[] result = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        //when
        int[] actual = Main.merge(teamA, teamB);
        //then
        Assertions.assertFalse(Arrays.equals(result, actual));
    }


}