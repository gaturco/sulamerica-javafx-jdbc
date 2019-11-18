package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;

public class MainViewController implements Initializable {

	@FXML
	private MenuItem menuItemPaciente;
	
	@FXML
	private MenuItem menuItemTranstorno;
	
	@FXML
	private MenuItem menuItemUsuario;
	
	@FXML
	private MenuItem menuItemAbout;
	
	@FXML
	public void onMenuItemPacienteAction() {
		System.out.println("onMenuItemPacienteAction");
	}
	
	@FXML
	public void onMenuItemTranstornoAction() {
		System.out.println("onMenuItemTranstornoAction");
	}
	
	@FXML
	public void onMenuItemUsuarioAction() {
		System.out.println("onMenuItemUsuarioAction");
	}
	
	@FXML
	public void onMenuItemAboutAction() {
		System.out.println("onMenuItemAboutAction");
	}
	
	@Override
	public void initialize(URL uri, ResourceBundle rb) {
		// TODO Auto-generated method stub
		
	}

}
