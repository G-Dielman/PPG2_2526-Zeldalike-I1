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

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ZeldaLike extends Application {

    private static final int LARGEUR = 800;
    private static final int HAUTEUR = 600;
    private Pane monde;
    private List<Rectangle>obstacles;
    private List<Wall> walls;



    @Override
    public void start(Stage primaryStage) {
        monde = new Pane();
        int position = 0;
        Scene scene = new Scene(monde, LARGEUR, HAUTEUR);

        primaryStage.setTitle("Zelda Like - Itération 1");
        primaryStage.setScene(scene);

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

       for (Wall wall : this.walls) {
            monde.getChildren().add(wall);
            this.obstacles.add(wall);
        }

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
                    joueur.move(0, -joueur.getVitesse(),this.obstacles);
                    break;
                case DOWN:
                    joueur.move(0, +joueur.getVitesse(),this.obstacles);
                    break;
                case LEFT:
                    joueur.move(-joueur.getVitesse(), 0,this.obstacles);
                    break;
                case RIGHT:
                    joueur.move(+joueur.getVitesse(), 0,this.obstacles);
                    break;
                default:
                    break;
            }
        });
        //end artus update
    }


    public static void main(String[] args) {
        launch(args);
    }
}
