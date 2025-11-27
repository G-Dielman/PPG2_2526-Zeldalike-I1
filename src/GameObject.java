import javafx.scene.Group;
import javafx.scene.layout.Pane;

public abstract class GameObject {

    protected abstract Group getToken();

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

    protected void setAngle(double angle) {
        this.getToken().setRotate(angle);
    }

    protected double getAngle() {
        return this.getToken().getRotate();
    }

    protected void addToPane(Pane pane) {
        pane.getChildren().add(this.getToken());
    }

}
