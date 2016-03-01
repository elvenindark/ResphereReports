/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resphere.report.ejb;

import com.resphere.report.model.Eventotipo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author hp
 */
@Local
public interface EventotipoFacadeLocal {

    void create(Eventotipo eventotipo);

    void edit(Eventotipo eventotipo);

    void remove(Eventotipo eventotipo);

    Eventotipo find(Object id);

    List<Eventotipo> findAll();

    List<Eventotipo> findRange(int[] range);

    int count();
    
}
