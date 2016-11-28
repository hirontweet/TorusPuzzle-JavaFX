/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TorusCore;

import TorusComponent.Block;
import TorusComponent.Button;
import TorusGUI.TorusPuzzleGUI;
import java.awt.Color;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author Hirofumi
 */
public class TorusPuzzle implements ITorusPuzzle{
   
    public static final int GRID_SIZE = 5;
    public static final int MAX_BLOCK_WIDTH = GRID_SIZE;
    public static final int MAX_BLOCK_HEIGHT = GRID_SIZE;
    public static final int MAX_BUTTON_WIDTH = GRID_SIZE + 1;
    public static final int MAX_BUTTON_HEIGHT = GRID_SIZE + 1;
    
    // BLOCK_SIZEはGRIDの大きさにしたいが、GRID_SIZEがすでに使われているため、仕方がなくBLOCK_SIZEにしている
    public static final int BLOCK_SIZE = Math.min(TorusPuzzleGUI.GUI_HEIGHT, TorusPuzzleGUI.GUI_WIDTH) / (GRID_SIZE + 1 + 1);
    public static final int MARGIN_SIZE = 5;
    public static final int BUTTON_SIZE = BLOCK_SIZE - 2 * MARGIN_SIZE;
    
    
    private Button mButtonGridVertical[];
    private Button mButtonGridHorizontal[];
    private Block mBlockGrid[][];
    private Stage primaryStage;
    
    private StringBuffer mStrBuffer;
    
    public TorusPuzzle(Stage stage){
        
        primaryStage = stage;
        
        // mButtonGridの初期化
        mBlockGrid = new Block[MAX_BLOCK_HEIGHT][MAX_BLOCK_WIDTH];
        for(int y = 0; y < MAX_BLOCK_HEIGHT; y++){
            for(int x = 0; x < MAX_BLOCK_WIDTH; x++){
                mBlockGrid[y][x] = null;
            }
        }
        
        // mButtonGridHorizontalとmButtonGridVerticalの初期化
        mButtonGridHorizontal = new Button[MAX_BUTTON_WIDTH];
        mButtonGridVertical = new Button[MAX_BUTTON_HEIGHT];
        for(int i = 0; i < MAX_BUTTON_HEIGHT; i++){
            mButtonGridHorizontal[i] = null;
            mButtonGridVertical[i] = null;
        }
        
        // StringBufferの初期化
        mStrBuffer = new StringBuffer();
    }
    
    /**
     * 
     * @param userInput 表示する文字列を入力
     */
    public void display(int userInput){
        
        // 今はコンソールに表示されるように設定している
        // TODO: JavaFXのGUIで表示されるように設定する(例えば、Labelを使って)
        System.out.println(userInput);
        
        mStrBuffer.append(userInput);
        mStrBuffer.append("\n");
    }

    /**
     * 
     * @param userInput 表示する文字列を入力
     */
    public void display(float userInput){
        
        // 今はコンソールに表示されるように設定している
        // TODO: JavaFXのGUIで表示されるように設定する(例えば、Labelを使って)
        System.out.println(userInput);
        
        mStrBuffer.append(userInput);
        mStrBuffer.append("\n");
    }
    
    /**
     * 
     * @param userInput 表示する文字列を入力
     */
    public void display(double userInput){
        
        // 今はコンソールに表示されるように設定している
        // TODO: JavaFXのGUIで表示されるように設定する(例えば、Labelを使って)
        System.out.println(userInput);
        
        mStrBuffer.append(userInput);
        mStrBuffer.append("\n");
    }
    
    /**
     * 
     * @param userInput 表示する文字列を入力
     */
    public void display(char userInput){
        
        // 今はコンソールに表示されるように設定している
        // TODO: JavaFXのGUIで表示されるように設定する(例えば、Labelを使って)
        System.out.println(userInput);
        
        mStrBuffer.append(userInput);
        mStrBuffer.append("\n");
    }
    
    /**
     * 
     * @param userInput 表示する文字列を入力
     */
    public void display(String userInput){
        
        // 今はコンソールに表示されるように設定している
        // TODO: JavaFXのGUIで表示されるように設定する(例えば、Labelを使って)
        System.out.println(userInput);
        
        mStrBuffer.append(userInput);
        mStrBuffer.append("\n");
    }
    
    /**
     * ブロックをステージ上に表示させる
     * @param num ブロックに表示させる数字
     * @param coord_x ブロックのx座標
     * @param coord_y ブロックのy座標
     */
    public void makeBlock(int num, int coord_x, int coord_y){
        
        Block newBlock = new Block(num);
        try{
            mBlockGrid[coord_y][coord_x] = newBlock;
        }catch(ArrayIndexOutOfBoundsException e){
            System.err.println("配列の要素番号がしきい値を超えています");
            newBlock = null;
        }
    }
    
