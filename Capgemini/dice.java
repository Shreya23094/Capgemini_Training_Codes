import java.util.*;

public class dice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of players: ");
        int n = sc.nextInt();
        int[] scores = new int[n];
        boolean gameWon = false;
        while(!gameWon){
            for(int i = 0; i < n; i++){
                int die = (int)(Math.random() * 6) + 1;
                scores[i] += die;
                System.out.println("Player " + (i+1) + " rolled a " + die + ". Total score: " + scores[i]);
                if(scores[i] >= 50){
                    System.out.println("\nPlayer " + (i+1) + " wins!");
                    gameWon = true;
                    break;
                }
            }
            if(!gameWon){
                System.out.println("Select 1 to Roll, 0 to Stop:");
                int choice = sc.nextInt();
                if(choice == 0){
                    System.out.println("Game exited.");
                    break;
                }
            }
        }
        sc.close();
    }
}
