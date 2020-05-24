package com.gamedroid;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;

import vista.Juego;

//Clase que hereda de la clase base AndroidApplication para la inicialización del videojuego. Esta dentro del modulo android

public class AndroidLauncher extends AndroidApplication {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
        config.useAccelerometer = false;
        config.useCompass = false;
        config.useWakelock = true;
        //he elimindado la config.GL20 true porque esta obsoleta y no se necesita
        //Se inicializa la clase encargada de ejecutar el videojuego.
        initialize(new Juego(), config);
    }
}
