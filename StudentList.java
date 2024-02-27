import java.util.*;
class StudentList
{	
	public static void main(String [] args)
	{
		Student [] sarr = new Student[3];
		Student s1 = new Student(10,"ram",100);
		Student s2 = new Student(20,"raj",200);
		Student s3=new Student(10,"abhi",300);
		sarr[0]=s1;
		sarr[1]=s2;
		sarr[2]=s3;
    	List<Student> slist = new ArrayList<Student>();
		for(Student s : sarr)
			if(!slist.contains(s))
				slist.add(s);
	
		System.out.println(slist);   
	}
}