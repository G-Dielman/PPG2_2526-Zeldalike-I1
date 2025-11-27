import java.util.List;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;

public class Player extends GameObject {

    private final int speed = 15;

    public Player(double initialX, double initialY) {
        super(80, 20);
        this.setX(initialX);
        this.setY(initialY);
    }

    public Group getToken() {
        final Ellipse body = new Ellipse(0,0, this.width / 2, this.height / 2);
        final Circle head = new Circle(0,0,15);
        final Circle hand = new Circle(32,-10,6);
        final Rectangle sword = new Rectangle(25,-13 ,15,3);

        body.setFill(Color.DARKOLIVEGREEN);
        head.setFill(Color.DARKORANGE);
        hand.setFill(Color.DARKGREEN);
        sword.setFill(Color.WHITE);

        return new Group(body, head, hand, sword);
    }

    public void moveLeft(List<Rectangle> obstacles) {
        this.move(obstacles, -this.speed,0, -90);
    }

    public void moveRight(List<Rectangle> obstacles) {
        this.move(obstacles, this.speed,0, 90);
    }

    public void moveUp(List<Rectangle> obstacles) {
        this.move(obstacles, 0, -this.speed,0);
    }

    public void moveDown(List<Rectangle> obstacles) {
        this.move(obstacles, 0, this.speed,-180);
    }

    public void move(List<Rectangle> obstacles, double dx, double dy, double angle) {
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

}