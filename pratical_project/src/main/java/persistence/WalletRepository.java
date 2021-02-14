package persistence;

import model.Wallet;
import util.DBUtil;

import javax.persistence.EntityManager;

public class WalletRepository {
    private EntityManager entityManager;

    public WalletRepository() {
        entityManager = DBUtil.getEntityManager();
    }

    public void saveWallet(Wallet wallet) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(wallet);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    public void updateWallet(Wallet wallet) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(wallet);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    public void deleteWallet(Wallet wallet) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(entityManager.merge(wallet));
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }
}