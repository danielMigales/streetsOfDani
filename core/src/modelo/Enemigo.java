package modelo;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Enemigo {

    static final float ANCHO = 1.5f;
    static final float ALTO = 4f;

    private Vector2 posicion;
    private Rectangle dimension;
    private Vector2 velocidad;

    //variable para la deteccion de colisiones
    public Rectangle rect;
    public int lives;
    protected boolean dead;

    public Enemigo(Vector2 posicion) {
        this.posicion = posicion;
        this.dimension = new Rectangle();
        this.dimension.width = ANCHO;
        this.dimension.height = ALTO;
        this.velocidad =new Vector2(1f, 1f);
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
        Vector2 deltaP = velocidad.scl(deltaT); //aqui se debe cambiar el .mul ya que esta obsoleto (opengl1.0) y ahora se usa .scl (opengl2.0)
        posicion.add(deltaP);
    }

    public Vector2 getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(Vector2 velocidad) {
        this.velocidad = velocidad;
    }
}