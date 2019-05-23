import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {

	private int puntaje;
	private String usuario;
	private ArrayList<Card> mano;
	private ArrayList<Card> tablero;
	private int faseEscogida;
	private int poderMilitar;
		
	
	public Player(String usuario) {
		this.usuario = usuario;
		this.puntaje = 0;
		this.mano = new ArrayList<Card>();
		this.tablero = new ArrayList<Card>();
		this.faseEscogida = 0;
		this.poderMilitar = 0;
		//tablero.add(mundoBase);
	}
	
	public void agregarCartaAlaMano(Card c) {
		mano.add(c);
	}
	
	public void agregarCartaAltablero(Card c) {
		tablero.add(c);
	}	
	
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public int getPoderMilitar() {
		return poderMilitar;
	}

	public void setPoderMilitar(int poderMilitar) {
		this.poderMilitar = poderMilitar;
	}

	public String getId() {
		return usuario;
	}
	public void setId(String id) {
		this.usuario = id;
	}
	public int getPuntaje() {
		return puntaje;
	}
	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}
	public List<Card> getMano() {
		return mano;
	}
	public void setMano(ArrayList<Card> mano) {
		this.mano = mano;
	}
	public List<Card> getTablero() {
		return tablero;
	}
	public void setTablero(ArrayList<Card> tablero) {
		this.tablero = tablero;
	}
	public int getFaseEscogida() {
		return faseEscogida;
	}
	public void setFaseEscogida(int faseEscogida) {
		this.faseEscogida = faseEscogida;
	}

	@Override
	public String toString() {
		return "Player [puntaje=" + puntaje + ", usuario=" + usuario + ", mano=" + mano + ", tablero=" + tablero + "]";
	}

	public Card descartarCarta() {
		System.out.println("Seleccione una carta de su mano para desechar");
		for (int i = 0; i < mano.size(); i++) {
			System.out.println("Carta "+ (i+1)+ ": "+mano.get(i).getNombre());
		}
		Scanner sc = new Scanner(System.in);
		int temp = sc.nextInt()-1;
		Card carta = mano.get(temp);
		mano.remove(carta);
		return carta;
	}

	public int seleccionarFase() {
		System.out.println("Seleccione la fase a jugar");
		Scanner sc = new Scanner(System.in);
		int str = sc.nextInt();		
		return str;
	}

	public boolean skip() {
		System.out.println("Desea saltarse esta fase? (true false)");
		Scanner sc = new Scanner(System.in);
		boolean bool = sc.nextBoolean();		
		return bool;		
	}

	public Card escogerCarta() {
		System.out.println("Seleccione la carta de su mano que desea jugar");
		for (int i = 0; i < mano.size(); i++) {
			System.out.println("Carta "+ (i+1)+ ": "+mano.get(i).getNombre());
		}
		Scanner sc = new Scanner(System.in);
		int temp = sc.nextInt()-1;
		Card carta = mano.get(temp);
		mano.remove(carta);
		return carta;		
	}

	public void ManoCartaAltablero(Card carta) {
		mano.remove(carta);
		tablero.add(carta);
	}

	public Card bonusWindfall() 
	{		
		System.out.println("Seleccione la carta Windfall de su mano que desea jugar");
		for (int i = 0; i < mano.size(); i++) {
			if (mano.get(i).isEsWindfall()) {
				System.out.println("Carta "+ (i+1)+ ": "+mano.get(i).getNombre());	
			}			
		}
		Scanner sc = new Scanner(System.in);
		int temp = sc.nextInt()-1;
		Card carta = mano.get(temp);
		mano.remove(carta);
		return carta;		
	}

	public boolean hasWindafall() {
		for (Card card : mano) {
			if (card.isEsWindfall() && (card.getBienes().equals(null))) {
				return true;
			}
		}
		return false;
	}

	public boolean producirRecursos() {
		for (Card card : tablero) {
			if (card.getBienes().equals(null) && card.getPoderes().containsKey(6)) {
				return true;
			}
		}
		return false;
	}
	
}
