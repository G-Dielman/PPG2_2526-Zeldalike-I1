import java.util.List;

import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;

public class Joueur {

    private final double width = 80;
    private final double height = 20;

    private int vitesse = 15;

    private Group link;

    public Joueur() {
        this.link = createToken(1.0);
        this.setX(400);
        this.setY(400);
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
        this.resolveCollisionOnXAxis(obstacles, movex);
        this.link.setLayoutY(this.link.getLayoutY() + movey);
        this.resolveCollisionOnYAxis(obstacles, movey);
    }

    public void setX(double x) {
        this.link.setLayoutX(x);
    }

    public double getX() {
        return this.link.getLayoutX();
    }

    public void setY(double y) {
        this.link.setLayoutY(y);
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

    private void resolveCollisionOnXAxis(List<Rectangle> obstacles, double movex) {
        final double halfWidth = this.width / 2.0;
        for(final Rectangle obstacle : obstacles) {
            final double obstacleLeft = obstacle.getX();
            final double obstacleRight = obstacle.getX() + obstacle.getWidth();
            if (movex > 0 && this.canCollideLeft(obstacle)) {
                System.out.println("left");
                this.setX(obstacleLeft - halfWidth);
            } else if (movex < 0 && this.canCollideRight(obstacle)) {
                System.out.println("right");
                this.setX(obstacleRight + halfWidth);
            }
        }
    }

    private void resolveCollisionOnYAxis(List<Rectangle> obstacles, double movey) {
        final double halfHeight = this.height / 2.0;
        for(final Rectangle obstacle : obstacles) {
            final double obstacleTop = obstacle.getY();
            final double obstacleBottom = obstacle.getY() + obstacle.getHeight();
            if (movey > 0 && this.canCollideTop(obstacle)) {
                System.out.println("top");
                this.setY(obstacleTop - halfHeight);
            } else if (movey < 0 && this.canCollideBottom(obstacle)) {
                System.out.println("bottom");
                this.setY(obstacleBottom + halfHeight);
            }
        }
    }

    public boolean canCollideLeft(Rectangle obstacle) {
        //double xGaucheToken = this.getX() - (this.width / 2);
        //double murDroit  = rectangle.getX() + rectangle.getWidth();

        //return (xGaucheToken <= murDroit && xGaucheToken >= rectangle.getX());

        final double halfWidth = this.width / 2.0;
        final double halfHeight = this.height / 2.0;

        final double tokenLeft = this.getX() - halfWidth;
        final double tokenRight = this.getX() + halfWidth;
        final double tokenTop = this.getY() - halfHeight;
        final double tokenBottom = this.getY() + halfHeight;

        final double obstacleLeft = obstacle.getX();
        final double obstacleRight = obstacle.getX() + obstacle.getWidth();
        final double obstacleTop = obstacle.getY();
        final double obstacleBottom = obstacle.getY() + obstacle.getHeight();

        final boolean overlapsHorizontally = (
            tokenRight > obstacleLeft &&
            tokenLeft < obstacleRight
        );
        final boolean overlapsVertically = (
            tokenBottom > obstacleTop &&
            tokenTop < obstacleBottom
        );
        return overlapsHorizontally && overlapsVertically;
    }

    public boolean canCollideRight(Rectangle obstacle) {
        //double xDroiteToken = this.getX() + (this.width / 2);
        //double murGauche = rectangle.getX();

        //return (xDroiteToken >= murGauche && xDroiteToken <= rectangle.getX());

        final double halfWidth = this.width / 2.0;
        final double halfHeight = this.height / 2.0;

        final double tokenLeft = this.getX() - halfWidth;
        final double tokenRight = this.getX() + halfWidth;
        final double tokenTop = this.getY() - halfHeight;
        final double tokenBottom = this.getY() + halfHeight;

        final double obstacleLeft = obstacle.getX();
        final double obstacleRight = obstacle.getX() + obstacle.getWidth();
        final double obstacleTop = obstacle.getY();
        final double obstacleBottom = obstacle.getY() + obstacle.getHeight();
        final boolean overlapsHorizontally = (
            tokenRight > obstacleLeft &&
            tokenLeft < obstacleRight
        );
        final boolean overlapsVertically = (
            tokenBottom > obstacleTop &&
            tokenTop < obstacleBottom
        );
        return overlapsHorizontally && overlapsVertically;
    }

    public boolean canCollideTop(Rectangle obstacle) {
        //double yTopToken = this.getY() - (this.height / 2);
        //double murTop = rectangle.getY();

        //return (yTopToken <= murTop && yTopToken >= rectangle.getY());

        final double halfWidth = this.width / 2.0;
        final double halfHeight = this.height / 2.0;
        final double tokenLeft = this.getX() - halfWidth;
        final double tokenRight = this.getX() + halfWidth;
        final double tokenTop = this.getY() - halfHeight;
        final double tokenBottom = this.getY() + halfHeight;
        final double obstacleLeft = obstacle.getX();
        final double obstacleRight = obstacle.getX() + obstacle.getWidth();
        final double obstacleTop = obstacle.getY();
        final double obstacleBottom = obstacle.getY() + obstacle.getHeight();
        final boolean overlapsHorizontally = (
            tokenRight > obstacleLeft &&
            tokenLeft < obstacleRight
        );
        final boolean overlapsVertically = (
            tokenBottom > obstacleTop &&
            tokenTop < obstacleBottom
        );
        return overlapsHorizontally && overlapsVertically;
    }

    public boolean canCollideBottom(Rectangle obstacle) {
        //double yBottomToken = this.getY() + (this.height / 2);
        //double murBottom = rectangle.getY() + rectangle.getHeight();

        //return (yBottomToken >= murBottom && yBottomToken <= rectangle.getHeight());

        final double halfWidth = this.width / 2.0;
        final double halfHeight = this.height / 2.0;
        final double tokenLeft = this.getX() - halfWidth;
        final double tokenRight = this.getX() + halfWidth;
        final double tokenTop = this.getY() - halfHeight;
        final double tokenBottom = this.getY() + halfHeight;
        final double obstacleLeft = obstacle.getX();
        final double obstacleRight = obstacle.getX() + obstacle.getWidth();
        final double obstacleTop = obstacle.getY();
        final double obstacleBottom = obstacle.getY() + obstacle.getHeight();
        final boolean overlapsHorizontally = (
            tokenRight > obstacleLeft &&
            tokenLeft < obstacleRight
        );
        final boolean overlapsVertically = (
            tokenBottom > obstacleTop &&
            tokenTop < obstacleBottom
        );
        return overlapsHorizontally && overlapsVertically;
    }

}