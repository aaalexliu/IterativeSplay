public class SplayTest2{
	public static void main(String[] args){
	BinarySearchTree s = new BinarySearchTree();

	int[] testValues = {2, 1, 4, 6, 8, 3, 9, 10, 5, 7};

	for (int i : testValues)
	    {
		System.out.printf("=== ADDING %d ===\n", i);
		s.add(i);
		System.out.println(s);
		for (int j = 0; j <= 11; j++)
		    {
			System.out.printf("nextExcluded(%d) = %d\n", j, s.nextExcluded(j));
		    }
	    }

	for (int i = 0; i <= 11; i++)
	    {
		System.out.println(i + ": " + s.contains(i));
	    }
	System.out.println(s);

	int[] removeValues = {1, 10, 5, 2, 4, 8, 7, 6, 9, 3};
	for (int i : removeValues)
	    {
		System.out.printf("=== REMOVING %d ===\n", i);
		s.remove(i);
		System.out.println(s);
	    }

	System.out.println("=== ADDING BACK ===");
	for (int i : testValues)
	    {
		s.add(i);
	    }
	System.out.println(s);
    }
}