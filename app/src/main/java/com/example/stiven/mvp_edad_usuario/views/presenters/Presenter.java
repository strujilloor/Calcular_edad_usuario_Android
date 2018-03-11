package com.example.stiven.mvp_edad_usuario.views.presenters;

import com.example.stiven.mvp_edad_usuario.domain.IInteractorOperations;
import com.example.stiven.mvp_edad_usuario.domain.InteractorOperations;
import com.example.stiven.mvp_edad_usuario.views.activities.IView;

/**
 * Created by stiven on 10/03/2018.
 */

public class Presenter implements IPresenter {

    private IView view;
    private IInteractorOperations operaciones;

    public Presenter(IView view) {
        this.view = view;
        operaciones = new InteractorOperations();
    }

    @Override
    public void calcularEdad(String fechaNacimiento) {
        try {
            view.mostrarLoading();
            int result = operaciones.calcularEdad(fechaNacimiento);
            view.ocultarLoading();
            view.mostrarResultado(result + " Años");
        } catch (Exception e) {
            view.mostrarError(e.getMessage());
        }
    }

    @Override
    public void concatenarNombre(String nombres, String apellidos) {
        try {
            view.mostrarLoading();
            String result = operaciones.concatenarNombre(nombres, apellidos);
            view.ocultarLoading();
            view.mostrarResultado(result + " Tiene");
        } catch (Exception e) {
            view.mostrarError(e.getMessage());
        }
    }
}
