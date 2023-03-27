package Tests;
import Clases.Cuenta;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.crypto.CipherInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class TestCartera {

    //-----------Creacion de Cuenta-------------------
    @Test
    public void crearCuenta(){
        Cuenta c1 = new Cuenta(0.0);
        Double resultadoEsperado = 0.0;
        Double resultadoReal = c1.getSalario();
        assertEquals(resultadoEsperado, resultadoReal);
    }
    //-----------Ingresos-------------------
    @Test
    public void Ingresar1(){
        Cuenta c1 = new Cuenta(0.0);
        Double resultadoEsperado = 100.0;
        Double resultadoReal = c1.ingresar(100);
        assertEquals(resultadoEsperado, resultadoReal);
    }
    @Test
    public void Ingresar2(){
        Cuenta c1 = new Cuenta(0.0);
        Double resultadoEsperado = 3000.0;
        Double resultadoReal = c1.ingresar(3000);
        assertEquals(resultadoEsperado, resultadoReal);
    }
    @Test
    public void Ingresar3(){
        Cuenta c1 = new Cuenta(100.0);
        Double resultadoEsperado = 3100.0;
        Double resultadoReal = c1.ingresar(3000);
        assertEquals(resultadoEsperado, resultadoReal);
    }

    @Test
    public void IngresarNegativo(){
        Cuenta c1 = new Cuenta(0.0);
        Double resultadoEsperado = 0.0;
        Double resultadoReal = c1.ingresar(-100);
        assertEquals(resultadoEsperado, resultadoReal);
    }

    @Test
    public void IngresarDecimales(){
        Cuenta c1 = new Cuenta(0.0);
        Double resultadoEsperado = 100.45;
        Double resultadoReal = c1.ingresar((double)100.45);
        assertEquals(resultadoEsperado, resultadoReal, 0.001);
    }

    @Test
    public void IngresarMax1(){
        Cuenta c1 = new Cuenta(0.0);
        Double resultadoEsperado = 6000.0;
        Double resultadoReal = c1.ingresar(6000);
        assertEquals(resultadoEsperado, resultadoReal, 0.001);
    }

    @Test
    public void IngresarMax2(){
        Cuenta c1 = new Cuenta(0.0);
        Double resultadoEsperado = 0.0;
        Double resultadoReal = c1.ingresar(6000.01);
        assertEquals(resultadoEsperado, resultadoReal, 0.001);
    }

    //-----------Retiradas-------------------

    @Test
    public void retirarSinComision(){
        Cuenta c1 = new Cuenta(500.0);
        Double resultadoEsperado = 400.0;
        Double resultadoReal = c1.retirar(100.0);
        assertEquals(resultadoEsperado, resultadoReal, 0.001);
    }

    @Test
    public void retiradaMasQueSaldo(){
        Cuenta c1 = new Cuenta(200.0);
        Double resultadoEsperado = 200.0;
        Double resultadoReal = c1.retirar(500.0);
        assertEquals(resultadoEsperado, resultadoReal, 0.001);
    }

    @Test
    public void retiradaNegativa(){
        Cuenta c1 = new Cuenta(500.0);
        Double resultadoEsperado = 500.0;
        Double resultadoReal = c1.retirar(-100.0);
        assertEquals(resultadoEsperado, resultadoReal, 0.001);
    }

    @Test
    public void retiradaDecimales(){
        Cuenta c1 = new Cuenta(500.0);
        Double resultadoEsperado = 399.55;
        Double resultadoReal = c1.retirar(100.45);
        assertEquals(resultadoEsperado, resultadoReal, 0.001);
    }

    @Test
    public void retiradaMax1(){
        Cuenta c1 = new Cuenta(7000.0);
        Double resultadoEsperado = 1000.0;
        Double resultadoReal = c1.retirar(6000.0);
        assertEquals(resultadoEsperado, resultadoReal, 0.001);
    }

    @Test
    public void retiradaMax2(){
        Cuenta c1 = new Cuenta(7000.0);
        Double resultadoEsperado = 7000.0;
        Double resultadoReal = c1.retirar(6000.01);
        assertEquals(resultadoEsperado, resultadoReal, 0.001);
    }

    //-----------Transferencias-------------------

    @Test
    public void transferencia(){
        Cuenta c1 = new Cuenta(500.0);
        Cuenta c2 = new Cuenta(50.0);
        Double[] resultadoEsperado = {400.0, 150.0};
        Double[] resultadoReal = c1.transferencia(c2, 100.0);
        Assertions.assertArrayEquals(resultadoEsperado, resultadoReal);
    }

    @Test
    public void transferenciaNegativa(){
        Cuenta c1 = new Cuenta(500.0);
        Cuenta c2 = new Cuenta(50.0);
        Double[] resultadoEsperado = {500.0, 50.0};
        Double[] resultadoReal = c1.transferencia(c2, -100.0);
        Assertions.assertArrayEquals(resultadoEsperado, resultadoReal);
    }

    @Test
    public void transferenciaMax1(){
        Cuenta c1 = new Cuenta(3500.0);
        Cuenta c2 = new Cuenta(50.0);
        Double[] resultadoEsperado = {500.0, 3050.0};
        Double[] resultadoReal = c1.transferencia(c2, 3000.0);
        Assertions.assertArrayEquals(resultadoEsperado, resultadoReal);
    }

    @Test
    public void transferenciaMax2(){
        Cuenta c1 = new Cuenta(3500.0);
        Cuenta c2 = new Cuenta(50.0);
        Double[] resultadoEsperado = {3500.0, 50.0};
        Double[] resultadoReal = c1.transferencia(c2, 3000.01);
        Assertions.assertArrayEquals(resultadoEsperado, resultadoReal);
    }
}
