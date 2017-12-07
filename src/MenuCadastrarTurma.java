
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;




public class MenuCadastrarTurma {
	
	static Turma turmaNova ;
	private static JFrame janela;
	private static JTextField JTFDisciplina;
	private static JTextField JTFVagas;
	private static JLabel JLDisciplina;
	private static JLabel JL;
	private static JButton cadastrar;
	
public static void apresentarGUICadastrarTurma (Turma turma){
		
		janela = new JFrame("Cadastro de Turmas");
		JLDisciplina = new JLabel("Nome:");
		JTFDisciplina = new JTextField();
		JL = new JLabel("Numero de vagas:");
		JTFVagas = new JTextField();
		cadastrar = new JButton("cadastrar");

		//janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						
		
		janela.getContentPane().add(JLDisciplina);
		janela.getContentPane().add(JTFDisciplina);
		janela.getContentPane().add(JL);
		janela.getContentPane().add(JTFVagas);
		JL = new JLabel();
		janela.getContentPane().add(JL);
		janela.getContentPane().add(JL);
		janela.getContentPane().add(cadastrar);
		
		janela.setMinimumSize(new Dimension(200, 300));
		janela.setLayout(new GridLayout(0, 1, 3, 3));
		
		cadastrar.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String nome = JTFDisciplina.getText();
            	int vaga = Integer.parseInt(JTFVagas.getText());
            	
            	turmaNova = new Turma();
            	turmaNova.setDisciplina(nome);
            	turmaNova.setVagas(vaga);
            	turmaNova.setAval(new Avaliacao());
            	turma.cadastrar(turmaNova);
            
            	janela.dispose();
            }
		});
		
		
		janela.pack();
		janela.setVisible(true);
		
	
		
	}

}
