package com.canteen.canteenapi.model.entity;

import com.canteen.canteenapi.model.DishCategory;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "dishes", schema = "canteen")
public class DishEntity {

    private Integer id;
    private UUID dishUid = UUID.randomUUID();
    private Integer canteenId;
    private DishCategory category;
    private String name;
    private Integer price;
    private Integer weight;
    private Double calories;
    private Double proteins;
    private Double fats;
    private Double carbohydrates;

    public DishEntity() {
    }

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Integer getId() {
        return id;
    }

    public DishEntity setId(Integer id) {
        this.id = id;
        return this;
    }

    @Type(type = "pg-uuid")
    @Column(name = "ext_id", nullable = false)
    public UUID getDishUid() {
        return dishUid;
    }

    public DishEntity setDishUid(UUID dishUid) {
        this.dishUid = dishUid;
        return this;
    }

    public Integer getCanteenId() {
        return canteenId;
    }

    @Column(name = "canteen_id", nullable = false)
    public DishEntity setCanteenId(Integer canteenId) {
        this.canteenId = canteenId;
        return this;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "category", nullable = false)
    public DishCategory getCategory() {
        return category;
    }

    public DishEntity setCategory(DishCategory category) {
        this.category = category;
        return this;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public DishEntity setName(String name) {
        this.name = name;
        return this;
    }

    @Column(name = "price", nullable = false)
    public Integer getPrice() {
        return price;
    }

    public DishEntity setPrice(Integer price) {
        this.price = price;
        return this;
    }

    @Column(name = "weight", nullable = false)
    public Integer getWeight() {
        return weight;
    }

    public DishEntity setWeight(Integer weight) {
        this.weight = weight;
        return this;
    }

    @Column(name = "calories", nullable = false)
    public Double getCalories() {
        return calories;
    }

    public DishEntity setCalories(Double calories) {
        this.calories = calories;
        return this;
    }

    @Column(name = "proteins", nullable = false)
    public Double getProteins() {
        return proteins;
    }

    public DishEntity setProteins(Double proteins) {
        this.proteins = proteins;
        return this;
    }

    @Column(name = "fats", nullable = false)
    public Double getFats() {
        return fats;
    }

    public DishEntity setFats(Double fats) {
        this.fats = fats;
        return this;
    }

    @Column(name = "carbohydrates", nullable = false)
    public Double getCarbohydrates() {
        return carbohydrates;
    }

    public DishEntity setCarbohydrates(Double carbohydrates) {
        this.carbohydrates = carbohydrates;
        return this;
    }

    public DishEntity copy(DishEntity entity) {
        return this
                .setDishUid(entity.dishUid)
                .setProteins(entity.proteins)
                .setWeight(entity.weight)
                .setPrice(entity.price)
                .setName(entity.name)
                .setFats(entity.fats)
                .setCategory(entity.category)
                .setCarbohydrates(entity.carbohydrates)
                .setCalories(entity.calories);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o, false);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }
}
