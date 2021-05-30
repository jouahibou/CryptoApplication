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
public class FXMLDocumentController implements Initializable {

   
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
            
            
        
           
            /*la on recupére les variables dans le textfield */
             String nom = noms.getText();
             String prenon =prénoms.getText();
             String  num = numéro.getText();
            
             
            
            
            List<String> p = new ArrayList<>();
           
           
           /*on a d'abord cree une liste puis on recupére au hasard un caractére dans chaque champ
           que l'on ajoute a la liste on a d'abord commencer par le champ noms ensuite par le champ 
           prenom et enfin par le champ numero de telepone */
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
           
           /* ici on a gére aléatoirement en entier a compris en 0 et 8 que l'on 
           introduit dans la fonction random ce qui va nous permettre d'avoir 
           des permutation */
           Collections.shuffle(p, new Random(a));
          // System.out.println(p.size());
           System.out.println("Le code initial est  : " +p);
              
           
               
           
           
                
             FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Jouahibou.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            MoussaController controllerchif = fxmlLoader.getController();
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
                alert.setTitle("ATTENTION!!!! ATTENTION !!!! ");
        alert.setContentText("Veuillez vérifier les champs remplis   ");
        alert.showAndWait();
               
           
        
       
                 
             
            
        }}
    
    
    public String Alertes(){
        
        String a =prenon1+" "+nom1;
       
        return a;
        
    }
    public String NOMBI(){
        String s = nom1;
        return s;
    }
    public String PRENOM(){
        String w = prenon1;
        return w;
    }
   

 public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

   }
           
           
           
           
           
          
           
           
           
           
           
           
          
           
          
           
           
        
           
           
           
            
            
           
            
               
           
           

           
           
           
           
           
       
           
          
           
           
           
           
           
           
       


           
           
           
           
       
