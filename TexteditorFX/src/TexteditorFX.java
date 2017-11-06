
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.Highlighter.HighlightPainter;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//TODO: bei Checkbox!

public class TexteditorFX extends Application {

	MenuBar menubar;

	Menu m_datei, m_suchen;

	// Menuitems - Datei
	MenuItem mi_new, mi_open, mi_save;
	// Menuitems - Suche
	MenuItem mi_search;
	// VBox + Textarea
	TextArea textArea;
	VBox vbox;

	// Variable holds search element
	String searchElement;

	// MAIN
	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("TexteditorFX");

		BorderPane root = new BorderPane();

		// Menubar
		menubar = new MenuBar();
		menubar.prefWidthProperty().bind(primaryStage.widthProperty());
		root.setTop(menubar);

		// Menu
		m_datei = new Menu("Datei");
		m_suchen = new Menu("Suche");

		// Menuitems - Datei
		mi_new = new MenuItem("Neu");
		mi_new.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("neu gedrückt.");
				// TODO: Datei neu einbinden
			}
		});
		mi_open = new MenuItem("Öffnen");
		mi_open.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("öffnen gedrückt.");
				// TODO: Datei öffnen einbinden
			}

		});
		mi_save = new MenuItem("Speichern");
		mi_save.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("speichern gedrückt.");
				// TODO: Datei speichern einbinden
			}

		});

		// Menuitems - Suche
		mi_search = new MenuItem("Wort-/Textsuche");
		mi_search.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				showSearchWindow();
			}
		});

		// Textarea
		// Passt Width und Height dynamisch an die Größe des Windows an
		textArea = new TextArea();
		textArea.setWrapText(true); // Zeilenumbruch
		textArea.prefWidthProperty().bind(primaryStage.widthProperty());
		textArea.prefHeightProperty().bind(primaryStage.heightProperty());
		vbox = new VBox();
		vbox.getChildren().add(textArea);
		root.setCenter(vbox);

		// Add Items to Menu - Datei
		m_datei.getItems().addAll(mi_new, mi_open, mi_save);

		// Add Items to Menu - Suche
		m_suchen.getItems().addAll(mi_search);

		// Add Menus to Menubar
		menubar.getMenus().addAll(m_datei, m_suchen);

		Scene scene = new Scene(root, 800, 600);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	/**
	 * Methode opens a second window for the search option
	 */
	private void showSearchWindow() {
		Stage newWindow = new Stage();

		BorderPane sec_window = new BorderPane();

		TextArea suchText = new TextArea();
		suchText.setWrapText(true); // Zeilenumbruch
		vbox = new VBox();
		vbox.getChildren().add(suchText);

		// Checkbox - checked/true -> case sensitive
		CheckBox chb_CaseSensitive = new CheckBox();
		// chb_CaseSensitive.

		// Button - OK
		Button b_ok = new Button("OK");
		b_ok.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				searchElement = suchText.getText();
				checkForSearchElement(searchElement);

			}
		});

		// Button - Cancel
		Button b_cancel = new Button("Cancel");
		b_cancel.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				newWindow.close();
			}
		});

		// Add Buttons to BorderPane
		sec_window.setLeft(b_ok);
		sec_window.setRight(b_cancel);

		// Add Pane to Scene
		sec_window.setCenter(suchText);

		Scene sec_scene = new Scene(sec_window, 400, 300);

		newWindow.setTitle("Suchefunktion");
		newWindow.setScene(sec_scene);

		newWindow.show();
	}

	private void checkForSearchElement(String s) {
		// TODO:
		// Liste hält alle offsets von allen Suchelementen.
		List<Integer> list = new ArrayList<Integer>();

		String textareaText = textArea.getText();

		int offset = 0;
		int wordlength = s.length();
		int length = 0;

		if (textareaText.contains(s)) {
			// TODO : Was passiert wenn mehrere Stellen gefunden wurden? ->
			// evtl Treffer Liste erzeugen

			offset = textareaText.indexOf(s);
			length = offset + wordlength;

			textArea.selectRange(offset, length);

		} else {
			// TODO: evtl neues Fenster mit Alert-Nachricht
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Info");
			alert.setContentText("Suchelement wurde nicht gefunden.");
			alert.showAndWait();
		}

	}

}
