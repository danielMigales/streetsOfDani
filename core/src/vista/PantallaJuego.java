package vista;


import com.badlogic.gdx.Files;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;

import controlador.ControladorPrincipal;
import modelo.Mundo;

public class PantallaJuego implements Screen, InputProcessor { //ha de implementar estas dos clases

    private Mundo ciudad;
    private PintorMundos pintor;
    private ControladorPrincipal controlador;

    //esto es para saber la medida de la pantalla
    int width = Gdx.graphics.getWidth();
    int height = Gdx.graphics.getHeight();

    //añadido de audio para el juego
    private Music music;


    //variables para el metodo touchdown valores iniciales ????
    private int ancho = 1;
    private int alto = 1;


    public void show() { //este metodo tambien lo podemos encontrar con el nombre de create()

        ciudad = new Mundo();
        pintor = new PintorMundos(ciudad);
        controlador = new ControladorPrincipal(ciudad);

        //añadido de la musica durante el juego
        music = Gdx.audio.newMusic(Gdx.files.getFileHandle("music/streets.mp3", Files.FileType.Internal)); //este audio se pone en la carpeta assets
        music.play();
        music.setLooping(true);

        Gdx.input.setInputProcessor(this); //se añade esto que implementa el InputProcessor
    }


    public void render(float delta) {

        Gdx.gl.glClearColor(1.0f, 1.0f, 1.0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); //GL10 esta obsoleto, se cambia a GL20. Esto lo que hace es vaciar el buffer de la pantalla
        controlador.actualiza(delta);
        pintor.pinta();
    }

    public void resize(int width, int height) {
        pintor.setDimension(width, height);
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void dispose() {
        //se elimina recursos. Esto para la musica si cambias de pantalla
        music.dispose();
    }

    //se añaden estos metodos que controlan las teclas //AQUI AÑADO ARRIBA Y ABAJO
    public boolean keyDown(int keycode) { //cuando se pulsa tecla
        if (keycode == Input.Keys.LEFT) controlador.izquierdaPulsada();
        if (keycode == Input.Keys.RIGHT) controlador.derechaPulsada();
        if (keycode == Input.Keys.UP) controlador.arribaPulsada();
        if (keycode == Input.Keys.DOWN) controlador.abajoPulsada();
        if (keycode == Input.Keys.Z) controlador.saltoPulsada();
        if (keycode == Input.Keys.X) controlador.disparoPulsado();
        return true;
    }

    //modificado
    public boolean keyUp(int keycode) { //cuando soltamos el dedo de la tecla
        if (keycode == Input.Keys.LEFT) controlador.izquierdaLiberada();
        if (keycode == Input.Keys.RIGHT) controlador.derechaLiberada();
        if (keycode == Input.Keys.UP) controlador.arribaLiberada();
        if (keycode == Input.Keys.DOWN) controlador.abajoLiberada();
        if (keycode == Input.Keys.Z) controlador.saltoLiberada();
        if (keycode == Input.Keys.X) controlador.disparoLiberada();
        return true;
    }

    public boolean keyTyped(char character) {
        return false;
    }

    public boolean touchDown(int x, int y, int pointer, int button) { //se dispara cuando empezamos a tocar pantalla
        //en este metodo faltan por declarar las variables ancho y alto. No se que valores han de tener ni de donde salen. Las he creado al inicio sin inicializar.

        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {//cuando soltamos la pantalla
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    //este metodo se parece al anterior. Investigar para que vale cada uno
    public boolean touchDragged(int x, int y, int pointer, int button) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    public boolean touchMoved(int x, int y, int pointer, int button) {
        return false;
    }

    public boolean scrolled(int amount) {
        return false;
    }
}
