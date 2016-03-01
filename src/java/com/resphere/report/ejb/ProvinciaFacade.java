/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resphere.report.ejb;

import com.resphere.report.model.Provincia;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author hp
 */
@Stateless
public class ProvinciaFacade extends AbstractFacade<Provincia> implements ProvinciaFacadeLocal {
    @PersistenceContext(unitName = "ResphereReportsPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProvinciaFacade() {
        super(Provincia.class);
    }
    
    public List<Provincia> findAll(){
        return super.findAll();
    }
}
