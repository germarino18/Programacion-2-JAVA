package org.example.Service;

import java.util.List;

import org.example.DAO.PedidoDAOImpl;
import org.example.DAO.ProductoDAOImpl;
import org.example.model.Pedido;
import org.example.model.Producto;
import org.example.model.ItemPedido;
import org.hibernate.Session;

public class PedidoServiceImpl implements GenericService<Pedido> {

    private final PedidoDAOImpl pedidoDAO = new PedidoDAOImpl();
    private final ProductoDAOImpl productoDAO = new ProductoDAOImpl();

    @Override
    public boolean crear(Pedido pedido) {
        // Validar que haya al menos un ítem
        if (pedido.getItems() == null || pedido.getItems().isEmpty()) {
            System.out.println("El pedido debe tener al menos un ítem.");
            return false;
        }

        double total = 0.0;

        try (Session session = PedidoDAOImpl.getSessionFactory().openSession()) {
            session.beginTransaction();

            // Validar y procesar cada ítem
            for (ItemPedido item : pedido.getItems()) {
                // Validar cantidad > 0
                if (item.getCantidad() <= 0) {
                    System.out.println("La cantidad de cada ítem debe ser mayor a cero.");
                    session.getTransaction().rollback();
                    return false;
                }

                // Validar existencia del producto y stock
                Producto producto = session.get(Producto.class, item.getProducto().getId());
                if (producto == null) {
                    System.out.println("El producto con ID " + item.getProducto().getId() + " no existe.");
                    session.getTransaction().rollback();
                    return false;
                }
                if (producto.getCantidad() < item.getCantidad()) {
                    System.out.println("Stock insuficiente para el producto: " + producto.getNombre());
                    session.getTransaction().rollback();
                    return false;
                }
                producto.setCantidad(producto.getCantidad() - item.getCantidad());
                session.merge(producto);

                double subtotal = producto.getPrecio() * item.getCantidad();
                item.setSubtotal(subtotal);
                item.setPedido(pedido);
                session.persist(item);

                total += subtotal;
            }

            pedido.setTotal(total);
            pedido.setFecha(java.time.LocalDate.now());
            session.persist(pedido);

            session.getTransaction().commit();
            System.out.println("Pedido creado correctamente. Total: " + total);
            return true;
        } catch (Exception e) {
            System.err.println("Error al crear el pedido: " + e.getMessage());
            return false;
        }
    }

    public void mostrarDetallePedido(int pedidoId) {
        try (Session session = PedidoDAOImpl.getSessionFactory().openSession()) {
            String hql = "SELECT i FROM ItemPedido i "
                       + "JOIN FETCH i.producto p "
                       + "JOIN FETCH p.categoria "
                       + "WHERE i.pedido.id = :pedidoId";
            List<ItemPedido> items = session.createQuery(hql, ItemPedido.class)
                    .setParameter("pedidoId", pedidoId)
                    .getResultList();

            if (items.isEmpty()) {
                System.out.println("No se encontró el pedido o no tiene ítems.");
                return;
            }

            double total = 0.0;
            System.out.println("Detalle del pedido #" + pedidoId + ":");
            for (ItemPedido item : items) {
                String nombreProducto = item.getProducto().getNombre();
                String nombreCategoria = item.getProducto().getCategoria().getNombre();
                int cantidad = item.getCantidad();
                double subtotal = item.getSubtotal();
                total += subtotal;
                System.out.printf("Producto: %s | Categoría: %s | Cantidad: %d | Subtotal: %.2f%n",
                        nombreProducto, nombreCategoria, cantidad, subtotal);
            }
            System.out.println("Total general: " + total);
        } catch (Exception e) {
            System.err.println("Error al mostrar el detalle del pedido: " + e.getMessage());
        }
    }
}
