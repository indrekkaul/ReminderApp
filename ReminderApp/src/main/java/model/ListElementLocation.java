package model;

import javax.persistence.*;

@Entity
public class ListElementLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ListElementLocationId;

    @ManyToOne
    @JoinColumn(name = "todoId")
    private ToDoList toDoList;

    @ManyToOne
    @JoinColumn(name = "shoplistid")
    private ShopList shopList;

    @ManyToOne
    @JoinColumn(name = "locationid")
    private Location location;

    public ListElementLocation() {
    }

    public ListElementLocation(int listElementLocationId, ToDoList toDoList, ShopList shopList, Location location) {
        ListElementLocationId = listElementLocationId;
        this.toDoList = toDoList;
        this.shopList = shopList;
        this.location = location;
    }

    @Override
    public String toString() {
        return "ListElementLocation{" +
                "ListElementLocationId=" + ListElementLocationId +
                ", toDoList=" + toDoList +
                ", shopList=" + shopList +
                ", location=" + location +
                '}';
    }

    public int getListElementLocationId() {
        return ListElementLocationId;
    }

    public void setListElementLocationId(int listElementLocationId) {
        ListElementLocationId = listElementLocationId;
    }

    public ToDoList getToDoList() {
        return toDoList;
    }

    public void setToDoList(ToDoList toDoList) {
        this.toDoList = toDoList;
    }

    public ShopList getShopList() {
        return shopList;
    }

    public void setShopList(ShopList shopList) {
        this.shopList = shopList;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
