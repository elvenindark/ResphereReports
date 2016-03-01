/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resphere.report.jsf;

//import com.resphere.report.ejb.VRpteventoFacade;
import com.resphere.report.ejb.VRpteventoFacadeLocal;
import com.resphere.report.model.VRptevento;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author hp
 */
@ManagedBean
@SessionScoped
public class VRpteventoMB implements Serializable{

    @EJB
    private VRpteventoFacadeLocal eventoEJB;
    private VRptevento evento;
    private List<VRptevento> eventos;
    
    @PostConstruct  
    public void init(){
        evento = new VRptevento();
    }    
    //public List<VRptevento> searchEventos(String provincia, String canton, String fecha, String evento){
    public List<VRptevento> searchEventos(){
        try{
            return eventoEJB.findAll();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }        
    }

    public VRptevento getEvento() {
        return evento;
    }

    public void setEvento(VRptevento evento) {
        this.evento = evento;
    }

    public List<VRptevento> getEventos() {
        return eventos;
    }

    public void setEventos(List<VRptevento> eventos) {
        this.eventos = eventos;
    }
   
    
}
