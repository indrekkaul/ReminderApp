package presistance;

import model.ToDoList;
import util.DBUtil;

import javax.persistence.EntityManager;

public class ToDoListRepository {
    private EntityManager entityManager;

    public ToDoListRepository(){
        entityManager = DBUtil.getEntityManager();
    }

    public void save(ToDoList toDoListRepository){
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(toDoListRepository);
            entityManager.getTransaction().commit();;
        }catch (Exception e){
            entityManager.getTransaction().rollback();
        }
    }

    public void update(ToDoListRepository toDoListRepository){
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(toDoListRepository);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
        }
    }

    public void delete(ToDoListRepository toDoListRepository){
        try{
            entityManager.getTransaction().begin();
            entityManager.remove(toDoListRepository);
            entityManager.getTransaction().commit();
        } catch (Exception e){
            entityManager.getTransaction().rollback();
        }
    }

}
