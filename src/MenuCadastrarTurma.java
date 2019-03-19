
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import exceptionpac.BlankException;
import exceptionpac.WrongFormatException;




public class MenuCadastrarTurma {
	
	private static Turma turmaNova ;
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
            	boolean a = false;
            	String nome = JTFDisciplina.getText();
            	int vaga = 0;
            	if(nome.equals("")) {
            		try {
            			throw new BlankException("O nome não pode ser em branco!");
            		}catch(BlankException er) {
        				JOptionPane.showMessageDialog(null, "Nome em branco nao e permitido. Insira o nome novamente.",
        						"ATENCAO", JOptionPane.ERROR_MESSAGE);
        				a = true;
            			er.printStackTrace();
            		}
            	}else {
	            	try {
	            		vaga = Integer.parseInt(JTFVagas.getText());
	            	}catch(NumberFormatException er) {
	    				JOptionPane.showMessageDialog(null, "Deve ser informado um numero valido de vagas. Tente novamente.",
	    						"ATENCAO", JOptionPane.ERROR_MESSAGE);
	    				a = true;
	        			er.printStackTrace();
	            	}
	            	if(vaga < 0) {
	            		try {
	            			throw new WrongFormatException("Valor Invalido");
	            		}catch(WrongFormatException er) {
	            			JOptionPane.showMessageDialog(null, "Deve ser informado um numero valido de vagas. Tente novamente.",
		    						"ATENCAO", JOptionPane.ERROR_MESSAGE);
	        				a = true;
	            			er.printStackTrace();
	            		}
	            	}
            	}

            	if(a == false) {
	            	turmaNova = new Turma();
	            	turmaNova.setDisciplina(nome);
	            	turmaNova.setVagas(vaga);
	            	turmaNova.setAval(new Avaliacao());
	            	turma.cadastrar(turmaNova);
	            	janela.dispose();
	            }
            	a = false;
            }
		});
		
		
		janela.pack();
		janela.setVisible(true);
		
	
		
	}

}
