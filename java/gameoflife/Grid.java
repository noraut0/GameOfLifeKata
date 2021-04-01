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

        this.cells = new Cell[this.sizeGrid][this.sizeGrid];

        for (int i = 0; i < this.sizeGrid ; i++) {
            for (int j = 0; j < this.sizeGrid; j++) {
                this.cells[i][j] = new Cell(this.rd.nextBoolean());

            }
        }


    }

    private boolean checkIndex(int i, int j, int k , int l, int sizeMax){

        if( i + k >= 0 && i + k < sizeMax && j + l >= 0 && j + l < sizeMax && (k != 0 || l != 0) ) return true;
        else return false;

    }

    public void generateNextState() {

        Cell[][] oldCells = this.cells;


        for (int i = 0; i < this.sizeGrid ; i++) {
            for (int j = 0; j < this.sizeGrid; j++) {

                int countNeighbour = 0;

                for( int k = -1 ; k < 2 ; k++){
                    for( int l = -1 ; l < 2 ; l++) {

                        if( checkIndex(i, j, k, l,this.sizeGrid) && oldCells[i + k][j + l].isAlive() )countNeighbour++;

                    }
                }

                this.cells[i][j].setIsAlive( oldCells[i][j].processState(oldCells[i][j].isAlive() , countNeighbour) );


            }
        }

    }

    public String toString() {

        String displayString = "";

        for (int i = 0; i < this.sizeGrid ; i++) {
            for (int j = 0; j < this.sizeGrid; j++) {

              displayString += this.cells[i][j].toString();
              if(j < this.sizeGrid -1) displayString += " ";

            }
            if(i < this.sizeGrid -1) displayString += "\n";
        }
        return displayString;
    }
}
