package presistance;

import model.User;
import util.DBUtil;

import javax.persistence.EntityManager;

public class UserLoginRepository {
    private EntityManager entityManager;

    public UserLoginRepository(){
        this.entityManager = DBUtil.getEntityManager();

    }

    public User searchUser(User user){
        String sql = "from User as st where st.user_email = :name";

        User user1 = entityManager.createNamedQuery(sql,User.class)
                .setParameter("name" , user.getUserEmail())
                .getSingleResult();
        return user1;

    }

}
