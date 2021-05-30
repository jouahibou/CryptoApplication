/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptoapplication;

import static java.lang.Class.forName;
import java.sql.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;



/**
 *
 * @author Lenovo
 */
public class CryptoApplication extends Application {

    private static Connection connectrDB() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   
    
    @Override
    public void start(Stage stage) throws Exception {
        
        FXMLLoader loader =new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
        
         Parent root = loader.load();
         FXMLDocumentController controller = loader.getController();
         
        Scene scene = new Scene(root);
        stage.setScene(scene);
        
        
        
        
        stage.show();
        stage.getIcons().add(new Image("Ucad.jpg"));
        
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
       
       
        launch(args);
    }
   
    
}
