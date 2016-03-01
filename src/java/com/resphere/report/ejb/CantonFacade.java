/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resphere.report.ejb;

import com.resphere.report.model.Canton;
import com.resphere.report.model.CantonPK;
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
public class CantonFacade extends AbstractFacade<Canton> implements CantonFacadeLocal {
    @PersistenceContext(unitName = "ResphereReportsPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CantonFacade() {
        super(Canton.class);
    }
    
    public List<Canton> findByProvincia(String idprovincia){
        try{  
            Provincia provincia = (Provincia)em.createNamedQuery("Provincia.findByProvincia").setParameter("provincia", idprovincia).getSingleResult();            
            List<Canton> cantones = em.createNamedQuery("Canton.findByIdprovincia").setParameter("idprovincia", provincia.getIdprovincia()).getResultList();
            return cantones;  
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
    public List<Canton> findAll(){
        return super.findAll();
    }
}
