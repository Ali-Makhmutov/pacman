import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Map extends Pane{
    private int UNIT;
    private int size;
    private int[][] map;
    private Position start;

    public Map(String s){
        UNIT = 30;
        GridPane pane = new GridPane();
        File file = new File(s);
        Scanner scan = null;
        try {
            scan = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        size = scan.nextInt();
        map = new int[size][size];

        for(int i = 0;i < size;i++){
            for(int j = 0; j < size;j++){
                map[i][j] = scan.nextInt();
                if(map[i][j] == 2){
                    start = new Position(i,j);

                }
            }
        }
        Rectangle[][] rect = new Rectangle[size][size];
        for(int i = 0;i < size;i++){
            for(int j = 0; j < size;j++){
                rect[i][j] = new Rectangle(30,30, Color.WHITE);
                if(getValue(j,i) == 0){
                    rect[i][j].setFill(Color.WHITE);
                }else if(getValue(j,i) == 1){
                    rect[i][j].setFill(Color.BLACK);

                }
                rect[i][j].setStroke(Color.BLACK);
                rect[i][j].setStrokeWidth(0.5);
                pane.add(rect[i][j],i,j);
            }
        }
        getChildren().add(pane);

    }

    public int getUnit() {
        return UNIT;
    }

    public int getSize() {
        return size;
    }

    public int getValue(int a,int b) {
        return map[a][b];
    }

    public Position getStartPosition() {

        return start;
    }
}
