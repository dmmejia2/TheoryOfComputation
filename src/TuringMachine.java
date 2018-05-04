/**
 * 
 * @author Daniel Mejia
 * Theory of Computation: Turing Machine
 * Instructor: Dr. Kreinovich
 *
 */
public class TuringMachine {

	public static void main(String[] args){
		int tapeLength=8;
		int N = 2;
		int M = 2;
		int [][] state = new int[N][M];
		int [][] symbol = new int[N][M];
		char [][] lr = new char[N][M];
		int [] tape = new int[tapeLength];
		
		state[0][0] = 0;
		state[0][1] = 1;
		symbol[0][0] = 1;
		symbol[0][1] = 0;
		lr[0][0] = 'R';
		lr[0][1] = 'R';

		state[1][0] = 1;
		state[1][1] = 0;
		symbol[1][0] = 1;
		symbol[1][1] = 0;
		lr[1][0] = 'R';
		lr[1][1] = 'R';

		tape[0] = 1;
		tape[1] = 0;
		tape[2] = 0;
		tape[3] = 0;
		tape[4] = 0;
		tape[5] = 0;
		tape[6] = 0;
		tape[7] = 1;

		emulateTuring(N,M,state,symbol,lr,tape);






	}

	static void emulateTuring(int n, int m, int[][] state, int[][] symbol, char[][] lr, int[] tape){
		int currentLocation = 0;
		int count=1;

		int currentSymbol = tape[currentLocation];	
		int nextState = state[0][currentSymbol];
		char nextDirection = lr[0][currentSymbol];
		int writeCurrent = symbol[0][currentSymbol];

		System.out.println(nextDirection);;
		while(currentLocation<tape.length){


	
			currentSymbol = tape[currentLocation];
			nextDirection = lr[nextState][currentSymbol];
			writeCurrent = symbol[nextState][currentSymbol];
			tape[currentLocation] = writeCurrent;
			nextState = state[nextState][currentSymbol];	
			
			
			System.out.println("Count: "+count);
			System.out.println("TapeValue: "+tape[currentLocation]);
			System.out.println("ReplaceTapeValue: "+writeCurrent);
			System.out.println("NextState: "+nextState);
			System.out.println("Next Direction: "+nextDirection);
			System.out.println("");
			count++;
			if(nextDirection=='L'){
				currentLocation--;
				//return;
			}
			if(nextDirection=='R'){
				currentLocation++;
				//return;
			}
			if(nextDirection=='_'){
				System.out.println("STOP");
				return;

			}

		}
	}
}
