/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.especialistajee.spring.datos;

import java.util.Date;
import java.util.List;

import org.especialistajee.Coche;

/**
 *
 * @author especialista
 */
public interface ICocheDAO {
    public void crear(Coche coche);
    public void actualizar(Coche coche);
    public List<Coche> listar();
    public List<Coche> listarPosterioresA(Date fecha);
    public Coche obtener(String matricula);
}
