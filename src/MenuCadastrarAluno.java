
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.text.MaskFormatter;

public class MenuCadastrarAluno {

	// private static final String TamanhoFixoText = null;
	static Aluno alunoNovo;
	private static JFrame janela;
	private static JTextField JTFnome;
	private static JLabel JLnome, JLmatricula;
	private static JButton confirmar;
	private static MaskFormatter mascaraMatricula;
	public static void apresentarGUICadastrarAluno(Aluno aluno) {

		janela = new JFrame("Cadastro de alunos");
		// janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JTFnome = new JTextField();
		new JTextField();

		try {
			mascaraMatricula = new MaskFormatter("##/#######");

		} catch (ParseException exp) {
			exp.printStackTrace();
			mascaraMatricula.setPlaceholderCharacter('_');

		}
		JFormattedTextField matriculaF = new JFormattedTextField(mascaraMatricula);

		JLnome = new JLabel("Nome:");
		// JLnome.setHorizontalTextPosition(SwingConstants.CENTER);
		// JLnome.setHorizontalTextPosition(SwingConstants.TOP);
		JLmatricula = new JLabel("Matricula:");

		confirmar = new JButton("cadastrar");

		janela.getContentPane().add(JLnome);
		janela.getContentPane().add(JTFnome);
		janela.getContentPane().add(JLmatricula);
		janela.getContentPane().add(matriculaF);
		janela.getContentPane().add(confirmar);

		janela.setMinimumSize(new Dimension(200, 300));
		// janela.setLayout(new GridLayout(6, 2, 3, 3));
		janela.setLayout(new GridLayout(6, 2, 3, 3));
		
		Rectangle r = new Rectangle(200,20);
		JTFnome.setBounds(r);

		confirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String nome = JTFnome.getText();
				String matricula = matriculaF.getText();
				
				UIManager.put("OptionPane.yesButtonText", "Confirmar cadastro");
				UIManager.put("OptionPane.noButtonText", "Alterar dados");

				String message = "Aluno :"+nome+" \nMatriculla : "+matricula+"\nConfirmar dados cadastrados?";

				int op = JOptionPane.showConfirmDialog(null, message, "Confirmação", JOptionPane.YES_NO_OPTION);

				if (op == JOptionPane.YES_OPTION) {
					alunoNovo = new Aluno();
					alunoNovo.setNome(nome);
					alunoNovo.setMatricula(matricula);
					if (!alunoNovo.getError()) {
						Aluno.cadastrar(alunoNovo);
						janela.dispose();
					}

				} else if (op == JOptionPane.NO_OPTION) {

		
				}

			}
		});

		janela.pack();
		janela.setVisible(true);

	}

}
