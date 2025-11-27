import javafx.scene.Node;
import javafx.scene.layout.Pane;

public abstract class GameObject {

    public abstract Node getToken();

    public void addToPane(Pane pane) {
        pane.getChildren().add(this.getToken());
    }

}
