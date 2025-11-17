import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;

public class Joueur {

    private  double width =80, height =20;

    private double x = 400;
    private double y = 400;

    private int vitesse = 15;

    public Joueur(){
        this.link = createToken(1.0);



    }
    public Group getLink() {
        return link;
    }

    private Group link;

    public Group createToken(double scale) {

        Ellipse corp= new Ellipse(0,0, width/2, height/2);
        Circle tete = new Circle(0,0,15);
        Circle main = new Circle(32,-10,6);
        Rectangle sword = new Rectangle(25,-13 ,15,3);

        corp.setFill(Color.DARKOLIVEGREEN);
        tete.setFill(Color.DARKORANGE);
        main.setFill(Color.DARKGREEN);
        sword.setFill(Color.WHITE);


        Group g = new Group(corp, tete, main, sword);

        return g;
    }
    //artus add move method
    public void move(double movex, double movey) {

        this.x += movex;
        this.y += movey;
        link.setLayoutX(x);
        link.setLayoutY(y);

    }
    //end artus update

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    //add get vitesse
    public int getVitesse(){
        return this.vitesse;
    }



    public void setLink(Group link) {
        this.link = link;
    }
}
