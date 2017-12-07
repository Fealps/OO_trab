import java.awt.*;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.util.ArrayList;

import javax.swing.*;

public class MenuRelatorioAluno {

	private static JFrame janela;
	public static JLabel j1 = null;
	public static JLabel j2 = null;
	public static JLabel t1 = null;
	public static JLabel t2 = null;
	private static JButton c;
	private static JComboBox<String> nomesList;
	private static String[] lista;
	static int k;

	public static void apresentarGUIExibir(Aluno a) {

		c = new JButton();
		t1 = new JLabel("Nome ");
		t2 = new JLabel("Matrícula");
		janela = new JFrame("Relatorio de alunos");

		// janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c.setText("Fechar");

		janela.getContentPane().add(t1);
		janela.getContentPane().add(t2);

		nomesList = new JComboBox<String>();

		for (int i = 0; i < a.alunos.size(); i++) {
			// j1 = new JLabel(a.alunos.get(i).getNome().toString());
			// j2 = new JLabel(a.alunos.get(i).getMatricula().toString());
			nomesList.addItem(a.alunos.get(i).getNome().toString());
			// janela.getContentPane().add(j1);
			// janela.getContentPane().add(j2);
		}

		j2 = new JLabel();

		nomesList.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				k = nomesList.getSelectedIndex();
				
				j2.setText(a.alunos.get(k).getMatricula().toString());
				
				
			}
		});
		
		
		j2 = new JLabel ();

		janela.getContentPane().add(nomesList);
		janela.getContentPane().add(j2);

		janela.getContentPane().add(c);

		janela.setMinimumSize(new Dimension(400, 200));
		janela.setLayout(new GridLayout(0, 2, 10, 10));

		janela.pack();
		janela.setVisible(true);

		c.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				janela.dispose();
			}
		});

	}

}
