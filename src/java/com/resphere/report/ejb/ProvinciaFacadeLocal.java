/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resphere.report.ejb;

import com.resphere.report.model.Provincia;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author hp
 */
@Local
public interface ProvinciaFacadeLocal {

    void create(Provincia provincia);

    void edit(Provincia provincia);

    void remove(Provincia provincia);

    Provincia find(Object id);

    List<Provincia> findAll();

    List<Provincia> findRange(int[] range);

    int count();
    
}
