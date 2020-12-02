package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.bean.Cliente;
import model.dao.ClienteDAO;

import javax.swing.JButton;

public class JFListarClientes extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable jtCliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFListarClientes frame = new JFListarClientes();
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
	public JFListarClientes() {
		setTitle("Listar Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 803, 525);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Listar Clientes");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 11, 188, 38);
		contentPane.add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 60, 723, 332);
		contentPane.add(scrollPane);

		jtCliente = new JTable();
		jtCliente.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"nome", "endereco", "cpf", "sexo"
			}
		));
		scrollPane.setViewportView(jtCliente);

		JButton btnCadastrar = new JButton("Cadastrar Cliente");
		btnCadastrar.setBounds(20, 434, 125, 23);
		contentPane.add(btnCadastrar);

		JButton btnAlterar = new JButton("Alterar Cliente");
		btnAlterar.setBounds(176, 434, 111, 23);
		contentPane.add(btnAlterar);

		JButton btnExcluir = new JButton("Excluir Cliente");
		btnExcluir.setBounds(321, 434, 117, 23);
		contentPane.add(btnExcluir);

		readJTable();
	}

	public void readJTable() {
		DefaultTableModel modelo = (DefaultTableModel) jtCliente.getModel();
		modelo.setNumRows(0);
		ClienteDAO cdao = new ClienteDAO();
		for(Cliente c : cdao.read()) {
			modelo.addRow(new Object[] {
					c.getNome(),
					c.getEndereco(),
					c.getCpf(),
					c.isSexo()
			});
		}

	}


}