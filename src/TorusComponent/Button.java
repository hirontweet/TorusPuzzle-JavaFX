/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TorusComponent;

/**
 *
 * @author Yamazaki Laboratory
 */
public class Button {
    
    public static int MOVE_VERTICAL = 0;
    public static int MOVE_HORIZONTAL = 1;
    
    private int mDirection;
    private int mIndex;
    
    public Button(int direction, int index){
        mDirection = direction;
        mIndex = index;
    }
    
    /**
     * 押されたボタンがどっち方向に回転するのかを返す関数
     * @return ボタンに設定された方向をintで(Buttonクラスの定数で判定)
     */
    public int getDirection(){
        return mDirection;
    }
}
