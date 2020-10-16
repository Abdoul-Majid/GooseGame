package goosegame.cell;
import goosegame.util.*;


public interface Cell{

    public boolean canBeLeft();

    public int bounce(int dieThrow);

    public boolean isBusy();

    public void welcomePlayer(Player player);

    public void removePlayer();
    public Player getPlayer();

    public int getIndex();
}