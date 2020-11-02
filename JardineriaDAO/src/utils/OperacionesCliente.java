package utils;

import java.util.List;

import dao.ClienteDao;
import model.Cliente;

public class OperacionesCliente {

	public static void crearCliente(Cliente cliente) throws Exception{
		
		Cliente clienteNuevo = cliente;
		ClienteDao cDao = new ClienteDao();
		List <Cliente> clientesSaved = cDao.getAll();
		
		//Comprobar la duplicidad de datos.
		for (Cliente clienteSaved : clientesSaved) {
			if (clienteNuevo.getCodigo_cliente() == clienteSaved.getCodigo_cliente()) 
			{
				throw new Exception("El código ya está siendo utilizado.");
			}else if (clienteNuevo.getNombre_contacto().equals(clienteSaved.getNombre_contacto()) && 
				clienteNuevo.getApellido_contacto().equals(clienteSaved.getApellido_contacto()) ||
				clienteNuevo.getTelefono().equals(clienteSaved.getTelefono()))  
			{
				throw new Exception("Se puede estar produciendo una duplicidad de datos.");
			}
		}
		//Guardar el cliente
		cDao.save(cliente);
		
	}
}

//Cliente cliente = new Cliente(50, "Manuel", "Ros", "607525252");
//Cliente cliente = new Cliente(codigo_cliente, nombre_cont, apellido_cont, telefono);
