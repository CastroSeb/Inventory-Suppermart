package inventario_supermercado;

import controlador.CtrlProducto;
import modelo.ConsultasProductos;
import modelo.Producto;
import vista.Inventario;

public class Inventario_supermercado {

    public static void main(String[] args) {
        Producto mod=new Producto();
        ConsultasProductos modC= new ConsultasProductos();
        Inventario frm = new Inventario();
        
        CtrlProducto ctrl= new CtrlProducto(mod,modC,frm);
        ctrl.iniciar();
        frm.setVisible(true);
    }  
}