    /**
     * ボタンをステージ上に表示させる
     * @param direction ボタンの方向(VERTICAL, HORIZONTAL)
     * @param coord_x ボタンのx座標
     * @param coord_y ボタンのy座標
     */
    public void makeButton(int direction, int coord_x, int coord_y){
        
        // (0, 0)に誤って振っても、表示されるようにする
        if(coord_x == 0 && coord_y == 0){
            Button newButton = new Button(-1, -1);
        
        // VERTICALとdirectionとして入力した場合
        }else if((coord_x == 0) && (coord_y >= 1 && coord_y <= MAX_BLOCK_HEIGHT)){
            Button newButton = new Button(direction, coord_y);
            // TODO: 配列の名前をわかりやすくする
            // mButtonGridHorizontalという名前は、おそらく、Button.HORIZONTALを受け付けるための配列として用意されていると思われる。
            mButtonGridHorizontal[coord_y] = newButton;
            
        // HORIZONTALとdirectionとして入力した場合
        }else if((coord_x >= 1 && coord_x <= MAX_BLOCK_WIDTH) && (coord_y == 0)){
            Button newButton = new Button(direction, coord_x);
            // TODO: 配列の名前をわかりやすくする
            // mButtonGridVerticalという名前は、おそらく、Button.VERTICALを受け付けるための配列として用意されていると思われる。
            mButtonGridVertical[coord_x] = newButton;
        }
    }
    
