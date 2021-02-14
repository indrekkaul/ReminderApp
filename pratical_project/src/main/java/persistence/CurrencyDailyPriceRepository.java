package persistence;

import model.CurrencyDailyPrice;
import util.DBUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class CurrencyDailyPriceRepository {
    private EntityManager entityManager;

    public CurrencyDailyPriceRepository(){
        entityManager = DBUtil.getEntityManager();
    }

    public void save(CurrencyDailyPrice currencyDailyPrice){
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(currencyDailyPrice);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
        }
    }

    public void update(CurrencyDailyPrice currencyDailyPrice){
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(currencyDailyPrice);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
        }
    }

    public void delete(CurrencyDailyPrice currencyDailyPrice){
        try{
            entityManager.getTransaction().begin();
            entityManager.remove(entityManager.merge(currencyDailyPrice));
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
        }
    }

    public List<CurrencyDailyPrice> searchByCurrencyDailyPrice(CurrencyDailyPrice currencyDailyPrice){
        String sql = "FROM CurrencyDailyPrice AS cdp" +
                "WHERE cdp.currency.currencyId = :currencyId AND cdp.registerDate = :date";

        return entityManager.createQuery(sql).setParameter("currencyId", currencyDailyPrice.getCurrency().getCurrencyId())
                .setParameter("date", currencyDailyPrice.getRegisterDate()).getResultList();
    }


    public void updateNewPrice(CurrencyDailyPrice currencyDailyPrice){
        String sql = "UPDATE CurrencyInventory ci " +
                "SET ci.newPrice = :newPrice " +
                "WHERE ci.currencyDailyPriceId = :id" +
                "AND ci.lastUpdate = :lastUpdate";

        try {
            entityManager.getTransaction().begin();
            entityManager.createQuery(sql).setParameter("newPrice", currencyDailyPrice.getPrice())
                    .setParameter("id", currencyDailyPrice.getId());
            //update the parameter
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
        }
    }
}
