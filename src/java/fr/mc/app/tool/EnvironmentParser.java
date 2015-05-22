/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.mc.app.tool;

import com.google.common.io.Files;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
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

    private String filepath = "environments.json";
    private ArrayList<Environment> environments = null;

    public ArrayList<Environment> getEnvironments() {
        return environments;
    }

    public EnvironmentParser() {
        JSONParser jsonParser = new JSONParser();

        try {
            File file = new File(filepath);

            if (file.exists()) {
                String fileContent = Files.toString(file, Charset.defaultCharset());
                JSONObject fileContentAsJSONObject = (JSONObject) jsonParser.parse(fileContent);
                JSONArray environmentsAsObject = (JSONArray) fileContentAsJSONObject.get("environments");
                ArrayList<Environment> newEnvironmentsCollection = new ArrayList<>();

                for (Object environmentAsObject : environmentsAsObject) {
                    JSONObject environmentAsJSONObject = (JSONObject) environmentAsObject;
                    Environment environment = new Environment();
                    environment.setClient_name((String) environmentAsJSONObject.get("client_name"));
                    environment.setResponse_type((String) environmentAsJSONObject.get("response_type"));
                    environment.setClient_id((String) environmentAsJSONObject.get("client_id"));
                    environment.setClient_secret((String) environmentAsJSONObject.get("client_secret"));
                    environment.setRedirect_uri((String) environmentAsJSONObject.get("redirect_uri"));
                    environment.setDisplay((String) environmentAsJSONObject.get("display"));
                    environment.setScope((String) environmentAsJSONObject.get("scope"));
                    newEnvironmentsCollection.add(environment);
                }
                environments = newEnvironmentsCollection;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EnvironmentParser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ParseException ex) {
            Logger.getLogger(EnvironmentParser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
