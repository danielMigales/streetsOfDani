package controlador;

import java.util.HashMap;
import java.util.Map;

import modelo.Mundo;
import modelo.Patrullero;

//esta clase controla los mandos, teclados, touch de la pantalla.  Actualmente solo esta programado caminar izquierda y derecha
public class ControladorPrincipal {

    enum Teclas {
        IZQUIERDA, DERECHA, SALTO, DISPARO
    }

    private Mundo ciudad;
    private Patrullero patrullero;
    static Map<Teclas, Boolean> teclas = new HashMap<>();

    static {
        teclas.put(Teclas.IZQUIERDA, false);
        teclas.put(Teclas.DERECHA, false);
        teclas.put(Teclas.SALTO, false);
        teclas.put(Teclas.DISPARO, false);
    }

    public ControladorPrincipal(Mundo mundo) {
        this.ciudad = mundo;
        this.patrullero = mundo.getDaniel();
    }

    // ** Actualización del mapa teclas ** //
    public void izquierdaPulsada() {
        teclas.put(Teclas.IZQUIERDA, true);
    }

    public void derechaPulsada() {
        teclas.put(Teclas.DERECHA, true);
    }

    public void saltoPulsada() {
        teclas.put(Teclas.SALTO, true);
    }

    public void disparoPulsado() {
        teclas.put(Teclas.DISPARO, false);
    }

    public void izquierdaLiberada() {
        teclas.put(Teclas.IZQUIERDA, false);
    }

    public void derechaLiberada() {
        teclas.put(Teclas.DERECHA, false);
    }

    public void saltoLiberada() {
        teclas.put(Teclas.SALTO, false);
    }

    public void disparoLiberada() {
        teclas.put(Teclas.DISPARO, false);
    }

    public void actualiza(float delta) {
        //Procesamos las entradas
        procesaEntradas();
        //Actualizamos el guerrero
        patrullero.actualiza(delta);
    }

    private void procesaEntradas() {
        if (teclas.get(Teclas.IZQUIERDA)) {
            patrullero.getVelocidad().x = -0.25f;
        }
        if (teclas.get(Teclas.DERECHA)) {
            patrullero.getVelocidad().x = 0.25f;
        }
        //en este if habia un lio de parentesis en los diferentes !
        if ((teclas.get(Teclas.IZQUIERDA) && teclas.get(Teclas.DERECHA)) ||
                (!teclas.get(Teclas.IZQUIERDA) && (!teclas.get(Teclas.DERECHA)))) {
            patrullero.getVelocidad().x = 0;
        }

        //CREO QUE AQUI FALTARIA LA ENTRADA PARA EL SALTO Y EL DISPARO QUE SUPUESTAMENTE SON LAS TECLAS Z Y X
    }


}
