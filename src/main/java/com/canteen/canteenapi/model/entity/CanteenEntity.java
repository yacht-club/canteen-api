package com.canteen.canteenapi.model.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "canteen", schema = "canteen")
public class CanteenEntity {

    private Integer id;
    private UUID canteenUid = UUID.randomUUID();
    private String name;
    private String location;
    private Instant workFromMillis;
    private Instant workTillMillis;
    private Set<DishEntity> dishes = new HashSet();

    public CanteenEntity() {
    }

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Integer getId() {
        return id;
    }

    public CanteenEntity setId(Integer id) {
        this.id = id;
        return this;
    }

    @Type(type = "pg-uuid")
    @Column(name = "external_id", nullable = false)
    public UUID getCanteenUid() {
        return canteenUid;
    }

    public CanteenEntity setCanteenUid(UUID canteenUid) {
        this.canteenUid = canteenUid;
        return this;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public CanteenEntity setName(String name) {
        this.name = name;
        return this;
    }

    @Column(name = "location", nullable = false)
    public String getLocation() {
        return location;
    }

    public CanteenEntity setLocation(String location) {
        this.location = location;
        return this;
    }

    @Column(name = "working_hours_start", nullable = false)
    public Instant getWorkFromMillis() {
        return workFromMillis;
    }

    public CanteenEntity setWorkFromMillis(Instant workFromMillis) {
        this.workFromMillis = workFromMillis;
        return this;
    }

    @Column(name = "working_hours_end", nullable = false)
    public Instant getWorkTillMillis() {
        return workTillMillis;
    }

    public CanteenEntity setWorkTillMillis(Instant workTillMillis) {
        this.workTillMillis = workTillMillis;
        return this;
    }

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "canteen_dish",
            joinColumns = {@JoinColumn(name = "canteen_id")},
            inverseJoinColumns = {@JoinColumn(name = "dish_id")},
            schema = "canteen"
    )
    public Set<DishEntity> getDishes() {
        return dishes;
    }

    public CanteenEntity setDishes(Set<DishEntity> dishes) {
        this.dishes = dishes;
        return this;
    }

    public CanteenEntity copy(CanteenEntity entity) {
        this.canteenUid = entity.getCanteenUid();
        this.dishes = entity.getDishes();
        this.location = entity.getLocation();
        this.name = entity.getName();
        this.workFromMillis = entity.getWorkFromMillis();
        this.workTillMillis = entity.getWorkTillMillis();
        return this;
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
