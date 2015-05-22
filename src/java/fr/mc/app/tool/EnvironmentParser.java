/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.mc.app.tool;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Mathieu
 */
public class EnvironmentParser {

    private File file;
    private String filepath;
    private List<Environment> environments = null;

    public List<Environment> getEnvironments() {
        return environments;
    }

    public EnvironmentParser() {
        JSONParser jsonParser = new JSONParser();
        //file = new File("environments.json");
        file = new File("resources/json/environments.json");
        filepath = file.getAbsolutePath();
        
        try {
            JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader(filepath));
            for (Object object : jsonArray) {
                JSONObject jsonObject = (JSONObject) object;

                Environment environment = new Environment();
                environment.setClient_name((String) jsonObject.get("client_name"));
                environment.setResponse_type((String) jsonObject.get("response_type"));
                environment.setClient_id((String) jsonObject.get("client_id"));
                environment.setClient_secret((String) jsonObject.get("client_secret"));
                environment.setRedirect_uri((String) jsonObject.get("redirect_uri"));
                environment.setDisplay((String) jsonObject.get("display"));
                environment.setScope((String) jsonObject.get("scope"));

                environments.add(environment);
            }
        } catch (FileNotFoundException ex) {
            File dir1 = new File (".");
            File dir2 = new File ("..");
            
            try {
                System.out.println ("### Current dir : " + dir1.getCanonicalPath());
                System.out.println ("### Parent  dir : " + dir2.getCanonicalPath());
            } catch (IOException ex1) {
                Logger.getLogger(EnvironmentParser.class.getName()).log(Level.SEVERE, null, ex1);
            }

            Logger.getLogger(EnvironmentParser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ParseException ex) {
            Logger.getLogger(EnvironmentParser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String toOptions() {
        String options = "";

        for (int i = 0; i < environments.size(); i++) {
            Environment environment = environments.get(i);
            System.out.println("### env : " + environment.getClient_name());
            options = options + "<option value=\"" + i + "\">" + environment.getClient_name() + "</option>";
        }
        return options;
    }
}
