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
    private static final int WALL_THICKNESS = 10;

    private Scene scene;
    private Pane pane;
    private Player player;
    private List<Rectangle> obstacles;

    @Override
    public void start(Stage primaryStage) {
        this.pane = new Pane();
        this.scene = new Scene(this.pane, WIDTH, HEIGHT);
        this.player = new Player(400, 400);
        this.player.addToPane(this.pane);
        this.obstacles = new ArrayList<>();
        this.buildWalls();
        this.addPlayerControls();

        primaryStage.setTitle("Zelda Like - Itération 1");
        primaryStage.setScene(this.scene);
        primaryStage.show();
    }

    private void buildWalls() {
        this.addWallObstacle(new Wall(0,0, WIDTH, WALL_THICKNESS, Color.BROWN)); // Up
        this.addWallObstacle(new Wall(0,HEIGHT - WALL_THICKNESS,WIDTH,WALL_THICKNESS, Color.BROWN)); // Down
        this.addWallObstacle(new Wall(WIDTH - WALL_THICKNESS,0, WALL_THICKNESS, HEIGHT, Color.BROWN)); // Right
        this.addWallObstacle(new Wall(0,0,WALL_THICKNESS,600, Color.BROWN)); // Left

        this.addWallObstacle(new Wall(200,200,100,100, Color.BROWN)); // Middle
    }

    private void addWallObstacle(Wall wall) {
        wall.addToPane(this.pane);
        this.obstacles.add(wall);
    }

    private void addPlayerControls() {
        this.scene.setOnKeyPressed(event -> {
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
    }

    public static void main(String[] args) {
        launch(args);
    }
}
