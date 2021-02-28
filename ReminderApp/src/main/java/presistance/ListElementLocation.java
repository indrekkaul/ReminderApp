package presistance;

import util.DBUtil;

import javax.persistence.EntityManager;

public class ListElementLocation {
    private EntityManager entityManager;

    public ListElementLocation() {
        entityManager = DBUtil.getEntityManager();
    }

    public void save(ListElementLocation listElementLocation){
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(listElementLocation);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
        }
    }

    public void update(ListElementLocation listElementLocation){
        try{
            entityManager.getTransaction().begin();
            entityManager.merge(listElementLocation);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
        }
    }

    public void delete(ListElementLocation listElementLocation){
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(listElementLocation);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
        }
    }
}
