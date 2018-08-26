/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.librarystm.controller;

import com.jfoenix.controls.JFXTextField;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.librarystm.db.DBConnection;
import lk.ijse.librarystm.main.LibraryStm;

/**
 * FXML Controller class
 *
 * @author SSNLIVE
 */
public class AddBookFormController implements Initializable {

    @FXML
    private JFXTextField txtBkId;
    @FXML
    private JFXTextField txtBkName;
    @FXML
    private JFXTextField txtBkIsbn;
    @FXML
    private JFXTextField txtAuthor;
    @FXML
    private JFXTextField txtPublisher;
    @FXML
    private Button btnSave;
    @FXML
    private Button btnCancel;
    @FXML
    private TableView<?> tblBookView;
    @FXML
    private AnchorPane root;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void imgGo_Back_On_Action(MouseEvent event) {
        LibraryStm.navigateToHome(root, (Stage) this.root.getScene().getWindow());
    }

    @FXML
    private void FinfBookInfo_On_Action(KeyEvent event) {
    }

    @FXML
    private void btnSave_On_Action(ActionEvent event) {
        Connection coonection = null;
        String name = txtBkName.getText();
        String query = "select * from book where name = '"+name+"'";
        try {
            Statement stmt = DBConnection.getInstance().getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if(rs.next()){
                txtBkId.setText(rs.getString("bookid"));
                txtBkIsbn.setText(rs.getString("isbn"));
                txtAuthor.setText(rs.getString("author"));
                txtPublisher.setText(rs.getString("author"));
            }
            else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION,"There is no such a book",ButtonType.OK);
                alert.show();
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddBookFormController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AddBookFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnCancel_On_Action(ActionEvent event) {
        
    }

    @FXML
    private void btnSearch_On_Action(ActionEvent event) {
        Connection coonection = null;
        String name = txtBkName.getText();
        String query = "select * from book where name = '"+name+"'";
        try {
            Statement stmt = DBConnection.getInstance().getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if(rs.next()){
                txtBkId.setText(rs.getString("bookid"));
                txtBkIsbn.setText(rs.getString("isbn"));
                txtAuthor.setText(rs.getString("author"));
                txtPublisher.setText(rs.getString("author"));
            }
            else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION,"There is no such a book",ButtonType.OK);
                alert.show();
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddBookFormController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AddBookFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
