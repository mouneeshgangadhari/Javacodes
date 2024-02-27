
class StudentDemo{
	public static void main(String [] args)
	{
		Student s1 = new Student(10,"ram",100);
		Student s2 = new Student(20,"raj",200);
		Student s3 = new Student(10,"abhi",300);

		System.out.println(s1.equals(s3));
		System.out.println(s1.equals(s2));
	}
}