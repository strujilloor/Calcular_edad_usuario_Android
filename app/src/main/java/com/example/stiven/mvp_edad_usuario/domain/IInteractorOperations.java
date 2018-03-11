package com.example.stiven.mvp_edad_usuario.domain;

/**
 * Created by stiven on 10/03/2018.
 */

public interface IInteractorOperations {

    String concatenarNombre(String nombres, String apellidos);
    int calcularEdad(String fechaNacimiento);
}
