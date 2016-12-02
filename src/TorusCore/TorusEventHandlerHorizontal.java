/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TorusCore;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author Yamazaki Laboratory
 */
public class TorusEventHandlerHorizontal implements EventHandler<ActionEvent>{

    private int mIndex = 1;
    private TorusPuzzle mTorus;
    
    public TorusEventHandlerHorizontal(TorusPuzzle torus, int index){
        mTorus = torus;
        mIndex = index;
    }
    
    @Override
    public void handle(ActionEvent event) {
        mTorus.moveHorizontally(mIndex);
    }
    
}
