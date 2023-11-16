package com.example.finalapp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@MappedSuperclass
public class AbstractJPAPersistable<T extends Serializable> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private T id;


    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractJPAPersistable<?> that = (AbstractJPAPersistable<?>) o;
        if (this.id == null) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public String toString() { return "Entity of type " + this.getClass().getSimpleName() +" with id: " + getId(); }
}
