package br.com.fiap.carstation.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import br.com.fiap.carstation.dao.EstacaoDao;
import br.com.fiap.carstation.App;

public class TableController implements MouseListener{

	EstacaoDao dao = new EstacaoDao();
	private App app;

	public TableController(App app) {
		this.app = app;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() == 2) {
			int answer = JOptionPane.showConfirmDialog(null, "Tem certeza que quer deletar?");
			if (answer == JOptionPane.YES_OPTION) {
				JTable table = (JTable) e.getSource();
				String estacaoId = (String) table.getValueAt(table.getSelectedRow(), 0);
				dao.delete(Long.valueOf(estacaoId));
				app.loadData();
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}
}
