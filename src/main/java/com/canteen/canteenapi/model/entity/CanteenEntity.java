package com.canteen.canteenapi.model.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "canteens", schema = "canteen")
public class CanteenEntity {

    private Integer id;
    private UUID canteenUid = UUID.randomUUID();
    private String name;
    private String location;
    private Instant workFromMillis;
    private Instant workTillMillis;

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
    @Column(name = "ext_id", nullable = false)
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

    public CanteenEntity copy(CanteenEntity entity) {
        this.canteenUid = entity.getCanteenUid();
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
