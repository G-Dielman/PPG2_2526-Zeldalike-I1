import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class ZeldaLikeApplication extends Application {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private Pane world;
    private List<Wall>walls;

    @Override
    public void start(Stage primaryStage) {
        world = new Pane();
        Scene scene = new Scene(world, WIDTH, HEIGHT);

        primaryStage.setTitle("Zelda Like - Itération 1");
        primaryStage.setScene(scene);

        this.walls = new ArrayList<>();
       walls.add(new Wall(0,0,10,50, Color.BROWN));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
