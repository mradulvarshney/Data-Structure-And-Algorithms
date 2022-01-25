package Arrays;

/*
Create an array of 10 students and print the record of those students who got the highest marks and who got minimum marks. The structure of student class is as follows 
class Student
{
	private int rollno;
	private int marks
	private String name;
}
// create constructor or getter and setter methods as per need
*/

import java.util.Scanner;

class Student
{
    private int rollno;
    private int marks;
    private String name;
    Student(String name, int rollno, int marks)
    {
        this.name=name;
        this.rollno=rollno;
        this.marks=marks;
    }
    public String getName()
    {
        return name;
    }
    public int getRollno()
    {
        return rollno;
    }
    public int getMarks() { return marks; }
}

public class StudentMain
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Student[] obj =new Student[5];
        for(int i=0;i< obj.length;i++)
        {
            System.out.println("Enter name, roll no and marks :");
            obj[i]= new Student(sc.next(), sc.nextInt(), sc.nextInt());
        }
        int max=obj[0].getMarks(), min=obj[0].getMarks();
        for (Student value : obj) {
            if (value.getMarks() > max)
                max = value.getMarks();
            else if (value.getMarks() < min)
                min = value.getMarks();
        }
        System.out.println("Students who scored maximum marks are:");
        for (Student student : obj) 
        {
            if (student.getMarks() == max)
                System.out.println(student.getName() + " " + student.getRollno() + " " + student.getMarks());
        }
        System.out.println("Students who scored minimum marks are:");
        for (Student student : obj) 
        {
            if (student.getMarks() == min)
                System.out.println(student.getName() + " " + student.getRollno() + " " + student.getMarks());
        }
    }
}