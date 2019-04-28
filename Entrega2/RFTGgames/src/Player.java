import java.util.ArrayList;
import java.util.List;

public class Player {

	private int puntaje;
	private String usuario;
	private ArrayList<Card> mano;
	private ArrayList<Card> tablero;
		
	
	public Player(String usuario) {
		this.usuario = usuario;
		this.puntaje = 0;
		this.mano = new ArrayList<Card>();
		this.tablero = new ArrayList<Card>();
		//tablero.add(mundoBase);
	}
	
	public void agregarCartaAlaMano(Card c) {
		mano.add(c);
	}
	
	public void agregarCartaAltablero(Card c) {
		tablero.add(c);
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

	@Override
	public String toString() {
		return "Player [puntaje=" + puntaje + ", usuario=" + usuario + ", mano=" + mano + ", tablero=" + tablero + "]";
	}
	
}
