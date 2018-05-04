/**
 * 
 * @author Daniel Mejia
 * Theory of Computation: Turing Machine (With Stacks)
 * Instructor: Dr. Kreinovich
 *
 */
import java.util.Stack;
public class TuringMachineStack {

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

		Stack<Integer> stackOne = new Stack<Integer>();
		Stack<Integer> stackTwo = new Stack<Integer>();
		for(int i=tape.length-1;i>0;i--){
			stackOne.push(tape[i]);
		}
		stackOne.push(-1);
		emulateTuring(N,M,state,symbol,lr,tape, stackOne, stackTwo);

		




	}

	static void emulateTuring(int n, int m, int[][] state, int[][] symbol, char[][] lr, int[] tape, Stack<Integer> firstStack, Stack<Integer> secondStack){
		int count=1;
		if(firstStack.isEmpty()){
			System.out.println("Empty Tape");
			return;
		}
		secondStack.push(firstStack.pop());
		if(secondStack.peek()==-1){
			secondStack.push(firstStack.pop());
		}
		int currentSymbol = secondStack.peek();//tape[currentLocation];	
		int nextState = state[0][currentSymbol];
		char nextDirection = lr[0][currentSymbol];
		int writeCurrent = symbol[0][currentSymbol];

		System.out.println(nextDirection);;
		while(!firstStack.isEmpty()&&!(firstStack.peek()==-1)){


			
			//currentSymbol = tape[currentLocation];
			currentSymbol = firstStack.peek();
			nextDirection = lr[nextState][currentSymbol];
			writeCurrent = symbol[nextState][currentSymbol];
			//tape[currentLocation] = writeCurrent;
			firstStack.pop();
			firstStack.push(currentSymbol);
			nextState = state[nextState][currentSymbol];	
			
			
			System.out.println("TapeValue: "+firstStack.peek());
			System.out.println("ReplaceTapeValue: "+writeCurrent);
			System.out.println("NextState: "+nextState);
			System.out.println("Next Direction: "+nextDirection);
			System.out.println("");
			if(nextDirection=='L'){
				firstStack.push(secondStack.pop());
				//return;
			}
			if(nextDirection=='R'){
				secondStack.push(firstStack.pop());
				if(firstStack.isEmpty()){
					firstStack.push(-1);
				}
				//return;
			}
			if(nextDirection=='_'){
				System.out.println("STOP");
				return;

			}

		}
	}
}
