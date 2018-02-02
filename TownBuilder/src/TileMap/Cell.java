/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TileMap;

/**
 *
 * @author Jamie
 */
public class Cell{  
        public int heuristicCost = 0; //Heuristic cost
        public int finalCost = 0; //G+H
        public int i, j;
        public Cell parent; 
        private int nextMove;

    public int getNextMove() {
        return nextMove;
    }

    public void setNextMove(int nextMove) {
        this.nextMove = nextMove;
    }
        
        public Cell(int i, int j){
            this.i = i;
            this.j = j; 
        }
        
        @Override
        public String toString(){
            return "["+this.i+", "+this.j+"]";
        }
    }