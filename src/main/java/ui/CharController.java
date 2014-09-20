/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import model.Skillset;
/**
 * FXML Controller class
 *
 * @author MainWin7
 */
public class CharController implements Initializable {
    private int cpoints;
    private Skillset skill;
    private int p,n,e,c;
    @FXML
    Button pn;
    @FXML
    Button pp;
    @FXML
    Button nn;
    @FXML
    Button np;
    @FXML
    Button en;
    @FXML
    Button ep;
    @FXML
    Button cn;
    @FXML
    Button cp;
    @FXML
    Button cancel;

    @FXML
    Label points;
    @FXML
    Label pl;
    @FXML
    Label cl;
    @FXML
    Label el;
    @FXML
    Label nl;


    @FXML
    Button done;

    @FXML
    TextField name;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cpoints=5;
        p=n=c=e=0;
        points.setText(""+cpoints);
        pp.setOnAction((ActionEvent event) -> {
            if(cpoints>0){
                cpoints--;
                p++;
            }
            points.setText(""+cpoints);
            pl.setText(""+p);
        });
        pn.setOnAction((ActionEvent event) -> {
            if(p>0){
                cpoints++;
                p--;
            }
            points.setText(""+cpoints);
            pl.setText(""+p);

        });
        np.setOnAction((ActionEvent event) -> {
            if(cpoints>0){
                cpoints--;
                n++;
            }
            points.setText(""+cpoints);            
            nl.setText(""+n);

        });
        nn.setOnAction((ActionEvent event) -> {
            if(n>0){
                cpoints++;
                n--;
            }
            points.setText(""+cpoints);
            nl.setText(""+n);

        });
        ep.setOnAction((ActionEvent event) -> {
            if(cpoints>0){
                cpoints--;
                e++;
            }
            points.setText(""+cpoints);
            el.setText(""+e);

        });
        en.setOnAction((ActionEvent event) -> {
            if(e>0){
                cpoints++;
                e--;
            }
            points.setText(""+cpoints);
            el.setText(""+e);

        });
        cp.setOnAction((ActionEvent event) -> {
            if(cpoints>0){
                cpoints--;
                c++;
            }
            points.setText(""+cpoints);
            cl.setText(""+c);
        });
        cn.setOnAction((ActionEvent event) -> {
            if(c>0){
                cpoints++;
                c--;
            }
            points.setText(""+cpoints);
            cl.setText(""+c);
        });
        done.setOnAction((ActionEvent event) -> {
            skill=new Skillset();
            skill.setCharisma(c);
            skill.setEngineering(e);
            skill.setNavigation(n);
            skill.setPiloting(p);
            skill.setName(name.getText());
            skill.save();
            System.out.println("Engineering:"+skill.getEngineering());
            System.out.println("Charisma:"+skill.getCharisma());
            System.out.println("Navigation:"+skill.getNavigation());
            System.out.println("Piloting:"+skill.getPiloting());
            System.out.println("Name:"+skill.getName());
            Platform.exit();
        });    
        cancel.setOnAction((ActionEvent ever)->{
            Platform.exit();
        });
    }
    public Button getDone(){
        return done;
    }
    public Button getCancel(){
        return cancel;
    }
    public Skillset getSkillset(){
        return skill;
    }
}
