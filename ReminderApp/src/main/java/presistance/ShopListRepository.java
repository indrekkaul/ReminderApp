package presistance;

import util.DBUtil;

import javax.persistence.EntityManager;

public class ShopListRepository {
    private EntityManager entityManager;

    public ShopListRepository(){
        entityManager = DBUtil.getEntityManager();
    }

    public void save(ShopListRepository shopListRepository){
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(shopListRepository);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
        }
    }

    public void update(ShopListRepository shopListRepository){
        try{
            entityManager.getTransaction().begin();
            entityManager.merge(shopListRepository);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
        }
    }

    public void delete(ShopListRepository shopListRepository){
        try{
            entityManager.getTransaction().begin();
            entityManager.remove(shopListRepository);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
        }
    }
}
