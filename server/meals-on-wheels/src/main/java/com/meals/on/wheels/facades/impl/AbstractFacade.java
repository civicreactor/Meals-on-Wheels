package com.meals.on.wheels.facades.impl;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractFacade {

    @Autowired
    protected Mapper mapper;

}
