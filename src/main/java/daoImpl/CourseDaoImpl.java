package daoImpl;

import dao.CourseDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import models.Course;

import java.util.List;

public class CourseDaoImpl implements CourseDao {

    private EntityManagerFactory emf;

    public CourseDaoImpl() {
        emf = Persistence.createEntityManagerFactory("default");
    }

    @Override
    public void addCourse(Course course) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(course);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public Course getCourse(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Course.class, id);
        } finally {
            em.close();
        }
    }

    @Override
    public List<Course> getAllCourses() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Course> query = em.createQuery("SELECT c FROM Course c", Course.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public void updateCourse(Course course) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(course);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public void deleteCourse(Course course) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Course managedCourse = em.merge(course);
            em.remove(managedCourse);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public void close() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}