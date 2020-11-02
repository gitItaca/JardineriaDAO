package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import model.Pedido;

public class PedidoDao implements Dao<Pedido>{
	
	private static List<Pedido> pedidos = new ArrayList<>();
	
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
	public void update(Pedido pedido) {
	
		pedidos.get(pedido.getCodigo_pedido()).setFecha_pedido(pedido.getFecha_pedido());
		pedidos.get(pedido.getCodigo_pedido()).setFecha_esperada(pedido.getFecha_esperada());
		pedidos.get(pedido.getCodigo_pedido()).setFecha_entrega(pedido.getFecha_entrega());
		pedidos.get(pedido.getCodigo_pedido()).setEstado(pedido.getEstado());
		pedidos.get(pedido.getCodigo_pedido()).setComentarios(pedido.getComentarios());
		pedidos.get(pedido.getCodigo_pedido()).setCodigo_cliente(pedido.getCodigo_cliente());
		
		//pedidos.add(pedido);
	}

	@Override
	public void delete(Pedido pedido) {
		pedidos.remove(pedido);
	}

}
