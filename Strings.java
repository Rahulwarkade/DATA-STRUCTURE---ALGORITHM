import java.util.*;

public class Strings
{
    static void stringCreation()
    {
        char arr[] = {'a','b','c','c'};

        String str = "abcd";
        String str2 = "abcd";

        //Strings are IMMUTABLE

        Scanner jin = new Scanner(System.in);
        String name;
        String lastName;
        name = jin.nextLine();
        lastName = jin.nextLine();
        String fullName = name+ " "+lastName;
        System.out.println(fullName);
    }

    static void printLeters(String str)
    {
        for(int i=0; i<str.length(); i++)
        {
            System.out.print(str.charAt(i)+" ");
        }
        System.out.println();
    }
    static boolean palindrome(String str)
    {
        int startIdx = 0;
        int endIdx = str.length()-1;

        while(startIdx<endIdx)
        {
            if(str.charAt(startIdx)!=str.charAt(endIdx))
            {
                System.out.println("not a plindrome");
                return false;
            }
            startIdx++;
            endIdx--;
        }
        System.out.println("plindrome");
        return true;
    }
    static void shortestPath(String str)
    {
        int x1,y1;
        x1=y1=0;
        int x2,y2;
        x2=x1;
        y2=y1;
        char dir;
        for(int i=0; i<str.length(); i++)
        {
            dir = str.charAt(i);
            if(dir=='N')
            {
                y2++;
            }
            else if (dir =='S')
            {
                y2--;
            }
            else if(dir =='E')
            {
                x2++;
            }
            else if(dir=='W')
            {
                x2--;
            }
            else
            {
                System.out.println("Invalid direction");
            }
        }
        
        int pointA = (x2-x1);
        int pointB = (y2-y1);
        pointA *=pointA;
        pointB *=pointB;

        System.out.println((float)Math.sqrt(pointA+pointB));
    }
    static void subString(String str,int sIdx,int eIdx)
    {
        String sub = "";
        for(int i=sIdx; i<eIdx; i++)
        {
            sub+=str.charAt(i);
        }
        System.out.println(sub);
        System.out.println(sub.substring(0,4));
    }
    static void stringComparision(String str)
    {
        String str1 = "Tony";
        String str2 = new String("Tony");
        System.out.println((str==str1)?"equal":"not equal");
        System.out.println((str2==str1)?"equal":"not equal");
        System.out.println((str1.equals(str2))?"equal":"not equal");
    }
    static void largestString()
    {
        String arr[] = {"apple","mango","Banana"};
        String largest = arr[0];
        for(int i=1; i<arr.length; i++)
        {
            if(largest.compareToIgnoreCase(arr[i])<0)
            {
                largest = arr[i];
            }
        }
        System.out.println(largest);
    }
    static void interning(String str)
    {
        StringBuilder str2 = new StringBuilder("");
        for(char ch = 'a'; ch<='z'; ch++)
        {
            str2.append(ch);
        }

        System.out.println(str2);
        System.out.println(str2.length());
    }
    static void capitilized(String str)
    {
        StringBuilder capstr = new StringBuilder("");
        char ch = Character.toUpperCase(str.charAt(0));
        capstr.append(ch);

        for(int i=1; i<str.length(); i++)
        {
            if(str.charAt(i)==' ' && i<str.length()-1)
            {
                capstr.append(str.charAt(i));
                i++;
                capstr.append(Character.toUpperCase(str.charAt(i)));
            }
            else
            {
                capstr.append(str.charAt(i));
            }
        }

        System.out.println(capstr);
    }
    
    static void strCompression(String str)
    {
        StringBuilder cmp = new StringBuilder("");

        for(int i=0; i<str.length(); i++)
        {
            Integer count = 1;
            while(i<str.length()-1 && str.charAt(i)==str.charAt(i+1))
            {
                count++;
                i++;
            }
            cmp.append(str.charAt(i));
            if(count>1)
            {
                cmp.append(count.toString());
            }
        }
        System.out.println(cmp);
    }
    public static void main(String args[])
    {
        
    }
}