import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Wall extends Rectangle {

    public Wall(double x, double y, double width, double height, Color color){
        this.setX(x);
        this.setY(y);
        this.setWidth(width);
        this.setHeight(height);
        this.setFill(color);
    }

    public void addToPane(Pane pane) {
        pane.getChildren().add(this);
    }

}
