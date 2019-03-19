package com.canteen.canteenapi.model.entity;

import com.canteen.canteenapi.model.DishCategory;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dish_categories", schema = "canteen")
public class DishCategoryEntity {

    @Id
    @Enumerated(EnumType.STRING)
    @Column(name = "name", nullable = false)
    private DishCategory category;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "order", nullable = false)
    private int order;

    public DishCategoryEntity() {
    }

    public DishCategory getCategory() {
        return category;
    }

    public DishCategoryEntity setCategory(DishCategory category) {
        this.category = category;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public DishCategoryEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public int getOrder() {
        return order;
    }

    public DishCategoryEntity setOrder(int order) {
        this.order = order;
        return this;
    }
}
