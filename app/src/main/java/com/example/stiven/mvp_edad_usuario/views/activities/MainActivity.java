package com.example.stiven.mvp_edad_usuario.views.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.stiven.mvp_edad_usuario.R;
import com.example.stiven.mvp_edad_usuario.views.presenters.IPresenter;
import com.example.stiven.mvp_edad_usuario.views.presenters.Presenter;

import net.danlew.android.joda.JodaTimeAndroid;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements IView{

    @BindView(R.id.etNombres)
    EditText etNombres;

    @BindView(R.id.etApellidos)
    EditText etApellidos;

    @BindView(R.id.etNacimiento)
    EditText etNacimiento;

    @BindView(R.id.btnRegistrar)
    Button btnRegistrar;

    private IPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        JodaTimeAndroid.init(this);

        presenter = new Presenter(this);
    }

    @Override
    public void mostrarLoading() {
        Log.i("MainActivity", "Mostrando Loading...");
    }

    @Override
    public void ocultarLoading() {
        Log.i("MainActivity", "Ocultando Loading...");
    }

    @Override
    public void mostrarError(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.btnRegistrar)
    public void onClickCalcularEdad() {
        String fechaNacimiento = etNacimiento.getText().toString();
        String nombres = etNombres.getText().toString();
        String apellidos = etApellidos.getText().toString();
        presenter.concatenarNombre(nombres, apellidos);
        presenter.calcularEdad(fechaNacimiento);
    }

    @Override
    public void mostrarResultado(String result) {
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
    }
}
