/**
 * Created by jug on 1/22/18.
 */
public class DebugExercise3 {
    public static long countTurnips(In in) {
        long totalTurnips = 0;
        while (!in.isEmpty()) {
            String vendor = in.readString();
            String foodType = in.readString();
            double cost = in.readDouble();
            int numAvailable = in.readInt();
            if (foodType.equals("turnip")) {
                // Check if adding numAvailable will not cause overflow
                if (numAvailable > 0 && Long.MAX_VALUE - totalTurnips < numAvailable) {
                    // Handle overflow scenario here, if needed
                    // For now, assume it doesn't occur in realistic input
                    System.err.println("Warning: Integer overflow may occur. Adjusting calculation.");
                    // Handle overflow by skipping this addition or logging an error
                    continue; // Skip this iteration or handle as per your requirement
                }
                // Safely add numAvailable to totalTurnips
                for (int i = 0; i < numAvailable; i++) {
                    totalTurnips++;
                }
            }
            in.readLine();
        }
        return totalTurnips;
    }

    public static void main(String[] args) {
        In in = new In("foods.csv");
        System.out.println(countTurnips(in));
    }
}
