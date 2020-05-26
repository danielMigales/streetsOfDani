package controlador;

import com.badlogic.gdx.Gdx;

import java.util.HashMap;
import java.util.Map;

import modelo.Mundo;
import modelo.Patrullero;

//esta clase controla los mandos, teclados, touch de la pantalla.  Actualmente solo esta programado caminar izquierda y derecha
public class ControladorPrincipal {

    //le incorporo movimiento por toda la pantalla con las teclas arriba y abajo
    enum Teclas {
        IZQUIERDA, DERECHA, ARRIBA, ABAJO, SALTO, DISPARO
    }

    private Mundo ciudad;
    private Patrullero patrullero;

    static Map<Teclas, Boolean> teclas = new HashMap<>();

    static {
        teclas.put(Teclas.IZQUIERDA, false);
        teclas.put(Teclas.DERECHA, false);
        teclas.put(Teclas.ARRIBA, false);
        teclas.put(Teclas.ABAJO, false);
        teclas.put(Teclas.SALTO, false);
        teclas.put(Teclas.DISPARO, false);
    }

    public ControladorPrincipal(Mundo mundo) {
        this.ciudad = mundo;
        this.patrullero = mundo.getDaniel();

    }

    // ** Actualización del mapa teclas ** //  AÑADO ARRIBA Y ABAJO PARA QUE SE DESPLAZE POR TODA LA PANTALLA, EL DISPARO Y SALTO FUNCIONAN PERO DE MOMENTO SOLO IMPRIMEN EN PANTALLA UN TEXTO
    public void izquierdaPulsada() {
        teclas.put(Teclas.IZQUIERDA, true);
    }
    public void izquierdaLiberada() {
        teclas.put(Teclas.IZQUIERDA, false);
    }

    public void derechaPulsada() {
        teclas.put(Teclas.DERECHA, true);
    }
    public void derechaLiberada() {
        teclas.put(Teclas.DERECHA, false);
    }

    public void arribaPulsada() {
        teclas.put(Teclas.ARRIBA, true);
    }
    public void arribaLiberada() {
        teclas.put(Teclas.ARRIBA, false);
    }

    public void abajoPulsada() {
        teclas.put(Teclas.ABAJO, true);
    }
    public void abajoLiberada() {
        teclas.put(Teclas.ABAJO, false);
    }

    public void saltoPulsada() {
        teclas.put(Teclas.SALTO, true);
    }
    public void saltoLiberada() {
        teclas.put(Teclas.SALTO, false);
    }

    public void disparoPulsado() {
        teclas.put(Teclas.DISPARO, true);
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

        //con estos valores el personaje va mas rapido a la hora de moverse en pantalla. Estos son los eventos que le hacen desplazarse
        if (teclas.get(Teclas.IZQUIERDA)) {
            patrullero.getVelocidad().x = -1f;
            System.out.println("izquierda pulsada");
        }
        if (teclas.get(Teclas.DERECHA)) {
            patrullero.getVelocidad().x = 1f;
            System.out.println("derecha pulsada");
        }
        //en este if habia un lio de parentesis en los diferentes !
        if ((teclas.get(Teclas.IZQUIERDA) && teclas.get(Teclas.DERECHA)) ||
                (!teclas.get(Teclas.IZQUIERDA) && (!teclas.get(Teclas.DERECHA)))) {
            patrullero.getVelocidad().x = 0; //aqui el valor esta a 0 para asi detenerse
        }

        //ESTAS DOS SE MUEVEN POR EL EJE Y. TAMBIEN SE HAN DE AÑADIR EN LA CLASE PANTALLAJUEGO

        if (teclas.get(Teclas.ARRIBA)) {
            //asi obtengo la posicion actual y le sumo un poco para que suba
            float y = patrullero.getPosicion().y;
            float aumento = (float) 0.25;
            patrullero.getPosicion().y = (y + aumento);
            //ademas hay que reducir la velocidad de movimiento por ese eje, sino se embala
            patrullero.getVelocidad().y = -10;
            System.out.println("arriba pulsada");
        }

        if (teclas.get(Teclas.ABAJO)) {
            //lo mismo para bajar
            float y = patrullero.getPosicion().y;
            float disminucion = (float) -0.25;
            patrullero.getPosicion().y = (y + disminucion);
            //en este caso la velocidad es positiva
            patrullero.getVelocidad().y = 10;
            System.out.println("abajo pulsada");
        }

        //CREO QUE AQUI FALTARIA LA ENTRADA PARA EL SALTO Y EL DISPARO QUE SUPUESTAMENTE SON LAS TECLAS Z Y X
        //ASI YA FUNCIONAN LAS TECLAS EN LA APLICACION DESKTOP. PERO COMO NO HAY NINGUNA ANIMACION O EFECTO NO SE PUEDE HACER NADA AUN

        if (teclas.get(Teclas.SALTO)) {
            System.out.println("saltando");
        }
        if (teclas.get(Teclas.DISPARO)) {
            System.out.println("disparando");
        }

        if(Gdx.input.isTouched()) {
            System.out.println("tocada la pantalla");

        }
    }


}
