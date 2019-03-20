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
        int numDays;
        
        if (month == 2 && isLeap(year)) {
            numDays = 29;
        } else {
            numDays = days[month];
        }

        for (int i = 0; i < startDay; i++) {
            calendarArray[i] = " ";
        }

        for (int i = 0; i <= numDays; i++) {
            calendarArray[i + startDay] = Integer.toString(i + 1);
        }

        for (int i = startDay + numDays; i < calendarArray.length; i++) {
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

    private static boolean isLeap(int year) {
        boolean flag = false;

        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    flag = true; // if divisible by 400, then is a leap year
                } else {
                    flag = false; // if divisible by 4 and 100, but not 400, then not a leap year
                }
            } else {
                flag = true; // if divisble by 4 but not 100, then is a leap year
            }
        } else {
            flag = false;
        }

        return flag;
    }
}
