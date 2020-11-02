package utils;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import dao.ClienteDao;
import dao.PedidoDao;
import model.Cliente;
import model.Pedido;

public class OperacionesPedido {

	public static void crearPedido(Pedido pedido) throws Exception{
		
		Pedido pedidoNuevo = pedido;
		Calendar fechaActual = new GregorianCalendar();
		Calendar fechaMinimaEsperada = pedidoNuevo.getFecha_pedido();
		fechaMinimaEsperada.add(Calendar.DAY_OF_MONTH, 3);		
		
		//Comprobar la fecha actual del pedido.
		if(pedidoNuevo.getFecha_pedido() != fechaActual) {
			throw new Exception("La fecha del pedido tiene que ser el día de hoy.");
		}
		//Comprobar la fecha esperada del pedido.
		if(pedidoNuevo.getFecha_esperada().before(fechaMinimaEsperada)) {
			throw new Exception("La fecha de entrega esperada no puede ser anterior a tres días después de la fecha de creación.");
		}		
		//Comprobar el codigo del cliente.
		PedidoDao pDao = new PedidoDao();
		ClienteDao cDao = new ClienteDao();
		boolean existeCliente = false;
		List <Cliente> clientesSaved = cDao.getAll();
		for (Cliente clienteSaved : clientesSaved) {
			if(pedidoNuevo.getCodigo_cliente() == clienteSaved.getCodigo_cliente()) {
				existeCliente = true;
			}
		}
		if(existeCliente == false) {
			throw new Exception("El cliente del pedido no existe en la base de datos.");
		}
		//Guardar el pedido
		pDao.save(pedido);
		
	}
	

	
}
