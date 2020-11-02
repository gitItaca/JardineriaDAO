package utils;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import dao.ClienteDao;
import dao.PedidoDao;
import model.Cliente;
import model.Pedido;

public class OperacionesPedido {

	public static Pedido crearPedido(int id_pedido, Calendar f_pedido, Calendar f_esperada, Calendar f_entrega, int id_cliente) throws Exception{
		
		
		Calendar fechaActual = new GregorianCalendar();
		Calendar fechaMinimaEsperada = f_pedido;
		fechaMinimaEsperada.add(Calendar.DAY_OF_MONTH, 3);		
		
		//Comprobar la fecha actual del pedido.
		if(f_pedido != fechaActual) {
			throw new Exception("La fecha del pedido tiene que ser el día de hoy.");
		}
		//Comprobar la fecha esperada del pedido.
		if(f_esperada.before(fechaMinimaEsperada)) {
			throw new Exception("La fecha de entrega esperada no puede ser anterior a tres días después de la fecha de creación.");
		}		
		//Comprobar el codigo del cliente.
		PedidoDao pDao = new PedidoDao();
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
		//Guardar el pedido
		//pDao.save(pedido);
		return new Pedido(id_pedido, f_pedido, f_esperada, f_entrega, id_cliente);
	}
	

	
}
