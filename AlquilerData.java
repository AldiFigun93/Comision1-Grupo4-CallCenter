/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aldana
 */
public class AlquilerData {
    private Connection connection = null;

    public AlquilerData(Conexion conexion)
    {
        try 
        {
            connection = conexion.getConexion();
        } 
        catch (SQLException ex)
        {
            System.out.println("Error al obtener conexion");
        }
    }
    
    
    public void guardarAlquiler(Alquiler alquiler)
    {
        try
        {
            
            String sql = "INSERT INTO alquiler (idAlquiler, idPersona, idInmueble, fechaInicio, costo) VALUES ( ? , ? , ? , ? , ? );";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, alquiler.getIdAlquiler());
            statement.setInt(2, alquiler.getPersona().getIdPersona());
            statement.setInt(3, alquiler.getInmueble().getIdInmueble());
            statement.setDate(4, (Date) alquiler.getFechaInicio());
            statement.setInt(5, alquiler.getCosto());
            
            statement.executeUpdate();
            
            statement.close();
    
        }
        catch (SQLException ex) 
        {
            System.out.println("Error al insertar un alquiler: " + ex.getMessage());
        }
    }
    
    public List<Alquiler> obtenerAlquileres()
    {
        List<Alquiler> alquileres = new ArrayList<Alquiler>();
            
        try
        {
            String sql = "SELECT * FROM alquiler;";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            
            Alquiler alquiler;
            
            while(resultSet.next())
            {
                alquiler = new Alquiler();
                alquiler.setIdAlquiler(resultSet.getInt("idAlquiler"));
                
                Persona persona = buscarPersona(resultSet.getInt("idPersona"));
                alquiler.setPersona(persona);
                
                Inmueble inmueble = buscarInmueble(resultSet.getInt("idInmueble"));
                alquiler.setInmueble(inmueble);
                
                alquiler.setFechaInicio(resultSet.getDate("fechaInicio"));
                alquiler.setCosto(resultSet.getInt("costo"));

                alquileres.add(alquiler);
            }      
            statement.close();
        }
        catch (SQLException ex) {
            System.out.println("Error al obtener los alquileres: " + ex.getMessage());
        }
 
        return alquileres;
    }

    public void borrarAlquiler(int id)
    {
        try{
            
            String sql = "DELETE FROM alquiler WHERE idAlquiler =?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);
  
            statement.executeUpdate();                       
            statement.close();
    
        }
        catch (SQLException ex) 
        {
            System.out.println("Error al insertar un alquiler: " + ex.getMessage());
        }       
    }
    
    public void actualizarAlquiler(Alquiler alquiler)
    {
        try 
        {
            
            String sql = "UPDATE alquiler SET idPersona = ?, idInmueble = ? , fechaInicio = ? , costo = ? WHERE idAlquiler = ?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            statement.setInt(1, alquiler.getPersona().getIdPersona());
            statement.setInt(2, alquiler.getInmueble().getIdInmueble());    
            statement.setDate(3, (Date) alquiler.getFechaInicio());
            statement.setInt(4, alquiler.getCosto());
            
            statement.executeUpdate();
            statement.close();
    
        } 
        catch (SQLException ex)
        {
            System.out.println("Error al insertar un alquiler: " + ex.getMessage());
        }
    
    }
    
    public Persona buscarAlquiler(int id)
    {
      Alquiler alquiler=null;
        try
        {
            
            String sql = "SELECT * FROM alquiler WHERE idAlquiler =?;";

            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);
            
            ResultSet resultSet=statement.executeQuery();
            
            while(resultSet.next()){
                alquiler = new Alquiler();
                
                alquiler.setIdAlquiler(resultSet.getInt("idAlquiler"));
                
                Persona persona = buscarPersona(resultSet.getInt("idPersona"));
                alquiler.setPersona(persona);
                
                Inmueble inmueble = buscarInmueble(resultSet.getInt("idInmueble"));
                alquiler.setInmueble(inmueble);
                
                alquiler.setFechaInicio(resultSet.getDate("fechaInicio"));             
                alquiler.setCosto(resultSet.getInt("costo"));
     
            }      
            statement.close();        
        }catch (SQLException ex){
            System.out.println("Error al insertar un alquiler: " + ex.getMessage());
        }
        
        return alquiler;
    }

}
