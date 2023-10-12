/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.uv.tpcs_practica03;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.SessionFactory;

/**
 *
 * @author juan
 */
public class TPCS_Practica03 {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        //SessionFactory s=HibernateUtil.getSessionFactory();
        /*Producto p=new Producto();
        p.setDescripcion("Producto1");
        p.setExistencia(10);
        p.setPrecio(10);
        p.setCosto(7.5F);
        long id=0;
        DAOProducto daop=new DAOProducto();
        p=daop.create(p);
        System.out.print("Id del producto registrado: "+p.getProductoId());
        List<Producto>list=daop.findAll();
        for(Producto producto:list){
            System.out.println(producto.getProductoId());
            id=producto.getProductoId();
        }
        
        boolean pase=daop.delete(id);
        if(pase){
            System.out.println("Producto eliminado con exito");
        }else{rfc
            System.out.println("Producto no encontrado");
        }*/
        
        //Creamos los DAO a utilizar
        DAOCliente daoCliente=new DAOCliente();
        DAOProducto daoProducto=new DAOProducto();
        DAOVenta daoVenta=new DAOVenta();
        
        //Primero creamos un cliente
        Cliente cliente=new Cliente();
        cliente.setNombre("David");
        cliente.setRfc("DEMJ0112177G9");
        //daoCliente.create(cliente);
        System.out.println("Cliente Registrado con exito: "+cliente.getClienteId());
        
        //Creamos varios productos
        Producto p1=new Producto();
        p1.setDescripcion("Producto1");
        p1.setCosto(10);
        p1.setPrecio(12.5F);
        p1.setExistencia(20);
        //daoProducto.create(p1);
        
        Producto p2=new Producto();
        p2.setDescripcion("Producto2");
        p2.setCosto(5);
        p2.setPrecio(10F);
        p2.setExistencia(20);
        //daoProducto.create(p2);
        
        Producto p3=new Producto();
        p3.setDescripcion("Producto3");
        p3.setCosto(16);
        p3.setPrecio(22.5F);
        p3.setExistencia(20);
        //daoProducto.create(p3);
        
        //Ahora vamos a crear un detalle que sera añadido a la venta
        DetVenta detalle1=new DetVenta();
        detalle1.setProducto(daoProducto.findByID(3L));
        detalle1.setCantidad(2);
        detalle1.setDescripcion(detalle1.getProducto().getDescripcion());
        detalle1.setPrecio(detalle1.getProducto().getPrecio());
        List<DetVenta>detalles=new ArrayList<>();
        detalles.add(detalle1);
        
        Venta venta=new Venta();
        venta.setCliente(daoCliente.findByID(1L));
        venta.setDetalles(detalles);
        Date fecha=new Date();
        java.sql.Date sqlDate = new java.sql.Date(fecha.getTime()); 
        venta.setFecha(sqlDate);
        
        //ahora guardamos la venta
        venta=daoVenta.create(venta);
        
        
        //Vamos a actualizarla
        DetVenta detalle2=new DetVenta();
        detalle2.setProducto(daoProducto.findByID(3L));
        detalle2.setCantidad(2);
        detalle2.setDescripcion(detalle2.getProducto().getDescripcion());
        detalle2.setPrecio(detalle2.getProducto().getPrecio());
        detalles.add(detalle2);
        
        //venta=daoVenta.findByID(1L);
        //detalle1.setVenta(venta);
        //detalle2.setVenta(venta);
        //detalles.add(detalle1);
        //detalles.add(detalle2);
        //venta.setDetalles(detalles);
        
        //venta.setDetalles(detalles);
        
        //daoVenta.update(venta, 1L);
        //daoVenta.delete(2L);
        
       //System.out.println(daoVenta.delete(5L));
        
    }
}
