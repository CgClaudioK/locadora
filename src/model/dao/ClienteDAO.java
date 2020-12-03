package model.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import connection.ConnectionFactory;
import model.bean.Cliente;



public class ClienteDAO {
	public void create(Cliente c	) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
	try { 
		stmt = con.prepareStatement("INSERT INTO CLIENTE(nome, endereco, cpf, sexo) VALUES" + "(?,?,?,?)");
		
		stmt.setString(1, c.getNome());		
		stmt.setString(2, c.getEndereco());
		stmt.setLong(3, c.getCpf());
		stmt.setBoolean(4, c.isSexo());
		
		
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Cliente Salvo com sucesso!");
		} catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar: "+ e);
		}finally{
			ConnectionFactory.closeConnection(con, stmt);		
	
		}
	
	}
	public List<Cliente> read(){
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Cliente> clientes = new ArrayList<>();
		
		try {
			stmt = con.prepareStatement("SELECT * FROM CLIENTE;");
			rs = stmt.executeQuery();	
			while (rs.next()) {
				Cliente c = new Cliente();
				c.setIdCliente(rs.getInt("idCliente"));
				c.setNome(rs.getString("nome"));
				c.setEndereco(rs.getString("endereco"));
				c.setCpf(rs.getLong("cpf"));
				c.setSexo(rs.getBoolean("sexo"));
		
					clientes.add(c);
			}
		} catch (SQLException e	) {
			JOptionPane.showMessageDialog(null, "Erro ao acessar o BD" + e);
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);		
	
		}
		return clientes;
	}
}

