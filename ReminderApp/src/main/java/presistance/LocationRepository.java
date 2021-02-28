package presistance;

import util.DBUtil;

import javax.persistence.EntityManager;

public class LocationRepository {
    private EntityManager entityManager;

    public LocationRepository() {
        entityManager = DBUtil.getEntityManager();
    }

    public void save(LocationRepository locationRepository){
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(locationRepository);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
        }
    }

    public void update(LocationRepository locationRepository){
        try{
            entityManager.getTransaction().begin();
            entityManager.merge(locationRepository);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
        }
    }

    public void delete(LocationRepository locationRepository){
        try{
            entityManager.getTransaction().begin();
            entityManager.remove(locationRepository);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
        }
    }
}
