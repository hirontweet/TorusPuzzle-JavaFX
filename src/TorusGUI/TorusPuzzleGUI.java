/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TorusGUI;

import TorusCore.TorusPuzzle;
import TorusUser.UserCode;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


/**
 *
 * @author Yamazaki Laboratory
 */
public class TorusPuzzleGUI extends Application {
    
    public static final int GUI_WIDTH = 800;
    public static final int GUI_HEIGHT = 600;
    
    private TorusPuzzle mTorusPuzzle;
    private UserCode mUserCode;
    
    @Override
    public void start(Stage primaryStage) {
        
        // primaryStageの初期設定
        primaryStage.setTitle("Torus Puzzle");
        
        mTorusPuzzle = new TorusPuzzle(primaryStage);
        mUserCode = new UserCode(mTorusPuzzle);
        
        // ユーザーのコードを実行
        mUserCode.myCode();
        
        // ユーザーが加えた変更をprimaryStageを取得
        mTorusPuzzle.updateStage();
        
        // primaryStageを表示する
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
