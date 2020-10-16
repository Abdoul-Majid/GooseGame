package goosegame.cell;
import goosegame.cell.Cell; 
import goosegame.util.*;


public class TeleportCell extends BasicCell {
    protected int jumpIndex;

    public TeleportCell (int index, int jumpIndex) {
        super(index);
        jumpIndex= jumpIndex;
        this.str = "L";
    
    }
    
    public int bounce(int dieThrow) {
        
        return this.jumpIndex;
        
        }
}