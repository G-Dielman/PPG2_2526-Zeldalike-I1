import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;

public class Joueur {

    private  double width =80, height =20;

    private Group createTopDownLink(double scale) {

        Ellipse corp= new Ellipse(0,0, width/2, height/2);
        Circle tete = new Circle(0,0,15);
        Circle main = new Circle(32,-10,6);
        Rectangle sword = new Rectangle(25,-13 ,15,3);
        sword.setFill(Color.WHITE);
        corp.setFill(Color.DARKOLIVEGREEN);


        Group g = new Group(corp, tete, main, sword);

        return g;
    }


}
