package controller;

import datastruct.Coordinate;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.util.Duration;
import model.CellularAutomataSimulation;
import view.MatrixPane;

import static java.util.Objects.requireNonNull;

/**
 * Controller for <i>The Game of Life</i> application.
 */
public class Controller {

    public static final int PERIOD_IN_MILLISECONDS = 100;
    @FXML
    private ToggleButton playToggleButton;
    @FXML
    private ToggleButton pauseToggleButton;
    @FXML
    private Label generationNumberLabel;
    @FXML
    private MatrixPane matrixPane;
    private Timeline timeline;

    public Simulation getSimulation() {
        return simulation;
    }

    private Simulation simulation;

    @FXML
    private void initialize() {
        initializePlayAndPauseToggleButtons();
        updateTimeline();
    }

    private void initializePlayAndPauseToggleButtons() {
        ToggleGroup toggleGroup = new PersistentToggleGroup();
        toggleGroup.getToggles().addAll(playToggleButton, pauseToggleButton);
        pauseToggleButton.setSelected(true);
    }


    /**
     * Sets {@link CellularAutomataSimulation} instance.
     *
     * @param simulation {@link CellularAutomataSimulation} instance
     * @throws NullPointerException if {@code gameOfLife} is {@code null}
     */

    public void setSimulation(Simulation simulation) {
        this.simulation = requireNonNull(simulation, "game of life is null");
        setGenerationNumberLabelTextProperty();
        initializeMatrixPane();
    }

    private void setGenerationNumberLabelTextProperty() {
        generationNumberLabel.textProperty().bind(simulation.generationNumberProperty().asString());
    }

    private void initializeMatrixPane() {
        matrixPane.initialize(this);
    }

    @FXML
    private void playToggleButtonAction() {
        this.play();
    }

    @FXML
    private void pauseToggleButtonAction() {
        this.pause();
    }

    @FXML
    private void resetButtonAction() {
        this.pause();
        simulation.reset();
        pauseToggleButton.setSelected(true);
    }

    @FXML
    private void clearButtonAction() {
        this.pause();
        simulation.clear();
        pauseToggleButton.setSelected(true);
    }



    public Iterable<Coordinate> coordinates() {
        return simulation;
    }

    private void updateTimeline() {
        Duration duration = new Duration(Controller.PERIOD_IN_MILLISECONDS);
        EventHandler<ActionEvent> eventHandler =
                event -> simulation.updateToNextGeneration();
        KeyFrame keyFrame = new KeyFrame(duration, eventHandler);
        timeline = new Timeline(keyFrame);
        timeline.setCycleCount(Animation.INDEFINITE);
    }

    /**
     * Plays the game.
     */
    public void play() {
        timeline.play();
    }

    /**
     * Pauses the game.
     */
    public void pause() {
        timeline.pause();
    }
}
