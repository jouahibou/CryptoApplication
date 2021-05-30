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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Formatter;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 *
 * @author Lenovo
 */
public class FirstInterfaceController implements Initializable {

   
    @FXML
    private TextField prénoms;
    @FXML
    private  TextField noms;
    @FXML
    private  TextField numéro;
    
     @FXML
    private Text actiontarget ;
     
     public static String nom1;
     public static String prenon1;
     static boolean verificateurInt = true;
     
     
     public int j;
    
    public void handleButtonAction(ActionEvent event) throws IOException {
        j=j+1;
        
        try
            
        {
            
            
        
           
            /*there we get the variables in the textfield */
             String nom = noms.getText();
             String prenon =prénoms.getText();
             String  num = numéro.getText();
            
             
            
            
            List<String> p = new ArrayList<>();
           
           
           /*we first created a list then we randomly retrieve a character in each field
           that we add to the list we first start with the names field then with the field
           first name and finally by the telepone number field */
           
            Random rand = new Random();
           int k = rand.nextInt(nom.length());
           String strVar = Character.toString(nom.charAt(k));
           p.add(strVar);
            
             Random rand1 = new Random();
           int m =rand1.nextInt(prenon.length());
           String strVare =  Character.toString(prenon.charAt(m));
           
           
           p.add(strVare);
             
            int entier = Integer.parseInt(num);
            if (entier >0){
                
                for (int i =0;i<6;i++){
           Random rand2 = new Random();
              int l = rand2.nextInt(num.length());
               String strVars = Character.toString(num.charAt(l));
               
            p.add(strVars);
            }
            }
             nom1=nom;
           prenon1=prenon;
           
           
           Random rand3 = new Random();
           int a = rand3.nextInt(8);
           
           /* here we have managed randomly in full and understood in 0 and 8 that we
           introduced in the random function which will allow us to have
           permutations */
           
           Collections.shuffle(p, new Random(a));
          
           
           System.out.println(" The initial code  : " +p);
              
           
               
           
          /* the FXMLDocument.fxml file is called is called
           this is the interface
           */
     
                
             FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SecondInterface.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            SecondInterfaceController controllerchif = fxmlLoader.getController();
            Stage stage= (Stage)( (Node) (event.getSource())).getScene().getWindow();
            stage.setScene(new Scene(root1));
            stage.show();
            
              String res = "";
                for (int i = 0; i < 8; i++) {
                res = res+p.get(i);}
                
                controllerchif.affiche(res);
                
              
          
               
            
        }catch(Exception e){
              //  e.printStackTrace();
          
               Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Warning!!!! Warning !!!! ");
        alert.setContentText("Please check the fields  ");
        alert.showAndWait();
               
           
        
       
                 
             
            
        }}
    
    
    public String Prenon_Nom(){
        
        String a =prenon1+" "+nom1;
       
        return a;
        
    }
    public String Nom(){
        String s = nom1;
        return s;
    }
    public String Prenom(){
        String w = prenon1;
        return w;
    }
   

 public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

   }
           
           
           
           
           
          
           
           
           
           
           
           
          
           
          
           
           
        
           
           
           
            
            
           
            
               
           
           

           
           
           
           
           
       
           
          
           
           
           
           
           
           
       


           
           
           
           
       
