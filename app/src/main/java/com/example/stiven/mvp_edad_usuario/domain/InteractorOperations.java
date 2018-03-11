package com.example.stiven.mvp_edad_usuario.domain;

import android.util.Log;

import org.joda.time.Years;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by stiven on 10/03/2018.
 */

public class InteractorOperations implements IInteractorOperations {
    @Override
    public String concatenarNombre(String nombres, String apellidos) {
        return nombres + " " + apellidos;
    }

    @Override
    public int calcularEdad(String fechaNacimiento) {
        int edad = 0;
        String strFechaNac = fechaNacimiento;

        Date fechaNacDate = null;

        SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");

        try {
            fechaNacDate = formateador.parse(strFechaNac);
        }catch (java.text.ParseException e){
            e.printStackTrace();
        }

        Calendar fechaNacCalendar = new GregorianCalendar();
        fechaNacCalendar.setTime(fechaNacDate);

        Calendar hoy = Calendar.getInstance();

        int difAño = hoy.get(Calendar.YEAR) - fechaNacCalendar.get(Calendar.YEAR);
        int difMes = hoy.get(Calendar.MONTH) - fechaNacCalendar.get(Calendar.MONTH);
        int difDia = hoy.get(Calendar.DAY_OF_MONTH) - fechaNacCalendar.get(Calendar.DAY_OF_MONTH);
        edad = difAño;
        //Si está en ese año pero todavía no los ha cumplido
        if ( difMes < 0 || (difMes == 0 && difDia < 0) ){
            edad = edad - 1;
        }

        return edad;
    }
}
