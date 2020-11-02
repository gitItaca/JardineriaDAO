package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import model.Cliente;

public class ClienteDao implements Dao<Cliente>{
	
	private List<Cliente> clientes = new ArrayList<>();

	public ClienteDao() {		
	}

	@Override
	public Optional<Cliente> get(long id) {
		return Optional.ofNullable(clientes.get((int) id));
	}

	@Override
	public List<Cliente> getAll() {
		return clientes;
	}

	@Override
	public void save(Cliente cliente) {
		clientes.add(cliente);
	}

	@Override
	public void update(Cliente cliente, String[] params) {
		clientes.get(cliente.getCodigo_cliente()).setCodigo_cliente(cliente.getCodigo_cliente());
		cliente.setNombre_cliente(Objects.requireNonNull(params [0], "Nombre cliente obligatorio"));
		cliente.setNombre_contacto(Objects.requireNonNull(params [1], "Nombre contacto obligatorio"));
		cliente.setApellido_contacto(Objects.requireNonNull(params [2], "Apellido contacto obligatorio"));
		cliente.setTelefono(Objects.requireNonNull(params [3]));
		cliente.setFax(Objects.requireNonNull(params [4]));
		cliente.setLinea_direccion1(Objects.requireNonNull(params [5]));
		cliente.setLinea_direccion2(Objects.requireNonNull(params [6]));
		cliente.setCiudad(Objects.requireNonNull(params [7]));
		cliente.setRegion(Objects.requireNonNull(params [8]));
		cliente.setPais(Objects.requireNonNull(params [9]));
		cliente.setCodigo_postal(Objects.requireNonNull(params [10]));
		clientes.get(cliente.getCodigo_cliente()).setCodigo_empleado_rep_ventas(cliente.getCodigo_empleado_rep_ventas());
		clientes.get(cliente.getCodigo_cliente()).setLimite_credito(cliente.getLimite_credito());
		
		clientes.add(cliente);
	}

	@Override
	public void delete(Cliente cliente) {
		clientes.remove(cliente);
	}

	
}
