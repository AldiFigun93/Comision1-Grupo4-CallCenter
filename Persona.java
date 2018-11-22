/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Aldana
 */
public class Persona {
    private int idPersona;
    private String nombreCompleto;
    private int dni;
    private int celular;

    public Persona(int idPersona, String nombreCompleto, int dni, int celular) {
        this.idPersona = idPersona;
        this.nombreCompleto = nombreCompleto;
        this.dni = dni;
        this.celular = celular;
    }
    
    public Persona(String nombreCompleto, int dni, int celular) {
        this.idPersona = -1;
        this.nombreCompleto = nombreCompleto;
        this.dni = dni;
        this.celular = celular;
    }

    Persona() {
        this.idPersona = -1;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }
    
}
