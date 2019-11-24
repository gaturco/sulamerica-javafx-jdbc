package model.services;

import java.util.List;

import model.dao.DAOFactory;
import model.dao.TranstornoDAO;
import model.entities.Transtorno;

public class TranstornoService {

	private TranstornoDAO dao = DAOFactory.createTranstornoDAO();

	public List<Transtorno> findAll() {
		return dao.findAll();
	}
}
