package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.ConsultasProductos;
import modelo.Producto;
import vista.Inventario;

public class CtrlProducto implements ActionListener {
    
    private Producto mod;
    private ConsultasProductos modC;
    private Inventario frm;
 
    public CtrlProducto(Producto mod, ConsultasProductos modC, Inventario frm){
        
        this.mod=mod;
        this.modC=modC;
        this.frm=frm;
        this.frm.btnGuardar.addActionListener(this);
        this.frm.btnModificar.addActionListener(this);
        this.frm.btnEliminar.addActionListener(this);
        this.frm.btnLimpiar.addActionListener(this);
        this.frm.btnBuscar.addActionListener(this);
    }
    
    public void iniciar(){
        frm.setTitle("Inventario Supermercado");
        frm.setLocationRelativeTo(null);
        frm.txtId.setVisible(false);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==frm.btnGuardar){
            mod.setCodigo(frm.txtCodigo.getText());
            mod.setNombre(frm.txtNombre.getText());
            mod.setPrecio(Integer.parseInt(frm.txtPrecio.getText()));
            mod.setCantidad(Integer.parseInt(frm.txtCantidad.getText()));
            
            if(modC.registrar(mod)){
                JOptionPane.showMessageDialog(null, "Registro Exitoso");
                Limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Error al guardar");
                Limpiar();
            }
        }
        if(e.getSource()==frm.btnModificar){
            mod.setId_producto(Integer.parseInt(frm.txtId.getText()));
            mod.setCodigo(frm.txtCodigo.getText());
            mod.setNombre(frm.txtNombre.getText());
            mod.setPrecio(Integer.parseInt(frm.txtPrecio.getText()));
            mod.setCantidad(Integer.parseInt(frm.txtCantidad.getText()));
            
            if(modC.modificar(mod)){
                JOptionPane.showMessageDialog(null, "Registro modificado");
                Limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Error al modificar");
                Limpiar();
            }
        }
        if(e.getSource()==frm.btnEliminar){
            mod.setId_producto(Integer.parseInt(frm.txtId.getText()));
            
            if(modC.eliminar(mod)){
                JOptionPane.showMessageDialog(null, "Registro eliminado");
                Limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Error al eliminar");
                Limpiar();
            }
        }
        if(e.getSource()==frm.btnBuscar){
            mod.setCodigo(frm.txtCodigo.getText());
            
            if(modC.buscar(mod)){
                
                frm.txtId.setText(String.valueOf(mod.getId_producto()));
                frm.txtCodigo.setText(mod.getCodigo());
                frm.txtNombre.setText(mod.getNombre());
                frm.txtPrecio.setText(String.valueOf(mod.getPrecio()));
                frm.txtCantidad.setText(String.valueOf(mod.getCantidad()));
            }else{
                JOptionPane.showMessageDialog(null, "No se encontro registro");
                Limpiar();
            }
        }
        if(e.getSource()==frm.btnLimpiar){
            Limpiar();
        }
    }
    public void Limpiar(){
        frm.txtId.setText(null);
        frm.txtCodigo.setText(null);
        frm.txtNombre.setText(null);
        frm.txtPrecio.setText(null);
        frm.txtCantidad.setText(null);  
    }
}