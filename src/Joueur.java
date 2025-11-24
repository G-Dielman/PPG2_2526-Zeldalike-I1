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
    private double angle = 0;

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

    public void move(double movex, double movey, List<Rectangle> obstacles) {
        this.x += movex;
        this.resolveCollisionOnXAxis(obstacles);
        this.y += movey;
        this.resolveCollisionOnYAxis(obstacles);
        link.setLayoutX(x);
        link.setLayoutY(y);
    }

    //add setter for angle
    public void setAngle(double angle) {
        this.angle = angle;
        this.link.setRotate(angle);
    }


    public double getX() {
        return this.link.getLayoutX();
    }

    public double getY() {
        return this.link.getLayoutY();
    }


    public int getVitesse(){
        return this.vitesse;
    }

    //add getteur for angle
    public double getAngle() {
        return this.angle;
    }

    public void spawn(Pane world) {
        this.link.setLayoutX(this.x);
        this.link.setLayoutY(this.y);
        world.getChildren().add(this.link);
    }

    private void resolveCollisionOnXAxis(List<Rectangle> obstacles) {
        for(final Rectangle obstacle : obstacles) {
            final double obstacleLeft = obstacle.getX();
            final double obstacleRight = obstacle.getX() + obstacle.getWidth();
            final double halfWidth = this.width / 2.0;
            if(this.canCollideLeft(obstacle)) {
                this.x = obstacleLeft - halfWidth;
            } else if(this.canCollideRight(obstacle)) {
                this.x = obstacleRight + halfWidth;
            }
        }
    }

    private void resolveCollisionOnYAxis(List<Rectangle> obstacles) {
        for(final Rectangle obstacle : obstacles) {
            final double obstacleTop = obstacle.getY();
            final double obstacleBottom = obstacle.getY() + obstacle.getHeight();
            final double halfHeight = this.height / 2.0;
            if(this.canCollideTop(obstacle)) {
                this.y = obstacleTop - halfHeight;
            } else if(this.canCollideBottom(obstacle)) {
                this.y = obstacleBottom + halfHeight;
            }
        }
    }

    public boolean canCollideLeft(Rectangle rectangle) {
        double xGaucheToken = this.x - (this.width/2);
        double murDroit  = rectangle.getX() + rectangle.getWidth();

        return (xGaucheToken <= murDroit && xGaucheToken >= rectangle.getX());
    }

    public boolean canCollideRight(Rectangle rectangle) {
        double xDroiteToken = this.x + (this.width/2);
        double murGauche = rectangle.getX();

        return (xDroiteToken >= murGauche && xDroiteToken <= rectangle.getX());
    }

    public boolean canCollideTop(Rectangle rectangle) {
        double yTopToken = this.y - (this.height/2);
        double murTop = rectangle.getY();

        return (yTopToken <= murTop && yTopToken >= rectangle.getY());
    }

    public boolean canCollideBottom(Rectangle rectangle) {
        double yBottomToken = this.y + (this.y/2);
        double murBottom = rectangle.getY() + rectangle.getHeight();

        return (yBottomToken >= murBottom && yBottomToken <= rectangle.getHeight());
    }

    public void setLink(Group link) {
        this.link = link;
    }





    }









