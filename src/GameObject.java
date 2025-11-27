import javafx.scene.Node;
import javafx.scene.layout.Pane;

public abstract class GameObject {

    protected abstract Node getToken();

    protected void addToPane(Pane pane) {
        pane.getChildren().add(this.getToken());
    }

}
