import controller.Controller;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.CellularAutomatonSimulation;
import model.states.BriansBrainState;
import model.states.SeedsState;

import java.io.IOException;
import java.net.URL;
import java.util.Random;

import static java.util.Objects.requireNonNull;

/**
 * Entry point for <i>The Game of Life</i> application.
 *
 */
public class SimulatorApplication extends Application {

  public static final int NUMBER_OF_ROWS = 40;
  public static final int NUMBER_OF_COLUMNS = 70;

  public static final Random GENERATOR = new Random();

  private static final String APP_NAME = "Game of Life";
  private static final String VIEW_RESOURCE_PATH = "/view/view.fxml";

  private final CellularAutomatonSimulation<SeedsState> gameOfLife;
  private Stage primaryStage;
  private Parent view;

  /**
   * Creates a new {@code GameOfLifeApplication} instance.
   */
  public SimulatorApplication() {
    this.gameOfLife =
      new CellularAutomatonSimulation<>(
              NUMBER_OF_COLUMNS,
              NUMBER_OF_ROWS,
              SeedsState.OFF,
              SeedsState::random
      );
  }


  @Override
  public void start(Stage primaryStage) throws IOException {
    initializePrimaryStage(primaryStage);
    initializeView();
    showScene();
  }

  private void initializePrimaryStage(Stage primaryStage) {
    this.primaryStage = primaryStage;
    this.primaryStage.setTitle(APP_NAME);
    this.primaryStage.setOnCloseRequest(event -> Platform.exit());
    this.primaryStage.setResizable(false);
    this.primaryStage.sizeToScene();
  }

  private void initializeView() throws IOException {
    FXMLLoader loader = new FXMLLoader();
    URL location = SimulatorApplication.class.getResource(VIEW_RESOURCE_PATH);
    loader.setLocation(location);
    view = loader.load();
    Controller controller = loader.getController();
    controller.setSimulation(gameOfLife);
  }


  private void showScene() {
    Scene scene = new Scene(view);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

}
