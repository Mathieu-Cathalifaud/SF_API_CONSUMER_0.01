/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.mc.app.tool;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Mathieu
 */
public class EnvironmentParser {
    
    private static final String filepath = "web/resources/json/environments.json";
    
    public EnvironmentParser() {
        JSONParser jsonParser = new JSONParser();
        
        try {
            JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader(filepath));
            System.out.println("### Coucou");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EnvironmentParser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ParseException ex) {
            Logger.getLogger(EnvironmentParser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
