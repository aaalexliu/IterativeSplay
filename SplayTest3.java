import java.lang.Integer;
import java.util.Random;

public class SplayTest3{
	public static void main(String[] args){
		BinarySearchTree s = new BinarySearchTree();

		int n = Integer.parseInt(args[0]);

		Random r = new Random();
		int[] testValues = new int[n];

		for(int i = 0; i < n; i++){
			testValues[i] = r.nextInt();
		}



		for (int i : testValues)
		    {
			System.out.printf("=== ADDING %d ===\n", i);
			s.add(i);
		}
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
		for (int i : removeValues)
		    {
			System.out.printf("=== REMOVING %d ===\n", i);
			s.remove(i);
			// System.out.println(s);
		    }

		System.out.println("=== ADDING BACK ===");
		for (int i : testValues)
		    {
			s.add(i);
		    }
		System.out.println(s);
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