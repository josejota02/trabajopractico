/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jose.dao;

import com.jose.model.Mueble;
import java.util.List;


public interface MuebleDAO {
    // Método que devuelve el listado de objetos
public List<Mueble> findAll();
// Método que inserta un objeto en la BBDD
public Mueble insert(Mueble objMueble);
// Método que devuelve un objeto en base a su ID
public Mueble findById(Integer id);
// Método que modifica un objeto en la BBDD en base a su ID
public Mueble updateById(Integer id, Mueble objMueble);
// Método que elimina un objeto en la BBDD en base a su ID
public Boolean deleteById(Integer id);
}
