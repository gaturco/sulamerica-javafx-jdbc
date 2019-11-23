package gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
	public void onBtNewAction() {
		System.out.println("onBtNewAction");
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
}
