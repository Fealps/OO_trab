import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.*;

import com.sun.xml.internal.bind.v2.TODO;

import javafx.scene.control.RadioButton;

public class MenuRelatorioFrequencia {

	private static JFrame janela;
	private static JTabbedPane tabela;
	public static String textT = null;
	public static ButtonGroup radioGrupo;
	public static JRadioButton presente;
	public static ArrayList<ButtonGroup> gruposButtonGroup = new ArrayList<>();
	public static JRadioButton faltoso;
	public static JPanel tabelaContent;
	public static JLabel alunoNome = null;
	public static JLabel alunoMatricula = null;
	static ImageIcon icon = null;

	public static void apresentarGUIExibir(Aluno a, Turma t) {

		janela = new JFrame();
		janela.setVisible(true);
		janela.setMinimumSize(new Dimension(400, 300));
		janela.setMaximumSize(new Dimension(600, 300));
		janela.setTitle("Relatório de frequência de alunos");
		// janela.pack();

		tabela = new JTabbedPane();
		tabela.setMinimumSize(new Dimension(600, 100));

		for (int i = 0; i < t.getTurmas().size(); i++) {

			tabelaContent = new JPanel();
			tabelaContent.setVisible(true);
			tabelaContent.setLayout(new GridLayout(0, 4, 5, 5));

			textT = t.getTurmas().get(i).getDisciplina().toString();

			tabelaContent.add(new JLabel("Nomes"));
			tabelaContent.add(new JLabel("Matriculas"));
			tabelaContent.add(new JLabel("P"));
			tabelaContent.add(new JLabel("A"));

			for (int j = 0; j < t.getTurmas().get(i).getAlunos().size(); j++) {

				alunoNome = new JLabel(t.getTurmas().get(i).getAlunos().get(j).getNome());
				alunoMatricula = new JLabel(t.getTurmas().get(i).getAlunos().get(j).getMatricula());

				// tabelaContent.add(new
				// JLabel(t.getTurmas().get(i).getAlunos().get(j).getNome()));
				tabelaContent.add(alunoNome);
				// tabelaContent.add(new
				// JLabel(t.getTurmas().get(i).getAlunos().get(j).getMatricula()));
				tabelaContent.add(alunoMatricula);

				presente = new JRadioButton("Presente");
				faltoso = new JRadioButton("Ausente");
				
				radioGrupo = new ButtonGroup();
				
				radioGrupo.add(presente);
				radioGrupo.add(faltoso);
				
				//gruposButtonGroup.add(radioGrupo);

				tabelaContent.add(presente);
				tabelaContent.add(faltoso);
				
			}

		/*	for (int w = 0; w < gruposButtonGroup.size(); w++) {
				
				for (int y = 0; y <gruposButtonGroup.get(w).getButtonCount();y ++) {
					
					if(gruposButtonGroup.get(w).getSelection().equals(presente.getModel())){
						
					}
					
			
					
				}

				
			}
		*/
			
			tabela.addTab(textT, null, tabelaContent, "nome da disciplina");
			tabela.setMnemonicAt(0, KeyEvent.VK_1);

		}
		janela.getContentPane().add(tabela, BorderLayout.PAGE_START);

	}

}
