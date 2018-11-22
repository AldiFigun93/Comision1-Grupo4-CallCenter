/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author Aldana
 */
public class Alquiler {
    private int idAlquiler;
    private Persona persona;
    private Inmueble inmueble;
    private java.util.Date fechaInicio;
    private int costo;

    public Alquiler(int idAlquiler, Persona persona, Inmueble inmueble, Date fechaInicio, int costo) {
        this.idAlquiler = idAlquiler;
        this.persona = persona;
        this.inmueble = inmueble;
        this.fechaInicio = fechaInicio;
        this.costo = costo;
    }
    
    public Alquiler(Persona persona, Inmueble inmueble, Date fechaInicio, int costo) {
        this.idAlquiler = -1;
        this.persona = persona;
        this.inmueble = inmueble;
        this.fechaInicio = fechaInicio;
        this.costo = costo;
    }

    Alquiler() {
        this.idAlquiler = -1;
    }

    public int getIdAlquiler() {
        return idAlquiler;
    }

    public void setIdAlquiler(int idAlquiler) {
        this.idAlquiler = idAlquiler;
    }
    
    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Inmueble getInmueble() {
        return inmueble;
    }

    public void setInmueble(Inmueble inmueble) {
        this.inmueble = inmueble;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }
    
}
