//Obviously this needs to be edited, I wasn't sure how to write it without the GUI except as a console app 
//to make it do what I wanted. Please feel free to tell me what is terrible!

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calendar2019 {
public static String[] months = {
"", // first element in the array is left blank so that we can get January at index 1, not 0
"January", "February", "March", 
"April", "May", "June",
"July", "August", "September",
"October", "November", "December"
};
  
public static int[] days = {
0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
};
  
public static String menuInput;
public static int menuChoice;
public static int startingMonth, endingMonth;
  
public static void main(String[] args) throws IOException
{
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  
do
{
displayMenu();
menuInput = br.readLine(); //First, we take the input into a normal string variable
while(!isDigit(menuInput)) //Then, we check whether the input is a digit or not
{ //If not, the while loop continues till a valid digit is entered
System.out.print("Enter your selection (Only numbers are allowed):");
menuInput = br.readLine(); //Again taking input in a normal string variable and checking for the isDigit(..) condition
}
menuChoice = Integer.parseInt(menuInput); //Finally, if a digit is entered, we convert the input into integer
menuInput = ""; //Then we need to set the variable to null to make it ready for further inputs
  
switch(menuChoice)
{
case 1:
System.out.print("\nEnter month index (1 for January and 12 for December): ");
menuInput = br.readLine();
while(!isDigit(menuInput))
{
System.out.print("\nEnter month index (1 for January and 12 for December): ");
menuInput = br.readLine();
}
startingMonth = Integer.parseInt(menuInput);
menuInput = "";
showCalForOneMonth(startingMonth);
break;
  
case 2:
System.out.print("\nEnter month index to start (1 for January and 12 for December): ");
menuInput = br.readLine();
while(!isDigit(menuInput))
{
System.out.print("\nEnter month index to start (1 for January and 12 for December): ");
menuInput = br.readLine();
}
startingMonth = Integer.parseInt(menuInput);
menuInput = "";
showCalForThreeMonths(startingMonth);
break;
  
case 3:
System.out.println("Displaying calendar for the whole year:");
showCalForAllMonths();
break;
  
case 4:
System.out.println("Exiting with status code OK");
System.exit(0);
break;
  
default:
System.out.println("Invalid option selected, exiting application!");
  
}
}while(menuChoice >= 1 && menuChoice <= 4);
}
  
public static void displayMenu()
{
System.out.print(
"1. Show Calendar for 1 month\n2. Show Calendar for 3 months\n3. Show Calendar for the year\n"
+ "4. Exit\n"
+ "Enter your selection (Only numbers are allowed): ");
}
  
public static boolean isDigit(String s)
{
try
{
Integer.parseInt(s);
return true;
}catch(NumberFormatException e){
System.out.println(s + " is not a valid number!");
return false;
}
}
  
public static void showCalForOneMonth(int month)
{
if(month >= 1 && month <= 12)
{
System.out.println(" " + months[month] + " 2019");
System.out.println(" S M Tu W Th F S");
  
int day = daysOfTheMonth(month, 1, 2019);
  
for (int i = 0; i < day; i++)
{
System.out.print(" ");
}
  
for (int i = 1; i <= days[month]; i++)
{
System.out.printf("%2d ", i);
if (((i + day) % 7 == 0) || (i == days[month]))
System.out.println();
}
System.out.println();
}
else
{
System.out.println("Please enter a valid month index (1 - 12)!\n");
}
}
  
public static void showCalForThreeMonths(int startMonth)
{
if(startMonth >= 1 && startMonth <= 12)
{
//Displaying the 1st Month
System.out.println(" " + months[startMonth] + " 2019");
System.out.println(" S M Tu W Th F S");
  
int daysOfFirstMonth = daysOfTheMonth(startMonth, 1, 2019);
  
for (int i = 0; i < daysOfFirstMonth; i++)
{
System.out.print(" ");
}
  
for (int i = 1; i <= days[startMonth]; i++)
{
System.out.printf("%2d ", i);
if (((i + daysOfFirstMonth) % 7 == 0) || (i == days[startMonth]))
System.out.println();
}
System.out.println();
  
//Displaying the 2nd Month
startMonth += 1;
System.out.println(" " + months[startMonth] + " 2019");
System.out.println(" S M Tu W Th F S");
  
int daysOfSecondMonth = daysOfTheMonth(startMonth, 1, 2019);
  
for (int i = 0; i < daysOfSecondMonth; i++)
{
System.out.print(" ");
}
  
for (int i = 1; i <= days[startMonth]; i++)
{
System.out.printf("%2d ", i);
if (((i + daysOfSecondMonth) % 7 == 0) || (i == days[startMonth]))
System.out.println();
}
System.out.println();
  
//Displaying the 3rd Month
startMonth += 1;
System.out.println(" " + months[startMonth] + " 2019");
System.out.println(" S M Tu W Th F S");
  
int daysOfThirdMonth = daysOfTheMonth(startMonth, 1, 2019);
  
for (int i = 0; i < daysOfThirdMonth; i++)
{
System.out.print(" ");
}
  
for (int i = 1; i <= days[startMonth]; i++)
{
System.out.printf("%2d ", i);
if (((i + daysOfThirdMonth) % 7 == 0) || (i == days[startMonth]))
System.out.println();
}
System.out.println();
}
else
{
System.out.println("Please enter a valid month index (1 - 12)!\n");
}
}
  
public static void showCalForAllMonths()
{
int startMonth = 1;
  
while(startMonth <= 12)
{
System.out.println(" " + months[startMonth] + " 2019");
System.out.println(" S M Tu W Th F S");
  
int daysOfThirdMonth = daysOfTheMonth(startMonth, 1, 2019);
  
for (int i = 0; i < daysOfThirdMonth; i++)
{
System.out.print(" ");
}
  
for (int i = 1; i <= days[startMonth]; i++)
{
System.out.printf("%2d ", i);
if (((i + daysOfThirdMonth) % 7 == 0) || (i == days[startMonth]))
System.out.println();
}
startMonth++;
System.out.println();
}
}
  
public static int daysOfTheMonth(int month, int day, int year)
{
int y = year - (14 - month) / 12;
int x = y + y/4 - y/100 + y/400;
int m = month + 12 * ((14 - month) / 12) - 2;
int d = (day + x + (31*m)/12) % 7;
return d;
}
}