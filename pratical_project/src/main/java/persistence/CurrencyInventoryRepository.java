package persistence;

import model.CurrencyDailyPrice;
import util.DBUtil;

import javax.persistence.EntityManager;

public class CurrencyInventoryRepository {

    private EntityManager entityManager;

    public CurrencyInventoryRepository() {
        entityManager = DBUtil.getEntityManager();
    }

    public void save(CurrencyInventoryRepository currencyInventoryRepository){
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(currencyInventoryRepository);
            entityManager.getTransaction().commit();
        } catch (Exception e){
            entityManager.getTransaction().rollback();
        }
    }

    public void updateNewPrice(CurrencyDailyPrice currencyDailyPrice){
        String sql = "UPDATE CurrencyInventory ci " +
                "SET ci.newPrice = :newPrice " +
                "WHERE ci.currencyDailyPriceId = :id";
        try {
            entityManager.getTransaction().begin();
            entityManager.createQuery(sql).setParameter("newPrice", currencyDailyPrice.getPrice())
                    .setParameter("id", currencyDailyPrice.getId());
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
        }
    }

    public void updateOldPriceWithCurrentNewPrice(CurrencyDailyPrice currencyDailyPrice){
        String sql = "UPDATE CurrencyInventory ci " +
                "SET ci.oldPrice = ci.newPrice " +
                "WHERE ci.currencyDailyPriceId = :id";

        try {
            entityManager.getTransaction().begin();
            entityManager.createQuery(sql).setParameter("id", currencyDailyPrice.getId());
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
        }
    }

    public void updateUpdatedIn(CurrencyDailyPrice currencyDailyPrice){
        String sql = "UPDATE CurrencyInventory ci " +
                "SET ci.updatedIn = :newDate " +
                "WHERE ci.currencyDailyPriceId = :id";

        try {
            entityManager.getTransaction().begin();
            entityManager.createQuery(sql).setParameter("newDate", currencyDailyPrice.getLastUpdate())
                    .setParameter("id", currencyDailyPrice.getId());
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
        }
    }
}
