/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.tpcs_practica03;

import java.sql.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
/**
 *
 * @author juan
 */
@Entity
@Table(name="venta")
public class Venta {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="venta_id")
    private long ventaId;
    
    @Column
    private Date fecha;
    
    @ManyToOne()
    @JoinColumn(name="cliente_id")
    private Cliente cliente;
    
    @OneToMany(mappedBy="venta", cascade={CascadeType.REMOVE, CascadeType.MERGE}, /*orphanRemoval=true,*/ fetch=FetchType.EAGER)
    private List<DetVenta> detalles;

    @Column
    private float total;
    
    public long getVentaId() {
        return ventaId;
    }

    public void setVentaId(long ventaId) {
        this.ventaId = ventaId;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<DetVenta> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetVenta> detalles) {
        this.detalles = detalles;
        this.total=0;
        for(DetVenta detalle:detalles){
            this.total+=detalle.getPrecio()*detalle.getCantidad();
        }
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
    
    
    
    
}
