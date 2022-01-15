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

public class Marks
{
    public static void main(String[] args)
    {
        int[][] marks=new int[4][5];
        Scanner sc=new Scanner(System.in);
        for (int i = 0; i < marks.length; i++) {
            System.out.println("Enter marks of student " + (i + 1));
            for (int j = 0; j < marks[i].length; j++)
            {
                marks[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < 5; i++)
        {
            float average_subject_marks=0;
            for (int j = 0; j < 4; j++)
            {
                average_subject_marks+=marks[j][i];
            }
            average_subject_marks = average_subject_marks/4;
            System.out.println("Average marks in subject "+(i+1)+" "+average_subject_marks);
        }
        int count_students_scored_below_50 = 0;
        for (int i = 0; i < 4; i++)
        {
            float average_student_marks=0;
            for (int j = 0; j < 5; j++)
            {
                average_student_marks+=marks[i][j];
            }
            average_student_marks = average_student_marks/5;
            System.out.println("Average marks of student "+(i+1)+"="+average_student_marks);
            if(average_student_marks<50)
                count_students_scored_below_50++;
        }
        System.out.println("Number of students who scored below 50 in their average="+count_students_scored_below_50);
        for (int i = 0; i < 4; i++)
        {
            System.out.print("Marks of student "+(i+1)+"=> ");
            for (int j = 0; j < 5; j++)
            {
                System.out.print(marks[i][j]+" , ");
            }
            System.out.println();
        }
    }
}import java.util.Scanner;

public class Student
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
class StudentMain
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
        System.out.println("Students who scored manimum marks are:");
        for (Student student : obj) 
        {
            if (student.getMarks() == min)
                System.out.println(student.getName() + " " + student.getRollno() + " " + student.getMarks());
        }
    }
}