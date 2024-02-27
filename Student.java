class Student implements Comparable
{
	String name;
	int id;
	int marks;

	Student(int id,String name,int marks)
	{
	   this.name=name;
	   this.id = id;
	   this.marks = marks;
	}

	@Override
	public  int  compareTo(Object s1)
	{
		Student s=(Student)s1;
		return this.name.compareTo(s.name);		
	}

	@Override 
	public boolean equals(Object o)
	{
		System.out.println("equals method called");
		if(o!=null && o instanceof Student)
		{
			Student s = (Student)o;
			
			if( this.marks == s.marks)
				 return true;
			else
				return false;
	    }
		else
			return false;
	}

	@Override 
	public int hashCode()
	{
		System.out.println("hashcode called");
		return id;
	}

	@Override 
	public String toString()
	{
		return id+" "+name+" "+marks;
	}
}