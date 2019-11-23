package model.services;

import java.util.ArrayList;
import java.util.List;

import model.entities.Transtorno;

public class TranstornoService {

	public List<Transtorno> findAll() {
		List<Transtorno> list = new ArrayList<>();
		list.add(new Transtorno("F32", "depressao"));
		list.add(new Transtorno("F41", "ansiedade"));
		
		return list;
	}
}
