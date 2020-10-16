package goosegame.cell;
import goosegame.cell.Cell;


public class TrapCell extends BasicCell{
    public TrapCell (int index){
        super(index);
        this.str = "T";
    }
    
    public boolean canBeLeft() {
        return false;
    }


}