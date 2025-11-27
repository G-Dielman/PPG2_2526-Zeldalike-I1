import javafx.scene.Group;
import javafx.scene.layout.Pane;

public abstract class GameObject {

    protected double width, height;

    public GameObject(double width, double height) {
        this.width = width;
        this.height = height;
    }

    protected abstract Group getToken();

    protected void addToPane(Pane pane) {
        pane.getChildren().add(this.getToken());
    }

    protected double getWidth() {
        return this.width;
    }

    protected double getHeight() {
        return this.height;
    }

    protected double getHalfWidth() {
        return this.getWidth() / 2.0;
    }

    protected double getHalfHeight() {
        return this.getHeight() / 2.0;
    }

    protected void setX(double x) {
        this.getToken().setLayoutX(x);
    }

    protected double getX() {
        return this.getToken().getLayoutX();
    }

    protected void setY(double y) {
        this.getToken().setLayoutY(y);
    }

    protected double getY() {
        return this.getToken().getLayoutY();
    }

    protected double getTokenBottom() {
        return this.getY() + this.getHalfHeight();
    }

    protected double getTokenTop() {
        return this.getY() - this.getHalfHeight();
    }

    protected double getTokenRight() {
        return this.getX() + this.getHalfWidth();
    }

    protected double getTokenLeft() {
        return this.getX() - this.getHalfWidth();
    }

    protected void setAngle(double angle) {
        this.getToken().setRotate(angle);
    }

    protected double getAngle() {
        return this.getToken().getRotate();
    }

}
