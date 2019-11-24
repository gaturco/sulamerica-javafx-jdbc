package gui;

import java.net.URL;
import java.util.ResourceBundle;

import gui.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.entities.Transtorno;

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
	
	public void setTranstorno(Transtorno entity) {
		this.entity = entity;
	}
	
	@FXML
	public void onBtSalvarAction() {
		System.out.println("onBtSalvarAction");
	}
	
	@FXML
	public void onBtCancelarAction() {
		System.out.println("onBtCancelarAction");
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
	
}
