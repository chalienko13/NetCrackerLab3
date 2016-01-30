package com.chalienko.hr.model;

import java.io.Serializable;

/**
 * Created by Chalienko on 29.01.2016.
 */
public abstract class Model implements Serializable {

    private static final long serialVersionUID = -5743090912999199238L;

    private Long id;

    public Model() {
    }

    public Model(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
