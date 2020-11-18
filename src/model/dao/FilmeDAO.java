package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import connection.ConnectionFactory;
import model.bean.Filme;

public class FilmeDAO {
	public void create(Filme f	) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
	try { 
		stmt = con.prepareStatement("INSERT INTO FILME(titulo, categoria, tempo, img3d, dublado) VALUES" + "(?,?,?,?,?)");
		
		stmt.setString(1, f.getTitulo());	
		stmt.setString(2, f.getCategoria());
		stmt.setInt(3, f.getTempo());
		stmt.setBoolean(4, f.isImg3d());
		stmt.setBoolean(5, f.isDublado());
		
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Filme Salvo com sucesso!");
		} catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar: "+ e);
		}finally{
			ConnectionFactory.closeConnection(con, stmt);		
	
		}
	
	}
}
