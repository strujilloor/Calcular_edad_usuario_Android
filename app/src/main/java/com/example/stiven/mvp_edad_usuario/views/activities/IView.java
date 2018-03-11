package com.example.stiven.mvp_edad_usuario.views.activities;

/**
 * Created by stiven on 10/03/2018.
 */

public interface IView {

    void mostrarLoading();
    void ocultarLoading();
    void mostrarError(String msg);
    void onClickCalcularEdad();
    void mostrarResultado(String result);
}
