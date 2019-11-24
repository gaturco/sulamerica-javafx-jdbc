package gui;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import gui.util.Alerts;
import gui.util.Utils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.entities.Transtorno;
import model.services.TranstornoService;

public class TranstornoListController implements Initializable {

	private TranstornoService service;
	
	@FXML
	private TableView<Transtorno> tableViewTranstorno;

	@FXML
	private TableColumn<Transtorno, String> tableColumnCodigo;

	@FXML
	private TableColumn<Transtorno, String> tableColumnNome;

	@FXML
	private Button btNew;
	
	private ObservableList<Transtorno> obsList;

	@FXML
	public void onBtNewAction(ActionEvent event) {
		createDialogForm("/gui/TranstornoForm.fxml", Utils.currentStage(event));
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();
	}
	
	public void setTranstornoService(TranstornoService service) {
		this.service = service;
	}

	private void initializeNodes() {

		tableColumnCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
		tableColumnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));

		Stage stage = (Stage) Main.getMainScene().getWindow();
		tableViewTranstorno.prefHeightProperty().bind(stage.heightProperty());
	}
	
	public void updateTableView() {
		if(service == null) {
			throw new IllegalStateException("Service null");
		}
		
		List<Transtorno> list = service.findAll();
		
		obsList = FXCollections.observableArrayList(list);
		tableViewTranstorno.setItems(obsList);
	}
	
	private void createDialogForm(String absoluteName, Stage parentStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			Pane pane = loader.load();
			
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Preencha os dados do transtorno");
			dialogStage.setScene(new Scene(pane));
			dialogStage.setResizable(false);
			dialogStage.initOwner(parentStage);
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.showAndWait();
			
		} catch (IOException e) {
			Alerts.showAlerts("IOException", "Erro ao carregar a tela", e.getMessage(), AlertType.ERROR);
		}
	}
}
