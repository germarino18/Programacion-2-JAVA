package org.example.DAO;

import java.util.List;

import org.example.model.Pedido;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PedidoDAOImpl implements GenericDAO<Pedido> {

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
    public void crear(Pedido pedido) {
        try (var session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(pedido);
            session.getTransaction().commit();
            System.out.println("Pedido creado correctamente: " + pedido.getId());
        } catch (Exception e) {
            // Captura y muestra errores durante la operación.
            System.err.println("Error al intentar crear el pedido: " + e.getMessage());
        }
    }

    @Override
    public Pedido leer(int id) {
        Pedido pedido = null;
        try (var session = sessionFactory.openSession()) {
            pedido = session.get(Pedido.class, id);
            if (pedido != null) {
                System.out.println("Pedido encontrado: " + pedido.getId());
            } else {
                System.out.println("No se encontró el pedido con ID: " + id);
            }
        } catch (Exception e) {
            // Captura y muestra errores durante la operación.
            System.err.println("Error al intentar leer el pedido: " + e.getMessage());
        }
        return pedido;
    }

    @Override
    public void actualizar(Pedido pedido) {
        try (var session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.merge(pedido);
            session.getTransaction().commit();
            System.out.println("Pedido actualizado correctamente: " + pedido.getId());
        } catch (Exception e) {
            // Captura y muestra errores durante la operación.
            System.err.println("Error al intentar actualizar el pedido: " + e.getMessage());
        }
    }

    @Override
    public void eliminar(int id) {
        try (var session = sessionFactory.openSession()) {
            session.beginTransaction();
            Pedido pedido = session.get(Pedido.class, id);
            if (pedido != null) {
                session.remove(pedido);
                session.getTransaction().commit();
                System.out.println("Pedido eliminado correctamente: " + id);
            } else {
                System.out.println("No se encontró el pedido con ID: " + id);
            }
        } catch (Exception e) {
            // Captura y muestra errores durante la operación.
            System.err.println("Error al intentar eliminar el pedido: " + e.getMessage());
        }
    }

    @Override
    public List<Pedido> listar() {
        List<Pedido> pedidos = null;
        try (var session = sessionFactory.openSession()) {
            pedidos = session.createQuery("from Pedido", Pedido.class).list();
            System.out.println("Pedidos listados correctamente.");
        } catch (Exception e) {
            // Captura y muestra errores durante la operación.
            System.err.println("Error al intentar listar los pedidos: " + e.getMessage());
        }
        return pedidos;
    }

    @Override
    public boolean existeNombre(String nombre) {
        try (var session = sessionFactory.openSession()) {
            String hql = "SELECT COUNT(p) FROM Pedido p WHERE p.nombre = :nombre";
            long count = session.createQuery(hql, Long.class)
                    .setParameter("nombre", nombre)
                    .uniqueResult();
            return count > 0;
        } catch (Exception e) {
            // Captura y muestra errores durante la operación.
            System.err.println("Error al verificar si el pedido existe: " + e.getMessage());
            return false;
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
