package modelo;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Enemigo {

    static final float ANCHO = 1.25f;
    static final float ALTO = 2f;

    private Vector2 posicion;
    private Rectangle dimension;
    private Vector2 velocidad;

    public Enemigo(Vector2 posicion, Rectangle dimension, Vector2 velocidad) {
        this.posicion = posicion;
        this.dimension = dimension;
        this.velocidad = velocidad;
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

    //Implementaremos el método actualiza() como sigue:
    public void actualiza(float deltaT) {
        Vector2 deltaP = velocidad.scl(deltaT);
        posicion.add(deltaP);
    }

    public Vector2 getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(Vector2 velocidad) {
        this.velocidad = velocidad;
    }
}