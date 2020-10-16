package goosegame.board;
import goosegame.cell.*;

abstract public class Board {
    /** must be greater than the max result of the throwof dies */
    protected final int NB_OF_CELLS;
    protected Cell[] theCells;

    public Board(int nbOfCells) {
        NB_OF_CELLS = nbOfCells;
        theCells = new Cell[NB_OF_CELLS+ 1];
        this.theCells[0] = new StartCell(0);
        initBoard();

    }

    /** initializes the board by creating the cells */
    abstract protected void initBoard();
    
    public Cell[] getListOfCells(){
        return theCells;
    }
    
    public void setCell(int index, Cell cell){
        theCells[index] = cell;
    }
    public Cell getCell(int numero) {
        return theCells[numero];
        }

    public int nbOfCells() {
        return NB_OF_CELLS;
    }
}