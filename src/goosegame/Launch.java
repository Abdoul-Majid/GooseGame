package goosegame;

import goosegame.util.*;
import goosegame.board.*;
import goosegame.cell.*;
import goosegame.random.*;
import java.util.ArrayList;
import goosegame.*;

public class Launch{

    public static void main(String[] args){

        Board b = ClassicBoard.THE_BOARD;
        Player p1 = new Player("1");
        Player p2 = new Player("2");
        Player p3 = new Player("3");

        Game g = new Game(b);
        g.addPlayer(p1);
        g.addPlayer(p2);
        g.addPlayer(p3);


        g.play();
    }
}