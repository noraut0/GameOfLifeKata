package gameoflife;

import java.util.Random;

public class Grid {
    private Cell[][] cells;
    private int sizeGrid;
    private Random rd;

    public Grid(int sizeGrid) {
        this.rd = new Random();
        this.sizeGrid = sizeGrid;

        generateRandomInitialState();
    }

    Grid(int sizeGrid, Cell[][] cells) {
        this.sizeGrid = sizeGrid;
        this.cells = cells;
    }

    private void generateRandomInitialState() {

        // we create new grid and put new cell with random boolean in every box of the array;
        this.cells = new Cell[this.sizeGrid][this.sizeGrid];

        for (int i = 0; i < this.sizeGrid ; i++) {
            for (int j = 0; j < this.sizeGrid; j++) {
                this.cells[i][j] = new Cell(this.rd.nextBoolean());

            }
        }


    }
    //method that check every index is not out of range and also neighbour != cell
    private boolean checkIndex(int i, int j, int k , int l, int sizeMax){

        if( i + k >= 0 && i + k < sizeMax && j + l >= 0 && j + l < sizeMax && (k != 0 || l != 0) ) return true;
        else return false;

    }

    public void generateNextState() {


        //new array that will take the next step of the actual grid
        Cell[][] nextCells = new Cell[this.sizeGrid][this.sizeGrid];;

        // check every cell of the array
        for (int i = 0; i < this.sizeGrid ; i++) {
            for (int j = 0; j < this.sizeGrid; j++) {

                int countNeighbour = 0;

                // check out every neighbour of each cell
                for( int k = -1 ; k < 2 ; k++){
                    for( int l = -1 ; l < 2 ; l++) {

                        // check value of index and neighbour is alive or not
                        if( checkIndex(i, j, k, l,this.sizeGrid) && this.cells[i + k][j + l].isAlive() )countNeighbour++;

                    }
                }

                // modify value according with the number of neighbour and also the cell value;
                nextCells[i][j] = new Cell( true);
                nextCells[i][j].setIsAlive( Cell.processState( this.cells[i][j].isAlive(), countNeighbour) );

            }
        }
        //replace actual array by the new one
        this.cells = nextCells;

    }

    public String toString() {

        String displayString = "";

        for (int i = 0; i < this.sizeGrid ; i++) {
            for (int j = 0; j < this.sizeGrid; j++) {

              displayString += this.cells[i][j].toString();
              //put a space between every cell except the last of the line
              if(j < this.sizeGrid -1) displayString += " ";

            }
            // put a \n between every line except last one
            if(i < this.sizeGrid -1) displayString += "\n";
        }
        return displayString;
    }
}
