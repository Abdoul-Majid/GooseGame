package goosegame.cell;
import goosegame.cell.Cell;
import goosegame.util.*;

public class StartCell implements Cell {

    private int index;
    public static final String STR ="START  ";


    /**
     */
    public StartCell(int index){
        this.index = index;
    }

    /**
     */
    public int getIndex(){
        return this.index;
    }
    
    /**
     */
    public boolean canBeLeft() {
        return true;
    }
    

    public void removePlayer(){

    }


    /**
     */
    public int bounce(int dieThrow) {
    return 1;
    }

    /**
     */
    public boolean isBusy() {
        return false;
    }
    

    /**
     */
    public Player getPlayer(){
        return null;
    }

    /**
     */
    public void welcomePlayer(Player player){
        player.setCell(this);
    }

    /**
     */
    public String toString(){
        return StartCell.STR;
    }
}