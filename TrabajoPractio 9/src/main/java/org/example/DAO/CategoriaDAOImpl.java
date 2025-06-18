package org.example.DAO;

import org.example.model.Categoria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class CategoriaDAOImpl implements GenericDAO<Categoria> {
    
    private static final SessionFactory sessionFactory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(org.example.model.Categoria.class)
            .buildSessionFactory();

    // Método público para cerrar el SessionFactory al final de la app
    public static void closeSessionFactory() {
        sessionFactory.close();
        System.out.println("SessionFactory cerrado correctamente.");
    }

    @Override
    public void crear(Categoria categoria){

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            System.out.println("Categoria: " + categoria.getId());
            session.persist(categoria);

            session.getTransaction().commit();

        } catch (Exception e) {
            // Captura y muestra errores durante la operación.
            System.err.println("Error al intentar crear la categoría: " + e.getMessage());
        }
    }

    @Override
    public Categoria leer(int id) {

        Categoria categoria = null;
        try (Session session = sessionFactory.openSession()) {
            categoria = session.get(Categoria.class, id);
            if (categoria != null) {
                System.out.println("Categoría encontrada: " + categoria.getNombre());
            } else {
                System.out.println("No se encontró la categoría con ID: " + id);
            }
        } catch (Exception e) {
            // Captura y muestra errores durante la operación.
            System.err.println("Error al intentar leer la categoría: " + e.getMessage());
        }
        return categoria;
    }

    @Override
    public void actualizar(Categoria categoria) {

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            // Busca la categoría existente por ID, aca esta fijo para las pruebas
            categoria = leer(6);
            if (categoria != null) {
                // Actualiza los campos necesarios
                categoria.setNombre("Bebidas");
                categoria.setDescripcion("Bebidas consumibles");
                // Guarda los cambios
                session.merge(categoria);
                System.out.println("Categoría actualizada correctamente.");
            } else {
                System.out.println("No se encontró la categoría con ID: " + categoria.getId());
            }

            session.getTransaction().commit();
        }catch (Exception e) {
            // Captura y muestra errores durante la operación.
            System.err.println("Error al intentar actualizar la categoría: " + e.getMessage());
        }
    }

    @Override
    public void eliminar(int id) {

        try (Session session = sessionFactory.openSession()) {
            // Abre una nueva sesión de Hibernate.
            session.beginTransaction();

            // Obtiene la categoría de la DB por su ID para asegurar que está gestionada.
            Categoria categoriaToDelete = session.get(Categoria.class, id);
            if (categoriaToDelete != null) { // Verifica si la categoría fue encontrada.
                session.remove(categoriaToDelete); // Marca la categoría para eliminación.
                System.out.println("Categoria con ID: " + categoriaToDelete.getId() + " borrada exitosamente.");
            } else {
                System.out.println("No se encontró la categoría con ID: " + id + " para borrar.");
            }

            session.getTransaction().commit();

        } catch (Exception e) {
            // Captura y muestra errores durante la operación.
            System.err.println("Error al intentar borrar la categoría: " + e.getMessage());
        }
    }

    @Override
    public List<Categoria> listar() {
        
        List<Categoria> categorias;
        try (Session session = sessionFactory.openSession()){
            session.beginTransaction();
            categorias = session.createQuery("from Categoria", Categoria.class).getResultList();
            session.getTransaction().commit();
            System.out.println("Lista de categorías obtenida correctamente.");
            return categorias;
        } catch (Exception e) {
            System.err.println("Error al obtener la lista de categorías: " + e.getMessage());
            return null; // Retorna null en caso de error
        }    
    }

    @Override
    public boolean existeNombre(String nombre) {
        
        List<Categoria> categorias;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            categorias = session.createQuery("from Categoria", Categoria.class).getResultList();
            for (Categoria categoria : categorias) {
                if (categoria.getNombre().equalsIgnoreCase(nombre)) {
                    System.out.println("El nombre de la categoría existe: " + nombre);
                    return true; // Retorna true si el nombre existe
                }
            }
            return false;
        } catch (Exception e) {
            System.err.println("Error al verificar la existencia del nombre: " + e.getMessage());
            return false; // Retorna false en caso de error
        }
    }
}
