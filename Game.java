import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class Game extends Application {
    private static Map map;
    private Player player;
    private Food food;

    public static void main(String[] args) {
    	map = new Map(args[0]);
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        
        player = new MyPlayer(map);
        food = new Food(map,player);

        map.setOnKeyPressed(e ->{
            try {
                if (e.getCode() == KeyCode.LEFT) {
                    player.moveLeft();

                } else if (e.getCode() == KeyCode.RIGHT) {
                    player.moveRight();
                } else if (e.getCode() == KeyCode.UP) {
                    player.moveUp();
                } else if (e.getCode() == KeyCode.DOWN) {
                    player.moveDown();
                }
            }catch (ArrayIndexOutOfBoundsException ex){
                System.out.println("Invalid Position!");
            }
        });
        primaryStage.setTitle("Eater");
        primaryStage.setScene(new Scene(map));
        primaryStage.show();

        map.requestFocus();

    }
}
