import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

public class Main {
    public static void main(String[] args) {

        String URL = "jdbc:mysql:// sql10.freemysqlhosting.net:3306/sql10720954";
        String USER = "sql10720954";
        String PASSWORD = "LtqHn5Canf";
        Connection conexion = null;
        PreparedStatement pstmt = null;

        try {

            //establecer conexion
            conexion = DriverManager.getConnection(URL,USER,PASSWORD);
            //preparar la sentencia sql
            String sql = "UPDATE estudiante SET bimestreUno= ? WHERE cedula=?";
            pstmt = conexion.prepareStatement(sql);

            //seteamos los valores de la sentencia previa
            pstmt.setInt(1, 7); //en esta linea se hara la modificicacion que se mostrara en sql, tu modificas.
            pstmt.setString(2, "1736635219"); // aqui es donde tu pondras a quien quieres modificar

            //imprimir el enunciado
            System.out.println(sql);
            int result=pstmt.executeUpdate();
            System.out.println("Se actualizo "+result+" filas");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try{
                //cerrando la conexion
                if(pstmt != null){
                    pstmt.close();
                }
                if (conexion != null){
                    conexion.close();
                }
            }catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
