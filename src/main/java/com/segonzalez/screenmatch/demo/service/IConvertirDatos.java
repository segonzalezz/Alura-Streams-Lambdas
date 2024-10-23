package com.segonzalez.screenmatch.demo.service;

public interface IConvertirDatos {
    <T> T obtenerDatos_(String json, Class<T> clase);
}
