package goosegame.util;
import goosegame.cell.Cell;


public class Player{


    private String number;
    private Cell cell;

    /**
     */
    public Player(String number){
        this.number = number;
        this.cell = null;
    }

    /**
     */
    public String getNumber(){
        return this.number;
    }

    /**
     */
    public void setCell(Cell cell){
        this.cell = cell;
    }

    /**
     */
    public Cell getCell() {
        return this.cell;
    }

    /**
     */
    public String toString(){

        return this.getNumber();
    }
}