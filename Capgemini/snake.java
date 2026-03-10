
import java.util.*;

public class snake {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 10; 
        char[][] grid = new char[n][n];
        for (char[] row : grid) Arrays.fill(row, '.');
        int sx = n / 2, sy = n / 2; 
        int fx = (int)(Math.random() * n), fy = (int)(Math.random() * n); 
        grid[sx][sy] = 'S';
        grid[fx][fy] = 'F';
        int len = 1;
        LinkedList<int[]> snake = new LinkedList<>();
        snake.add(new int[]{sx, sy});
        boolean alive = true;
        while (alive) {
            for (char[] row : grid) System.out.println(new String(row));
            System.out.print("Move (WASD)\nwhere w -> up, s -> down, a -> left, d -> right : ");
            String move = sc.next().toUpperCase();
            int[] head = snake.peekFirst();
            int nx = head[0], ny = head[1];
            if (move.equals("W")) nx--;
            else if (move.equals("S")) nx++;
            else if (move.equals("A")) ny--;
            else if (move.equals("D")) ny++;
            else {
                System.out.println("Invalid move. Use W, A, S, D.");
                continue;
            }
            if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                System.out.println("Game Over! Hit wall.");
                break;
            }
            for (int[] s : snake) {
                if (s[0] == nx && s[1] == ny) {
                    System.out.println("Game Over! Hit self.");
                    alive = false;
                    break;
                }
            }
            if (!alive) break;
            
            snake.addFirst(new int[]{nx, ny});
            if (nx == fx && ny == fy) {
                len++;

                do {
                    fx = (int)(Math.random() * n);
                    fy = (int)(Math.random() * n);
                } while (grid[fx][fy] == 'S');
            } else {
                int[] tail = snake.removeLast();
                grid[tail[0]][tail[1]] = '.';
            }
            grid[nx][ny] = 'S';
            grid[fx][fy] = 'F';
            System.out.println();
        }
        System.out.println("Final Score: " + (len - 1));
        sc.close();
    }
}