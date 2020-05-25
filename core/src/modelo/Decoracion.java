package modelo;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;


//clase nueva en la que genero diferentes elementos decorativos y los coloco en una posicion fija en el escenario

public class Decoracion {

    //tamaño del objeto
    static final float ANCHO = 1.5f;
    static final float ALTO = 3f;

    private Vector2 posicion;
    private Rectangle dimension;


    public Decoracion(Vector2 posicion) {
        this.posicion = posicion;
        this.dimension = new Rectangle();
        this.dimension.width = ANCHO;
        this.dimension.height = ALTO;
    }

    //añado un constructor extra para poder pasar como parametro la altura y la anchura del objeto
    public Decoracion(Vector2 posicion, float ancho, float alto) {
        this.posicion = posicion;
        this.dimension = new Rectangle();
        this.dimension.width = ancho;
        this.dimension.height = alto;
    }

    public Vector2 getPosicion() {
        return posicion;
    }

    public void setPosicion(Vector2 posicion) {
        this.posicion = posicion;
    }

    public Rectangle getDimension() {
        return dimension;
    }

    public void setDimension(Rectangle dimension) {
        this.dimension = dimension;
    }


}