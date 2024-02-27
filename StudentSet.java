import java.util.*;

class StudentSet
{
	public static void main(String [] args)
	{
		Student [] sarr = new Student[3];
		sarr[0] = new Student(10,"ram",100);
		sarr[1] = new Student(30,"raj",300);
		sarr[2] = new Student(20,"abhi",200);

   		Set<Student> sset = new TreeSet<Student>(new MarksComparator());
		for(Student s : sarr)
			sset.add(s);
		System.out.println(sset);
  	}
}