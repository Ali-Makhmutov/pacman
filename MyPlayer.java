import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class MyPlayer implements Player{
    private Circle ball;
    private Map map;
    private Position position;

    public MyPlayer(Map m){
        this.map = m;
        position = map.getStartPosition();
        ball = new Circle(15,15,15, Color.RED);
        map.getChildren().add(ball);
    }

    @Override
    public void moveRight() {
        int i = 1;
        if(1 == map.getValue(position.getY(),(position.getX() + 1))) {
            System.out.println("Invalid Position!");
        }else {
            position.setX(position.getX() + 1);
            ball.setCenterX(ball.getCenterX() + map.getUnit());
        }
    }

    @Override
    public void moveLeft() {
        int i = 1;
        if(1 == map.getValue(position.getY(),(position.getX() - 1))) {
            System.out.println("Invalid Position!");
        }else {
            position.setX(position.getX() - 1);
            ball.setCenterX(ball.getCenterX() - map.getUnit());
        }

    }

    @Override
    public void moveUp() {
        int i = 1;
        if(1 == map.getValue((position.getY() - 1),position.getX())) {
            System.out.println("Invalid Position!");
        }else {
            position.setY(position.getY() - 1);
            ball.setCenterY(ball.getCenterY() - map.getUnit());
        }

    }

    @Override
    public void moveDown() {
        int i = 1;
        if(1 == map.getValue((position.getY() + 1),position.getX())) {
            System.out.println("Invalid Position!");
        }else {
            position.setY(position.getY() + 1);
            ball.setCenterY(ball.getCenterY() + map.getUnit());
        }

    }

    @Override
    public Position getPosition() {
        return position;
    }
    /*public void Black(){
        int[][] num = new int[][];
        for(int i = 0;i < map.getSize();i++){
            for(int j = 0;j < map.getSize();j++){
                if(map.getValue(j,i) == 1){
                    num[i] = new int[]{i,j};
                }
            }
        }
    }*/
}
