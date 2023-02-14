public class Opps
{
	public static void main(String args[])
	{

	}
}

class Parent
{
	String color;
	Parent()
	{
		System.out.println("parent....");
	}
}
class Child extends Parent
{
	Child()
	{
		super();
		super.color = "brown";
		System.out.println("child....");
	}
}

class Student2{
	static String school;
	String name;
}

//Interface 
//totoal abstraction
interface chess
{
	void moves();
}

class Queen implements chess{
	public void moves(){
		System.out.println("queen moves- up down left right all 4 drins");
	}
}
class Rook implements chess{
	public void moves(){
		System.out.println("Rook moves-up down left right");
	}
}
class King implements chess
{
	public void moves(){
		System.out.println("King moves - up down left right diagonal");
	}
}

interface Carnivor{
	void dirnks();
}
interface Harnivor{
	void eat();
}
//multiple inheritance
class Deeer implements Carnivor,Harnivor{
	public void dirnks()
	{
		System.out.println("Carnivor drinks water");
	}
	public void eat()
	{
		System.out.println("Harnivore eat grass");
	}
}

//abstraction
// by abstract classes
abstract class Human{
	void eat(){
		System.out.println("human can simile");
	}

	abstract void gender();
}

class Boy extends Human{
	 void gender(){
		System.out.println("Boys");
	}
}


//compile time polymorphism
	//Method overloading
class Calculate{
	int sum(int a,int b){
		return a+b;
	}
	float sum(float a,float b){
		return a+b;
	}
	int sum(int a,int b,int c){
		return a+b+c;
	}
}
// run time polymorphism
	//Method overrding
class Deer extends Animal{
	void eat()
	{
		System.out.println("can eat grass");
	}
}
class Animal{

	void breath(){
		System.out.println("animal can breath");
	}
	void eat()
	{
		System.out.println("can eat enthing");
	}
}

//single level inheritance
class Dog extends Animal {
	void run(){
		System.out.println("can run");
	}
}
//multilevel inheritance
class Cat extends Dog{

	void drink(){
		System.out.println("can drink");
	}
}

//Herarchial inheritance
class Fish extends Animal{
	void swim(){
		System.out.println("fish can swim");
	}
}

//hybrid inheritance
class Shark extends Fish{
	void shark(){
		System.out.println("im shark king of fishes");
	}
}
class Student{
	String name;
	String stream;
	int age ;
	int marks[] = new int[3];

//Non parametrized constructor
	Student(){
		// System.out.println("constructor is called...");
	}
// parametrized constructor
	Student(String name){
		this.name = name;
		System.out.println(name);
	}
	Student(int age)
	{
		this.age = age;
		System.out.println(age);
	}
//Copy constructor

//shallow copy
	// Student(Student obj)
	// {
	// 	this.name = obj.name;
	// 	this.stream = obj.stream;
	// 	this.age = obj.age;
	// 	this.marks = obj.marks;
	// }	

//deep copy
	Student(Student obj)
	{
		this.name = obj.name;
		this.stream = obj.stream;
		this.age = obj.age;
		for(int i=0; i<3; i++)
			this.marks[i] = obj.marks[i];
	}

	void print(String ob){
		System.out.println("properties of "+ ob);
		System.out.println(name);
		System.out.println(age);
		System.out.println(stream);
		System.out.println(marks[0]+" "+marks[1]+" "+marks[2]);
		System.out.println();
	}
}
class Password{
	public String account;
	private int password;

	void setPassword(int password)
	{
		this.password = password;
	}
	void getPassord()
	{
		System.out.println(password);
	}
}
class Pen{
	String name;
	String color;
	int price;

	void setColor(String color)
	{
		this.color = color;
	}

	void setName(String name)
	{
		this.name = name;
	}

	void setPrice(int price)
	{
		this.price = price;
	}
}