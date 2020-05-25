package modelo;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
//esta es la clase que construye los bloques que generan el escenario
public class Bloque {

    //estas dos variables son el tamaño de cada bloque de piedra. Este es el tamaño que me parece mas correcto para mostrarlo en pantalla
    static final float ANCHO = 1f;
    static final float ALTO = 1f;
    private Vector2 posicion;
    private Rectangle dimension;

    public Bloque(Vector2 v) {
        this.posicion = v;
        this.dimension = new Rectangle();
        this.dimension.width = ANCHO;
        this.dimension.height = ALTO;
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