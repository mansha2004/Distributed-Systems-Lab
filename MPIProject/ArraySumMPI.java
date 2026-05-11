import mpi.*; 
public class ArraySumMPI { 
    public static void main(String[] args) throws Exception { 
 
        MPI.Init(args); 
 
        int rank = MPI.COMM_WORLD.Rank();   // Processor ID 
        int size = MPI.COMM_WORLD.Size();   // Total processors 
 
        int N = 8;  // Total elements 
 
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8}; 
 
        int elementsPerProcess = N / size; 
        int[] subArray = new int[elementsPerProcess]; 
 
        // Display original array (only root) 
        if (rank == 0) { 
            System.out.println("Original Array:"); 
            for (int i = 0; i < N; i++) { 
                System.out.print(array[i] + " "); 
            } 
            System.out.println(); 
        } 
 
        // Scatter elements to all processors 
        MPI.COMM_WORLD.Scatter(array, 0, elementsPerProcess, MPI.INT, 
                subArray, 0, elementsPerProcess, MPI.INT, 0); 
 
        // Local sum calculation 
        int localSum = 0; 
        for (int i = 0; i < elementsPerProcess; i++) { 
            localSum += subArray[i]; 
        } 
 
        // Print intermediate sum 
        System.out.println("Processor " + rank + " local sum = " + localSum); 
 
        // Gather results 
        int[] gatheredSums = new int[size]; 
 
        MPI.COMM_WORLD.Gather(new int[]{localSum}, 0, 1, MPI.INT, 
                gatheredSums, 0, 1, MPI.INT, 0); 
 
        // Final sum (root only) 
        if (rank == 0) { 
            int totalSum = 0; 
 
            System.out.println("\nIntermediate sums:"); 
            for (int i = 0; i < size; i++) { 
                System.out.println("Processor " + i + " sum = " + gatheredSums[i]); 
                totalSum += gatheredSums[i]; 
            } 
 
            System.out.println("\nFinal Sum = " + totalSum); 
        } 
 
        MPI.Finalize(); 
    } 
}