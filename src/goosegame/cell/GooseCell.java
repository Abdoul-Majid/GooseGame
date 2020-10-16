package goosegame.cell;
import goosegame.cell.Cell;
import goosegame.util.*;


public class GooseCell extends BasicCell {


    public GooseCell(int index) {
    super(index);
    this.str = "G";
    }
    
    public int bounce(int dieThrow) {
        return 2*dieThrow;
        }
    }