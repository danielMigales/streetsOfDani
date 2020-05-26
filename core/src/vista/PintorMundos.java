package vista;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import modelo.Bloque;
import modelo.Decoracion;
import modelo.Enemigo;
import modelo.Mundo;
import modelo.Patrullero;

//esta clase crea las texturas de los bloques y del personaje a partir de unas imagenes que se han de importar
public class PintorMundos {

    private Mundo mundo;
    //estas dos variables son una especie de zoom. Este es el valor que mas se aproxima al resultado que quiero mostrar para que la pantalla sea 10 casillas * 10 casilllas
    private static final float CAMARA_ANCHO = 11f;
    private static final float CAMARA_ALTO = 11f;

    //ESTA OPCION AUN NO SE COMO SE IMPLEMENTA. LA CAMARA QUE ESTA USANDO EN EL METODO SETDIMENSION A VECES ME FALLA. LA UTILIDAD DE ESTA CLASE ES:
    // La cámara ortográfica se utilizará en entornos 2D porque implementa una proyección paralela (ortográfica)
    // y no habrá factor de escala para la imagen final, independientemente de dónde se coloquen los objetos en el mundo...INFORMACION OBTENIDA DE: https://github.com/libgdx/libgdx/wiki/Orthographic-camera
    private OrthographicCamera camera;

    /**
     * las Texturas que voy a utilizar son las siguientes: el personaje, un bloque que hara de acera, otro la pared y algun elemento decorativo como la boca de incendios
     **/
    private Texture patrulleroImg;
    private Texture aceraImg;
    private Texture cieloImg;
    private Texture paredImg;
    private Texture escenarioFondoImg;
    private Texture bocaIncendioIm;
    private Texture yonkiChandalImg;

    //texto en pantalla
    private BitmapFont font;

    private SpriteBatch spriteBatch;
    private int ancho;
    private int alto;
    private float ppuX;
    private float ppuY;

    public void setDimension(int an, int al) {
        this.ancho = an;
        this.alto = al;
        ppuX = (float) ancho / CAMARA_ANCHO;
        ppuY = (float) alto / CAMARA_ALTO;

        //esta opcion de momento no se esta usando. Pretendia implementarla cambiando la actual camara
        camera = new OrthographicCamera();
        camera.setToOrtho(false, CAMARA_ANCHO, CAMARA_ALTO);
    }

    public PintorMundos(Mundo calle) {
        this.mundo = calle;
        spriteBatch = new SpriteBatch();
        cargaTexturas();
    }

    //este procedimiento es el que obtiene las imagenes que se renderizan. Las obtiene de la carpeta assets qye hay que crear
    private void cargaTexturas() {
        //estas imagenes hay que buscarse la vida y buscarlas por internet, editandolas para intentar mejorar la fluidez. Tienen un tamaño de 64 px aproximadamente.
        patrulleroImg = new Texture(Gdx.files.internal("images/patrulleroFrontal.gif")); //renombro la imagen de jabato_01.gif original a patrullero.gif
        yonkiChandalImg = new Texture(Gdx.files.internal("images/yonkiChandal.gif"));
        cieloImg = new Texture(Gdx.files.internal("images/cielo.png"));
        aceraImg = new Texture(Gdx.files.internal("images/acera.png"));
        paredImg = new Texture(Gdx.files.internal("images/pared.png"));
        escenarioFondoImg = new Texture(Gdx.files.internal("images/escaparate.png"));
        bocaIncendioIm = new Texture(Gdx.files.internal("images/bocaIncendio.png"));
    }

    //aqui se llaman a metodos que usan el spritebatch para pintar objetos a partir de una textura
    public void pinta() {
        spriteBatch.begin();
        pintaBloques();
        pintaPatrullero();
        pintaDecoracion();
        pintaEnemigo();
        pintaTextos();
        spriteBatch.end();
    }

    private void pintaBloques() {
        //bucles que crean los bloques en pantalla. HAN SIDO REESTRUCTURADOS PARA CREAR UN ESCENARIO A MEDIDA
        for (Bloque pared : mundo.getParedes()) {
            spriteBatch.draw(paredImg,
                    pared.getPosicion().x * ppuX,
                    pared.getPosicion().y * ppuY,
                    pared.getDimension().width * ppuX,
                    pared.getDimension().height * ppuY);
        }

        for (Bloque cielo : mundo.getCielo()) {
            spriteBatch.draw(cieloImg,
                    cielo.getPosicion().x * ppuX,
                    cielo.getPosicion().y * ppuY,
                    cielo.getDimension().width * ppuX,
                    cielo.getDimension().height * ppuY);
        }

        for (Bloque acera : mundo.getAceras()) {
            spriteBatch.draw(aceraImg,
                    acera.getPosicion().x * ppuX,
                    acera.getPosicion().y * ppuY,
                    acera.getDimension().width * ppuX,
                    acera.getDimension().height * ppuY);
        }

    }

    //renombrado metodo que genera al guerrero
    private void pintaPatrullero() {
        Patrullero patrullero = mundo.getDaniel();
        spriteBatch.draw(patrulleroImg,
                patrullero.getPosicion().x * ppuX,
                patrullero.getPosicion().y * ppuY,
                patrullero.getDimension().width * ppuX,
                patrullero.getDimension().height * ppuY);
    }

    //metodo nuevo para incluir un enemigo en pantalla
    private void pintaEnemigo() {
        Enemigo yonkiChandal = mundo.getYonkiChandal();
        spriteBatch.draw(yonkiChandalImg,
                yonkiChandal.getPosicion().x * ppuX,
                yonkiChandal.getPosicion().y * ppuY,
                yonkiChandal.getDimension().width * ppuX,
                yonkiChandal.getDimension().height * ppuY);
    }

    //añado este nuevo procedimiento que pintara una  tienda en la pared y otros objetos. SON OBJETOS SOBREPUESTOS A LAS PAREDES Y ACERAS, COLOCADOS COMO EL PERSONAJE
    public void pintaDecoracion() {

        Decoracion escenarioFondo = mundo.getEscenarioFondo();
        spriteBatch.draw(escenarioFondoImg,
                escenarioFondo.getPosicion().x * ppuX,
                escenarioFondo.getPosicion().y * ppuY,
                escenarioFondo.getDimension().width * ppuX,
                escenarioFondo.getDimension().height * ppuY);

        Decoracion boca = mundo.getBocaIncendio();
        spriteBatch.draw(bocaIncendioIm,
                boca.getPosicion().x * ppuX,
                boca.getPosicion().y * ppuY,
                boca.getDimension().width * ppuX,
                boca.getDimension().height * ppuY);
    }

    public void pintaTextos(){
        //este pinta un texto con el numero de vidas. POR EL MOMENTO SOLO ES DECORATIVO
        font = new BitmapFont();
        font = new BitmapFont(Gdx.files.internal("fonts/funky.fnt"));
        font.draw(spriteBatch, "VIDAS = 3", 10, 1050);
        font.setColor(Color.BLACK);
    }
}
