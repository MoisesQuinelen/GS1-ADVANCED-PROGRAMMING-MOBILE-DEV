package br.com.fiap.carstation.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import br.com.fiap.carstation.dao.EstacaoDao;
import br.com.fiap.carstation.model.Estacao;
import br.com.fiap.carstation.App;

public class ButtonController implements ActionListener {
	EstacaoDao dao = new EstacaoDao();

	private App app;

	public ButtonController(App app) {
		this.app = app;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "Salvar") {
			Estacao estacao = new Estacao();
			estacao.setNome(app.getNomeInput().getText());
			estacao.setRua(app.getRuaInput().getText());
			estacao.setBairro(app.getBairroInput().getText());
			estacao.setCidade(app.getCidadeInput().getText());
			estacao.setEstado(app.getEstadosSelector().getSelectedItem().toString());
			estacao.setTomada(app.getCheckedboxes());
			estacao.setPreco(Float.parseFloat(app.getPrecoInput().getText()));
			estacao.setAvaliacao(app.getAvaliacao().getSelection());
			dao.insert(estacao);
			app.loadData();
			JOptionPane.showMessageDialog(null, "Salvo com sucesso!");		
			}
		if(e.getActionCommand() == "Limpar") {
			app.cleanData();
		}
        if(e.getActionCommand() == "Ordenar") {
			app.loadDataOrdered();
		}
	}	
}
