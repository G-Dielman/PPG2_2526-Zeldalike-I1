import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class ZeldaLikeApplication extends Application {

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


        this.walls.add(new Wall(200,200,100,100, Color.BROWN));

       for (Wall wall : this.walls) {
            monde.getChildren().add(wall);
            this.obstacles.add(wall);
        }

        primaryStage.show();

        Player joueur = new Player();
        joueur.spawn(monde);



        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case UP:
                    joueur.move(0, -joueur.getSpeed(),0,this.obstacles);
                    ;
                    break;
                case DOWN:
                    joueur.move(0, +joueur.getSpeed(),-180,this.obstacles);

                    break;
                case LEFT:
                    joueur.move(-joueur.getSpeed(),0, -90,this.obstacles);

                    break;
                case RIGHT:
                    joueur.move(+joueur.getSpeed(),0, 90,this.obstacles);

                    break;
                default:
                    break;
            }
        });
    }


    public static void main(String[] args) {
        launch(args);
    }
}
