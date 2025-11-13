import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ZeldaLikeApplication extends Application {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private Pane world;

    @Override
    public void start(Stage primaryStage) {
        world = new Pane();
        Scene scene = new Scene(world, WIDTH, HEIGHT);

        primaryStage.setTitle("Zelda Like - Itération 1");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
