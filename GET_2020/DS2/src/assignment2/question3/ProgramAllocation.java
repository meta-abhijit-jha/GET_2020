package assignment2.question3;

import java.util.Scanner;

import assignment2.question2.QueueImpl;

public class ProgramAllocation {
	
	public static void allocateProgram(QueueImpl<Student> students, Program[] programs) {
		
		while( !students.isEmpty() ) {
			Student student = students.dequeue();
			
			boolean flag = false;
			for(String programName : student.getPrograms()) {
				for(Program program : programs) {
					if( programName.equals( program.getName() ) && program.getCapacity() > program.getAllocated() ) {
						student.setProgramAllocated(programName);
						program.setAllocated(program.getAllocated() + 1);
						flag = true;
						break;
					}
				}
				if(flag)
					break;
			}
			System.out.println(student.getName()+" Allocated " + student.getProgramAllocated());
		}
	}
	
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = 5;
		Program[] programs = new Program[n];
		programs[0] = new Program("a",2);
		programs[1] = new Program("b",1);
		programs[2] = new Program("c",1);
		programs[3] = new Program("d",1);
		programs[4] = new Program("e",1);
		int no_of_students = 5;
		QueueImpl<Student> students = new QueueImpl<Student> (no_of_students) {};
		students.enqueue( new Student("first", new String[] {"a", "b", "c", "d", "e"} ) );
		students.enqueue( new Student("second", new String[] {"b", "d", "e", "a", "c"} ) );
		students.enqueue( new Student("third", new String[] {"a", "d", "e", "b", "d"} ) );
		students.enqueue( new Student("fourth", new String[] {"b", "d", "e", "c", "a"} ) );
		students.enqueue( new Student("fifth", new String[] {"e", "b", "c", "d", "a"} ) );
		allocateProgram(students, programs);
		sc.close();
	}
}
