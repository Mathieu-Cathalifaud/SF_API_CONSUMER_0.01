/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.mc.app.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Mathieu
 */
@ManagedBean
@ViewScoped
public class SessionInitializerBean {

    private String environment_id;
    
    public void submit() {
        // Add uniq id on each environment
    }
}
