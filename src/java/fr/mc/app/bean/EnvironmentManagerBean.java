/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.mc.app.bean;

import fr.mc.app.tool.Environment;
import fr.mc.app.tool.EnvironmentParser;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Mathieu
 */
@ManagedBean
@ViewScoped
public class EnvironmentManagerBean {

    private List<Environment> environments = null; 
    private String test = "Coucou";
    
    public EnvironmentManagerBean() {
        System.out.println("### 1HERE");
        EnvironmentParser environmentParser = new EnvironmentParser();
        System.out.println("### 2HERE");
        environments = environmentParser.getEnvironments();
        System.out.println("### 3HERE");
    }
    
    public List<Environment> getEnvironments() {
        System.out.println("### environments : " + environments);
        return environments;
    }
    
    public String getTest() {
        return test;
    }
}