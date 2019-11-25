package gui;

import java.net.URL;
import java.util.ResourceBundle;

import db.DbException;
import gui.util.Alerts;
import gui.util.Constraints;
import gui.util.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.entities.Transtorno;
import model.services.TranstornoService;

public class TranstornoFormController implements Initializable {

	@FXML
	private TextField txtId;
	
	@FXML
	private TextField txtCodigo;
	
	@FXML
	private TextField txtNome;
	
	@FXML
	private Label labelErrorCodigo;
	
	@FXML
	private Label labelErrorNome;
	
	@FXML
	private Button btSalvar;
	
	@FXML
	private Button btCancelar;
	
	private Transtorno entity;
	
	private TranstornoService service;
	
	public void setTranstorno(Transtorno entity) {
		this.entity = entity;
	}
	
	public void setTranstornoService(TranstornoService service) {
		this.service = service;
	}
	
	@FXML
	public void onBtSalvarAction(ActionEvent event) {
		if (entity == null) {
			throw new IllegalStateException("Entidade nula");
		}
		if (service == null) {
			throw new IllegalStateException("Service nula");
		}
		try {
			entity = getFormData();
			service.salvarOuAtualizar(entity);
			Utils.currentStage(event).close();
			
		} catch (DbException e) {
			Alerts.showAlert("Erro ao salvar o transtorno", null, e.getMessage(), AlertType.ERROR);
		}
	}
	
	@FXML
	public void onBtCancelarAction(ActionEvent event) {
		Utils.currentStage(event).close();
	}
	
	private void initializeNodes() {
		Constraints.setTextFieldInteger(txtId);
		Constraints.setTextFieldMaxLength(txtCodigo, 3);
		Constraints.setTextFieldMaxLength(txtNome, 50);
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();
	}
	
	public void updateFormData() {
		if (entity == null) {
			throw new IllegalStateException("Entidade nula");
		}
		txtId.setText(String.valueOf(entity.getId()));
		txtCodigo.setText(entity.getCodigo());
		txtNome.setText(entity.getNome());
	}
	
	private Transtorno getFormData() {
		Transtorno transtorno = new Transtorno();
		transtorno.setId(Utils.tryParseToInt(txtId.getText()));
		transtorno.setNome(txtNome.getText());
		transtorno.setCodigo(txtCodigo.getText());
		
		return transtorno;
	}
	
}
