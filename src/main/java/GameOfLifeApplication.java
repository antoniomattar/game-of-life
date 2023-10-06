import controller.Controller;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.CellGrid;
import model.CellularAutomataSimulation;
import model.GameOfLifeState;

import java.io.IOException;
import java.net.URL;

import static java.util.Objects.requireNonNull;

/**
 * Entry point for <i>The Game of Life</i> application.
 *
 */
public class GameOfLifeApplication extends Application {

  private static final int NUMBER_OF_ROWS = 40;
  private static final int NUMBER_OF_COLUMNS = 70;

  private static final String APP_NAME = "Game of Life";
  private static final String VIEW_RESOURCE_PATH = "/view/view.fxml";

  private final CellularAutomataSimulation<GameOfLifeState> gameOfLife;
  private Stage primaryStage;
  private Parent view;

  /**
   * Creates a new {@code GameOfLifeApplication} instance.
   */
  public GameOfLifeApplication() {
    this(new CellularAutomataSimulation<GameOfLifeState>(
            new CellGrid<>(NUMBER_OF_COLUMNS, NUMBER_OF_ROWS, GameOfLifeState.ALIVE),
            GameOfLifeState.DEAD,
            GameOfLifeState::random
    ));
  }

  /**
   * Creates a new {@code GameOfLifeApplication} instance given a {@link CellularAutomataSimulation} instance.
   *
   * @param cellularAutomataSimulation the {@link CellularAutomataSimulation} instance
   * @throws NullPointerException if {@code gameOfLife} is {@code null}
   */
  private GameOfLifeApplication(CellularAutomataSimulation<GameOfLifeState> cellularAutomataSimulation) {
    this.gameOfLife = requireNonNull(cellularAutomataSimulation, "game of life is null");
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
    URL location = GameOfLifeApplication.class.getResource(VIEW_RESOURCE_PATH);
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
