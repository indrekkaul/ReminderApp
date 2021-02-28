package presistance;

import util.DBUtil;

import javax.persistence.EntityManager;

public class ListElementLocationRepository {
    private EntityManager entityManager;

    public ListElementLocationRepository() {
        entityManager = DBUtil.getEntityManager();
    }

    public void save(ListElementLocationRepository listElementLocationRepository){
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(listElementLocationRepository);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
        }
    }

    public void update(ListElementLocationRepository listElementLocation){
        try{
            entityManager.getTransaction().begin();
            entityManager.merge(listElementLocation);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
        }
    }

    public void delete(ListElementLocationRepository listElementLocation){
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(listElementLocation);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
        }
    }
}
