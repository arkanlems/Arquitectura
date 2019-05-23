package dataModel;

import javax.ejb.Local;

@Local
public interface ServicePagoLocal {
	public String insertarPago(Pagos pago);
}
