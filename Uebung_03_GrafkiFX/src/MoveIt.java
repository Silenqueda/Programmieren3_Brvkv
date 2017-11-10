//package de.htwberlin.brovkov.movingellipse;

/**
 * Created by user on 31.03.16.
 */
import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;

public class MoveIt extends Application {

	private List<MovingEllipse> ovals = new ArrayList<MovingEllipse>();
	private Group group = new Group(); // root node for the play window
	private final Random random = new Random();
	private final Button bt = new Button("Restart");

	// wird als Gravitation genutzt -> handle();
	private final double y_Attraction = 1.0; // wird gr��er -> schneller fallen
	private final double x_Deceleration = 1; // wird gr��er -> wird seknrechter
	
	

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		final BorderPane borderPane;
		final Scene scene;
		final Pane pane;
		primaryStage.setTitle("Ellipse & AnimationTimer Example");
		generate(Color.RED, 100.0, 100.0, 35.0, true); // the first moving
														// circle
		generate(Color.GREENYELLOW, 150.0, 150.0, 17.0, true); // the second
																// moving circle
		// create a pane for a group with all moving objects
		pane = new Pane(group);
		pane.setPrefSize(500, 500);
		pane.setStyle("-fx-background-color: blue;");
		// create a restart button
		bt.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				ovals.clear(); // clear List with references
				group.getChildren().clear();// clear all moving objects

				generate(Color.RED, 100.0, 100.0, 35.0, true); // the new first
																// moving circle
				
				//bei reset muss x_Deceleration und y_ Attraction auf default werde gestellt werden.
			}
		});
		// create the main window lauout
		borderPane = new BorderPane();
		borderPane.setTop(bt);
		borderPane.setCenter(pane);
		// setzt Gr��e des Screens (800, 800)
		scene = new Scene(borderPane, 800, 800, Color.ANTIQUEWHITE);
		primaryStage.setScene(scene);
		// set pane autoresisable
		scene.widthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observableValue, Number oldSceneWidth,
					Number newSceneWidth) {
				System.out.println("Width: " + newSceneWidth);
				pane.setPrefWidth(scene.getWidth());
			}
		});
		scene.heightProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observableValue, Number oldSceneHeight,
					Number newSceneHeight) {
				System.out.println("Height: " + newSceneHeight);
				pane.setPrefHeight(scene.getHeight());
			}
		});
		primaryStage.show();

		new AnimationTimer() { // animate all circles

			double grav_x = x_Deceleration;
			double grav_y = y_Attraction;
			
			@Override
			public void handle(long now) {

				
				for (MovingEllipse e : ovals) {

					if (grav_x > 0) {
						e.getEllipse().setCenterX((e.getEllipse().getCenterX() + e.getStepX()));
						e.getEllipse().setCenterY(e.getEllipse().getCenterY() + e.getStepY() + grav_y);

						grav_x += 0.0;
						grav_y += 0.25;
						System.out.println(grav_y);

					} else {
						e.getEllipse().setCenterX(e.getEllipse().getCenterX() + e.getStepX());
						e.getEllipse().setCenterY(e.getEllipse().getCenterY() + e.getStepY());
					}

				}
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
				}
			}
		}.start();
	}

	private void generate(Color c, Double x, Double y, Double radius, boolean clickable) {
		Ellipse localCircle = new Ellipse(x, y, radius, radius);
		localCircle.setStrokeWidth(3);
		localCircle.setStroke(Color.BLACK);
		localCircle.setFill(c);
		if (clickable) { // add event handler
			localCircle.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e) { // create one more moving
													// circle

					
					
					for (int i = 0; i < 10; i++) {
						generate(Color.YELLOW, e.getSceneX(), e.getSceneY() - bt.getHeight(), 10.0, false);

					}
				}
			});
		}

		// ovals.add(new MovingEllipse(localCircle, 0, 0));

		ovals.add(new MovingEllipse(localCircle, random.nextDouble() * 10, random.nextDouble()));
		group.getChildren().add(localCircle); // add object to the group

	}

	private class MovingEllipse {
		private double stepX; //
		private double stepY;
		private Ellipse c; // reference on a circle

		MovingEllipse(Ellipse c, double dx, double dy) {
			this.c = c;
			stepX = dx;
			stepY = dy;
		}

		public double getStepX() {
			return stepX;
		}

		public void setStepX(double stepX) {
			this.stepX = stepX;
		}

		public double getStepY() {
			return stepY;
		}

		public void setStepY(double stepY) {
			this.stepY = stepY;
		}

		public Ellipse getEllipse() {
			return c;
		}

		public void setEllipse(Ellipse c) {
			this.c = c;
		}

		double getDistance(Ellipse e) {
			double x = c.getCenterX() - e.getCenterX();
			double y = c.getCenterY() - e.getCenterY();
			return Math.sqrt(x * x + y * y);
		}

		double getDistance(double coordX, double coordY) {
			double x = c.getCenterX() - coordX;
			double y = c.getCenterY() - coordY;
			return Math.sqrt(x * x + y * y);
		}
	}
}