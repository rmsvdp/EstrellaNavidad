
/**
 * Importación de librerías
 */
import arrayView.arrayView;
import TiraLed.Led;
import TiraLed.TiraLed;
import java.awt.Color;


public class WetStar {

	public static void main(String[] args) {
		// TODO  Inicializar el tablero
		// 32 columnas y 16 filas
		arrayView av = new arrayView (16,8);
		av.turnOff();
		
		// TODO  Crear tiras y aplicar efectos
		/*
		 * 1.- Instanciar objeto tira, indicando el número de leds que tendrá
		 * 2.- Especificar la ublicación de los leds en el tablero, para ello
		 *     usaremos la opcción de hacer click en cada celda. El programa 
		 *     mostrará por consola las coordenadas. Se debe tener en cuenta
		 *     que el orden en el que hagamos click /ordenemos estas coordenadas
		 *     hará referencia a la ubicación física de los leds en la tira
		 * 3.- Aplicar el efecto deseado, con las fuciones disponibles:
		 * 			- Inicializa Tira de Leds
		 * 				initTira() 
		 * 			- Todos los leds de un color
		 * 				allLeds(Color _color) 
		 * 			- Actualizar la posición de la cabecera
		 * 				setHead(int head)
		 * 			- Cambiar el color del led de cabecera y desplaza la cabecera
		 * 				shiftHead(int dir,Color _color, boolean persist)
		 *          - Cambia el color de un segmento de leds dentro de la tira
		 *              drawLine(int ini,int fin,Color _color)
		 *     Es importante tener en cuenta que se pueden actualizar varias tiras
		 *     antes de pasar al siguiente paso.
		 * 4.- Refrescar el tablero para que recoja los cambios
		 * 5.- Aplicar pausa si es necesario    
		 */
		
		// -- Ejemplo de creación de una tira de leds con forma de rombo
		// Array de colores para mayor facilidad en tratamiento de bucles
		Color[] _color = {av.negro,av.azul,av.cyan,av.verde,av.naranja,av.amarillo,av.magenta,av.rojo,av.gris,av.blanco};
		//------------------------------------- rentágulo 6 x 12
		TiraLed t2 = new TiraLed(32);
		int pos2[][] = {{1,2},{1,3},{1,4},{1,5},{1,6},{1,7},{1,8},{1,9},{1,10},{1,11},{1,12},{1,13},{2,13},{3,13},{4,13},{5,13},
				        {6,13},{6,12},{6,11},{6,10},{6,9},{6,8},{6,7},{6,6},{6,5},{6,4},{6,3},{6,2},{5,2},{4,2},{3,2},{2,2}};
		t2.locateLeds(pos2);



	
		for (int i=0;i<11;i++) {
			
			t2.drawLine(0, 0+i, Color.RED);
			t2.drawLine(16, 16+i, Color.RED);
			if (i<5) {
				t2.drawLine(11, 11+i, Color.RED);
				t2.drawLine(27, 27+i, Color.RED);
			}
			av.refresh(t2);
			av.delay(125);
		}
		
		av.turnOff(); 
		for (int j=0;j<2;j++) {
			fade_off(av,t2,3);
			fade_on(av,t2,3);	
		} //j
			
		av.turnOff();

		
	} // main

	public static void fade_off(arrayView v,TiraLed t, int msec) {
		
		for (int i = 255;i>=0;i-=1) {
			Color c = new Color(i,0,0);
			t.allLeds(c); // Actualizo los leds
			v.refresh(t);
			v.delay(msec);
			}
	}
	
	public static void fade_on(arrayView v,TiraLed t, int msec) {
		
		for (int i = 0;i<256;i+=1) {
			Color c = new Color(i,0,0);
			t.allLeds(c); // Actualizo los leds
			v.refresh(t);
			v.delay(msec);
			}
	}
	
	
}
