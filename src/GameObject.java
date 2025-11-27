import javafx.scene.Group;
import javafx.scene.layout.Pane;

public abstract class GameObject {

    protected abstract Group getToken();

    protected void addToPane(Pane pane) {
        pane.getChildren().add(this.getToken());
    }

}
