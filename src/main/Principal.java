package main;

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.concurrent.ThreadLocalRandom;

public class Principal {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int dormirInicial = 10000;
		int clickPorDebajo = 10000;//300000;
		int clickPorEncima = 150000;
		
		try {
			System.out.println("comienza en 10seg");
			Thread.sleep(dormirInicial);
			
			Point p = MouseInfo.getPointerInfo().getLocation();
			System.out.println("Posicion del mouse" +  p);

			boolean clicking = true;
			int clicked = 0;
			Robot robot = new Robot();
			while (clicking) {
				try {
					Point z = MouseInfo.getPointerInfo().getLocation();
					System.out.println("Posicion del mouse" +  z);
					
					int randomNum = ThreadLocalRandom.current().nextInt(clickPorDebajo, clickPorEncima);
					System.out.println("Proximo click en" +  randomNum);

					Thread.sleep(randomNum);
					robot.mousePress(InputEvent.BUTTON1_MASK);
					robot.mouseRelease(InputEvent.BUTTON1_MASK);
					clicked++;
					System.out.println("Cantidad de Clicks" +  clicked);

					if (Math.round(z.getX()+z.getY()) != Math.round(p.getX()+p.getY())) {
						System.out.println("Mouse se movio");
						clicking = false;
					}

				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		} catch (AWTException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
