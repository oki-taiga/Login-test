package jp.co.afroce.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jp.co.afroce.beans.Bean;

public class LoginDAO extends DAO {
	Bean b = new Bean();
	public Bean search(String id,String pass)throws Exception{
		Connection con=getConnection();

		PreparedStatement st=con.prepareStatement("SELECT * FROM login WHERE ID=? and PASS=?");

		st.setString(1, id);
		st.setString(2, pass);

		ResultSet rs=st.executeQuery();

		while(rs.next()) {
			b.setLoginId(rs.getString("ID"));
			b.setLoginPass(rs.getString("PASS"));
		}

		st.close();
		con.close();

		return b;

	}
}
