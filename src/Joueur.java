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

    private final double width = 80;
    private final double height = 20;

    private int vitesse = 15;

    private double x = 400;
    private double y = 400;

    private Group link;

    public Joueur(){
        this.link = createToken(1.0);
    }

    private Group createToken(double scale) {
        Ellipse corp = new Ellipse(0,0, width/2, height/2);
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

    public void spawn(Pane world) {
        world.getChildren().add(this.link);
    }

    public void move(double movex, double movey, List<Rectangle> obstacles) {
        this.link.setLayoutX(this.link.getLayoutX() + movex);
        this.resolveCollisionOnXAxis(obstacles);
        this.link.setLayoutY(this.link.getLayoutY() + movey);
        this.resolveCollisionOnYAxis(obstacles);

    }

    public void setX(double x) {
        // TODO: Set layout x
    }

    public double getX() {
        return this.link.getLayoutX();
    }

    public void setY(double y) {
        // TODO: Set layout y
    }

    public double getY() {
        return this.link.getLayoutY();
    }

    public void setAngle(double angle) {
        this.link.setRotate(angle);
    }

    public double getAngle() {
        return this.link.getRotate();
    }

    public int getVitesse(){
        return this.vitesse;
    }

    private void resolveCollisionOnXAxis(List<Rectangle> obstacles) {
        double x = this.getX();
        for(final Rectangle obstacle : obstacles) {
            final double obstacleLeft = obstacle.getX();
            final double obstacleRight = obstacle.getX() + obstacle.getWidth();
            final double halfWidth = this.width / 2.0;
            if(this.canCollideLeft(obstacle)) {
                x = obstacleLeft - halfWidth;
            } else if(this.canCollideRight(obstacle)) {
                x = obstacleRight + halfWidth;
            }
        }
        this.setX(x);
    }

    private void resolveCollisionOnYAxis(List<Rectangle> obstacles) {
        double y = this.getY();
        for(final Rectangle obstacle : obstacles) {
            final double obstacleTop = obstacle.getY();
            final double obstacleBottom = obstacle.getY() + obstacle.getHeight();
            final double halfHeight = this.height / 2.0;
            if(this.canCollideTop(obstacle)) {
                y = obstacleTop - halfHeight;
            } else if(this.canCollideBottom(obstacle)) {
                y = obstacleBottom + halfHeight;
            }
        }
        this.setY(y);
    }

    public boolean canCollideLeft(Rectangle rectangle) {
        double xGaucheToken = this.getX() - (this.width / 2);
        double murDroit  = rectangle.getX() + rectangle.getWidth();

        return (xGaucheToken <= murDroit && xGaucheToken >= rectangle.getX());
    }

    public boolean canCollideRight(Rectangle rectangle) {
        double xDroiteToken = this.getX() + (this.width / 2);
        double murGauche = rectangle.getX();

        return (xDroiteToken >= murGauche && xDroiteToken <= rectangle.getX());
    }

    public boolean canCollideTop(Rectangle rectangle) {
        double yTopToken = this.getY() - (this.height / 2);
        double murTop = rectangle.getY();

        return (yTopToken <= murTop && yTopToken >= rectangle.getY());
    }

    public boolean canCollideBottom(Rectangle rectangle) {
        double yBottomToken = this.getY() + (this.y / 2);
        double murBottom = rectangle.getY() + rectangle.getHeight();

        return (yBottomToken >= murBottom && yBottomToken <= rectangle.getHeight());
    }

}