import java.util.*;

class MarksComparator implements Comparator
{
	@Override
	public int compare(Object o1,Object o2)
	{  
		Student s1 = (Student)o1;  
		Student s2 = (Student)o2;  
		  
		if(s1.marks == s2.marks)  
			return 0;  
		else if(s1.marks > s2.marks)  
			return 1;  
		else  
			return -1;  
	}
}