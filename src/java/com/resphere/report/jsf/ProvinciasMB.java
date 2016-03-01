/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.resphere.report.jsf;

//import com.resphere.report.ejb.ProvinciaFacade;
import com.resphere.report.ejb.CantonFacadeLocal;
import com.resphere.report.ejb.EventotipoFacadeLocal;
import com.resphere.report.ejb.ProvinciaFacadeLocal;
import com.resphere.report.ejb.VRpteventoFacadeLocal;
import com.resphere.report.model.Canton;
import com.resphere.report.model.Eventotipo;
import com.resphere.report.model.Provincia;
import com.resphere.report.model.VRptevento;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author hp
 */
@ManagedBean
@ViewScoped
public class ProvinciasMB implements Serializable{

    @EJB
    private ProvinciaFacadeLocal provinciaEJB;
    @EJB
    private CantonFacadeLocal cantonEJB;
    @EJB
    private VRpteventoFacadeLocal eventoEJB;
    @EJB
    private EventotipoFacadeLocal eventotipoEJB;
    
    private Provincia provincia;
    private String idprovincia;
    private String idcanton;
    private String ideventotipo;    
    private String idevento;
    private Canton canton;
    private Date finicial;
    private Date ffinal;
    private VRptevento evento;
    private List<Provincia> provincias;
    private List<Canton> cantones;
    private List<VRptevento> eventos;
    private List<Eventotipo> eventotipos; 
    private ArrayList<String> cantonesString;
    
    @PostConstruct
    public void init(){
        FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        provincia = new Provincia();
        idprovincia = "-1";
        idcanton = "-1";
        idevento = "";
        ideventotipo = "-1";
        canton = new Canton();
        provincias = provinciaEJB.findAll();
        eventos = eventoEJB.findAll();
        eventotipos = eventotipoEJB.findAll();
        cantonesString = new ArrayList<>();
        
    }
    
