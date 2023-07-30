package org.example;

import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        int[][] teams = {
                {45, 31, 24, 22, 20, 17, 14, 13, 12, 10},
                {31, 18, 15, 12, 10, 8, 6, 4, 2, 1},
                {51, 30, 10, 9, 8, 7, 6, 5, 2, 1}
        };

        int[] nationalTeam = mergeAll(teams);
        System.out.println(Arrays.toString(nationalTeam)); // [51, 45, 31, 31, 30, 24, 22, 20, 18, 17]
    }

    /*** Метод для слияния всех команд в одну национальную*/
    public static int[] mergeAll(int[][] teams) {
        int[] result = teams[0];
        for (int i = 1; i < teams.length; i++) {
            result = merge(result, teams[i]);
        }
        return result;
    }

    /*** Метод для слияния двух команд в одну*/
    public static int[] merge(int[] teamA, int[] teamB) {
        int[] result = new int[10];
        int ia = 0;
        int ib = 0;
        int ic = 0;
        teamA = sort(teamA);
        teamB = sort(teamB);

        while (ic < 10) {
            if (teamA[ia] > teamB[ib]) {
                result[ic] = teamA[ia];
                ia++;
            } else {
                result[ic] = teamB[ib];
                ib++;
            }
            ic++;
        }
        return result;
    }

    public static int[] sort(int[] team) {
        int i = 1;
        int buf = 0;
        while (i < 10) {
            if (team[i-1] < team [i]) {
                buf = team [i-1];
                team [i-1] = team[i];
                team[i] = buf;
                i=1;
            }
            else {
                i++;
            }
        }
        return team;
    }
}