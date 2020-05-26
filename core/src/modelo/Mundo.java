package modelo;


import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;
import java.util.List;

//esta clase es la que crea las paredes del castillo y el personaje
public class Mundo {

    //arraylist que contiene los bloques (texturas) que se listan en el metodo crearMundo
    private List<Bloque> cielo;
    private List<Bloque> paredes;
    private List<Bloque> aceras;
    //elementos decorativos extra
    private Decoracion bocaIncendio;
    private Decoracion escenarioFondo;
    //personaje principal y un enemigo en pantalla
    private Patrullero daniel;
    private Enemigo yonkiChandal;

    public Mundo() {
        paredes = new ArrayList<>();
        aceras = new ArrayList<>();
        cielo = new ArrayList<>();
        creaMundoDemo();
    }

    private void creaMundoDemo() {

        int numeroBloquesPantalla = 11; //creo esta variable para controlar los bloques en la pantalla

        //renderizacion de decoraciones y personajes
        escenarioFondo = new Decoracion(new Vector2(1, 5), 9f, 6f); //nuevo objeto decorativo escenario de fondo con un tamaño predeterminado diferente al de los otros elementos usando constructor alternativo
        bocaIncendio = new Decoracion(new Vector2(2, 0));
        daniel = new Patrullero(new Vector2(0, 1)); //esto es la posicion en la que aparece el personaje en la pantalla. Con estas coordenadas me aparece al principio
        yonkiChandal = new Enemigo(new Vector2(8,1)); //enemigo en el lado opuesto

        //estos arrays se llenan en la clase PintorMundos con la imagen correspondiente en el metodo pintaBloques y pintaPatrullero
        //con estos for se añade un bloque a cada posicion xy de la pantalla. Se llenan esas posiciones en el array
        for (int i = 0; i < numeroBloquesPantalla; i++) { //este for tenia el i-- y eso hace que no se ejecute. 11 es el numero de bloques que va a generar por pantalla, se cuenta del 0 al 10
            //esto llena las tres primeras filas verticales haciendo la carretera
            aceras.add(new Bloque(new Vector2(i, 0)));
            aceras.add(new Bloque(new Vector2(i, 1)));
            aceras.add(new Bloque(new Vector2(i, 2)));
            aceras.add(new Bloque(new Vector2(i, 3)));
            aceras.add(new Bloque(new Vector2(i, 4)));
        }

        //finalmente no uso el cielo por estetica
        for (int i = 0; i < numeroBloquesPantalla; i++) { //este for tenia el i-- y eso hace que no se ejecute. 10 es el numero de bloques que va a generar por pantalla
            //esto llena las primeras filas superiores construyendo el cielo
            //cielo.add(new Bloque(new Vector2(i, 8)));
            //cielo.add(new Bloque(new Vector2(i, 7)));
        }

        //esto no se aprecia ya que lo tapa el escenario de fondo añadido al final. En caso de no cargarse el gif aun estaria esto
        for (int i = 0; i < numeroBloquesPantalla; i++) { //este for tenia el i-- y eso hace que no se ejecute. 10 es el numero de bloques que va a generar por pantalla
            //esto llena las tres primeras filas verticales haciendo la carretera
            paredes.add(new Bloque(new Vector2(i, 5)));
            paredes.add(new Bloque(new Vector2(i, 6)));
            paredes.add(new Bloque(new Vector2(i, 7)));
            paredes.add(new Bloque(new Vector2(i, 8)));
            paredes.add(new Bloque(new Vector2(i, 9)));
            paredes.add(new Bloque(new Vector2(i, 10)));
        }
    }

    public Patrullero getDaniel() {
        return daniel;
    }

    public void setDaniel(Patrullero daniel) {
        this.daniel = daniel;
    }

    public Enemigo getYonkiChandal() {
        return yonkiChandal;
    }

    public void setYonkiChandal(Enemigo yonkiChandal) {
        this.yonkiChandal = yonkiChandal;
    }

    //esto son los getters y setters de los arraylist que general paredes, cielo y carretera
    public List<Bloque> getCielo() {
        return cielo;
    }

    public void setCielo(List<Bloque> cielo) {
        this.cielo = cielo;
    }

    public List<Bloque> getParedes() {
        return paredes;
    }

    public void setParedes(List<Bloque> paredes) {
        this.paredes = paredes;
    }

    public List<Bloque> getAceras() {
        return aceras;
    }

    public void setAceras(List<Bloque> aceras) {
        this.aceras = aceras;
    }

    public Decoracion getBocaIncendio() {
        return bocaIncendio;
    }

    public void setBocaIncendio(Decoracion bocaIncendio) {
        this.bocaIncendio = bocaIncendio;
    }

    public Decoracion getEscenarioFondo() {
        return escenarioFondo;
    }

    public void setEscenarioFondo(Decoracion escenarioFondo) {
        this.escenarioFondo = escenarioFondo;
    }



}

