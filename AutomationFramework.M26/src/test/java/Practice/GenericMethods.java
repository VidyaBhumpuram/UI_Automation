package Practice;

public class GenericMethods {

	public static void main(String[] args) {
		
		int sum=add(10,20);
		System.out.println("Additon of 2 numbers : "+ sum);
		
		System.out.println(sum+20 +" : is the Addtion of sum and 20");
		
		int sum1=sub(40,10);
		System.out.println("Substraction of 2 numbers : "+ sum1);

	}
	
	public static int add(int a, int b)
	{
		int c= a+b;
		return c;
	}
	
	public static int sub(int a, int b)
	{
		int c= a-b;
		return c;
	}

}
