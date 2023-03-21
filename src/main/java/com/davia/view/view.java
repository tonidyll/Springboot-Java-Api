/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.davia.view;

import com.fasterxml.jackson.databind.ObjectMapper;
import static com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormat.URI;
import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author antonidavyll
 */
public class view extends javax.swing.JFrame {
    HttpClient client = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();
    String Url = "http://api.com/src/controller/empleadoController.java?bs=";
    public view(){
    initComponents();
    show();
    }
    
    private void show(){
        HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(Url)).build();
        try {
            HttpResponse response = client.send(request,HttpResponse.BodyHandlers.ofString());
        } catch (IOException ex) {
            Logger.getLogger(view.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(view.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

