package utils;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import dao.ClienteDao;
import model.Cliente;
import model.Pedido;

public class OperacionesPedido {

	
	public static Pedido crearPedido(int id_pedido, Calendar f_pedido, Calendar f_esperada, Calendar f_entrega, int id_cliente) throws Exception{
				
		Calendar fechaActual = new GregorianCalendar();
		Calendar fechaMinimaEsperada = new GregorianCalendar();
		fechaMinimaEsperada = f_pedido;
				
		//Comprobar la fecha actual del pedido.
		if((f_pedido.get(Calendar.DAY_OF_MONTH) == fechaActual.get(Calendar.DAY_OF_MONTH)) 
				&& (f_pedido.get(Calendar.MONTH) == fechaActual.get(Calendar.MONTH))
				&& (f_pedido.get(Calendar.YEAR) == f_pedido.get(Calendar.YEAR))) {			
		}else throw new Exception("La fecha del pedido tiene que ser el día de hoy.");
		//Comprobar la fecha esperada del pedido.
		fechaMinimaEsperada.add(Calendar.DAY_OF_MONTH, 3);
		if(f_esperada.before(fechaMinimaEsperada)) {
			throw new Exception("La fecha de entrega esperada no puede ser anterior a tres días después de la fecha de creación.");
		}		
		fechaMinimaEsperada.add(Calendar.DAY_OF_MONTH, -3);
		//Comprobar el codigo del cliente.
		ClienteDao cDao = new ClienteDao();
		boolean existeCliente = false;
		List <Cliente> clientesSaved = cDao.getAll();
		for (Cliente clienteSaved : clientesSaved) {
			if(id_cliente == clienteSaved.getCodigo_cliente()) {
				existeCliente = true;
			}
		}
		if(existeCliente == false) {
			throw new Exception("El cliente del pedido no existe en la base de datos.");
		}

		return new Pedido(id_pedido, f_pedido, f_esperada, f_entrega, id_cliente);
	}
	

	
}
