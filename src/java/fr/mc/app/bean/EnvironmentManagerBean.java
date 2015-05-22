/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.mc.app.bean;

import fr.mc.app.tool.Environment;
import fr.mc.app.tool.EnvironmentParser;
import java.util.ArrayList;
import java.util.Collection;
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

    private ArrayList<Environment> environments = null;

    public EnvironmentManagerBean() {
        EnvironmentParser environmentParser = new EnvironmentParser();
        environments = environmentParser.getEnvironments();
    }

    public ArrayList<Environment> getEnvironments() {
        System.out.println("### environments : " + environments);
        return environments;
    }
}
