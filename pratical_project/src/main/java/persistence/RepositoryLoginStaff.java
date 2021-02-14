package persistence;

import model.Staff;
import util.DBUtil;

import javax.persistence.EntityManager;

public class RepositoryLoginStaff {
    private EntityManager entityManager;

    public RepositoryLoginStaff() {
        this.entityManager = DBUtil.getEntityManager();

    }

    public Staff searchUser(Staff staff) {
        String sql = "from Staff as st where st.userName = :name";

        Staff staff1 = entityManager.createQuery(sql,Staff.class).setParameter("name" , staff.getUsername()).getSingleResult();
        return staff1;



    }
}

