package persistence;

import model.Wallet;
import util.DBUtil;

import javax.persistence.EntityManager;

public class WalletRepository {
    private EntityManager entityManager;

    public WalletRepository() {
        entityManager = DBUtil.getEntityManager();
    }

    public void save(Wallet wallet) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(wallet);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    public void update(Wallet wallet) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(wallet);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    public void delete(Wallet wallet) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(entityManager.merge(wallet));
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }
}
