import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class GameLoop {
	
	public int turnos;
	public int VictoryPoints;
	
	public ArrayList<Player> jugadores = new ArrayList<Player>(4);
	
	public static Stack<Card> mazo = new Stack<Card>();
	public static ArrayList<Card> pozo = new ArrayList<Card>();
	
	public static void SetUpJuego() throws IOException {
		CardParser.cargarCartas(mazo);
		Collections.shuffle(mazo);		
		/*for (Card card : mazo) {
			System.out.println(card.toString());
		}*/

		//TODO:RECIBIR JUGADORES 
		Card temp;
		for (int i = 0; i < 4; i++) {
			Player p = new Player("jugador: "+ i);
			temp = mazo.pop();
			p.agregarCartaAltablero(temp);
			pozo.add(temp);
			darCartas(p,6);
			
			System.out.println(p);
			
		}
		System.out.println(mazo.size());
		
	}
	
	public static void darCartas(Player p,int cantidad)
	{
		if (cantidad>mazo.size()) {
			llenarMazo();
		}
		Card temp;
		for (int i = 0; i < cantidad; i++) {
			temp = mazo.pop();
			p.agregarCartaAlaMano(temp);
			pozo.add(temp);
		}
	}
	
	private static void llenarMazo() {
		mazo.addAll(pozo);
		Collections.shuffle(mazo);	
	}

	public static void main(String[] args) throws IOException {
		SetUpJuego();
	}
}
