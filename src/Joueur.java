import java.util.List;

import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;

public class Joueur {

    private final double width =80;
    private final double height=20;



    private double x = 400;
    private double y = 400;

    private int vitesse = 15;

    public Joueur(){
        this.link = createToken(1.0);
    }

    private Group link;

    private Group createToken(double scale) {

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
    public void move(double movex, double movey, List<Rectangle> obstacles) {
        this.x += movex;
        this.resolveCollisionOnXAxis(obstacles);
        this.y += movey;
        this.resolveCollisionOnYAxis(obstacles);
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

    public void spawn(Pane world) {
        this.link.setLayoutX(this.x);
        this.link.setLayoutY(this.y);
        world.getChildren().add(this.link);
    }

    private void resolveCollisionOnXAxis(List<Rectangle> obstacles) {
        double linkBoundsWidth = this.getLinkBounds().getWidth();
        for(final Rectangle obstacle : obstacles) {
            double obstacleLeft = obstacle.getX();
            double obstacleRight = obstacle.getX() + obstacle.getWidth();
            if(this.canCollideLeft(obstacle)) {
                this.x = obstacleLeft - linkBoundsWidth;
            }
            if(this.canCollideRight(obstacle)) {
                this.x = obstacleRight;
            }
        }
    }

    private void resolveCollisionOnYAxis(List<Rectangle> obstacles) {
        double linkBoundsHeight = this.getLinkBounds().getHeight();
        for(final Rectangle obstacle : obstacles) {
            double obstacleTop = obstacle.getY();
            double obstacleBottom = obstacle.getY() + obstacle.getHeight();
            if(this.canCollideTop(obstacle)) {
                this.y = obstacleTop - linkBoundsHeight;
            }
            if(this.canCollideBottom(obstacle)) {
                this.y = obstacleBottom;
            }
        }
    }

    public boolean canCollideLeft(Rectangle rectangle) {
        return this.isMovingToLeft(rectangle) && this.getLinkBounds().intersects(rectangle.getBoundsInParent());
    }

    public boolean isMovingToLeft(Rectangle rectangle) {
        return false;
    }

    public boolean canCollideRight(Rectangle rectangle) {
        return this.getLinkBounds().intersects(rectangle.getBoundsInParent());
    }

    public boolean isMovingToRight(Rectangle rectangle) {
        return false;
    }

    public boolean canCollideTop(Rectangle rectangle) {
        return this.getLinkBounds().intersects(rectangle.getBoundsInParent());
    }

    public boolean isMovingToTop(Rectangle rectangle) {
        return false;
    }

    public boolean canCollideBottom(Rectangle rectangle) {
        return this.getLinkBounds().intersects(rectangle.getBoundsInParent());
    }

    public boolean isMovingToBottom(Rectangle rectangle) {
        return this.getLinkBounds().intersects(rectangle.getBoundsInParent());
    }

    private Bounds getLinkBounds() {
        return this.link.getBoundsInParent();
    }

    public void setLink(Group link) {
        this.link = link;
    }
}
