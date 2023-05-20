import javax.swing.JFrame;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//import static jdk.internal.logger.DefaultLoggerFinder.SharedLoggers.system;

public class NewClass extends JFrame {
    int xStartCord,yStartCord,xEndCord,yEndCord;
    boolean pathExist;
    int maze[][] =
            {
                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                    {1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1},
                    {1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1},
                    {1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1},
                    {1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1},
                    {1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 1},
                    {1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1},
                    {1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1},
                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
            };
    public List<Integer> path = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public NewClass() {
        setTitle("Maze Solver");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        System.out.println("Enter the Starting point X coordinate in range 1 to 8");
         xStartCord = sc.nextInt();
        System.out.println("Enter the Starting point Y coordinate in range 1 to 11");
         yStartCord = sc.nextInt();
        System.out.println("Enter the Ending point X coordinate in range 1 to 8");
         xEndCord = sc.nextInt();
        System.out.println("Enter the Ending point Y coordinate in range 1 to 11");
         yEndCord = sc.nextInt();
        maze[xEndCord][yEndCord]=9;
        pathExist= DepthFirst.searchPath(maze, yStartCord, xStartCord, path);
//        System.out.print(path);
    }

    public void paint(Graphics g) {
        g.translate(50, 50);
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                Color color;
                switch (maze[i][j]) {
                    case 1:
                        color = Color.BLACK;
                        break;
                    default:
                        color = Color.WHITE;
                        break;
                }
                g.setColor(color);
                g.fillRect(30 * j, 30 * i, 30, 30);
                g.setColor(Color.RED);
                g.drawRect(30 * j, 30 * i, 30, 30);
            }
        }
        g.setColor(Color.RED);
        g.fillRect(30 * yEndCord,30 * xEndCord,30,30);
        if(pathExist==false){
            g.setColor(Color.CYAN);
            g.drawString("Path Does not exist!",150,350);
        }
        for (int i = 0; i < path.size(); i += 2) {
            int pathX = path.get(i);
            int pathY = path.get(i + 1);
            g.setColor(Color.GREEN);
            g.fillRect(30 * pathX, 30 * pathY, 25, 25);
        }
    }
}



