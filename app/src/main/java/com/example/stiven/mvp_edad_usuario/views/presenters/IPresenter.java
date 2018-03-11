package com.example.stiven.mvp_edad_usuario.views.presenters;

/**
 * Created by stiven on 10/03/2018.
 */

public interface IPresenter {
    void calcularEdad(String fechaNacimiento);
    void concatenarNombre(String nombres, String apellidos);
}
