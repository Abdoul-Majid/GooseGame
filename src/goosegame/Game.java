package goosegame;
import goosegame.util.*;
import goosegame.cell.*;
import goosegame.random.*;
import goosegame.board.*;
import java.util.ArrayList;

public class Game{
    private Board board;
    private ArrayList<Player> players;
    private int playerTurn;
    private Cell[] cells;

    /**
     */
    public Game(Board board){
        this.board = board; //board of the game
        this.players = new ArrayList<Player>(); //list of players
        this.playerTurn = -1;
        this.cells = board.getListOfCells();

    }

    /**gets the board of the game
     *@return the board of tge game
     */
    public Board getBoard(){
        return this.board;
    }

    /**Allows to place players at the start of the board
     *@param player the player to place
     */
    public void addPlayer(Player p){
        this.players.add(p);
        this.cells[0].welcomePlayer(p);
        this.board.setCell(0,this.cells[0]);
    }

    /**Launchs randomly two dice between 1 and 6 and returns the sum 
     *@return the sum of the launch of two dices
     */
    public int launchTwoDice(){
        int launch1 = RandomDice.generate(1,6);
        int launch2 = RandomDice.generate(1,6);
        System.out.println("First launch :"+launch1);
        System.out.println("Second launch : "+launch2);

        return launch1+launch2;
    }
    

    /**Produces the right index of the passed argument according to the board's length 
     *e.g if the board's length is 63, when we passed 66 as argument it will return 60 (move back of (66-63))
     *@param index the index to parse 
     *@return the right number that will be used to move the player
     */
    public int parseIndex(int index){
        int length = this.board.nbOfCells();
        //index++;

        if (index == length-1) return index;
        else if (index >= length) return length - (index%length);
        return index;

    }

    
    /**This method is used to move a player at the specified index 
     *@param index the specified index 
     *@param player the player to move
     */
    public void movePlayer(int index, Player player){
        
        try{
            
            int oldIndex = player.getCell().getIndex(); //the index of the player before the move
            this.cells[oldIndex].removePlayer(); //remove it from the old index
            int destinationIndex = this.parseIndex(oldIndex+index); //compute the destination index

            if (this.cells[destinationIndex].isBusy() ) { // destination cell contains player?
                Player playerToRedirect =  this.cells[destinationIndex].getPlayer(); // get player situed in the destination cell
                this.cells[oldIndex].welcomePlayer(playerToRedirect); // place it at the old index
            }

            this.cells[destinationIndex].welcomePlayer(player); //place the player to the corresponding cell
            this.board.setCell(oldIndex,this.cells[oldIndex]);
            this.board.setCell(destinationIndex,this.cells[destinationIndex]);


        }catch(ArrayIndexOutOfBoundsException e){
            throw new ArrayIndexOutOfBoundsException("the index is invalid");
        }
        
        
    }

    /**This method is used to give the turn to each player to play a match 
     *@return the next player situed in the game board
     */
    public Player nextPlayer(){
        this.playerTurn = (this.playerTurn + 1)%this.players.size();
        return this.players.get(this.playerTurn);
    }


    /**Launchs randomly two dices and returns the consequence 
     *produced by the cell situed at the index corresponding to the sum of the two dices 
     *@return the bounce produced by the cell whose index has been choosed ramdomly by launching 
     *two dices
     */
    public int match(Player player) {
        
        int launch = this.launchTwoDice();
        int bounce = this.cells[launch].bounce(launch);
        return bounce;

    }


    /**This method verifies if the player can quit his cell 
     *@return <code>true</code> if the player can quit his cell, <code>false</code> else 
     */
    public boolean canPlay(Player player ){
        return player.getCell().canBeLeft();
    }


    /**This method allows to play to the goose game
     */
    public void play(){

        Player player = null;
        boolean won = false;
        int length = this.cells.length;


        while (!won){
            System.out.println(this.board+"\n");  //display the board
            player = this.nextPlayer(); //give the turn to the next player
            System.out.println("player "+player.toString());


            if (this.canPlay(player)){ //the player can quit the cell ?

                int bounce  = this.match(player); //launch two dice and get the sum
                this.movePlayer(bounce,player); // place the player

                if (player.getCell().getIndex() == length-1) { // player is at the end?
                    System.out.println(this.board);
                    won = true; // the player has won
                    this.displayWinner(player); 
                }
            }else{
                this.displayPlayerCannotPlay(player); // the player cannot quit its cell
            }

        }
    }

    /**This method will be used to display the winner of the game
     *@param player the player who has won the game
     */
    public void displayPlayerCannotPlay(Player player){

        System.out.println("the player "+player.toString()+" cannot play ");
    }


    /**Informs that the player cannot play 
     *@param player the player who cannot play
     */
    public void displayWinner(Player player){
        System.out.println("The player "+player.toString()+" has won !!!");
    }

}