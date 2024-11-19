package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class ConsultasProductos extends Conexion {
    
    public boolean registrar(Producto pro){
        PreparedStatement ps = null;
        Connection con= getConexion();
        
        String sql="INSERT INTO Producto (codigo,nombre,precio,cantidad) VALUES (?,?,?,?)";
        
        try{
            ps=con.prepareStatement(sql);
            ps.setString(1, pro.getCodigo());
            ps.setString(2, pro.getNombre());
            ps.setInt(3, pro.getPrecio());
            ps.setInt(4, pro.getCantidad());
            ps.execute();
            return true;
        }catch(SQLException e){
            System.err.println(e);
            return false;
        }finally{
            try{
                con.close();
            }catch(SQLException e){
            System.err.println(e);
            }
        }
    }
    public boolean modificar(Producto pro){
        PreparedStatement ps = null;
        Connection con= getConexion();
        
        String sql="UPDATE Producto SET codigo=?, nombre=?, precio=?, cantidad=? WHERE id_producto=?";
        
        try{
            ps=con.prepareStatement(sql);
            ps.setString(1, pro.getCodigo());
            ps.setString(2, pro.getNombre());
            ps.setInt(3, pro.getPrecio());
            ps.setInt(4, pro.getCantidad());
            ps.setInt(5, pro.getId_producto());
            ps.execute();
            return true;
        }catch(SQLException e){
            System.err.println(e);
            return false;
        }finally{
            try{
                con.close();
            }catch(SQLException e){
            System.err.println(e);
            }
        }
    }
    public boolean eliminar(Producto pro){
        PreparedStatement ps = null;
        Connection con= getConexion();
        
        String sql="DELETE FROM Producto WHERE id_producto=?";
        
        try{
            ps=con.prepareStatement(sql);
            ps.setInt(1, pro.getId_producto());
            ps.execute();
            return true;
        }catch(SQLException e){
            System.err.println(e);
            return false;
        }finally{
            try{
                con.close();
            }catch(SQLException e){
            System.err.println(e);
            }
        }
    }
    public boolean buscar(Producto pro ){
        PreparedStatement ps = null;
        ResultSet res = null;
        Connection con= getConexion();
        
        String sql="SELECT * FROM Producto WHERE codigo=?";
        
        try{
            ps=con.prepareStatement(sql);
            ps.setString(1, pro.getCodigo());
            res = ps.executeQuery();
            
            if(res.next()){
                pro.setId_producto(Integer.parseInt(res.getString("id_producto")));
                pro.setCodigo(res.getString("codigo"));
                pro.setNombre(res.getString("nombre"));
                pro.setPrecio(Integer.parseInt(res.getString("precio")));
                pro.setCantidad(Integer.parseInt(res.getString("cantidad")));
                return true;
            }
            return false;
        }catch(SQLException e){ 
            System.err.println(e);
            return false;
        }finally{
            try{
                con.close();
            }catch(SQLException e){
            System.err.println(e);
            }
        }
    }
}