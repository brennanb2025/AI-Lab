package com.brennan.ai;

import java.util.List;
import java.util.Random;

import com.briansea.gamecabinet.game.Game;
import com.briansea.gamecabinet.game.Move;
import com.briansea.gamecabinet.game.Player;

public class Ai extends Player {

	private MMNode node;
	public Ai() {
		
		node = new MMNode();
		// set my name
		this.nameProperty().set("Ay Aye AI");
	}
	
	public void makeMove(Game gamestate, List<Move> move) {
		List<List<Move>> validMoves = gamestate.getValidMoves();
		
		node.alphaBeta(5, 10);
		Random r = new Random();
		int pick = r.nextInt(validMoves.size());
		for( Move m : validMoves.get(pick)) {
			move.add(m);
		}
		
	}
	
	private class MMNode {
		public int alphaBeta(int alpha, int beta) {
			
			return 5;
			
		}
	}
}


//max node = alpha min node = beta

/*
void alphabeta(Node node, int depth, alpha, beta, boolean maximizingPlayer) { //just change attributes of nodes
	if(depth == 0 || node is a terminal node) {
		return the heuristic value of node;
	}
	if(maximizingPlayer) {
    	value := −∞;
	    for(each child of node) {
	        value = max(value, alphabeta(child, depth − 1, alpha, beta, FALSE))
	        alpha := max(alpha, value)
	        if(alpha ≥ beta) {
	            break (* beta cut-off *);
	        }
	    }
        return value;
    else {
	    value := +∞
	    for(each child of node) {
	        value := min(value, alphabeta(child, depth − 1, alpha, beta, TRUE))
	        beta := min(beta, value)
	        if(alpha ≥ beta) {
	            break (* alpha cut-off *);
	        }
	    }
		return value;
    }
}
	    		
	    		
(* Initial call *)
alphabeta(origin, depth, −∞, +∞, TRUE) */