/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TorusUser;

import TorusCore.ITorusPuzzle;

/**
 *
 * @author Hirofumi
 */
public class UserCode {
    
    /*
        ** 注意 **
        この部分のコードに変更を加えないでください
    */
    private ITorusPuzzle Torus = null;
    
    /*
        ** 注意 **
        この部分のコードに変更を加えないでください
    */
    public UserCode(ITorusPuzzle torus){ // この関数を「コンストラクタ」と呼びます
        Torus = torus;
    }
    
    /**
     * 自分のコードをここに書く
     */
    public void myCode(){
        Torus.display("HelloWorld");
        
        for(int y = 0; y < 5; y++){
            for(int x = 0; x < 5; x++){
                Torus.makeBlock(5 * y + x + 1, x, y);
            }
            Torus.makeButton(0, y + 1, 0);
            Torus.makeButton(1, 0, y + 1);
        }
    }
    /*
        自分のコードはここまで
    */
    
    
}
