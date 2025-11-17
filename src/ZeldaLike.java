import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.Random;

public class ZeldaLike extends Application {

    private static final int LARGEUR = 800;
    private static final int HAUTEUR = 600;
    private Pane monde;



    @Override
    public void start(Stage primaryStage) {
        monde = new Pane();
        int position = 0;
        Scene scene = new Scene(monde, LARGEUR, HAUTEUR);

        primaryStage.setTitle("Zelda Like - Itération 1");
        primaryStage.setScene(scene);
        primaryStage.show();

        Joueur joueur = new Joueur();
        Group link = joueur.getLink();
        link.setLayoutX(joueur.getX());
        link.setLayoutY(joueur.getY());
        monde.getChildren().add(link);
        //artus add switch case for player movement

        //joueur.move(400,400);
        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case UP:
                    joueur.move(0, -joueur.getVitesse());
                    break;
                case DOWN:
                    joueur.move(0, +joueur.getVitesse());
                    break;
                case LEFT:
                    joueur.move(-joueur.getVitesse(), 0);
                    break;
                case RIGHT:
                    joueur.move(+joueur.getVitesse(), 0);
                    break;
                default:
                    break;
            }
        });
        System.out.println(joueur);
        //end artus update
    }


    public static void main(String[] args) {
        launch(args);
    }
}
