// import java.util.*;

public class JavaBasics {
    public static void helloo()
    {
        System.out.println("hooloo");
        System.out.println("hooloo");
        System.out.println("hooloo");
    }
    static int calculateSum(int a,int b)
    {
        return a+b;
    }
    public static void fun(int a,int b)
    {
        int temp =a;
        a=b;
        b=temp;
        System.out.println("a = "+a);
        System.out.println("b = "+b);
    }

    public static int product(int a,int b)
    {return a*b;}

    public static int facto(int n)
    {
        int fact =1;
        for(int i=1; i<=n; i++)
        {
            fact *=i;
        }
        return fact;
    }

    public static int binomialCoef(int n,int r)
    {
        int nfact = facto(n);
        int rfact = facto(r);
        int nmrfact = facto(n-r);
        return nfact/(rfact*nmrfact);
    }

    public static int sum(int a,int b)
    {return a+b;}
    public static int sum(int a,int b,int c)
    {return a+b+c;}
    public static float sum(float a,float b)
    {return a+b;}

    public static boolean isPrime(int n)
    {
        if(n==2) return true;
        for(int i=2; i<=Math.sqrt(n); i++)
        {
            if(n%i==0)
                return false;
        }
        return true;
    }

    public static void primeInRange(int n)
    {
        for(int i=2; i<=n; i++)
        {
            if(isPrime(i))
            {
                System.out.print(i+",");
            }
        }
        System.out.println();
    }
    public static void binToDec(int bin)
    {
        int pow = 0;
        int dec = 0;

        while(bin>0)
        {
            int lastdigit = bin%10;
            dec = dec+(lastdigit*(int)Math.pow(2, pow));
            pow++;
            bin/=10;
        }
        System.out.println(dec);
    }

    public static void decToBin(int dec)
    {
        int bin = 0;
        int pow = 0;
        while(dec>0)
        {
            int rem = dec%2;
            bin = bin + (rem*(int)Math.pow(10, pow));
            pow++;
            dec/=2;
        }
        System.out.println(bin);
    }

    public static int average(int a,int b,int c)
    {return (a+b+c)/3;}

    public static boolean isEven(int n)
    {return n%2==0;}
    public static boolean isPalindrome(int n)
    {
        int num = n;
        int pow =0;
        int palin = 0;
        while(n>0)
        {
            int lastdigit = n%10;
            palin = palin+(lastdigit*(int)Math.pow(10, pow));
            pow++;
            n/=10;
        }
        return num==palin;
    }

