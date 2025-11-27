import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class ZeldaLikeApplication extends Application {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private Scene scene;
    private Pane pane;
    private Player player;
    private List<Rectangle> obstacles;
    private List<Wall> walls;

    @Override
    public void start(Stage primaryStage) {
        this.pane = new Pane();
        this.scene = new Scene(this.pane, WIDTH, HEIGHT);
        this.player = new Player(400, 400);
        this.player.addToPane(this.pane);


        this.obstacles = new ArrayList<>();
        this.walls = new ArrayList<>();

        //mure du haut
        this.walls.add(new Wall(0,0,800,10, Color.BROWN));
       //mure du bas
        this.walls.add(new Wall(0,600-10,800,10, Color.BROWN));
        //mure de droite
        this.walls.add(new Wall(800-10,0,10,600, Color.BROWN));
        //mure de gauche
        this.walls.add(new Wall(0,0,10,600, Color.BROWN));


        this.walls.add(new Wall(200,200,100,100, Color.BROWN));

       for (Wall wall : this.walls) {
            this.pane.getChildren().add(wall);
            this.obstacles.add(wall);
        }



        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case LEFT:
                    this.player.moveLeft(this.obstacles);
                    break;
                case RIGHT:
                    this.player.moveRight(this.obstacles);
                    break;
                case UP:
                    this.player.moveUp(this.obstacles);
                    break;
                case DOWN:
                    this.player.moveDown(this.obstacles);
                    break;
            }
        });


       primaryStage.setTitle("Zelda Like - Itération 1");
       primaryStage.setScene(this.scene);
       primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
