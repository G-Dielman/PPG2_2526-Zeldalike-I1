import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Wall extends Rectangle {

    public Wall(double x, double y, double width, double height, Color color){
        setX(x);
        setY(y);
        setWidth(width);
        setHeight(height);
        this.setFill(color);
    }




}
