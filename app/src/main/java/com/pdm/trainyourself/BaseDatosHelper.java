package com.pdm.trainyourself;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class BaseDatosHelper extends SQLiteOpenHelper {

    /**
     * La clase BaseDatosHelper se encarga de comunicarse con la base de datos:
     * Si no existe, crea una base de datos con el método onCreate, donde crea
     * las 5 tablas y también introduce los ejercicios de ejemplo.
     * También tiene métodos para interactuar con las tablas, ya sea para obtener
     * filas, introducir o borrar.
     */

    public static final String TABLA_EJERCICIOS = "TABLA_EJERCICIOS";
    public static final String TABLA_LISTAEJER = "TABLA_LISTAEJER";
    public static final String RELACION_EJER_LISTA = "RELACION_EJER_LISTA";
    public static final String TABLA_RUTINAS = "TABLA_RUTINAS";
    public static final String RELACION_LISTAS_RUTINA = "RELACION_LISTAS_RUTINA";


    public BaseDatosHelper(@Nullable Context context) {
        super(context, "rutina.db", null, 1);
    }

    /**
     * El método onCreate crea 5 tablas:
     *  - TABLA_EJERCICIOS: La tabla de los ejercicios
     *  - TABLA_LISTAEJER: La tabla con cada una de las listas de ejercicios
     *  - RELACION_EJER_LISTA: Una tabla de dos columnas donde se relacionan todos los ejercicios de una lista con dicha lista (es una relacion MUCHOS A UNO)
     *  - TABLA_RUTINAS: La tabla con las rutinas
     *  - RELACION_LISTAS_RUTINAS: Una tabla de dos columnas donde se relacionan todas las listas de ejercicios de una rutina con su Rutina (es una relacion MUCHOS A UNO)
     *
     * Además, aquí también se añaden todos los ejercicios que existen en la base de datos
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sentenciaCreacionTablaEjercicios = "CREATE TABLE " + TABLA_EJERCICIOS + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, NOMBRE TEXT, DESCRIPCION TEXT, TIPO INTEGER, NUMMAXREP INTEGER, NUMMINREP INTEGER)";
        db.execSQL(sentenciaCreacionTablaEjercicios);
        //    CARDIO, MUSCULO, MIXTA, PECHO, BRAZOS, ABDOMINALES, PIERNAS, ESPALDA
        //      0       1       2       3       4       5           6         7

        //     EJERCICIOS DE CARDIO
        ContentValues cv = new ContentValues();
        cv.put("NOMBRE", "Elevación de rodillas");
        cv.put("DESCRIPCION", "Levanta la pierna hasta que forme un ángulo de 90 grados con el tronco, repita con la otra pierna, y continúe alternando un lado a otro vigorosamente.");
        cv.put("TIPO", 0);
        cv.put("NUMMAXREP", 30);
        cv.put("NUMMINREP", 10);
        db.insert(TABLA_EJERCICIOS, null, cv);
        cv.put("NOMBRE", "Saltos de tijera");
        cv.put("DESCRIPCION", "Comienza con los pies juntos y los brazos a los lados; a continuación, salta con los pies separados y las manos sobre la cabeza.");
        cv.put("TIPO", 0);
        cv.put("NUMMAXREP", 30);
        cv.put("NUMMINREP", 10);
        db.insert(TABLA_EJERCICIOS, null, cv);
        cv.put("NOMBRE", "Saltos sin cuerda");
        cv.put("DESCRIPCION", "Coloca los brazos a los lados y finge que sostienes el mango de una cuerda de salto en cada mano.");
        cv.put("TIPO", 0);
        cv.put("NUMMAXREP", 30);
        cv.put("NUMMINREP", 10);
        db.insert(TABLA_EJERCICIOS, null, cv);
        cv.put("NOMBRE", "Escalada de Montaña");
        cv.put("DESCRIPCION", "Comienza en posición para hacer flexiones, trae la rodilla derecha hacia el pecho, pega un salto y cambia de pie en el aire, metiendo el pie izquierdo y sacando el derecho.");
        cv.put("TIPO", 0);
        cv.put("NUMMAXREP", 30);
        cv.put("NUMMINREP", 10);
        db.insert(TABLA_EJERCICIOS, null, cv);
        cv.put("NOMBRE", "Estocada hacia atrás");
        cv.put("DESCRIPCION", "De pie, da un paso grande hacia atrás con la pierna derecha y baja el cuerpo hasta que el muslo izquierdo quede paralelo al suelo. Vuelve de pie y repite con el otro lado.");
        cv.put("TIPO", 0);
        cv.put("NUMMAXREP", 30);
        cv.put("NUMMINREP", 10);
        db.insert(TABLA_EJERCICIOS, null, cv);

        cv.put("NOMBRE", "Pliegue de rodillas con salto");
        cv.put("DESCRIPCION", "Comienza en posición para hacer flexiones. Salta hacia delante, acerca las rodillas al pecho y vuelve de un salto a la posición inicial.");
        cv.put("TIPO", 0);
        cv.put("NUMMAXREP", 20);
        cv.put("NUMMINREP", 5);
        db.insert(TABLA_EJERCICIOS, null, cv);
        cv.put("NOMBRE", "Butt Bridge");
        cv.put("DESCRIPCION", "Túmbate en el suelo y encoge las rodillas con los pies sobre el suelo. Después, sube el trasero todo lo que puedas, como si fueras un puente.");
        cv.put("TIPO", 0);
        cv.put("NUMMAXREP", 30);
        cv.put("NUMMINREP", 10);
        db.insert(TABLA_EJERCICIOS, null, cv);
        cv.put("NOMBRE", "Elevación trasera de piernas");
        cv.put("DESCRIPCION", "Comienza a cuatro patas. Luego da una patada hacia atrás lo máximo que puedas y vuelve a la posición de inicio. Tras varias repeticiones, cambia de lado.");
        cv.put("TIPO", 0);
        cv.put("NUMMAXREP", 20);
        cv.put("NUMMINREP", 5);
        db.insert(TABLA_EJERCICIOS, null, cv);
        cv.put("NOMBRE", "Frog press");
        cv.put("DESCRIPCION", "Túmbate boca abajo con las piernas levantadas y las rodillas flexionadas. Estira las piernas y vuelve a la posición inicial.");
        cv.put("TIPO", 0);
        cv.put("NUMMAXREP", 30);
        cv.put("NUMMINREP", 10);
        db.insert(TABLA_EJERCICIOS, null, cv);
        cv.put("NOMBRE", "Levantamiento recto de pierna");
        cv.put("DESCRIPCION", "Túmbate boca arriba con una pierna extendida y otra flexionada. Haz pierna con la pierna extendida y levántala lo que puedas. Luego bájala lentamente. Alterna.");
        cv.put("TIPO", 0);
        cv.put("NUMMAXREP", 15);
        cv.put("NUMMINREP", 5);
        db.insert(TABLA_EJERCICIOS, null, cv);
        cv.put("NOMBRE", "Squats (sentadillas)");
        cv.put("DESCRIPCION", "Estando de pie, baja el cuerpo hasta que los muslos se encuentren paralelos al suelo. Vuelve a la posición original y repite.");
        cv.put("TIPO", 0);
        cv.put("NUMMAXREP", 30);
        cv.put("NUMMINREP", 10);
        db.insert(TABLA_EJERCICIOS, null, cv);
        cv.put("NOMBRE", "Step en silla");
        cv.put("DESCRIPCION", "Coloca un pie en la silla y levante su cuerpo del suelo hasta subirse con los dos pies en la silla. Alterna.");
        cv.put("TIPO", 0);
        cv.put("NUMMAXREP", 15);
        cv.put("NUMMINREP", 5);
        db.insert(TABLA_EJERCICIOS, null, cv);
        cv.put("NOMBRE", "Zancada frontal");
        cv.put("DESCRIPCION", "Estando de pie, haga como que va a dar un paso grande hasta formar un ángulo de 90 grados respecto al tronco. Vuelva a la posición inicial y alterne.");
        cv.put("TIPO", 0);
        cv.put("NUMMAXREP", 15);
        cv.put("NUMMINREP", 5);
        db.insert(TABLA_EJERCICIOS, null, cv);
        cv.put("NOMBRE", "Elevaciones de piernas");
        cv.put("DESCRIPCION", "Túmbate de espaldas. Luego eleva las piernas hasta formar un águlo recto con el suelo. Baja las piernas despacio y vuelve a repetir.");
        cv.put("TIPO", 0);
        cv.put("NUMMAXREP", 30);
        cv.put("NUMMINREP", 10);
        db.insert(TABLA_EJERCICIOS, null, cv);
        cv.put("NOMBRE", "Toque al talón");
        cv.put("DESCRIPCION", "Túmbate, levanta ligeramente el tren superior del suelo y tócate los talones con las manos alternando entre una y otra.");
        cv.put("TIPO", 0);
        cv.put("NUMMAXREP", 15);
        cv.put("NUMMINREP", 5);


        //  EJERCICIOS DE PECHO
        cv.put("NOMBRE", "Flexiones");
        cv.put("DESCRIPCION", "Túmbese. Suba y baje el cuerpo con los brazos, mateniendo el cuerpo recto.");
        cv.put("TIPO", 3);
        cv.put("NUMMAXREP", 15);
        cv.put("NUMMINREP", 5);
        db.insert(TABLA_EJERCICIOS, null, cv);
        cv.put("NOMBRE", "Flexiones con brazos abiertos");
        cv.put("DESCRIPCION", "Comienza en posición de flexión pero las manos más abiertas que los hombros. Luego suba y baje el cuerpo con los brazos, mateniendo el cuerpo recto.");
        cv.put("TIPO", 3);
        cv.put("NUMMAXREP", 15);
        cv.put("NUMMINREP", 5);
        db.insert(TABLA_EJERCICIOS, null, cv);
        cv.put("NOMBRE", "Flexiones Hindúes");
        cv.put("DESCRIPCION", "Comienza con manos y pies extendidos tocando el suelo, formando una V invertida. Luego flexionas los codos para que tu cuerpo toque el suelo. Vuelve a elevar el cuerpo.");
        cv.put("TIPO", 3);
        cv.put("NUMMAXREP", 15);
        cv.put("NUMMINREP", 5);
        db.insert(TABLA_EJERCICIOS, null, cv);
        cv.put("NOMBRE", "Flexión y rotación");
        cv.put("DESCRIPCION", "Comienza en posición de flexión. Haz la flexión y al subir, rota el tren superior y extiende un brazo hacia arriba.");
        cv.put("TIPO", 3);
        cv.put("NUMMAXREP", 15);
        cv.put("NUMMINREP", 5);
        db.insert(TABLA_EJERCICIOS, null, cv);
        cv.put("NOMBRE", "Flexiones Spiderman");
        cv.put("DESCRIPCION", "Comienza en posición de flexiones. Mientras presionas el torso hacia abajo, flexiona y eleva la pierna hacia un lateral. Vuelve a la posición y repite con la otra pierna.");
        cv.put("TIPO", 3);
        cv.put("NUMMAXREP", 15);
        cv.put("NUMMINREP", 5);
        db.insert(TABLA_EJERCICIOS, null, cv);



        //EJERCICIOS DE BRAZOS
        cv.put("NOMBRE", "Tríceps en el suelo");
        cv.put("DESCRIPCION", "Siéntate y apoya los brazos detrás tuya. Levanta las caderas del suelo. Luego contrae y estira los codos de forma que levantes y bajes la cadera.");
        cv.put("TIPO", 4);
        cv.put("NUMMAXREP", 15);
        cv.put("NUMMINREP", 5);
        db.insert(TABLA_EJERCICIOS, null, cv);
        cv.put("NOMBRE", "Flexión de bíceps con pierna");
        cv.put("DESCRIPCION", "Colocate de espaldas a una pared. Levanta la pierna derecha, inclínate hacia delante y agarra tu tobillo. Levanta el tobillo todo lo que puedas, luego bájalo.");
        cv.put("TIPO", 4);
        cv.put("NUMMAXREP", 15);
        cv.put("NUMMINREP", 5);
        db.insert(TABLA_EJERCICIOS, null, cv);
        cv.put("NOMBRE", "Ganchos alternos");
        cv.put("DESCRIPCION", "Eleva el brazo derecho a la altura del hombro y mantén el antebrazo en paralelo al suelo. Gira los hombros y las caderas y lanza un puñetazo a la izquierda. Cambia de lado y repite.");
        cv.put("TIPO", 4);
        cv.put("NUMMAXREP", 30);
        cv.put("NUMMINREP", 10);
        db.insert(TABLA_EJERCICIOS, null, cv);
        cv.put("NOMBRE", "Giro de hombros");
        cv.put("DESCRIPCION", "Colócate en pie con las manos detrás de las orejas y los codos hacia afuera. Gira los codos hasta que ambos se apunten.");
        cv.put("TIPO", 4);
        cv.put("NUMMAXREP", 30);
        cv.put("NUMMINREP", 10);
        db.insert(TABLA_EJERCICIOS, null, cv);
        cv.put("NOMBRE", "Flexiones con brazo en puerta");
        cv.put("DESCRIPCION", "Agarra el marco de una puerta. Extiende los brazos e inclínate hacia atrás, después tira del marco de la puerta y regresa a la posición inicial.");
        cv.put("TIPO", 4);
        cv.put("NUMMAXREP", 30);
        cv.put("NUMMINREP", 10);
        db.insert(TABLA_EJERCICIOS, null, cv);



        //EJERCICIOS DE ABDOMINALES
        cv.put("NOMBRE", "Abdominales");
        cv.put("DESCRIPCION", "Túmbate y levanta la parte superior del cuerpo todo lo que puedas. Baja despacio hasta la posición inicial y repite el ejericio.");
        cv.put("TIPO", 5);
        cv.put("NUMMAXREP", 15);
        cv.put("NUMMINREP", 5);
        db.insert(TABLA_EJERCICIOS, null, cv);
        cv.put("NOMBRE", "Puente lateral izquierdo");
        cv.put("DESCRIPCION", "Apóyate sobre el lado derecho. Sitúa el codo bajo los hombros. Lenvanta la cadera hacia arriba, mantén 2 - 4 segundos y vuelve a la posición original.");
        cv.put("TIPO", 5);
        cv.put("NUMMAXREP", 30);
        cv.put("NUMMINREP", 10);
        db.insert(TABLA_EJERCICIOS, null, cv);
        cv.put("NOMBRE", "Puente lateral derecho");
        cv.put("DESCRIPCION", "Apóyate sobre el lado izquierdo. Sitúa el codo bajo los hombros. Lenvanta la cadera hacia arriba, mantén 2 - 4 segundos y vuelve a la posición original.");
        cv.put("TIPO", 5);
        cv.put("NUMMAXREP", 20);
        cv.put("NUMMINREP", 10);
        db.insert(TABLA_EJERCICIOS, null, cv);
        cv.put("NOMBRE", "Abdominal en V");
        cv.put("DESCRIPCION", "Túmbate boca arriba. Levanta el tronco y las piernas, utiliza los brazos para tocarte las piernas, y vuelve a la posición original.");
        cv.put("TIPO", 5);
        cv.put("NUMMAXREP", 15);
        cv.put("NUMMINREP", 5);
        db.insert(TABLA_EJERCICIOS, null, cv);
        cv.put("NOMBRE", "Twist ruso");
        cv.put("DESCRIPCION", "Siéntate en el suelo con las rodillas flexionadas. Une las manos y gira de un lado a otro.");
        cv.put("TIPO", 5);
        cv.put("NUMMAXREP", 45);
        cv.put("NUMMINREP", 15);
        db.insert(TABLA_EJERCICIOS, null, cv);



        //  EJERCICIOS DE PIERNAS
        cv.put("NOMBRE", "Círculos con la pierna");
        cv.put("DESCRIPCION", "Túmbate de un lado. Levanta la pierna de arriba y haz círculos con ella");
        cv.put("TIPO", 6);
        cv.put("NUMMAXREP", 30);
        cv.put("NUMMINREP", 10);
        db.insert(TABLA_EJERCICIOS, null, cv);
        cv.put("NOMBRE", "Step en silla");
        cv.put("DESCRIPCION", "Coloca un pie en la silla y levante su cuerpo del suelo hasta subirse con los dos pies en la silla. Alterna.");
        cv.put("TIPO", 6);
        cv.put("NUMMAXREP", 15);
        cv.put("NUMMINREP", 5);
        db.insert(TABLA_EJERCICIOS, null, cv);
        cv.put("NOMBRE", "Squats (sentadillas)");
        cv.put("DESCRIPCION", "Estando de pie, baja el cuerpo hasta que los muslos se encuentren paralelos al suelo. Vuelve a la posición original y repite.");
        cv.put("TIPO", 6);
        cv.put("NUMMAXREP", 15);
        cv.put("NUMMINREP", 5);
        db.insert(TABLA_EJERCICIOS, null, cv);
        cv.put("NOMBRE", "Pataleo inverso");
        cv.put("DESCRIPCION", "Boca abajo en un banco, eleva las piernas hasta que estén al mismo nivel que el cuerpo. Eleva una pierna por encima de la otra y bájala. Cambia de pierna.");
        cv.put("TIPO", 6);
        cv.put("NUMMAXREP", 30);
        cv.put("NUMMINREP", 10);
        db.insert(TABLA_EJERCICIOS, null, cv);
        cv.put("NOMBRE", "Levantamiento de pantorillas");
        cv.put("DESCRIPCION", "De cara a una pared, gira los tobillos para que los dedos miren hacia afuera. Levanta los talones y bájalos.");
        cv.put("TIPO", 6);
        cv.put("NUMMAXREP", 15);
        cv.put("NUMMINREP", 5);
        db.insert(TABLA_EJERCICIOS, null, cv);




        //  EJERCICIOS DE ESPALDA
        cv.put("NOMBRE", "Extensiones hacia atrás de tríceps");
        cv.put("DESCRIPCION", "Inclínate hacia delante. Extiende los brazos hacia atrás y aprieta el tríceps hasta que estén paralelos al suelo. Vuelve a la posición original y repite.");
        cv.put("TIPO", 7);
        cv.put("NUMMAXREP", 30);
        cv.put("NUMMINREP", 10);
        db.insert(TABLA_EJERCICIOS, null, cv);
        cv.put("NOMBRE", "Tracciones de romboides");
        cv.put("DESCRIPCION", "Colócate de pie. Levanta los brazos en paralelo al suelo y flexiona los codos. Tira de los codos hacia atrás y aprieta los omóplatos.");
        cv.put("TIPO", 7);
        cv.put("NUMMAXREP", 30);
        cv.put("NUMMINREP", 10);
        db.insert(TABLA_EJERCICIOS, null, cv);
        cv.put("NOMBRE", "Superman y nadador");
        cv.put("DESCRIPCION", "Túmbate boca abajo con los brazos extendidos. Alterna al levantar el brazo y la pierna contrarios.");
        cv.put("TIPO", 7);
        cv.put("NUMMAXREP", 30);
        cv.put("NUMMINREP", 10);
        db.insert(TABLA_EJERCICIOS, null, cv);
        cv.put("NOMBRE", "Bisagra de cadera");
        cv.put("DESCRIPCION", "De pie, echa la cadera hacia atrás y dobla el tronco manteniéndolo recto. Vuelve a la posición y repite.");
        cv.put("TIPO", 7);
        cv.put("NUMMAXREP", 15);
        cv.put("NUMMINREP", 5);
        db.insert(TABLA_EJERCICIOS, null, cv);
        cv.put("NOMBRE", "Postura Gato Vaca");
        cv.put("DESCRIPCION", "Comienza a cuatro patas. Inspira y baja la barriga, estirando los hombros hacia atrás y levantando la cabeza. Al expirar dobla la espalda hacia atrás y baja la cabeza.");
        cv.put("TIPO", 7);
        cv.put("NUMMAXREP", 15);
        cv.put("NUMMINREP", 5);
        db.insert(TABLA_EJERCICIOS, null, cv);


        String sentenciaCreacionTablaListaEjercicios = "CREATE TABLE " + TABLA_LISTAEJER + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, NUMEJERCICIOS INTEGER, INTENSIDAD REAL, TIPO INTEGER )";
        db.execSQL(sentenciaCreacionTablaListaEjercicios);

        String sentenciaCreacionTablaRelacion1 = "CREATE TABLE " + RELACION_EJER_LISTA + " (IDLISTA INTEGER, IDEJER INTEGER, FOREIGN KEY (IDLISTA) REFERENCES TABLA_LISTAEJER (ID), FOREIGN KEY (IDEJER) REFERENCES TABLA_EJERCICIOS (ID), PRIMARY KEY(IDLISTA, IDEJER))";
        db.execSQL(sentenciaCreacionTablaRelacion1);

        String sentenciaCreacionTablaRutinas = "CREATE TABLE " + TABLA_RUTINAS + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, NOMBRE TEXT, NUMDIAS INTEGER, INTENSIDAD REAL, TIPO INTEGER )";
        db.execSQL(sentenciaCreacionTablaRutinas);

        String sentenciaCreacionTablaRelacion2 = "CREATE TABLE " + RELACION_LISTAS_RUTINA + " (IDRUTINA INTEGER, IDLISTA INTEGER, FOREIGN KEY (IDLISTA) REFERENCES TABLA_LISTAEJER (ID), FOREIGN KEY (IDRUTINA) REFERENCES TABLA_RUTINAS (ID), PRIMARY KEY(IDLISTA, IDRUTINA))";
        db.execSQL(sentenciaCreacionTablaRelacion2);


    }

    // Codigo para actualizar la base de datos
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    /**
     * Método para añadir una lista de ejercicios a la bd.
     * En este método también se seleccionan ejercicios de diferentes tipos: piernas, brazos, pecho, espalda, abdominales o cardio
     * Esto se hace para que no se repita un mismo tipo de ejercicio el mismo dia de rutina
     * El id de dichos ejercicios seleccionados se introducen junto con el id de la Lista en la tabla RELACION_EJER_LISTA
     * @param numEjercicios: el número de ejercicios
     * @param intensidadMedia: intensidad media de los ejercicios
     * @param tipo: tipo de ejercicios: Cardio, músculo o mixto
     * @return el id de la lista introducida, o -1 en caso de error
     */
    public long anadirLista( int numEjercicios, float intensidadMedia, tipoEjercicio tipo){
        ArrayList<Ejercicio> listaEjercicios = obtenerTodosLosEjercicios(intensidadMedia);
        ArrayList<Integer> listaFinal = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        int contador = 0;


        long insercion = -1;

        cv.put("NUMEJERCICIOS", numEjercicios);
        cv.put("INTENSIDAD", intensidadMedia);
        switch (tipo){
            case CARDIO:
                cv.put("TIPO", 0);
                break;
            case MUSCULO:
                cv.put("TIPO", 1);
                break;
            case MIXTA:
                cv.put("TIPO", 2);
                break;

        }

        insercion = db.insert(TABLA_LISTAEJER, null, cv);

        if (insercion == -1)
            return -1;


        //AHORA BUSCAMOS LOS EJERCICIOS POSIBLES Y LOS INTRODUCIMOS
        // Si se escoge ejercicio Mixto, se intenta que estén al menos un ejercicio de cada tipo
        if(tipo.equals(tipoEjercicio.MIXTA)){
            ArrayList<tipoEjercicio> enumeradoTipoEjercicio = new ArrayList<tipoEjercicio>();
            enumeradoTipoEjercicio.add(tipoEjercicio.CARDIO);
            enumeradoTipoEjercicio.add(tipoEjercicio.ABDOMINALES);
            enumeradoTipoEjercicio.add(tipoEjercicio.BRAZOS);
            enumeradoTipoEjercicio.add(tipoEjercicio.ESPALDA);
            enumeradoTipoEjercicio.add(tipoEjercicio.PECHO);
            enumeradoTipoEjercicio.add(tipoEjercicio.PIERNAS);
            numEjercicios = 6;

            // Busca ejercicios que guardar
            for (int i = 0; contador < numEjercicios && i < listaEjercicios.size() ;i++){

                // Si ya ha metido un ejercicio de cada tipo, introduce cualquiera de otro tipo menos de cardio
                if(enumeradoTipoEjercicio.isEmpty() && listaEjercicios.get(i).getTipo() != tipoEjercicio.CARDIO) {
                    Ejercicio e = new Ejercicio(listaEjercicios.get(i), intensidadMedia);
                    e.setNumRepeticiones(e.obtenerNivelOptimo(intensidadMedia));

                    listaFinal.add(e.getIdentificador());
                    contador++;

                    listaEjercicios.remove(i);
                }

                // Si queda un tipo de ejercicio que no se ha introducido, lo busca e introduce
                else if (enumeradoTipoEjercicio.contains(listaEjercicios.get(i).getTipo())){
                    enumeradoTipoEjercicio.remove(listaEjercicios.get(i).getTipo());

                    Ejercicio e = new Ejercicio(listaEjercicios.get(i), intensidadMedia);
                    e.setNumRepeticiones(e.obtenerNivelOptimo(intensidadMedia));

                    listaFinal.add(e.getIdentificador());
                    contador++;

                    listaEjercicios.remove(i);
                }
            }
        }
        //Si se escoge músculo
        else if(tipo.equals(tipoEjercicio.MUSCULO)){
            ArrayList<tipoEjercicio> enumeradoTipoEjercicio = new ArrayList<tipoEjercicio>();
            enumeradoTipoEjercicio.add(tipoEjercicio.ABDOMINALES);
            enumeradoTipoEjercicio.add(tipoEjercicio.BRAZOS);
            enumeradoTipoEjercicio.add(tipoEjercicio.ESPALDA);
            enumeradoTipoEjercicio.add(tipoEjercicio.PECHO);
            enumeradoTipoEjercicio.add(tipoEjercicio.PIERNAS);
            numEjercicios = 6;

            // Busca ejercicios que guardar
            for (int i = 0; contador < numEjercicios && i < listaEjercicios.size() ;i++){

                // Si ya ha metido un ejercicio de cada tipo, introduce cualquiera de otro tipo menos de cardio
                if(enumeradoTipoEjercicio.isEmpty() && listaEjercicios.get(i).getTipo() != tipoEjercicio.CARDIO) {
                    Ejercicio e = new Ejercicio(listaEjercicios.get(i), intensidadMedia);
                    e.setNumRepeticiones(e.obtenerNivelOptimo(intensidadMedia));

                    listaFinal.add(e.getIdentificador());
                    contador++;

                    listaEjercicios.remove(i);
                }

                // Si queda un tipo de ejercicio que no se ha introducido, lo busca e introduce
                else if (enumeradoTipoEjercicio.contains(listaEjercicios.get(i).getTipo())){
                    enumeradoTipoEjercicio.remove(listaEjercicios.get(i).getTipo());

                    Ejercicio e = new Ejercicio(listaEjercicios.get(i), intensidadMedia);
                    e.setNumRepeticiones(e.obtenerNivelOptimo(intensidadMedia));

                    listaFinal.add(e.getIdentificador());
                    contador++;

                    listaEjercicios.remove(i);
                }
            }

        }

        //Si no se escoge mixto, se busca generar de un tipo específico
        else{
            for (int i = 0; contador < numEjercicios && i < listaEjercicios.size() ;i++){
                if(listaEjercicios.get(i).getTipo().equals(tipo)){

                    Ejercicio e = new Ejercicio(listaEjercicios.get(i), intensidadMedia);
                    e.setNumRepeticiones(e.obtenerNivelOptimo(intensidadMedia));

                    listaFinal.add(e.getIdentificador());
                    contador++;

                    listaEjercicios.remove(i);
                }
            }

        }
        long insercion2;
        for (int e: listaFinal){
            cv = new ContentValues();
            cv.put("IDLISTA", (int)insercion);
            cv.put("IDEJER", e);
            insercion2 = db.insert(RELACION_EJER_LISTA, null, cv);
            if (insercion2 == -1)
                return -1;
        }
        db.close();

        return insercion;
    }

    /**
     * Este método cambia la intensidad de una lista al nivel deseado.
     * Sirve tanto para subir la intensidad como para bajarla.
     * @param id id de la Lista a la que cambiar.
     * @param nivel siguiente nivel de intensidad.
     * @return si ha tenido éxito
     */
    public boolean cambiarIntensidadLista(int id, float nivel){
        String query = "SELECT * FROM " + TABLA_LISTAEJER + " WHERE ID = " + id;

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("INTENSIDAD", nivel);
        long resultado = db.update(TABLA_LISTAEJER, cv, "ID = ?", new String[]{String.valueOf(id)});

        db.close();
        if(resultado != -1)
            return true;
        else
            return false;

    }

    /**
     * Devuelve el objeto ListaEjercicios cuyo id es el indicado
     * @param id el id de la ListaEjercicios
     * @return el objeto ListaEjercicios que se quería consultar
     */
    public ListaEjercicios obtenerLista(int id){
        ListaEjercicios l = null;
        String query = "SELECT * FROM " + TABLA_LISTAEJER + " WHERE ID = " + id;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(query, null);

        if (c.moveToFirst()){
            ArrayList<Ejercicio> e = this.obtenerEjerciciosDeLista(id, c.getFloat(2));
            tipoEjercicio t = null;
            switch (c.getInt(3)){
                case 0:
                    t = tipoEjercicio.CARDIO;
                    break;
                case 1:
                    t = tipoEjercicio.MUSCULO;
                    break;
                case 2:
                    t = tipoEjercicio.MIXTA;
                    break;


            }
            l = new ListaEjercicios(c.getInt(0),c.getInt(1), e, c.getFloat(2), t);
            l.setId(c.getInt(0));
        }
        c.close();
        db.close();
        return l;
    }

    /**
     * Este méetodo devuelve una lista de ListaEjercicios, los cuales están asociados a la rutina con el id indicado
     * @param id el id de la Rutina
     * @return la lista de ListaEjercicios asociados a la rutina
     */
    public ArrayList<ListaEjercicios> obtenerListasDeRutina(int id){

        ArrayList<ListaEjercicios> l = new ArrayList<>();
        ListaEjercicios lista;

        String query = "SELECT * FROM " + TABLA_LISTAEJER + " WHERE TABLA_LISTAEJER.ID IN (SELECT RELACION_LISTAS_RUTINA.IDLISTA FROM " + RELACION_LISTAS_RUTINA + " WHERE RELACION_LISTAS_RUTINA.IDRUTINA = " + id + ")";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(query, null);

        if (c.moveToFirst()){
            do {
                ArrayList<Ejercicio> e = this.obtenerEjerciciosDeLista(id, c.getFloat(2));
                tipoEjercicio t = null;
                switch (c.getInt(3)){
                    case 0:
                        t = tipoEjercicio.CARDIO;
                        break;
                    case 1:
                        t = tipoEjercicio.MUSCULO;
                        break;
                    case 2:
                        t = tipoEjercicio.MIXTA;
                        break;


                }

                lista = new ListaEjercicios(c.getInt(0), c.getInt(1), e, c.getFloat(2), t);
                lista.setId(c.getInt(0));

                l.add(lista);

            }while(c.moveToNext());

        }
        else{
            c.close();
            db.close();
            return null;
        }
        c.close();
        db.close();
        return l;
    }


    /**
     * Este método borra el ListaEjercicios asociado al id indicado de la base de datos.
     * También se encarga de borrar las relaciones de la tabla RELACION_EJER_LISTA y de la tabla RELACION_LISTAS_RUTINA
     * @param id el id del ListaEjercicios
     * @return si ha tenido exito
     */
    public boolean borrarLista(int id){

        boolean resultado = false;
        SQLiteDatabase db = this.getWritableDatabase();

        int numBorrado = db.delete(RELACION_EJER_LISTA, "IDLISTA = ?", new String[]{String.valueOf(id)});

        if(numBorrado != 0)
            resultado = true;


        numBorrado = db.delete(RELACION_LISTAS_RUTINA, "IDLISTA = ?", new String[]{String.valueOf(id)});
        if(numBorrado != 0)
            resultado = true;


        numBorrado = db.delete(TABLA_LISTAEJER, "ID = ?", new String[]{String.valueOf(id)});
        if(numBorrado != 0)
            resultado = true;


        return resultado;

    }


    /**
     * Añade una rutina nueva a la base de datos.
     * Adapta los datos introducidos para que se introduzcan correctamente.
     * También añade los ListaEjercicios asociados a esta rutina y las relaciones necesarias
     * @param nombre el nombre de la rutina
     * @param numDias el numero de dias
     * @param intensidadRutina la intensidad elegida para la rutina
     * @param tipoRutina el tipo de rutina: cardio, musculo o mixto
     * @return
     */
    public boolean anadirRutina(String nombre, int numDias, int intensidadRutina, tipoEjercicio tipoRutina){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        long insercion = -1;

        cv.put("NOMBRE", nombre);
        cv.put("NUMDIAS", numDias);
        cv.put("INTENSIDAD", intensidadRutina);

        switch (tipoRutina){
            case CARDIO:
                cv.put("TIPO", 0);
                break;
            case MUSCULO:
                cv.put("TIPO", 1);
                break;
            case MIXTA:
                cv.put("TIPO", 2);
                break;

        }

        long insercion2;
        insercion = db.insert(TABLA_RUTINAS, null, cv);
        if (insercion == -1)
            return false;

        long insertado = -1;

        //INSERTA EL LISTAEJERCICIO Y JUSTO DESPUES INSERTA LA RELACION
        for(int i = 0; i < numDias; i++){
            cv = new ContentValues();
            insertado = this.anadirLista(5,intensidadRutina,tipoRutina);
            if (insertado == -1)
                return false;

            cv.put("IDRUTINA", (int)insercion);
            cv.put("IDLISTA", (int)insertado);
            if(!db.isOpen())
                db = this.getWritableDatabase();
            insercion2 = db.insert(RELACION_LISTAS_RUTINA, null, cv);
            if (insercion2 == -1)
                return false;
        }
        db.close();

        return true;
    }


    /**
     * Este metodo devuelve el objeto rutina asociado al id
     * @param id el id de la rutina a obtener
     * @return la rutina obtenida
     */
    public Rutina obtenerRutina(int id){
        Rutina r = null;
        String query = "SELECT * FROM " + TABLA_RUTINAS + " WHERE ID = " + id;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(query, null);

        if (c.moveToFirst()){
            ArrayList<ListaEjercicios> l = this.obtenerListasDeRutina(id);
            tipoEjercicio t = null;
            switch (c.getInt(4)){
                case 0:
                    t = tipoEjercicio.CARDIO;
                    break;
                case 1:
                    t = tipoEjercicio.MUSCULO;
                    break;
                case 2:
                    t = tipoEjercicio.MIXTA;
                    break;


            }
            r = new Rutina(c.getInt(0), c.getString(1), c.getInt(2), this.obtenerListasDeRutina(c.getInt(0)), c.getInt(3), t);
        }
        c.close();
        db.close();

        return r;
    }

    /**
     * Este método permite cambiar la intensidad de una rutina.
     * También cambia la intensidad de las ListaEjercicios asociadas a ella.
     * @param id id de la rutina
     * @param nivel intensidad nueva deseada
     * @return si ha tenido exito
     */
    public boolean cambiarIntensidadRutina(int id, float nivel){

        boolean exito;
        ArrayList<ListaEjercicios> lista = this.obtenerListasDeRutina(id);
        for(ListaEjercicios l: lista){
            exito = this.cambiarIntensidadLista(l.getId(),nivel);
            if(!exito)
                return false;
        }

        String query = "SELECT * FROM " + TABLA_RUTINAS + " WHERE ID = " + id;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("INTENSIDAD", nivel);
        long resultado = db.update(TABLA_RUTINAS, cv, "ID = ?", new String[]{String.valueOf(id)});

        db.close();
        if(resultado != -1)
            return true;
        else
            return false;

    }


    /**
     * Este método devuelve todas las rutinas existentes en la base de datos
     * @return una lista de rutinas
     */
    public ArrayList<Rutina> obtenerRutinas(){
        ArrayList<Rutina> r = new ArrayList<>();

        String query = "SELECT * FROM " + TABLA_RUTINAS;



        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(query, null);

        if (c.moveToFirst()){
            do {
                ArrayList<ListaEjercicios> l = this.obtenerListasDeRutina(c.getInt(0));
                tipoEjercicio t = null;
                switch (c.getInt(4)) {
                    case 0:
                        t = tipoEjercicio.CARDIO;
                        break;
                    case 1:
                        t = tipoEjercicio.MUSCULO;
                        break;
                    case 2:
                        t = tipoEjercicio.MIXTA;
                        break;


                }
                r.add( new Rutina(c.getInt(0), c.getString(1), c.getInt(2), this.obtenerListasDeRutina(c.getInt(0)), c.getInt(3), t));
            } while(c.moveToNext());
        }
        c.close();
        db.close();

        return r;
    }

    /**
     * Este método borra la rutina asociada al id proporcionado
     * También borra tanto las ListaEjercicios asociadas como las relaciones con dichas Listas
     * @param id el id de la rutina a borrar
     * @return si ha tenido exito
     */
    public boolean borrarRutina(int id){

        boolean resultado = false;

        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT IDLISTA FROM " + RELACION_LISTAS_RUTINA + " WHERE IDRUTINA = " + id;
        Cursor c = db.rawQuery(query, null);

        if(c.moveToFirst()) {
            do {
                this.borrarLista(c.getInt(0));
            } while (c.moveToNext());
        }
        

        int numBorrado = db.delete(RELACION_LISTAS_RUTINA, "IDRUTINA = ?", new String[]{String.valueOf(id)});
        if(numBorrado != 0) {
            resultado = true;
        }


        numBorrado = db.delete(TABLA_RUTINAS, "ID = ?", new String[]{String.valueOf(id)});
        if(numBorrado != 0) {
            resultado = true;
        }

        c.close();
        db.close();
        return resultado;

    }


    public Ejercicio obtenerEjercicio(int id, float intensidad){
        Ejercicio e;
        String query = "SELECT * FROM " + TABLA_EJERCICIOS + " WHERE ID = " + id;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(query, null);


        //    CARDIO, MUSCULO, MIXTA, PECHO, BRAZOS, ABDOMINALES, PIERNAS, ESPALDA
        if(c.moveToFirst()){
            tipoEjercicio t = null;
            switch (c.getInt(3)){
                case 0:
                    t = tipoEjercicio.CARDIO;
                    break;
                case 1:
                    t = tipoEjercicio.MUSCULO;
                    break;
                case 2:
                    t = tipoEjercicio.MIXTA;
                    break;
                case 3:
                    t = tipoEjercicio.PECHO;
                    break;
                case 4:
                    t = tipoEjercicio.BRAZOS;
                    break;
                case 5:
                    t = tipoEjercicio.ABDOMINALES;
                    break;
                case 6:
                    t = tipoEjercicio.PIERNAS;
                    break;
                case 7:
                    t = tipoEjercicio.ESPALDA;
                    break;

            }
            e = new Ejercicio(c.getInt(0), c.getString(1), c.getString(2), intensidad, t, c.getInt(4), c.getInt(5));

            c.close();
            db.close();

        }
        else{
            return null;
        }

        return e;
    }

    /**
     * Este método devuelve todos los ejercicios asociados a una ListaEjercicios
     * Se le pasa la intensidad, pues en la tabla de los Ejercicios no se guarda la intensidad, sino que se guarda en la ListaEjercicios
     * @param id El id de la Lista
     * @param intensidad La intensidad de la Lista
     * @return una lista de Ejercicio
     */
    public ArrayList<Ejercicio> obtenerEjerciciosDeLista(int id, float intensidad){
        ArrayList<Ejercicio> e = new ArrayList<>();
        String query = "SELECT * FROM " + TABLA_EJERCICIOS + " WHERE TABLA_EJERCICIOS.ID IN (SELECT RELACION_EJER_LISTA.IDEJER FROM " + RELACION_EJER_LISTA + " WHERE RELACION_EJER_LISTA.IDLISTA = " + id + ")";


        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(query, null);



        //    CARDIO, MUSCULO, MIXTA, PECHO, BRAZOS, ABDOMINALES, PIERNAS, ESPALDA
        if(c.moveToFirst()){
            do {

                tipoEjercicio t = null;
                switch (c.getInt(3)) {
                    case 0:
                        t = tipoEjercicio.CARDIO;
                        break;
                    case 1:
                        t = tipoEjercicio.MUSCULO;
                        break;
                    case 2:
                        t = tipoEjercicio.MIXTA;
                        break;
                    case 3:
                        t = tipoEjercicio.PECHO;
                        break;
                    case 4:
                        t = tipoEjercicio.BRAZOS;
                        break;
                    case 5:
                        t = tipoEjercicio.ABDOMINALES;
                        break;
                    case 6:
                        t = tipoEjercicio.PIERNAS;
                        break;
                    case 7:
                        t = tipoEjercicio.ESPALDA;
                        break;

                }

                e.add(new Ejercicio(c.getInt(0), c.getString(1), c.getString(2), intensidad, t, c.getInt(4), c.getInt(5)));

            }while (c.moveToNext());


        }
        else{
            c.close();
            db.close();
            return null;
        }
        c.close();
        db.close();

        return e;
    }

    /**
     * Este método obtiene todos los ejercicios que existen en la base de datos
     * @param intensidad una intensidad proporcionada
     * @return una lista de Ejercicio
     */
    public ArrayList<Ejercicio> obtenerTodosLosEjercicios(float intensidad){
        ArrayList<Ejercicio> e = new ArrayList<>();
        String query = "SELECT * FROM " + TABLA_EJERCICIOS + " ORDER BY RANDOM()";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(query, null);


        //    CARDIO, MUSCULO, MIXTA, PECHO, BRAZOS, ABDOMINALES, PIERNAS, ESPALDA
        if(c.moveToFirst()){
            do{
            tipoEjercicio t = null;
            switch (c.getInt(3)){
                case 0:
                    t = tipoEjercicio.CARDIO;
                    break;
                case 1:
                    t = tipoEjercicio.MUSCULO;
                    break;
                case 2:
                    t = tipoEjercicio.MIXTA;
                    break;
                case 3:
                    t = tipoEjercicio.PECHO;
                    break;
                case 4:
                    t = tipoEjercicio.BRAZOS;
                    break;
                case 5:
                    t = tipoEjercicio.ABDOMINALES;
                    break;
                case 6:
                    t = tipoEjercicio.PIERNAS;
                    break;
                case 7:
                    t = tipoEjercicio.ESPALDA;
                    break;

            }
            e.add( new Ejercicio(c.getInt(0), c.getString(1), c.getString(2), intensidad, t, c.getInt(4), c.getInt(5)));
            }while(c.moveToNext());

        }
        else{
            c.close();
            db.close();
            return null;
        }
        c.close();
        db.close();

        return e;
    }

}
