package com.example.api.demo.Services;

import org.hibernate.ObjectNotFoundException;

@FunctionalInterface
public interface ExceptionSupplier {
    ObjectNotFoundException get();
}