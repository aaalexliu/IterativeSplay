import java.util.Scanner;
import java.util.Iterator;

public class SplayTest
{
    public static void main(String[] args)
    {
	BinarySearchTree t = new BinarySearchTree();

	String test1 = "a 10 a 5 a 15 a 1 a 20 a 2 a 17";

	String test2 = "a 20 a 10 a 40 a 50 a 30 a 35 r 30";
	String test3 = "a 30 a 10 a 60 a 31 a 35 a 34 a 70 r 30";

	Scanner in = new Scanner(test3);
	//Scanner in = new Scanner(System.in);

	
	while (in.hasNext())
	    {
		String command = in.next();
		if (command.toLowerCase().startsWith("a"))
		    {
			int i = in.nextInt();
			t.add(i);
		    }
		else if (command.toLowerCase().startsWith("r"))
		    {
			int i = in.nextInt();
			t.remove(i);
		    }
		else
		    {
			in.nextLine();
		    }
		System.out.println(t);
		//t.validate();
		
		// Iterator<Integer> i = t.inorderIterator();
		// while (i.hasNext())
		//     {
		// 	System.out.print(i.next() + " ");
		//     }
		// System.out.println();
	    }
	System.out.println(t);
    }
}
