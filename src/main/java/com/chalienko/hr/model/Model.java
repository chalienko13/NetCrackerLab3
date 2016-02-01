package com.chalienko.hr.model;

import java.io.Serializable;

/**
 * Created by Chalienko on 29.01.2016.
 */
public interface  Model extends Serializable {

    static final long serialVersionUID = -5743090912999199238L;

    public Long getId();

    public void setId(Long id);
}
