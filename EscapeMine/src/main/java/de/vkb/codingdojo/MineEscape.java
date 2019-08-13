package de.vkb.codingdojo;

import java.util.ArrayList;
import java.util.List;

public class MineEscape {

    public List<String> calculatePath(boolean[][] board, Coordinate startPosition, Coordinate endPosition){

        Coordinate aktuellePosition = new Coordinate(startPosition.getX(), startPosition.getY());

        ArrayList<String> results = new ArrayList<String>();

        while( aktuellePosition.getX() != endPosition.getX() || aktuellePosition.getY() != endPosition.getY()) {

            while (aktuellePosition.getX() < endPosition.getX()){
                if( aktuellePosition.getX() + 1 < board.length && board[aktuellePosition.getX() + 1][aktuellePosition.getY()]) {

                    results.add("rechts");
                    aktuellePosition = new Coordinate(aktuellePosition.getX() + 1, aktuellePosition.getY());
                } else {
                    break;
                }

            }

            while (aktuellePosition.getX() > endPosition.getX()) {

                if(aktuellePosition.getX() - 1 >= 0 && board[aktuellePosition.getX() - 1][aktuellePosition.getY()]){
                    results.add("links");
                    aktuellePosition = new Coordinate(aktuellePosition.getX() - 1, aktuellePosition.getY());
                } else {
                    break;
                }
            }

            while(aktuellePosition.getY() < endPosition.getY()){

                if (aktuellePosition.getY() + 1 < board[aktuellePosition.getX()].length && board[aktuellePosition.getX()][aktuellePosition.getY() +1]){
                    results.add("runter");
                    aktuellePosition = new Coordinate(aktuellePosition.getX(), aktuellePosition.getY() + 1);
                } else {
                    break;
                }
            }

            while(aktuellePosition.getY() > endPosition.getY()){

                if(aktuellePosition.getY() - 1 >=0 && board[aktuellePosition.getX()][aktuellePosition.getY() -1]){
                    results.add("rauf");
                    aktuellePosition = new Coordinate(aktuellePosition.getX(), aktuellePosition.getY() - 1);
                } else {
                    break;
                }

            }
        }
        return results;
    }
}
