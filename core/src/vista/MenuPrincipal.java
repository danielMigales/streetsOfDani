package vista;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MenuPrincipal implements Screen {

    private Juego game;
    OrthographicCamera camera;
    //para cargar las texturas (en este caso la imagen de fondo de la ciudad)
    private SpriteBatch batch;
    private Texture fondoImg;
    //fuente de las letras de titulo
    private BitmapFont font;
    //una musica en mp3 como intro que sonara en esta pantalla hasta que pases a la siguiente. Usa la clase Music propias de libgdx
    Music intro;

    //en el constructor se ha de meter la camara y las texturas
    public MenuPrincipal(Juego game) {
        this.game = game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        batch = new SpriteBatch();
        fondoImg = new Texture(Gdx.files.internal("images/menuScreen.png"));
    }

    @Override
    public void show() {

        //se inicia al mostrar la pantalla. Musica y fuentes
        font = new BitmapFont();
        intro = Gdx.audio.newMusic(Gdx.files.internal("music/madWorld.mp3"));
        intro.setLooping(true);
        intro.play();

        //fuente de texto personalizada. Descargada de https://github.com/izzeroone/Game2048/find/master. HAY QUE BAJARSE EL ARCHIVO PNG Y EL FNT Y COPIARLO EN ASSETS
        font = new BitmapFont(Gdx.files.internal("fonts/ClearBold32.fnt"));

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //renderiza la imagen y luego el texto
        batch.begin();
        camera.update();
        batch.setProjectionMatrix(camera.combined);
        batch.draw(fondoImg, 0, 0);
        font.draw(batch, "POLICE LINE: DO NOT CROSS", 200, 350);
        font.draw(batch, "Pulsa para empezar", 100, 100);
        font.setColor(Color.YELLOW);

        batch.end();

        //evento para que al pulsar la pantalla continue con la siguiente
        if (Gdx.input.isTouched()) {
            game.setScreen((Screen) new PantallaJuego());
            //cierra la actual
            dispose();
        }
    }

    @Override
    public void resize(int width, int height) {

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

        //cerramos esto al cambiar de escenario
        font.dispose();
        batch.dispose();
        intro.stop();
    }


}
