/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.time.LocalDate;
import java.util.Date;

public class StudentGroup implements StudentArrayOperation  {

	private Student[] students;
	
	/**
	 * DO NOT remove or change this constructor, it will be used during task check
	 * @param length
	 */
	public StudentGroup(int length) {
		this.students = new Student[length];
	}

	
	public Student[] getStudents() {
		
		return students;
	}

	
	public void setStudents(Student[] students){
		if(students==null)
			throw new IllegalArgumentException();
		this.students=students;
	}

	
	public Student getStudent(int index) {
		if(index<0||index>=students.length)
			throw new IllegalArgumentException();
		return students[index];
	}

	
	public void setStudent(Student student, int index) {
		if(student==null||index<0||index>=students.length)
			throw new IllegalArgumentException();
		students[index]=student;
	}

	
	public void addFirst(Student student) {
		if(student==null)
			throw new IllegalArgumentException();
		Student tmp[]=new Student[students.length+1];
		tmp[0]=student;
		for(int i=0;i<students.length;i++)
			tmp[i+1]=students[i];
		students=tmp;
	}

	
	public void addLast(Student student) {
		if(student==null)
			throw new IllegalArgumentException();
		Student tmp[]=new Student[students.length+1];
		int i;
		for(i=0;i<students.length;i++)
			tmp[i]=students[i];
		tmp[i]=student;
		students=tmp;
	}

	
	public void add(Student student, int index) {
		if(student==null||index<0||index>=students.length)
			throw new IllegalArgumentException();
		Student tmp[]=new Student[students.length+1];
		for(int i=0;i<=index;i++)
			tmp[i]=students[i];
		tmp[index+1]=student;
		for(int i=index+1;i<students.length;i++)
			tmp[i+1]=students[i];
		students=tmp;		
	}

	
	public void remove(int index) {
		if(index<0||index>=students.length)
			throw new IllegalArgumentException();
		Student tmp[]=new Student[students.length-1];
		for(int i=0;i<students.length;i++)
			if(i!=index)
			tmp[i]=students[i];
		students=tmp;
	}


	public void remove(Student student) {
		if(student==null)
			throw new IllegalArgumentException();
		Student tmp[]=new Student[students.length-1];
		int flag=0;
		for(int i=0,k=0;i<students.length;i++){
			if(students[i]!=student)
				tmp[k++]=students[i];
			else
				flag=1;
		}
		if(flag==1)
			students=tmp;
		else
			throw new IllegalArgumentException("Student not exist");
	}

	
	public void removeFromIndex(int index) {
		if(index<0||index>=students.length)
			throw new IllegalArgumentException();
		Student tmp[]=new Student[index];
		for(int i=0;i<=index;i++)
			tmp[i]=students[i];
		students=tmp;
	}

	
	public void removeFromElement(Student student) {
		if(student==null)
			throw new IllegalArgumentException();
		int i;
		for(i=0;i<students.length;i++)
			if(students[i]==student)
				break;
		if(i==students.length)
			throw new IllegalArgumentException("Student not exist");
		Student tmp[]=new Student[i];
		for(int j=0;j<=i;j++)
			tmp[j]=students[j];
		
		students=tmp;
	}

	
	public void removeToIndex(int index) {
		if(index<0||index>=students.length)
			throw new IllegalArgumentException();
		Student tmp[]=new Student[students.length-index];
		for(int i=index;i<students.length;i++)
			tmp[i]=students[i];
		students=tmp;
	}

	
	public void removeToElement(Student student) {
		if(student==null)
			throw new IllegalArgumentException();
		int i;
		for(i=0;i<students.length;i++)
			if(students[i]==student)
				break;
		if(i==students.length)
			throw new IllegalArgumentException("Student not exist");
		Student tmp[]=new Student[students.length-i];
		for(int j=i;j<=students.length;j++)
			tmp[j]=students[j];
		
		students=tmp;
	}

	
	public void bubbleSort() {
		for(int i=0; i < students.length; i++){  
                 for(int j=1; j < (students.length-i); j++){  
                          if(students[i].getId() > students[j].getId()){  
                                 
                                 Student tmp = students[j-1];  
                                 students[j-1] = students[j];  
                                 students[j] = tmp;  
                         }  
                          
                 }  
		}
	}
	public Student[] getByBirthDate(Date date) {
		if(date==null)
			throw new IllegalArgumentException();
		int ct=0;
		for(int i=0;i<students.length;i++)
			if(students[i].getBirthDate().equals(date))
				ct++;
		Student tmp[]=new Student[ct];
		int k=0;
		for(int i=0;i<students.length;i++)
			if(students[i].getBirthDate().equals(date))
				tmp[k++]=students[i];
		return tmp;
	}

	
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
		if(firstDate==null||lastDate==null)
                    throw new IllegalArgumentException();
                int ct=0;
                for(int i=0;i<students.length;i++)
                        if((students[i].getBirthDate().compareTo(firstDate)>=0)||(students[i].getBirthDate().compareTo(lastDate)<=0))
                            ct++;
                Student tmp[]=new Student[ct];
                int k=0;
                for(int i=0;i<students.length;i++)
                        if((students[i].getBirthDate().compareTo(firstDate)>=0)||(students[i].getBirthDate().compareTo(lastDate)<=0))
                            tmp[k++]=students[i];
                           
                return tmp;
		
	}

	
	public Student[] getNearBirthDate(Date date, int days) {
		// Add your implementation here
		return null;
	}

	
	public int getCurrentAgeByDate(int indexOfStudent) {
                if(indexOfStudent<0||indexOfStudent>students.length)
                        throw new IllegalArgumentException();
                    return students[indexOfStudent].getAge();
		
	}

	
	public Student[] getStudentsByAge(int age) {
                int ct=0;
		for(int i=0;i<students.length;i++)
                        if(age==students[i].getAge())
                        ct++;
                Student tmp[]=new Student[ct];
                int k=0;
                for(int i=0;i<students.length;i++)
                        if(age==students[i].getAge())
                            tmp[k++]=students[i];
		return tmp;
	}

	
	public Student[] getStudentsWithMaxAvgMark() {
		double max=0;
                for(int i=0;i<students.length;i++)
                    if(max<students[i].getAvgMark())
                        max=students[i].getAvgMark();
                int ct=0;
                for(int i=0;i<students.length;i++)
                    if(max==students[i].getAvgMark())
                        ct++;
                Student [] tmp=new Student[ct];
                int k=0;
                 for(int i=0;i<students.length;i++)
                    if(max==students[i].getAvgMark())
                        tmp[k++]=students[i];
		return tmp;
	}

	
	public Student getNextStudent(Student student) {
                if(student==null)
			throw new IllegalArgumentException();
		for(int i=0;i+1<students.length;i++)
                        if(students[i]==student)
                            return students[i+1];
		return null;
	}
}