    public void redirectReport(){
        try {
            if(evento!=null){
                /*RequestContext.getCurrentInstance().update("cantones");
                RequestContext.getCurrentInstance().update("provincias");
                RequestContext.getCurrentInstance().update("eventotipo");*/
                idevento = evento.getIdevento();
                ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
                context.redirect(context.getRequestContextPath() + "/REPORTECODIGO.jsp?txtidcliente=" + idevento);
            }else
                Logger.getLogger(ProvinciasMB.class.getName()).log(Level.SEVERE, null, new IOException());
        } catch (IOException ex) {
            Logger.getLogger(ProvinciasMB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void onRowSelect(SelectEvent event){
        try {
            idevento = ((VRptevento) event.getObject()).getIdevento();
            if(evento!=null){
                idevento = evento.getIdevento();
                ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
                context.redirect(context.getRequestContextPath() + "/REPORTECODIGO.jsp?txtidcliente=" + idevento);
            }else
                Logger.getLogger(ProvinciasMB.class.getName()).log(Level.SEVERE, null, new IOException());
        } catch (IOException ex) {
            Logger.getLogger(ProvinciasMB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void clearSearch(){
        idcanton = "-1";
        idprovincia = "-1";
        finicial = null;
        ffinal = null;
        ideventotipo = "-1";
        eventos = eventoEJB.findAll();
        cantonesString = null;
    }
    
    public void searchCanton(AjaxBehaviorEvent event){
        ArrayList<VRptevento> resultados = new ArrayList<>();
        if(!idprovincia.equals("") && !idprovincia.equals("-1")){
            cantones = cantonEJB.findByProvincia(idprovincia); 
            cantonesString = new ArrayList<>();
            for(Canton item: cantones){
                cantonesString.add(item.getCanton());
            }            
            for(VRptevento item: eventos){
                if(item.getProvincia().equals(idprovincia))
                    resultados.add(item);
            }
        }else
            resultados.addAll(eventoEJB.findAll());
        eventos = resultados;
    }

    public void searchCantones(AjaxBehaviorEvent event){
        ArrayList<VRptevento> resultados = new ArrayList<>();
        //resultados.addAll(eventos);
        for(VRptevento item: eventos){
                if(!idcanton.equals("-1")){
                        if(item.getCanton().equals(idcanton))
                            resultados.add(item);
                    }
                else
                    resultados.addAll(eventos);
        }        
        eventos = resultados;
    }
        
    public void searchEventos(AjaxBehaviorEvent event){
        ArrayList<VRptevento> resultados = new ArrayList<>();
        //resultados.addAll(eventos);
        for(VRptevento item: eventos){
                if(!ideventotipo.equals("-1")){
                        if(item.getEvento().equals(ideventotipo))
                            resultados.add(item);
                    }
                else
                    resultados.addAll(eventos);
        }        
        eventos = resultados;
    }
    
    public void onFInicialSelect(SelectEvent event){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        event.getObject();
        SimpleDateFormat format = new SimpleDateFormat("yyyy/M/d");
        String fecha = format.format(event.getObject());
        finicial.toString();
        
        ArrayList<VRptevento> resultados = new ArrayList<>();
        //resultados.addAll(eventos);
        for(VRptevento item: eventos){
                if(finicial!=null){
                    Date fauxiliar = new Date(item.getFecha());
                        if(fauxiliar.compareTo(finicial) >= 0)
                            resultados.add(item);
                    }
                else
                    resultados.addAll(eventos);
        }        
        eventos = resultados;
    }
    
     public void onFFinalSelect(SelectEvent event){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        event.getObject();
        SimpleDateFormat format = new SimpleDateFormat("yyyy/M/d");
        String fecha = format.format(event.getObject());
        ffinal.toString();
        
        ArrayList<VRptevento> resultados = new ArrayList<>();
        //resultados.addAll(eventos);
        for(VRptevento item: eventos){
                if(ffinal!=null){
                    Date fauxiliar = new Date(item.getFecha());
                        if(fauxiliar.compareTo(ffinal) <= 0)
                            resultados.add(item);
                    }
                else
                    resultados.addAll(eventos);
        }        
        eventos = resultados;
    }
    
    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    public List<Provincia> getProvincias() {
        return provincias;
    }

    public void setProvincias(List<Provincia> provincias) {
        this.provincias = provincias;
    }
    
     public List<Canton> getCantones() {
        return cantones;
    }

    public void setCantones(List<Canton> cantones) {
        this.cantones = cantones;
    }

    public Canton getCanton() {
        return canton;
    }

    public void setCanton(Canton canton) {
        this.canton = canton;
    }

    public String getIdprovincia() {
        return idprovincia;
    }

    public void setIdprovincia(String idprovincia) {
        this.idprovincia = idprovincia;
    }

    public List<VRptevento> getEventos() {
        return eventos;
    }

    public void setEventos(List<VRptevento> eventos) {
        this.eventos = eventos;
    }

    public String getIdcanton() {
        return idcanton;
    }

    public void setIdcanton(String idcanton) {
        this.idcanton = idcanton;
    }

    public String getIdevento() {
        return idevento;
    }

    public void setIdevento(String idevento) {
        this.idevento = idevento;
    }

    public VRptevento getEvento() {
        return evento;
    }

    public void setEvento(VRptevento evento) {
        this.evento = evento;
    }

    public List<Eventotipo> getEventotipos() {
        return eventotipos;
    }

    public void setEventotipos(List<Eventotipo> eventotipos) {
        this.eventotipos = eventotipos;
    }

    public String getIdeventotipo() {
        return ideventotipo;
    }

    public void setIdeventotipo(String ideventotipo) {
        this.ideventotipo = ideventotipo;
    }

    public ArrayList<String> getCantonesString() {
        return cantonesString;
    }

    public void setCantonesString(ArrayList<String> cantonesString) {
        this.cantonesString = cantonesString;
    }

    public Date getFinicial() {
        return finicial;
    }

    public void setFinicial(Date finicial) {
        this.finicial = finicial;
    }

    public Date getFfinal() {
        return ffinal;
    }

    public void setFfinal(Date ffinal) {
        this.ffinal = ffinal;
    }
    
    
    
}
