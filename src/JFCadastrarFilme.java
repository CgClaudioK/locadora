import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.bean.Filme;
import model.dao.FilmeDAO;
import model.dao.FilmeDAO;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFCadastrarFilme extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTitulo;
	private JTextField txtCategoria;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFCadastrarFilme frame = new JFCadastrarFilme();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFCadastrarFilme() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 561, 367);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CADASTRO DE FILMES: LOCADORA");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 11, 271, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("T\u00CDTULO");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(10, 40, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		txtTitulo = new JTextField();
		txtTitulo.setBounds(10, 65, 416, 20);
		contentPane.add(txtTitulo);
		txtTitulo.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("CATEGORIA");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(10, 91, 82, 14);
		contentPane.add(lblNewLabel_2);
		
		txtCategoria = new JTextField();
		txtCategoria.setBounds(10, 116, 416, 20);
		contentPane.add(txtCategoria);
		txtCategoria.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("TEMPO");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(10, 159, 65, 14);
		contentPane.add(lblNewLabel_3);
		
		JSpinner spTempo = new JSpinner();
		spTempo.setBounds(10, 184, 82, 20);
		contentPane.add(spTempo);
		
		JLabel lblNewLabel_4 = new JLabel("IMAGEM");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(158, 159, 65, 14);
		contentPane.add(lblNewLabel_4);
		
		JRadioButton rdbtn3D = new JRadioButton("3D");
		rdbtn3D.setBounds(186, 183, 46, 23);
		contentPane.add(rdbtn3D);
		
		JRadioButton rdbtn2D = new JRadioButton("2D");
		rdbtn2D.setBounds(137, 183, 47, 23);
		contentPane.add(rdbtn2D);
		
		ButtonGroup imagem = new ButtonGroup();
		imagem.add(rdbtn3D);
		imagem.add(rdbtn2D);
		
		JLabel lblNewLabel_5 = new JLabel("\u00C1UDIO");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(284, 159, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		JRadioButton rdbtnDUBLADO = new JRadioButton("DUBLADO");
		rdbtnDUBLADO.setBounds(407, 183, 96, 23);
		contentPane.add(rdbtnDUBLADO);
		
		JRadioButton rdbtnLEGENDADO = new JRadioButton("LEGENDADO");
		rdbtnLEGENDADO.setBounds(268, 183, 116, 23);
		contentPane.add(rdbtnLEGENDADO);
		
		ButtonGroup audio = new ButtonGroup();
		audio.add(rdbtnDUBLADO);
		audio.add(rdbtnLEGENDADO);
		
		JButton btnCADASTRAR = new JButton("CADASTRAR");
		btnCADASTRAR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Filme f = new Filme();
				FilmeDAO dao = new FilmeDAO();
				f.setTitulo(txtTitulo.getText());
				f.setCategoria(txtCategoria.getText());
				f.setTempo(Integer.parseInt(spTempo.getValue().toString()));
				if(rdbtn2D.isSelected()) {
					f.setImg3d(false);
				}else if (rdbtn3D.isSelected()) {
					f.setImg3d(true);
				}
				if(rdbtnDUBLADO.isSelected()) {
					f.setDublado(true);
				}else if (rdbtnLEGENDADO.isSelected()) {
					f.setDublado(false);
				}
				dao.create(f);
			}
			
		});
		btnCADASTRAR.setBounds(10, 273, 109, 23);
		contentPane.add(btnCADASTRAR);
		
		JButton btnLIMPAR = new JButton("LIMPAR");
		btnLIMPAR.setBounds(158, 273, 89, 23);
		contentPane.add(btnLIMPAR);
		
		JButton btnCANCELAR = new JButton("CANCELAR");
		btnCANCELAR.setBounds(337, 273, 116, 23);
		contentPane.add(btnCANCELAR);
	}
}
