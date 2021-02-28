package model;

import javax.persistence.*;

@Entity
@Table(name="shop_list")
public class ShopList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shop_list_id")
    private int shopListId;

    @Column(name = "shop_list_description")
    private String shopListDescription;

    @Column (name = "shop_list_quantity")
    private int shopListQuantity;

    public ShopList() {
    }

    public ShopList(int shopListId, String shopListDescription, int shopListQuantity) {
        this.shopListId = shopListId;
        this.shopListDescription = shopListDescription;
        this.shopListQuantity = shopListQuantity;
    }

    public int getShopListId() {
        return shopListId;
    }

    public ShopList setShopListId(int shopListId) {
        this.shopListId = shopListId;
        return this;
    }

    public String getShopListDescription() {
        return shopListDescription;
    }

    public ShopList setShopListDescription(String shopListDescription) {
        this.shopListDescription = shopListDescription;
        return this;
    }

    public int getShopListQuantity() {
        return shopListQuantity;
    }

    public ShopList setShopListQuantity(int shopListQuantity) {
        this.shopListQuantity = shopListQuantity;
        return this;
    }

    @Override
    public String toString() {
        return "ShopList{" +
                "shopListId=" + shopListId +
                ", shopListDescription='" + shopListDescription + '\'' +
                ", shopListQuantity=" + shopListQuantity +
                '}';
    }
}
