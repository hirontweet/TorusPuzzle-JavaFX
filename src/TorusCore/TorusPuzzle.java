/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TorusCore;

import TorusComponent.Block;
import TorusComponent.Button;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author Hirofumi
 */
public class TorusPuzzle {
   
    public static final int GRID_SIZE = 4;
    public static final int MAX_BLOCK_WIDTH = GRID_SIZE;
    public static final int MAX_BLOCK_HEIGHT = GRID_SIZE;
    public static final int MAX_BUTTON_WIDTH = GRID_SIZE + 1;
    public static final int MAX_BUTTON_HEIGHT = GRID_SIZE + 1;
    
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
            mButtonGridVertical[coord_y] = newButton;
            
        // HORIZONTALとdirectionとして入力した場合
        }else if((coord_x >= 1 && coord_x <= MAX_BLOCK_WIDTH) && (coord_y == 0)){
            Button newButton = new Button(direction, coord_x);
            mButtonGridHorizontal[coord_x] = newButton;
        }
    }
    
    public void updateStage(){
        
        Label lblText = new Label();
        lblText.setText(mStrBuffer.toString());
        lblText.setFont(new Font(14));
        
        HBox boxText = new HBox();
        boxText.setAlignment(Pos.CENTER);
        boxText.getChildren().add(lblText);
        
        
        BorderPane layout = new BorderPane();
        layout.setBottom(boxText);
        
        Scene scene = new Scene(layout, 800, 600);
        
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
    }
    
}
