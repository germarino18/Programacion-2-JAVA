package org.example.DAO;

import java.util.List;

import org.example.model.Producto;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ProductoDAOImpl implements GenericDAO<Producto>{

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
    public void crear(Producto producto) {
        // Implementación para crear un producto    
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(producto);
            session.getTransaction().commit();
            System.out.println("Producto creado correctamente: " + producto.getNombre());
        }catch (Exception e) {
            // Captura y muestra errores durante la operación.
            System.err.println("Error al intentar crear el producto: " + e.getMessage());
        }
    }

    @Override
    public Producto leer(int id) {
        // Implementación para leer un producto por ID
        try (Session session = sessionFactory.openSession()) {
            Producto producto = session.get(Producto.class, id);
            if (producto != null) {
                System.out.println("Producto encontrado: " + producto.getNombre());
                return producto;
            } else {
                System.out.println("No se encontró el producto con ID: " + id);
                return null;
            }
        } catch (Exception e) {
            // Captura y muestra errores durante la operación.
            System.err.println("Error al intentar leer el producto: " + e.getMessage());
            return null;
        }
    }

    @Override
    public void actualizar(Producto producto) {
        // Implementación para actualizar un producto
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            
            if (session.get(Producto.class, producto.getId()) != null) {
                // Actualiza los campos necesarios
                System.out.println("Actualizando producto: " + producto.getNombre());
                producto.setNombre("Arroz");
                producto.setDescripcion("Arroz integral");
                producto.setPrecio(200.0);
                producto.setCantidad(50);
                producto.setCategoria(producto.getCategoria());
                // Guarda los cambios
                session.merge(producto);
                System.out.println("Producto actualizado correctamente.");
            } else {
                System.out.println("No se encontró el producto con ID: " + producto.getId());
            }

            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Error al intentar actualizar el producto: " + e.getMessage());
        }
    }

    @Override
    public void eliminar(int id) {
        // Implementación para eliminar un producto por ID
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Producto producto = session.get(Producto.class, id);
            if (producto != null) {
                session.remove(producto);
                System.out.println("Producto eliminado correctamente: " + producto.getNombre());
            } else {
                System.out.println("No se encontró el producto con ID: " + id);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            // Captura y muestra errores durante la operación.
            System.err.println("Error al intentar eliminar el producto: " + e.getMessage());
        }
    }

    @Override
    public boolean existeNombre(String nombre) {
        // Implementación para verificar si un producto con el nombre dado existe
        List<Producto> productos;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            productos = session.createQuery("from Producto", Producto.class).getResultList();
            for (Producto producto : productos) {
                if (producto.getNombre().equalsIgnoreCase(nombre)) {
                    System.out.println("El nombre del producto existe: " + nombre);
                    return true; // Retorna true si el nombre existe
                }
            }
            return false;
        } catch (Exception e) {
            System.err.println("Error al verificar la existencia del nombre: " + e.getMessage());
            return false; // Retorna false en caso de error
        }
    }

    @Override
    public java.util.List<Producto> listar() {
        // Implementación para listar todos los productos
        List<Producto> productos;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            productos = session.createQuery("from Producto", Producto.class).getResultList();
            session.getTransaction().commit();
            System.out.println("Lista de productos obtenida correctamente.");
            return productos;
        } catch (Exception e) {
            System.err.println("Error al obtener la lista de productos: " + e.getMessage());
            return null; // Retorna null en caso de error
        }
    }

    public List<Producto> listarPorCategoria(int idCategoria) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM Producto p JOIN FETCH p.categoria c WHERE c.id = :idCategoria";
            return session.createQuery(hql, Producto.class)
                    .setParameter("idCategoria", idCategoria)
                    .getResultList();
        } catch (Exception e) {
            System.err.println("Error al listar productos por categoría: " + e.getMessage());
            return null;
        }   
    }

    public Producto mostrarProductoConCategoria(int id) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM Producto p JOIN FETCH p.categoria WHERE p.id = :id";
            return session.createQuery(hql, Producto.class)
                    .setParameter("id", id)
                    .uniqueResult();
        } catch (Exception e) {
            System.err.println("Error al mostrar producto con categoría: " + e.getMessage());
            return null;
        }
    }

}
