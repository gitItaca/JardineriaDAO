package aplicacion;

import java.util.Calendar;
import java.util.GregorianCalendar;

import dao.ClienteDao;
import dao.PedidoDao;
import model.Cliente;
import model.Pedido;
import utils.OperacionesCliente;
import utils.OperacionesPedido;

public class App {

	public static void main(String[] args) {

		ClienteDao cDao = new ClienteDao();
		
		try {
			cDao.save(OperacionesCliente.crearCliente(50, "Manuel", "Ros", "607525252"));
			cDao.save(OperacionesCliente.crearCliente(10, "Victor", "Pot", "222525252"));
			cDao.save(OperacionesCliente.crearCliente(50, "Sonia", "Ros", "562525252"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			cDao.save(OperacionesCliente.crearCliente(6, "Sofia", "Brian", "607525252"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			cDao.save(OperacionesCliente.crearCliente(7, "Nacho", "Brian", "777856242"));
			cDao.save(OperacionesCliente.crearCliente(51, "Sonia", "Ros", "562523552"));
			cDao.save(OperacionesCliente.crearCliente(52, "Sonia", "Ros", "662523552"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		for (Cliente cliente : cDao.getAll()) {
			System.out.println(cliente);
		}
		
		PedidoDao pDao = new PedidoDao();
		Calendar today = new GregorianCalendar();
		Calendar day1 = new GregorianCalendar();
		day1.add(Calendar.DAY_OF_MONTH, 4);
		Calendar day2 = new GregorianCalendar();
		day2.add(Calendar.DAY_OF_MONTH, 6);
		Calendar day3 = new GregorianCalendar();
		day3.add(Calendar.DAY_OF_MONTH, 2);
		
		try {
			pDao.save(OperacionesPedido.crearPedido(10, today, day1, day2, 10));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		for (Pedido pedido : pDao.getAll()) {
			System.out.println(pedido);
		}
	}//FIN MAIN

}
