import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class CardParser {

	public static Boolean booleanizer(String fk) {
		if (fk.equals("1")) {
			return true;
		} else {
			return false;
		}
	}

	public static void cargarCartas(Stack<Card> mazo) throws IOException 
	{
		Scanner input = new Scanner(new File("Cartas.txt"));
		while (input.hasNextLine()) 
		{
			Card carta = new Card();
			String card_prop = input.nextLine().trim();

			StringTokenizer st = new StringTokenizer(card_prop, ";");
			carta.setNombre(st.nextToken());
			carta.setCosto(Integer.parseInt(st.nextToken()));
			carta.setPV(Integer.parseInt(st.nextToken()));
			carta.setEsMilitar(booleanizer(st.nextToken()));
			carta.setEsWindfall(booleanizer(st.nextToken()));
			carta.setEnInvestigacion(booleanizer(st.nextToken()));
			String pod = st.nextToken();
			StringTokenizer ste = new StringTokenizer(pod, ",;");
			HashMap<Integer,String> poderes= new HashMap<Integer,String>();
			int fase;
			String poder;
			while(ste.hasMoreTokens()) {
				fase=Integer.parseInt(ste.nextToken());
				poder=ste.nextToken();
				poderes.put(fase,poder);
			}
			carta.setPoderes(poderes);
			//System.out.println(carta);
			
			mazo.add(carta);
		}

	}
}
