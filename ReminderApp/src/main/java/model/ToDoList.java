package model;



import javax.persistence.*;


@Entity
@Table(name="todo_list")

public class ToDoList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "todo_id")
    private int todoId;

    @Column(name="todo_description")
    private String toDoDescription;

    @Override
    public String toString() {
        return "ToDoList{" +
                "todoId=" + todoId +
                ", toDoDescription='" + toDoDescription + '\'' +
                '}';
    }

    public ToDoList() {
    }

    public ToDoList(int todoId, String toDoDescription) {
        this.todoId = todoId;
        this.toDoDescription = toDoDescription;
    }

    public int getTodoId() {
        return todoId;
    }

    public ToDoList setTodoId(int todoId) {
        this.todoId = todoId;
        return this;
    }

    public String getToDoDescription() {
        return toDoDescription;
    }

    public ToDoList setToDoDescription(String toDoDescription) {
        this.toDoDescription = toDoDescription;
        return this;
    }
}
