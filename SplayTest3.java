import java.lang.Integer;
import java.util.Random;

public class SplayTest3{
	public static void main(String[] args){
		BinarySearchTree s = new BinarySearchTree();

		int n = (int) Math.pow(10,Integer.parseInt(args[0]));
		System.out.println(n);

		int[] testValues = new int[n];

		for(int i = 0; i < n; i++){
			//testValues[i] = r.nextInt(n);
			testValues[i] = i;
		}
		testValues = RandomizeArray(testValues);


		long startTime = System.nanoTime();

		for (int i : testValues)
		    {
			//System.out.printf("=== ADDING %d ===\n", i);
			s.add(i);
		}
		long endTime = System.nanoTime();

		System.out.println("TOTAL TIME OF ADD OPERATIONS: " + (endTime - startTime));
		System.out.println("SIZE: " + s.size());
		System.out.println("AVERAGE NUMBER OF ADD OPERATIONS: " + (s.addCount/s.add));
		System.out.println("AVERAGE NUMBER OF SPLAY OPERATIONS: " + (s.splayCount/s.splay));
		System.out.println("AVERAGE SUCCESSOR OPERATIONS: " + (s.successorCount/s.successor));
			// System.out.println(s);
			// for (int j = 0; j <= 11; j++)
			//     {
			// 	System.out.printf("nextExcluded(%d) = %d\n", j, s.nextExcluded(j));
			//     }
		 //    }

		// for (int i = 0; i <= 11; i++)
		//     {
		// 	System.out.println(i + ": " + s.contains(i));
		//     }
		// System.out.println(s);

		int[] removeValues = RandomizeArray(testValues);
		startTime = System.nanoTime();
		for (int i : removeValues)
		    {
			//System.out.printf("=== REMOVING %d ===\n", i);
			s.remove(i);
			// System.out.println(s);
		    }
	    endTime = System.nanoTime();
	    System.out.println("TOTAL TIME OF REMOVE OPERATIONS: " + (endTime - startTime));
	    System.out.println("SIZE: " + s.size());
		System.out.println("AVERAGE NUMBER OF SPLAY OPERATIONS: " + (s.splayCount/s.splay));
		System.out.println("AVERAGE NUMBER OF ADD NODE OPERATIONS: " + (s.addNodeCount/s.addNode));

	    System.out.println();

		Random r = new Random();
		for(int i = 0; i < n; i++){
			s.add(r.nextInt());
		}

		startTime = System.nanoTime();

		for(int i = 0; i < n; i++){
			s.contains(r.nextInt());
		}
		endTime = System.nanoTime();
		System.out.println(endTime - startTime);
		System.out.println(s.containsCount/s.contains);

		startTime = System.nanoTime();
		for(int i = 0; i < n; i++){
			s.nextExcluded(r.nextInt());
		}
		endTime = System.nanoTime();
		System.out.println(endTime - startTime);


		// System.out.println("=== ADDING BACK ===");
		// for (int i : testValues)
		//     {
		// 	s.add(i);
		//     }
		// System.out.println(s);
    }

    public static int[] RandomizeArray(int[] array){
		Random rgen = new Random();  // Random number generator			
 
		for (int i=0; i<array.length; i++) {
		    int randomPosition = rgen.nextInt(array.length);
		    int temp = array[i];
		    array[i] = array[randomPosition];
		    array[randomPosition] = temp;
		}
 
		return array;
	}
}