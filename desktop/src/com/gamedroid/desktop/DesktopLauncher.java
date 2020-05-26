package com.gamedroid.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;

import vista.Juego;


//este el lanzador para la aplicacion de escritorio. Esta dentro de un modulo llamado desktop
//hay que incluir la ruta de la carpeta assets.

public class DesktopLauncher {
    public static void main(String[] arg) {
        new LwjglApplication(new Juego(), "Streets Of Dani", 480, 320); //el parametro true se lo quito ya que no lo necesita en esta version de GL20
    }
}
