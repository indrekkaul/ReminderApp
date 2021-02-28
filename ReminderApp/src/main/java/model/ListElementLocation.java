package model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "list_element_location")
public class ListElementLocation {

    @ManyToOne
    @JoinColumn(name = "todo_id")
    private int todo_id;

    @ManyToOne
    @JoinColumn(name = "shop_list_id")
    private int shopListId;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private int locationId;

    public ListElementLocation() {
    }

    public ListElementLocation(int todo_id, int shopListId, int locationId) {
        this.todo_id = todo_id;
        this.shopListId = shopListId;
        this.locationId = locationId;
    }

    @Override
    public String toString() {
        return "ListElementLocation{" +
                "todo_id=" + todo_id +
                ", shopListId=" + shopListId +
                ", locationId=" + locationId +
                '}';
    }

    public int getTodo_id() {
        return todo_id;
    }

    public ListElementLocation setTodo_id(int todo_id) {
        this.todo_id = todo_id;
        return this;
    }

    public int getShopListId() {
        return shopListId;
    }

    public ListElementLocation setShopListId(int shopListId) {
        this.shopListId = shopListId;
        return this;
    }

    public int getLocationId() {
        return locationId;
    }

    public ListElementLocation setLocationId(int locationId) {
        this.locationId = locationId;
        return this;
    }
}
