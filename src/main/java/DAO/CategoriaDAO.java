/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author LabingXEON
 */
public class CategoriaDAO {
    
        private Connection connection;

    public CategoriaDAO() throws SQLException, URISyntaxException {
        connection = DbUtil.getConnection();
    }
    
      public boolean addCategoria(Categoria categoria) throws SQLException, URISyntaxException {
        boolean result = false;
        Connection connection = DbUtil.getConnection();
        String query = "insert into categoria (id,nombre,ubicacion) values (?,?,?);";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, categoria.getId());
            preparedStmt.setString(2, categoria.getNombre());
            preparedStmt.setString(3, categoria.getUbicacion());
       
            result = preparedStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    
}
