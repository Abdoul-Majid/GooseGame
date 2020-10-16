package goosegame.cell;
import goosegame.cell.Cell;
import goosegame.util.*;


public class WaitingCell extends BasicCell {
    protected int waitTime;
    protected int waitDuration;


    public WaitingCell (int index, int waitDuration){
        super(index);
        this.waitDuration= waitDuration;
        this.str = "W";
    }
    
    public boolean canBeLeft() {
        return(waitTime--) == 0;
    }

    public void welcomePlayer(Player player) {
        super.welcomePlayer(player);
        waitTime= waitDuration;
        }
    }