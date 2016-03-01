/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resphere.report.controller;

import com.resphere.report.controller.exceptions.NonexistentEntityException;
import com.resphere.report.controller.exceptions.PreexistingEntityException;
import com.resphere.report.controller.exceptions.RollbackFailureException;
import com.resphere.report.model.VRptevento;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.UserTransaction;

/**
 *
 * @author hp
 */
public class VRpteventoJpaController implements Serializable {

    public VRpteventoJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(VRptevento VRptevento) throws PreexistingEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            em.persist(VRptevento);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findVRptevento(VRptevento.getIdevento()) != null) {
                throw new PreexistingEntityException("VRptevento " + VRptevento + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(VRptevento VRptevento) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            VRptevento = em.merge(VRptevento);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = VRptevento.getIdevento();
                if (findVRptevento(id) == null) {
                    throw new NonexistentEntityException("The vRptevento with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            VRptevento VRptevento;
            try {
                VRptevento = em.getReference(VRptevento.class, id);
                VRptevento.getIdevento();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The VRptevento with id " + id + " no longer exists.", enfe);
            }
            em.remove(VRptevento);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<VRptevento> findVRpteventoEntities() {
        return findVRpteventoEntities(true, -1, -1);
    }

    public List<VRptevento> findVRpteventoEntities(int maxResults, int firstResult) {
        return findVRpteventoEntities(false, maxResults, firstResult);
    }

    private List<VRptevento> findVRpteventoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(VRptevento.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public VRptevento findVRptevento(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(VRptevento.class, id);
        } finally {
            em.close();
        }
    }

    public int getVRpteventoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<VRptevento> rt = cq.from(VRptevento.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
