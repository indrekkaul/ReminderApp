package presistance;

import model.User;
import util.DBUtil;

//import javax.persistence.EntityManager;
import javax.persistence.EntityManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserRepository {

    private EntityManager entityManager;
    private Connection connection;
    private PreparedStatement pst;

public UserRepository() { entityManager= DBUtil.getEntityManager();
}

public void saveUser(User userRepository){
    try{
        entityManager.getTransaction().begin();
        entityManager.persist(userRepository);
        entityManager.getTransaction().commit();
    }catch (Exception e){
        entityManager.getTransaction().rollback();
    }
}

/*public void update(UserRepository userRepository){
    try{
        entityManager.getTransaction().begin();
        entityManager.merge(userRepository);
        entityManager.getTransaction().commit();
    }catch (Exception e){
        entityManager.getTransaction().rollback();
    }
}

public void delete(UserRepository userRepository){
    try{
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager);
        entityManager.getTransaction().commit();
    }catch (Exception e){
        entityManager.getTransaction().rollback();
    }
}*/
}
