package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import model.Pedido;

public class PedidoDao implements Dao<Pedido>{
	
	private List<Pedido> pedidos = new ArrayList<>();
	
	public PedidoDao() {		
	}

	@Override
	public Optional<Pedido> get(long id) {
		return Optional.ofNullable(pedidos.get((int) id));
	}

	@Override
	public List<Pedido> getAll() {
		return pedidos;
	}

	@Override
	public void save(Pedido pedido) {
		pedidos.add(pedido);
	}

	@Override
	public void update(Pedido pedido, String[] params) {
		pedidos.get(pedido.getCodigo_pedido()).setCodigo_pedido(pedido.getCodigo_pedido());
		pedidos.get(pedido.getCodigo_pedido()).setFecha_pedido(pedido.getFecha_pedido());
		pedidos.get(pedido.getCodigo_pedido()).setFecha_esperada(pedido.getFecha_esperada());
		pedidos.get(pedido.getCodigo_pedido()).setFecha_entrega(pedido.getFecha_entrega());
		pedido.setEstado(Objects.requireNonNull(params [0]));
		pedido.setComentarios(Objects.requireNonNull(params [1]));
		pedidos.get(pedido.getCodigo_pedido()).setCodigo_cliente(pedido.getCodigo_cliente());
		
		pedidos.add(pedido);
	}

	@Override
	public void delete(Pedido pedido) {
		pedidos.remove(pedido);
	}

}
