package gui;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.entities.Transtorno;

public class TranstornoListController implements Initializable {

	@FXML
	private TableView<Transtorno> tableViewTranstorno;

	@FXML
	private TableColumn<Transtorno, String> tableColumnCodigo;

	@FXML
	private TableColumn<Transtorno, String> tableColumnNome;

	@FXML
	private Button btNew;

	@FXML
	public void onBtNewAction() {
		System.out.println("onBtNewAction");
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();
	}

	private void initializeNodes() {

		tableColumnCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
		tableColumnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));

		Stage stage = (Stage) Main.getMainScene().getWindow();
		tableViewTranstorno.prefHeightProperty().bind(stage.heightProperty());
	}
}
