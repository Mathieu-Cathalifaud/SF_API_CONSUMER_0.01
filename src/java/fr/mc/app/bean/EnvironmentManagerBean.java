/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.mc.app.bean;

import fr.mc.app.tool.EnvironmentParser;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Mathieu
 */
@ManagedBean
@ViewScoped
public class EnvironmentManagerBean {

    public EnvironmentManagerBean() {
        EnvironmentParser environmentParser = new EnvironmentParser();
    }
}