    public static int digitSum(int n)
    {
        int sum =0; 
        while(n>0)
        {
            int lastdigit = n%10;
            sum+=lastdigit;
            n/=10;
        }
        return sum;
    }
    public static void main(String args[])
    {
    // Scanner jin = new Scanner(System.in);

    /*
// System.out.println("****");
// System.out.println("***");
// System.out.println("**");
// System.out.println("*");
// int a = 10;
// int b = 5;
// System.out.println(a);
// System.out.println(b);
// a=2;
// System.out.println(a);
// String name = "Tony stark";
// System.out.println(name);
 */

    // VARIABLES AND DATA TYPES
            /* 
        PARIMPTIVE DATA TYPES

           type                 size         range

         * byte         -       1 byte      -128 to 127 = 256
         * boolean              1 byte      true & false
         * short        -       2 byte      
         * char         -       2 byte
         * int          -       4 byte      -2B t0 2B
         * float        -       4 byte
         * long         -       8 byte
         * double       -       8 byte
         * 
         * 
         tring name = jin.nextLine();
         System.out.println(name);

         int n = jin.nextInt();
         System.out.println(n);
         float m = jin.nextFloat();
         System.out.println(m);
         double o = jin.nextDouble();
         System.out.println(o);
         long p = jin.nextLong();
         System.out.println(p);
         short s = jin.nextShort();
         System.out.println(s);
         byte by = jin.nextByte();
         System.out.println(by);
         boolean boo = jin.nextBoolean();
         System.out.println(boo);
         
         int a = 10;
         int b = 5;
         int sum;
         sum = a+b;
         System.out.print(sum);

         int a = jin.nextInt();
        int b = jin.nextInt();
        int sum = a+b;
        System.out.println(sum);

        float c = 23.3f;
        float d = jin.nextFloat();
        float pro = c*d;
        System.out.println(pro);

        float rad = jin.nextFloat();
        float pai = 3.14159f;

        float area = pai*rad*rad;
        System.out.println(area);

    type conversion/widening conversion/implicit conversion
        int n1 = 23;
        float n2 = n1;
        int n3 = n2; //lossy conversion
        System.out.println(n3);
        System.out.println(n2);

        byte->short->int->float->long->double

    type casting/narrowing/explicit conversion
        float n4 = 99.999f;
        int n5 = (int)n4;
        System.out.println(n5);
        char ch = 'a';
        int n6 = ch;
        System.out.println(n6);

    //TYPE PROMOTION IN EXPRESSION
    
        byte n7 = 12;
        short n8 = 989;
        char ch = 'a';
        int n9 = n7+n8+ch;// java automatically pramotes char,short,byte,to int
        System.out.println(n9);

        int n10 = 89;
        float n11 = 98.8f;
        double n12 = 23.23;
        // int n13 = n10+n11+n12;
        double n13 = n10+n11+n12;// if operand is long, float, double, the whole expression is promoted to long,float,double respectively
        System.out.println(n13);

        byte n14 = 34;
        // byte n15 = n14+2; right
        // byte n15 = (int)n14+2; wrong
        int n15 = n14+2;
        System.out.println(n15);

    //PRACTICE QUESTIONS
        int num1 = jin.nextInt();
        int num2 = jin.nextInt();
        int num3 = jin.nextInt();
        int sum = num1+num2+num3;
        int average = sum/3;
        System.out.println(average);

        int side = jin.nextInt();
        int squreA = side*side;
        System.out.println(squreA);

        float pen = jin.nextFloat();
        float pencil = jin.nextFloat();
        float eraser = jin.nextFloat();
        float cost = pen+pencil+eraser;
        float costwithgst = cost+(cost*0.18f);
        System.out.println(costwithgst);
         */

    // OPERATOR IN JAVA

        /*

    BINARY OPERATORS
     System.out.println("add = " + (a+b));
     System.out.println("sub = " + (a-b));
     System.out.println("mult = " + (a*b));
     System.out.println("div = " + (a/b));
     System.out.println("rem = " + (a%b));
    
    UNARY OPERATOR
    int a = 4;
    //  int b = ++a;
     int c = a++;
     System.out.println(a);
    //System.out.println(b);
      System.out.println(c);
    
    RELATIONAL OPERATOR
        System.out.println(a>b);
        System.out.println(a<b);
        System.out.println(a>=b);
        System.out.println(a<=b);

    LOGICAL OPERATOR
        System.out.println((a>b)&&(b<a));
        System.out.println((a>b)||(b<a));
        System.out.println(!(a>b));
    
    ASSIGNMENT OPERATOR
        System.out.println(a+=b);
        System.out.println(a-=b);
        System.out.println(a*=b);
        System.out.println(a/=b);
        System.out.println(a%=b);

    PRACTICE QUESTIONS
        1. 5,4
        2. java
        3. x = 4,y=0,z=2
        4. 152
        5. 20,20
     */

    //CONDITIONAL STATEMENTS

        /*
    if(a>=b)
    {
        System.out.println(a);
    }
    else
    {
        System.out.println(b);
    }
    if(a%2==0)
    System.out.println("even");
    else
    System.out.println("odd");

    if(a==b)
    System.out.println("equal");
    else if(a>b)
    System.out.println("a>b");

        
    int income = jin.nextInt();
    int tax=0;
    if(income<500000)
        tax =0;
    else if(income>=500000 && income<=1000000){
        tax = (int)(income*0.2);
    }
    else
    {
        tax = (int)(income*0.3);
    }
    System.out.println("your tax is = "+tax);


    int a,b,c;
    a = jin.nextInt();
    b = jin.nextInt();
    c = jin.nextInt();

    if(a>b && a>c)
    System.out.println(a);
    else if(b>c)
    System.out.println(b);
    else
    System.out.println(c);

    System.out.println((2>3)?"true":"false");
    System.out.println((marks>=33?"pass":"fail"));


    char op = jin.next().charAt(0);
    int a = jin.nextInt();
    int b = jin.nextInt();
    switch(op)
    {
        case '+':
            System.out.println(a+b);
            break;
        case '-':
            System.out.println(a-b);
            break;
        case '*':
            System.out.println(a*b);
            break;
        case '/':
            System.out.println(a/b);
            break;
        case '%':
            System.out.println(a%b);
            break;
        default :
            System.out.println("wrong operator");
    }

    PRACTICE QUESTION
     int num4 = jin.nextInt();
     if(num4<0)
     System.out.println("Negative");
     else   
     System.out.println("positive");

     
     double temp = 103.5;

     System.out.println((temp>100)?"you have a fever":"you don't have a fever");

     
    int day = jin.nextInt();

    switch(day)
    {
        case 1:
            System.out.println("MONDAY");
            break;
        case 2:
            System.out.println("TUESDAY");
            break;
        case 3:
            System.out.println("WEDNESDAY");
            break;
        case 4:
            System.out.println("THURSDAY");
            break;
        case 5:
            System.out.println("FRIDAY");
            break;
        case 6:
            System.out.println("SATURDAY");
            break;
        case 7:
            System.out.println("SUNDAY");
            break;
        default :
            System.out.println("Enter vaild day");
    }

    4. true,63    
    
    int year = jin.nextInt();

     if((year%4)==0)
     {
        if(year%100==0)
        {
            if(year%400==0)
            System.out.println("leap year");
            else 
            System.out.println("not a leap year");
        }
        else 
        System.out.println("leap year");
     }
     else
     {
        System.out.println("not a leap year");
     }
     */

    //LOOPS(PART1)

        /*
         
    while(var<100)
     {
        System.out.println("HELLO WORLD");
        var++;
     }

     int var = 0;
     while(var<=10)
     {
        System.out.println(var++);
     }

     
     int n = jin.nextInt();
     int sum =0; 
     int cn = 1;
     while(cn<=n)
     {
        sum+=cn;
        cn++;
     }
     System.out.println(sum);

    for(int i=1; i<=10; System.out.println("rah"),i++)
     {
        System.out.println(i);
     }

    for(int line =1; line<=4; System.out.println("****"),line++){}

     int n=10899;
     while(n>0)
     {
        int lastdigit = n%10;
        System.out.print(lastdigit);
        n/=10;
     }

     int n = 10899;
     int rev = 0; 

     while(n>0)
     {
        int lastdigit = n%10;
        rev = (rev*10)+lastdigit;
        n/=10;
     }
     System.out.println(rev);

     int i=0;
     do
     {
        System.out.println("helloo "); i++;
        if(i==2)break;
     }while(i<4);

    int na =0;
     do
     {
        System.out.println("enter number");
        na = jin.nextInt();
        if(na%10==0)
            break;
        System.out.println(na);
     }while(true);
     
     for(int i=1; i<=4; i++)
     {if(i==3)continue;
        System.out.println(i);}

    int nm =0;
    do
    {
        System.out.println("enter number");
        nm = jin.nextInt();
        if(nm%10==0)
            continue;
        System.out.println(nm);
    }while(true);

    int num = jin.nextInt();
     boolean isPrime = true;
     if(num==2)System.out.println("prime");

     for(int i=2; i<Math.sqrt(num); i++)
     {
        if(num%i==0)
        {
            isPrime = false;
            break;
        }
     }

     System.out.println((isPrime)?"prime":"not a prime");

    //PRACTICE QUESTIONS

     1. 2
     
    int n = jin.nextInt();
    int even,odd;
    even=odd=0;
    for(int i=1; i<=n; i++)
    {
        if(i%2==0)
        {
            even+=i;
        }
        else
        {
            odd+=i;
        }
    }
    System.out.println("Even sum = "+even+" odd sum = "+odd);

     int n = jin.nextInt();
     int fact = 1;
     if(n==0)System.out.println(1);
     for(int i=1; i<=n; i++)
     {
        fact*=i;
     }
     System.out.println(fact);

     
     int N = jin.nextInt();

     for(int i=1; i<=12; i++)
     {
        System.out.println(i*N);
     }
     
     5. wrong
      */

//PATTERNS (PART1)

     /*
    int row = jin.nextInt();
    int col = jin.nextInt();
     //star pattern
      for(int line =1; line<=10; line++)
     {
        for(int star=1; star<=line; star++)
        {
            System.out.print("*");
        }
        System.out.println();
     }
     //inverted star pattern
      int n=10;
      for(int line = 1; line<=n; line++)
      {
        for(int star=1; star<=n-line+1; star++)
        {
            System.out.print("*");
        }
        System.out.println();
      }

      //HALF PYRMID
      int n =4;
      for(int line=1; line<=n; line++)
      {
        for(int number=1; number<=line; number++)
        {
            System.out.print(number);
        }
        System.out.println();
      }

      //character pattern
      
      int n =4;
      char ch = 'A';
      for(int line=1; line<=n; line++)
      {
        for(int number=1; number<=line; number++)
        {
            System.out.print(ch++);
        }
        System.out.println();
      }

      //HOLLO RECTANGLE
    for(int i=1; i<=row; i++)
    {
        for(int j=1; j<=col; j++)
        {
            if(i==1 || j==1 || j==col || i==row)
            System.out.print("* ");
            else
            System.out.print("  ");
        }
        System.out.println();
    }

    //HALF PYRAMID
    for(int i=1; i<=row; i++)
    {
        for(int j=1; j<=row-i; j++)
        {
            System.out.print("  ");
        }
        for(int k=1; k<=i; k++)
        {
            System.out.print("* ");
        }
        System.out.println();
    }

    //INVERTED HALF PYRMID
    for(int i=1; i<=row; i++)
    {
        for(int j=1; j<=col-i+1; j++)
        {
            System.out.print(j+" ");
        }
        System.out.println();
    }
   
    //FLOYD'S TRIANGLE

    int number =1;
    for(int i=1; i<=row; i++)
    {
        for(int j=1; j<=i; j++)
        {
            System.out.print(number+" ");
            number++;
        }
        System.out.println();
    }

    //0-1 TRIANGLE 
    for(int i=1; i<=row; i++)
    {
        for(int j=1; j<=i; j++)
        {
            if((i+j)%2==0)
            {
                System.out.print("1 ");
            }
            else 
            {
                System.out.print("0 ");
            }
        }
        System.out.println();
    }

    //BUTTERFLY 
    
    for(int i=1; i<=row; i++)
    {
        for(int j=1; j<=i; j++)
        {System.out.print("*");}
        for(int space=1; space<=col-2*i; space++)
        {System.out.print(" ");}
        for(int j=1; j<=i; j++)
        {System.out.print("*");}

        System.out.println();
    }
    for(int i=row; i>=1; i--)
    {
        for(int j=1; j<=i; j++)
        {System.out.print("*");}
        for(int space=1; space<=col-2*i; space++)
        {System.out.print(" ");}
        for(int j=1; j<=i; j++)
        {System.out.print("*");}

        System.out.println();
    }

    //RHOMBUS 
    for(int i=1; i<=row; i++)
    {
        for(int j=1; j<=row-i; j++)
        {
            System.out.print("  ");
        }
        for(int j=1; j<=col; j++)
        {
            System.out.print("* ");
        }
        System.out.println();
    }

    //HOLLOW RHOMBUS

    for(int i=1; i<=row; i++)
    {
        for(int j=1; j<=row-i; j++)
        {
            System.out.print("  ");
        }
        for(int j=1; j<=col; j++)
        {
            if(i==1 || j==1|| i==row || j==col)
                System.out.print("* ");
            else
                System.out.print("  ");
        }
        System.out.println();
    }

    //DIAMOND 
     for(int i=1; i<=row; i++)
    {
        for(int j=1; j<=row-i; j++)
        {
            System.out.print(" ");
        }
        for(int star=1; star<=2*i-1; star++)
        {
            System.out.print("*");
        }
        System.out.println();
    }
    for(int i=row; i>=1; i--)
    {
        for(int j=1; j<=row-i; j++)
        {
            System.out.print(" ");
        }
        for(int star=1; star<=2*i-1; star++)
        {
            System.out.print("*");
        }
        System.out.println();
    }

    //NUMBER PYRMID

    for(int i=1; i<=row; i++)
    {
        for(int space=1; space<=row-i; space++)
        {
            System.out.print(" ");
        }
        for(int j=1; j<=i; j++)
        {
            System.out.print(i+" ");
        }
        System.out.println();
    }

    //PALINDROMIC 
    
    for(int i=1; i<=row; i++)
    {
        for(int space=1; space<=row-i; space++)
        {
            System.out.print("  ");
        }
        for(int n=i; n>=1; n--)
        {
            System.out.print(n+" ");
        }
        for(int n=2; n<=i; n++)
        {
            System.out.print(n+" ");
        }
        System.out.println();
    }
      */ 

//FUNCTION/METHOD

    /*
    helloo();
         
    int a = jin.nextInt();
    int b = jin.nextInt();
    int sum = calculateSum(a,b);
    System.out.println(sum);

    fun(a,b);
    System.out.println("a = "+a);
    System.out.println("b = "+b);

    System.out.println(product(a, b));

    
    System.out.println(facto(5));

    System.out.println(binomialCoef(5,2));

    
    System.out.println(sum(2,3,8));
    System.out.println(sum(8,6));
    System.out.println(sum(2.3f,9.3f));
    
    System.out.println(isPrime(3));

    primeInRange(20);
    
    binToDec(101); 
    binToDec(111);

    decToBin(7);


//PRACTICE QUESTIONS
     */

    // System.out.println(average(3,3,3));

    // System.out.println(isEven(8));

    // System.out.println(isPalindrome(121));

    // System.out.println(Math.max(3,Math.min(7,2)));
    // System.out.println(Math.sqrt(25));
    // System.out.println(Math.pow(10,5));
    System.out.println(Math.abs(-89));
    System.out.println(digitSum(121));
   
}
}