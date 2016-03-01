/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resphere.report.ejb;

import com.resphere.report.model.VRptevento;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author hp
 */
@Local
public interface VRpteventoFacadeLocal {

    void create(VRptevento vRptevento);

    void edit(VRptevento vRptevento);

    void remove(VRptevento vRptevento);

    VRptevento find(Object id);

    List<VRptevento> findAll();

    List<VRptevento> findRange(int[] range);

    int count();
    
}
