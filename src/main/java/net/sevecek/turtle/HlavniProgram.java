package net.sevecek.turtle;

import net.sevecek.turtle.engine.*;

import java.awt.*;

public class HlavniProgram {

    Turtle zofka;
    double stranaC;
    double stranaCZmrzliny;


    public void main(String[] args) {
        zofka = new Turtle();

        //Zmrzlina zacatek
        double stranaAZmrzlina = 200;
        double uhelGamaZmrzlina = 45;
        Color barvaKornoutku;
        barvaKornoutku = new Color(234, 172, 73);
        Color barvaZmrzliny;
        barvaZmrzliny = new Color(43, 33, 18);

        zofka.setLocation(200, 150);
        zofka.turnRight(202);
        vypocitejDelkuTretiStrany(stranaAZmrzlina, uhelGamaZmrzlina);
        stranaCZmrzliny = vypocitejDelkuTretiStrany(stranaAZmrzlina, uhelGamaZmrzlina);
        nakresliRovnoramennyTrojuhlednik(stranaAZmrzlina,
                uhelGamaZmrzlina, stranaCZmrzliny, barvaKornoutku);
        zofka.turnRight(68);
        zofka.penUp();
        zofka.move((stranaCZmrzliny+1));
        zofka.turnRight(92);
        zofka.move(20);
        zofka.penDown();
        nakresliKruh(stranaCZmrzliny, barvaZmrzliny);
        zofka.turnLeft(3);

        // Snehulak zacatek, pomery kruhu 1:1.5:2:0.5
        Color barvaSnehulaka;
        barvaSnehulaka = new Color(2, 225, 255);
        zofka.setLocation(350,150);
        zofka.turnLeft(90);
        nakresliKruh(50, barvaSnehulaka);
        zofka.turnLeft(180);
        nakresliKruh(75, barvaSnehulaka);
        zofka.penUp();
        for (int i = 0; i < 91; i++) {
            zofka.turnRight(1);
            zofka.move((Math.PI*75/2)/180);
        }
        zofka.penDown();
        zofka.turnLeft(180);
        nakresliKruh(25, barvaSnehulaka);
        zofka.turnLeft(90);
        zofka.penUp();
        zofka.move(75);
        zofka.penDown();
        zofka.turnLeft(90);
        nakresliKruh(25, barvaSnehulaka);
        zofka.turnLeft(180);
        zofka.penUp();
        for (int i = 0; i < 270; i++) {
            zofka.turnRight(1);
            zofka.move((Math.PI * 75 / 2) / 180);
        }
        zofka.turnLeft(180);
        zofka.penDown();
        nakresliKruh(100, barvaSnehulaka);
        zofka.turnRight(180);
        // Snehulak konec

        // Lokomotiva zacatek
        Color barvaPredek;
        barvaPredek = new Color(2, 255, 36);
        Color barvaKolecek;
        barvaKolecek = new Color(246, 23, 23);
        Color barvaTela;
        barvaTela = new Color(255, 230, 2);
        Color barvaKominu;
        barvaKominu = new Color(27, 38, 216);
        double stranaA = 100;
        double uhelGama = 90;
        stranaC = vypocitejDelkuTretiStrany(stranaA, uhelGama);
        zofka.setLocation(550, 200);
        zofka.turnLeft(90);
        nakresliRovnoramennyTrojuhlednik(stranaA, uhelGama, stranaC, barvaPredek);
        zofka.turnRight(180);
        zofka.move(25);
        zofka.turnRight(90);
        nakresliObdelnik(200, 100, barvaTela);
        zofka.move(200);
        zofka.turnRight(90);
        zofka.move(100);
        zofka.turnRight(180);
        nakresliObdelnik(200, 100, barvaKominu);
        nakresliKruh(100, barvaKolecek);
        zofka.turnLeft(90);
        zofka.penUp();
        zofka.move(33);
        zofka.turnLeft(90);
        zofka.move(33);
        zofka.penDown();
        nakresliKruh(50, barvaKolecek);
        zofka.turnRight(90);
        zofka.penUp();
        zofka.move(90);
        zofka.penDown();
        zofka.turnLeft(90);
        nakresliKruh(50, barvaKolecek);
        // Lokomotiva konec

    }

    public void nakresliObdelnik(double velikostStranyA, double velikostStranyB,
                                 Color barvaObdelniku) {
        for (int i = 0; i < 2; i++) {
            zofka.setPenColor(barvaObdelniku);
            zofka.move(velikostStranyA);
            zofka.turnRight(90);
            zofka.move(velikostStranyB);
            zofka.turnRight(90);
        }
    }

        public void nakresliKruh(double prumerKruhu, Color barvaKruhu){
            for (int i = 0; i < 360; i++) {
                zofka.setPenColor(barvaKruhu);
                zofka.turnRight(1);
                zofka.move((Math.PI * prumerKruhu / 2) / 180);
            }
        }

        public void nakresliRovnoramennyTrojuhlednik(double stranaA,
                                                     double uhelGama,
                                                     double stranaC,
                                                     Color barvaRovnoramennehoTrojuhelniku) {
            zofka.setPenColor(barvaRovnoramennehoTrojuhelniku);
            zofka.move(stranaA);
            zofka.turnRight(180 - uhelGama);
            zofka.move(stranaA);
            zofka.turnRight(180 - ((180 - uhelGama)/2));
            zofka.move(stranaC);
            zofka.turnRight(180 - ((180 - uhelGama)/2));


        }

    public double vypocitejDelkuTretiStrany(double velikostRamene,
                                            double uhelMeziRameny) {
        double stranaC;
        stranaC = Math.abs((velikostRamene
                * Math.sin((uhelMeziRameny * Math.PI / 180.0) / 2.0))
                * 2.0);
        return stranaC;
    }
    }
