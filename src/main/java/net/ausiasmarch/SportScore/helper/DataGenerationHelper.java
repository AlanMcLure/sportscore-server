package net.ausiasmarch.SportScore.helper;

import java.time.LocalDate;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class DataGenerationHelper {

    private static final String[] oNombres = {
            "Lionel", "Cristiano", "Neymar", "Andrés", "Luis", "Sergio", "Kylian", "Robert", "Kevin", "Eden", "Mohamed",
            "Antoine", "Paul", "Gareth", "Sadio", "Virgil", "Luka", "Karim", "Harry", "Manuel"
    };

    private static final String[] oEntrenadores = {
            "José Mourinho", "Pep Guardiola", "Jurgen Klopp", "Zinedine Zidane", "Diego Simeone",
            "Carlo Ancelotti", "Antonio Conte", "Mauricio Pochettino", "Ole Gunnar Solskjær", "Thomas Tuchel",
            "Massimiliano Allegri", "Julian Nagelsmann", "Ernesto Valverde", "Rafael Benítez", "Erik ten Hag",
            "Unai Emery", "Marcelo Bielsa", "Lucien Favre", "Brendan Rodgers", "Nuno Espírito Santo"
    };

    private static final String[] oApellidos = {
            "Messi", "Ronaldo", "Neymar", "Iniesta", "Suárez", "Ramos", "Mbappé", "Lewandowski", "DeBruyne", "Hazard",
            "Salah", "Griezmann", "Pogba", "Bale", "Mané", "VanDijk", "Modrić", "Benzema", "Kane", "Neuer"
    };

    private static final String[] oPosiciones = {
            "Portero", "Defensa", "Mediocentro", "Delantero"
    };

    private static final String[] oCiudades = {
            "Madrid", "Barcelona", "Valencia", "Sevilla", "Zaragoza", "Málaga", "Murcia", "Mallorca", "Las Palmas",
            "Bilbao", "Alicante", "Córdoba", "Valladolid", "Vigo", "Gijón", "Hospitalet", "Vitoria", "Tenerife",
            "Santander"
    };

    private static final String[] oPaises = {
            "España", "Inglaterra", "Francia", "Alemania", "Italia",
            "Portugal", "Argentina", "Brasil", "Holanda", "Bélgica",
            "México", "Chile", "Colombia", "Uruguay", "Paraguay",
            "Ecuador", "Perú", "Venezuela", "Estados Unidos", "Canadá"
    };

    private static final String[] oPrefijos = {
            "FC", "Atlético de", "Real", "UD"
    };

    public static int getRandomInt(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    public static String getRandomNombre() {
        return oNombres[(int) (Math.random() * oNombres.length)];
    }

    public static String getRandomApellido() {
        return oApellidos[(int) (Math.random() * oApellidos.length)];
    }

    public static String generarNacionalidad() {
        int indicePais = ThreadLocalRandom.current().nextInt(oPaises.length);
        return oPaises[indicePais];
    }

    public static String generarPosicion() {
        int indicePosicion = ThreadLocalRandom.current().nextInt(oPosiciones.length);
        return oPosiciones[indicePosicion];
    }

    public static String generarNombreEquipo() {
        Random random = new Random();
        String ciudad = oCiudades[random.nextInt(oCiudades.length)];
        String prefijo = oPrefijos[random.nextInt(oPrefijos.length)];

        return prefijo + " " + ciudad;
    }

    public static String generarCiudad() {
        int indiceCiudad = ThreadLocalRandom.current().nextInt(oCiudades.length);
        return oCiudades[indiceCiudad];
    }

    public static String getRandomEntrenador() {
        return oEntrenadores[(int) (Math.random() * oEntrenadores.length)];
    }

    public static LocalDate generarFechaNacimiento() {
        int edad = ThreadLocalRandom.current().nextInt(18, 36);
        return LocalDate.now().minusYears(edad);
    }

    public static LocalDate generarFechaFundacionEquipo() {
        int antiguedad = ThreadLocalRandom.current().nextInt(50, 151);
        return LocalDate.now().minusYears(antiguedad);
    }

    public static LocalDate generarFechaPartido() {
        int diasAtras = ThreadLocalRandom.current().nextInt(1, 31);
        return LocalDate.now().minusDays(diasAtras);
    }

    public static String doNormalizeString(String cadena) {
        String original = "áàäéèëíìïóòöúùuñÁÀÄÉÈËÍÌÏÓÒÖÚÙÜÑçÇ";
        String ascii = "aaaeeeiiiooouuunAAAEEEIIIOOOUUUNcC";
        String cadenaSinAcentos = cadena;
        for (int i = 0; i < original.length(); i++) {
            cadenaSinAcentos = cadenaSinAcentos.replace(original.charAt(i), ascii.charAt(i));
        }
        return cadenaSinAcentos;
    }

}
