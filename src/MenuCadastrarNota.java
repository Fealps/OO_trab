
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

public class MenuCadastrarNota {

	private static JFrame janela;
	private static JComboBox<String> atividades;
	private static ArrayList<String> disciplinasDisponiveis = null;
	public static JLabel t1 = null;
	public static JLabel t2 = null;
	public static JLabel t3 = null;
	public static JButton cancel = new JButton("Cancelar");
	private static MaskFormatter mascaraMatricula;
	public static JButton adicionarNota = new JButton("Adicionar notas");
	private static String disciplinaEscolhida;
	private static String disciplinaEquivalente;
	private static int k;

	public static void apresentarGUIExibir(Aluno a, Turma t) {

		disciplinasDisponiveis = new ArrayList<>();

		for (int i = 0; i < t.getTurmas().size(); i++) {

			 disciplinasDisponiveis.add(t.getTurmas().get(i).getDisciplina());

		}

		disciplinaEscolhida = JOptionPane
				.showInputDialog("Em qual das turmas deseja cadastrar uma nota: " + disciplinasDisponiveis);

		janela = new JFrame();
		janela.setMinimumSize(new Dimension(600, 350));
		janela.setLayout(new GridLayout(0, 3, 5, 5));

		t1 = new JLabel("Atividade");
		t2 = new JLabel("Alunos");
		t3 = new JLabel("Notas");

		janela.getContentPane().add(t1);
		janela.getContentPane().add(t2);
		janela.getContentPane().add(t3);

		janela.setVisible(false);

		for (int i = 0; i < t.getTurmas().size(); i++) {

			disciplinaEquivalente = t.getTurmas().get(i).getDisciplina();

			if (disciplinaEquivalente.equals(disciplinaEscolhida)) {
				
				atividades = new JComboBox<String>();
				
				for(int j = 0; j < t.getTurmas().get(i).getAval().getAvaliacoes().size();j++) {
					
					String atividadeNome = t.getTurmas().get(i).getAval().getAvaliacoes().get(j).getNome();					
					atividades.addItem(atividadeNome);
					
				}
				
				try {
					mascaraMatricula = new MaskFormatter("#.##");

				} catch (ParseException exp) {
					exp.printStackTrace();
					mascaraMatricula.setPlaceholderCharacter('_');

				}
				JFormattedTextField matriculaF = new JFormattedTextField(mascaraMatricula);
				matriculaF.setVisible(true);

				
				adicionarNota.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						JOptionPane.showMessageDialog(null, "Notas inseridas");
					}
				});				
				
				cancel.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						janela.dispose();
					}
				});
				
				
				janela.getContentPane().add(atividades);
				janela.getContentPane().add(new JLabel("Teste Nome"));
				janela.getContentPane().add(matriculaF);

				janela.getContentPane().add(cancel);
				janela.getContentPane().add(adicionarNota);
				janela.setTitle("Cadastro de notas na turma de " + disciplinaEscolhida);
				janela.setVisible(true);
				janela.pack();

			}

		}

	}

}
