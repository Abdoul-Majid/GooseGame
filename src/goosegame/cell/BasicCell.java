package goosegame.cell;
import goosegame.cell.Cell;
import goosegame.util.*;


public class BasicCell implements Cell {
    protected Player player;
    protected int index;

    protected  String str ;
    public BasicCell(int index) {
        player= null;
        this.index = index;
        this.str = "B";
        }

    public int getIndex(){
        return this.index;
    }

    public boolean canBeLeft() {
        return true;
        }


    public int bounce(int dieThrow) {
        return dieThrow;
        }


    public boolean isBusy() {
        return player!= null;
        } 

    public void welcomePlayer(Player player) {
        this.player= player;
        if(player!= null) {
            player.setCell(this);
     }
    }

    public void removePlayer(){
        this.player = null;
    }

    public Player getPlayer() {
        return player;
    }

    public String toString(){
        if (! this.isBusy() ) return str;
        return this.player.toString();
    }
}
