/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Group 2
 */
public class Calendar {

    private static int[] days = {
        0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
    };

    public static String[] generate(int month, int year) {
        String[] calendarArray = new String[42];
        int startDay = startDay(month, year);

        for (int i = 0; i < startDay; i++) {
            calendarArray[i] = " ";
        }
        
        for (int i = 0; i <= days[month]; i++) {
            calendarArray[i + startDay] = Integer.toString(i + 1);
        }
        
        for (int i = startDay + days[month]; i < calendarArray.length; i++) {
            calendarArray[i] = " ";
        }
        
        return calendarArray;
    }

    public static int startDay(int month, int year) {
        int y = year - (14 - month) / 12;
        int x = y + y / 4 - y / 100 + y / 400;
        int m = month + 12 * ((14 - month) / 12) - 2;
        int d = (1 + x + (31 * m) / 12) % 7;
        return d;
    }
}
