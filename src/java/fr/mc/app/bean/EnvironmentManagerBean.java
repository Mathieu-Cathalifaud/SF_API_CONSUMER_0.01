/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.mc.app.bean;

import fr.mc.app.tool.Environment;
import fr.mc.app.tool.EnvironmentParser;
import java.util.ArrayList;
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
        return environments;
    }

    public String getEnvironmentsAsHTMLOptions() {
        String html = "";

        for (Environment environment : environments) {
            String value = environment.getClient_name().replace(" ", "_");
            String text = environment.getClient_name();
            html = html.concat("<option value=\"" + value + "\">" + text + "</option>");
        }
        return html;
    }
}
