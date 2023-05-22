/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jose.dao;

import com.jose.config.Conexion;
import com.jose.model.Mueble;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;


public class MuebleDAOImpl implements MuebleDAO {

    private Conexion objConexion;
private Connection objConnection;

public MuebleDAOImpl() {
    objConexion = new Conexion();
}

@Override
public List<Mueble> findAll() {
    String consulta = "SELECT * FROM muebles";
    List<Mueble> listado = new LinkedList<>();

    try {
        this.objConexion.conectar();
        this.objConnection = this.objConexion.getJdbcConnection();

        PreparedStatement prest = this.objConnection.prepareStatement(consulta);
        ResultSet rs = prest.executeQuery();

        Mueble objMueble;

        while (rs.next()) {
            objMueble = new Mueble();
            objMueble.setId(rs.getInt("id"));
            objMueble.setNombre(rs.getString("nombre"));
            objMueble.setColor(rs.getString("color"));
            objMueble.setDiseno(rs.getString("diseno"));
            objMueble.setPrecio(rs.getString("precio"));

            listado.add(objMueble);
        }

    } catch (Exception e) {
        System.out.println("Error en la consulta");
    }
    return listado;
}

@Override
public Mueble insert(Mueble objMueble) {
    String consulta = "INSERT INTO muebles (nombre, color, diseno, precio) VALUES (?,?,?,?)";
    try{
        this.objConexion.conectar();
        this.objConnection = this.objConexion.getJdbcConnection();

        PreparedStatement prest = this.objConnection.prepareStatement(consulta);
        prest.setString(1, objMueble.getNombre());
        prest.setString(2, objMueble.getColor());
        prest.setString(3, objMueble.getDiseno());
        prest.setString(4, objMueble.getPrecio());

        int count = prest.executeUpdate();

        ResultSet rs = null;
        rs = prest.executeQuery("SELECT LAST_INSERT_ID()");

        int autoKey = -1;
        if(rs.next()){
            autoKey = rs.getInt(1);
            objMueble.setId(autoKey);
            System.out.println("Último ID introducido: " + autoKey);
        }else{
            System.out.println("No existe dato de ID");
        }
    }catch(Exception e){
        System.out.println("Error al insertar");
    }
    return objMueble;
}

@Override
public Mueble findById(Integer id) {
    throw new UnsupportedOperationException("Not supported yet.");
}

@Override
public Mueble updateById(Integer id, Mueble objMueble) {
    throw new UnsupportedOperationException("Not supported yet.");
}

@Override
public Boolean deleteById(Integer id) {
    throw new UnsupportedOperationException("Not supported yet.");
}
}