    public void updateStage(){
        
        Label lblText = new Label();
        lblText.setText(mStrBuffer.toString());
        lblText.setFont(new Font(14));
        
        HBox boxText = new HBox();
        boxText.setAlignment(Pos.CENTER);
        boxText.getChildren().add(lblText);
        
        /*
        TODO: 変数名をしっかり決めて、リファクタリング。
        */
        GridPane gridGUI = new GridPane();
        gridGUI.setAlignment(Pos.CENTER);
        gridGUI.setPadding(new Insets(10, 10, 10, 10));
        gridGUI.setVgap(10);
        gridGUI.setHgap(10);
        // Blockを表示する処理
        for(int y = 0; y < MAX_BLOCK_HEIGHT; y++){
            for(int x = 0; x < MAX_BLOCK_WIDTH; x++){
                if(mBlockGrid[y][x] == null){
                    javafx.scene.control.Button btn = new javafx.scene.control.Button();
                    btn.setPrefHeight(BUTTON_SIZE);
                    btn.setPrefWidth(BUTTON_SIZE);
                    //btn.setPadding(new Insets(10, 10, 10, 10));
                    GridPane.setConstraints(btn, x + 1, y + 1);
                    btn.setVisible(false);
                    continue;
                }
                
                int number = mBlockGrid[y][x].getNumber();
                javafx.scene.control.Button btn = new javafx.scene.control.Button(String.valueOf(number));
                btn.setPrefHeight(BUTTON_SIZE);
                btn.setPrefWidth(BUTTON_SIZE);
                btn.setStyle("-fx-base: #33cc33");
                GridPane.setConstraints(btn, x + 1, y + 1);
                gridGUI.getChildren().add(btn);
            }
        }
        
        /*
        GridPane gridHorizontalButton = new GridPane();
        gridHorizontalButton.setAlignment(Pos.CENTER);
        gridHorizontalButton.setPadding(new Insets(10, 10, 10, 10));
        gridHorizontalButton.setVgap(10);
        //gridHorizontalButton.setHgap(10);
        */
        //ButtonのHorizontalを表示する処理
        for(int x = 1; x < MAX_BUTTON_WIDTH; x++){
            if(mButtonGridHorizontal[x] == null){
                javafx.scene.control.Button btn = new javafx.scene.control.Button();
                btn.setPrefHeight(BUTTON_SIZE);
                btn.setPrefWidth(BUTTON_SIZE);
                btn.setVisible(false);
//                GridPane.setConstraints(btn, 0, x);
                GridPane.setConstraints(btn, 0, x);
//                gridHorizontalButton.getChildren().add(btn);
                gridGUI.getChildren().add(btn);
                continue;
            }
            
            javafx.scene.control.Button btn = new javafx.scene.control.Button();
            btn.setPrefHeight(BUTTON_SIZE);
            btn.setPrefWidth(BUTTON_SIZE);
            btn.setStyle("-fx-base: #ff0000");
            // Buttonにイベントリスナーを付加
            // Buttonの配置場所がBlockに比べて一つずれているため、引いている
            EventHandler<ActionEvent> TorusEvent = null;
            if(mButtonGridHorizontal[x].getDirection() == Button.HORIZONTAL){
                TorusEvent = new TorusEventHandlerHorizontal(this, x - 1);
            }else if(mButtonGridHorizontal[x].getDirection() == Button.VERTICAL){
                TorusEvent = new TorusEventHandlerVertical(this, x - 1);
            }
            btn.setOnAction(TorusEvent);
//            GridPane.setConstraints(btn, 0, x);
            GridPane.setConstraints(btn, 0, x);
//            gridHorizontalButton.getChildren().add(btn);
            gridGUI.getChildren().add(btn);
        }
        
        /*
        GridPane gridVerticalButton = new GridPane();
        gridVerticalButton.setAlignment(Pos.CENTER);
        gridVerticalButton.setPadding(new Insets(10, 10, 10, 10));
        //gridVerticalButton.setVgap(10);
        gridVerticalButton.setHgap(10);
        */
        //ButtonのVerticalを表示する処理
        for(int y = 1; y < MAX_BUTTON_HEIGHT; y++){
            if(mButtonGridVertical[y] == null){
                javafx.scene.control.Button btn = new javafx.scene.control.Button();
                btn.setPrefHeight(BUTTON_SIZE);
                btn.setPrefWidth(BUTTON_SIZE);
                btn.setVisible(false);
                GridPane.setConstraints(btn, y, 0);
//                gridVerticalButton.getChildren().add(btn);
                gridGUI.getChildren().add(btn);
                continue;
            }
            
            javafx.scene.control.Button btn = new javafx.scene.control.Button();
            btn.setPrefHeight(BUTTON_SIZE);
            btn.setPrefWidth(BUTTON_SIZE);
            btn.setStyle("-fx-base: #ff0000");
            // Buttonにイベントリスナーを付加
            // Buttonの配置場所がBlockに比べて一つずれているため、引いている
            EventHandler<ActionEvent> TorusEvent = null;
            if(mButtonGridVertical[y].getDirection() == Button.HORIZONTAL){
                TorusEvent = new TorusEventHandlerHorizontal(this, y - 1);
            }else if(mButtonGridVertical[y].getDirection() == Button.VERTICAL){
                TorusEvent = new TorusEventHandlerVertical(this, y - 1);
            }
            btn.setOnAction(TorusEvent);
            GridPane.setConstraints(btn, y, 0);
//            gridVerticalButton.getChildren().add(btn);
            gridGUI.getChildren().add(btn);
        }
        
        /*
        GridPane root = new GridPane();
        GridPane.setConstraints(gridVerticalButton, 1, 0);
        GridPane.setConstraints(gridHorizontalButton, 0, 1);
        GridPane.setConstraints(gridGUI, 1, 1);
        root.getChildren().addAll(gridGUI, gridHorizontalButton, gridVerticalButton);
        
        // これを入れないと左にずれる
        HBox rootHorizontal = new HBox();
        rootHorizontal.setAlignment(Pos.CENTER);
        rootHorizontal.getChildren().add(root);
        */
        
        BorderPane layout = new BorderPane();
//        layout.setCenter(rootHorizontal);
        layout.setCenter(gridGUI);
        layout.setBottom(boxText);
        
        Scene scene = new Scene(layout, TorusPuzzleGUI.GUI_WIDTH, TorusPuzzleGUI.GUI_HEIGHT);
        
        primaryStage.setScene(scene);
        
    }
    
    /**
     * Blockを水平に動かすための関数
     * @param index どの行のBlockを水平に動かすか(0はじまり)
     */
    public void moveHorizontally(int index){
        if(!(index >= 0 && index < MAX_BLOCK_HEIGHT)){
            return;
        }
        
        Block temporary = mBlockGrid[index][0];
        for(int i = 0; i < MAX_BLOCK_WIDTH - 1; i++){
            mBlockGrid[index][i] = mBlockGrid[index][i + 1];
        }
        mBlockGrid[index][MAX_BLOCK_WIDTH - 1] = temporary;
        
        // 画面を更新
        updateStage();
    }
    
    /**
     * Blockを垂直に動かすための関数
     * @param index どの列のBlockを垂直に動かすか(0はじまり)
     */
    public void moveVertically(int index){
        if(!(index >= 0 && index < MAX_BLOCK_WIDTH)){
            return;
        }
        
        Block temporary = mBlockGrid[0][index];
        for(int i = 0; i < MAX_BLOCK_HEIGHT - 1; i++){
            mBlockGrid[i][index] = mBlockGrid[i + 1][index];
        }
        mBlockGrid[MAX_BLOCK_HEIGHT - 1][index] = temporary;
        
        // 画面の更新
        updateStage();
    }
    
}
