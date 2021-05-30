/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptoapplication;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Formatter;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;


/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class MoussaController implements Initializable {
     
     public Label chiffre;
     public Label message;
     public String nom1;
     public String prenom1;
     public boolean verificateur = false;
     String Fin="";
     String Fin1;
     int Fine1;
     int Fine;
      String a ="";
     String s ="";
     String w ="";
     String z;
     
      public  String codefin;
      public int l ;
      
       public  Connection connectrDB( ) throws IOException{
            Parent joe = fxmlLoader.load();
            FXMLDocumentController cc = fxmlLoader.getController();
            FXMLDocumentController cc1 = fxmlLoader.getController();
            FXMLDocumentController cc2 = fxmlLoader.getController();
            z = cc.Alertes();
            s= cc1.NOMBI();
            w =cc2.PRENOM();
            
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.print("Driver ok");
            String url = "jdbc:mysql://localhost:3306/crypto";
            String user ="root";
            String password="";
            Connection cn = DriverManager.getConnection(url,user,password);
            PreparedStatement st = cn.prepareStatement("insert into utilisateur (Prenom,nom,code) values(?,?,?)");
            st.setString(1,w);
            st.setString(2,s);
            st.setString(3,codefin);
            
            st.executeUpdate();
            cn.close();
            return cn;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
     
     
    public void affiche(String code)
    {

        chiffre.setText(code);
    }
    
    public void affiche1(String code1){
        
        message.setText(code1);
    }
    
 List<Character> j = new ArrayList<>();
    
  public void handleButtonAction1(ActionEvent event) throws IOException {
      verificateur = true;
        try{
            String joua = chiffre.getText().toUpperCase();
            if (j.size()>0){
                
            }
             
           
            
             a="";
           char[] tab1 = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','0','1','2','3','4','5','6','7','8','9'};
             
             for (int i=0;i<8;i++){
                Fin= Character.toString(joua.charAt(i));
               int  x= new String(tab1).indexOf(Fin);
               Fine = (7*(x)+23)%36;
               j.add(tab1[Fine]);
               a = a + j.get(i);
                 
             }
             
             System.out.println(a);
            
        affiche1(a);
      
        
       
    }catch(Exception e){
            e.printStackTrace();
        }
        }
    
    
    public void handleButtonAction2(ActionEvent event) throws IOException {
        verificateur = true ;
        try{
            if (j.size()>0){
             for (int i=0;i<j.size();i++){
             j.remove(i);
             }
            }
            
            a="";
             String joua1 = chiffre.getText().toUpperCase();
             char[] tab1 = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','0','1','2','3','4','5','6','7','8','9'};
            for (int i=0;i<8;i++){
                Fin1= Character.toString(joua1.charAt(i));
             int  x= new String(tab1).indexOf(Fin1);
              Fine1 = (x + 3)%36;
               j.add(tab1[Fine1]);
               a = a + j.get(i);
             
            }
            System.out.println(a);
            
        affiche1(a);
        
        
         
         
            }catch(Exception e){
            e.printStackTrace();
        }
        }
      
    
    public void handleButtonAction3(ActionEvent event) throws IOException {
        
        try{
            
             FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
             
            Parent root1 = (Parent) fxmlLoader1.load();
            Stage stage= (Stage)( (Node) (event.getSource())).getScene().getWindow();
            stage.setScene(new Scene(root1));
            stage.show();
            
            }catch(Exception e){
            e.printStackTrace();
        }
        }
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
    public void btnValider(ActionEvent event) throws IOException {
       if (!verificateur){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(" MODE DE CHIFFREMENT ");
        alert.setContentText("Vous avez oublié de choisir le mode de chiffrement ");
        alert.showAndWait();
            
        }
       else{
        
        try{
           
            codefin=a;
            connectrDB();
            
            
           
           
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("FELICITATION !!!! FELICITATION!!!! ");
        alert.setContentText("Vous avez crée un code pour "+z+" : "+codefin);
        alert.showAndWait();
         FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
             
            Parent root1 = (Parent) fxmlLoader1.load();
            Stage stage= (Stage)( (Node) (event.getSource())).getScene().getWindow();
            stage.setScene(new Scene(root1));
            stage.show();
        
       }catch(Exception e){
            e.printStackTrace();
        }
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
