/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TorusComponent;

/**
 *
 * @author Hirofumi
 */
public class Button {
    
    public static int VERTICAL = 0;
    public static int HORIZONTAL = 1;
    
    private int mDirection;
    private int mIndex;
    
    public Button(int direction, int index){
        mDirection = direction;
        mIndex = index;
    }
}
