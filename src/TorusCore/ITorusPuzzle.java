/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TorusCore;

/**
 *
 * @author Hirofumi
 */
public interface ITorusPuzzle {
    
    public void display(int userInput);
    
    public void display(double userInput);
    
    public void display(float userInput);
    
    public void display(String userInput);
    
    public void display(char userInput);
    
    public void makeBlock(int num, int coord_x, int coord_y);
    
    public void makeButton(int direction, int coord_x, int coord_y);
}
