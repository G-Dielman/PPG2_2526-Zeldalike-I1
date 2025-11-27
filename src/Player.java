import java.util.List;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;

public class Player extends GameObject {

    private final double width = 80;
    private final double height = 20;
    private final int speed = 15;

    public Player() {
        this.setX(400);
        this.setY(400);
    }

    public Node getToken() {
        Ellipse body = new Ellipse(0,0, width / 2, height / 2);
        Circle head = new Circle(0,0,15);
        Circle hand = new Circle(32,-10,6);
        Rectangle sword = new Rectangle(25,-13 ,15,3);

        body.setFill(Color.DARKOLIVEGREEN);
        head.setFill(Color.DARKORANGE);
        hand.setFill(Color.DARKGREEN);
        sword.setFill(Color.WHITE);

        Group group = new Group(body, head, hand, sword);
        return group;
    }

    public void move(double dx, double dy,double angle, List<Rectangle> obstacles) {
        this.setAngle(angle);
        this.setX(this.getX() + dx);
        this.resolveCollisionOnXAxis(obstacles, dx);
        this.setY(this.getY() + dy);
        this.resolveCollisionOnYAxis(obstacles, dy);
    }

    private void resolveCollisionOnXAxis(List<Rectangle> obstacles, double dx) {
        final double halfWidth = this.getHalfWidth();
        for(final Rectangle obstacle : obstacles) {
            if (dx > 0 && this.canCollideLeft(obstacle)) {
                System.out.println("left");
                this.setX(this.getObstacleLeft(obstacle) - halfWidth);
            } else if (dx < 0 && this.canCollideRight(obstacle)) {
                System.out.println("right");
                this.setX(this.getObstacleRight(obstacle) + halfWidth);
            }
        }
    }

    private void resolveCollisionOnYAxis(List<Rectangle> obstacles, double dy) {
        final double halfHeight = this.getHalfHeight();
        for(final Rectangle obstacle : obstacles) {
            if (dy > 0 && this.canCollideTop(obstacle)) {
                System.out.println("top");
                this.setY(this.getObstacleTop(obstacle) - halfHeight);
            } else if (dy < 0 && this.canCollideBottom(obstacle)) {
                System.out.println("bottom");
                this.setY(this.getObstacleBottom(obstacle) + halfHeight);
            }
        }
    }

    public boolean canCollideLeft(Rectangle obstacle) {
        //double xGaucheToken = this.getX() - (this.width / 2);
        //double murDroit  = rectangle.getX() + rectangle.getWidth();

        //return (xGaucheToken <= murDroit && xGaucheToken >= rectangle.getX());

        final boolean overlapsHorizontally = (
            this.getTokenRight() > this.getObstacleLeft(obstacle) &&
            this.getTokenLeft() < this.getObstacleRight(obstacle)
        );
        final boolean overlapsVertically = (
            this.getTokenBottom() > this.getObstacleTop(obstacle) &&
            this.getTokenTop() < this.getObstacleBottom(obstacle)
        );
        return overlapsHorizontally && overlapsVertically;
    }

    public boolean canCollideRight(Rectangle obstacle) {
        //double xDroiteToken = this.getX() + (this.width / 2);
        //double murGauche = rectangle.getX();

        //return (xDroiteToken >= murGauche && xDroiteToken <= rectangle.getX());

        final boolean overlapsHorizontally = (
            this.getTokenRight() > this.getObstacleLeft(obstacle) &&
            this.getTokenLeft() < this.getObstacleRight(obstacle)
        );
        final boolean overlapsVertically = (
            this.getTokenBottom() > this.getObstacleTop(obstacle) &&
            this.getTokenTop() < this.getObstacleBottom(obstacle)
        );
        return overlapsHorizontally && overlapsVertically;
    }

    public boolean canCollideTop(Rectangle obstacle) {
        //double yTopToken = this.getY() - (this.height / 2);
        //double murTop = rectangle.getY();

        //return (yTopToken <= murTop && yTopToken >= rectangle.getY());

        final boolean overlapsHorizontally = (
            this.getTokenRight() > this.getObstacleLeft(obstacle) &&
            this.getTokenLeft() < this.getObstacleRight(obstacle)
        );
        final boolean overlapsVertically = (
            this.getTokenBottom() > this.getObstacleTop(obstacle) &&
            this.getTokenTop() < this.getObstacleBottom(obstacle)
        );
        return overlapsHorizontally && overlapsVertically;
    }

    public boolean canCollideBottom(Rectangle obstacle) {
        //double yBottomToken = this.getY() + (this.height / 2);
        //double murBottom = rectangle.getY() + rectangle.getHeight();

        //return (yBottomToken >= murBottom && yBottomToken <= rectangle.getHeight());

        final boolean overlapsHorizontally = (
            this.getTokenRight() > this.getObstacleLeft(obstacle) &&
            this.getTokenLeft() < this.getObstacleRight(obstacle)
        );
        final boolean overlapsVertically = (
            this.getTokenBottom() > this.getObstacleTop(obstacle) &&
            this.getTokenTop() < this.getObstacleBottom(obstacle)
        );
        return overlapsHorizontally && overlapsVertically;
    }

    private double getHalfWidth() {
        return this.width / 2.0;
    }

    private double getHalfHeight() {
        return this.height / 2.0;
    }

    private double getTokenBottom() {
        return this.getY() + this.getHalfHeight();
    }

    private double getTokenTop() {
        return this.getY() - this.getHalfHeight();
    }

    private double getTokenRight() {
        return this.getX() + this.getHalfWidth();
    }

    private double getTokenLeft() {
        return this.getX() - this.getHalfWidth();
    }

    private double getObstacleLeft(Rectangle obstacle) {
        return obstacle.getX();
    }

    private double getObstacleRight(Rectangle obstacle) {
        return obstacle.getX() + obstacle.getWidth();
    }

    private double getObstacleTop(Rectangle obstacle) {
        return obstacle.getY();
    }

    private double getObstacleBottom(Rectangle obstacle) {
        return obstacle.getY() + obstacle.getHeight();
    }

    public void setX(double x) {
        this.getToken().setLayoutX(x);
    }

    public double getX() {
        return this.getToken().getLayoutX();
    }

    public void setY(double y) {
        this.getToken().setLayoutY(y);
    }

    public double getY() {
        return this.getToken().getLayoutY();
    }

    public void setAngle(double angle) {
        this.getToken().setRotate(angle);
    }

    public double getAngle() {
        return this.getToken().getRotate();
    }

    public int getSpeed(){
        return this.speed;
    }

}