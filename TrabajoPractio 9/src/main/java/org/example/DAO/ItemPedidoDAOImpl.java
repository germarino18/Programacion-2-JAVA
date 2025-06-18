package org.example.DAO;

import java.util.List;
import org.example.model.ItemPedido;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ItemPedidoDAOImpl implements GenericDAO<ItemPedido>{

    private static final SessionFactory sessionFactory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(org.example.model.Producto.class)
            .buildSessionFactory();

    // Método público para cerrar el SessionFactory al final de la app
    public static void closeSessionFactory() {
        sessionFactory.close();
        System.out.println("SessionFactory cerrado correctamente.");
    }

    @Override
    public void crear(ItemPedido itemPedido) {
        try (var session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(itemPedido);
            session.getTransaction().commit();
            System.out.println("ItemPedido creado correctamente: " + itemPedido.getId());
        } catch (Exception e) {
            // Captura y muestra errores durante la operación.
            System.err.println("Error al intentar crear el ItemPedido: " + e.getMessage());
        }
    }

    @Override
    public ItemPedido leer(int id) {
        ItemPedido itemPedido = null;
        try (var session = sessionFactory.openSession()) {
            itemPedido = session.get(ItemPedido.class, id);
            if (itemPedido != null) {
                System.out.println("ItemPedido encontrado: " + itemPedido.getId());
            } else {
                System.out.println("No se encontró el ItemPedido con ID: " + id);
            }
        } catch (Exception e) {
            // Captura y muestra errores durante la operación.
            System.err.println("Error al intentar leer el ItemPedido: " + e.getMessage());
        }
        return itemPedido;
    }

    @Override
    public void actualizar(ItemPedido itemPedido) {
        try (var session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.merge(itemPedido);
            session.getTransaction().commit();
            System.out.println("ItemPedido actualizado correctamente: " + itemPedido.getId());
        } catch (Exception e) {
            // Captura y muestra errores durante la operación.
            System.err.println("Error al intentar actualizar el ItemPedido: " + e.getMessage());
        }
    }

    @Override
    public void eliminar(int id) {
        try (var session = sessionFactory.openSession()) {
            session.beginTransaction();
            ItemPedido itemPedido = session.get(ItemPedido.class, id);
            if (itemPedido != null) {
                session.remove(itemPedido);
                session.getTransaction().commit();
                System.out.println("ItemPedido eliminado correctamente: " + id);
            } else {
                System.out.println("No se encontró el ItemPedido con ID: " + id);
            }
        } catch (Exception e) {
            // Captura y muestra errores durante la operación.
            System.err.println("Error al intentar eliminar el ItemPedido: " + e.getMessage());
        }
    }

    @Override
    public List<ItemPedido> listar() {
        List<ItemPedido> itemPedidos = null;
        try (var session = sessionFactory.openSession()) {
            itemPedidos = session.createQuery("from ItemPedido", ItemPedido.class).list();
            System.out.println("ItemPedidos listados correctamente.");
        } catch (Exception e) {
            // Captura y muestra errores durante la operación.
            System.err.println("Error al intentar listar los ItemPedidos: " + e.getMessage());
        }
        return itemPedidos;
    }

    @Override
    public boolean existeNombre(String nombre) {
        try (var session = sessionFactory.openSession()) {
            String hql = "SELECT COUNT(p) FROM ItemPedido p WHERE p.nombre = :nombre";
            long count = session.createQuery(hql, Long.class)
                    .setParameter("nombre", nombre)
                    .uniqueResult();
            return count > 0;
        } catch (Exception e) {
            // Captura y muestra errores durante la operación.
            System.err.println("Error al verificar si el ItemPedido existe: " + e.getMessage());
            return false;
        }
    }
}
