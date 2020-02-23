package com.company;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.MouseEvent;
import java.awt.event.KeyEvent;
import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

    public class Main {
        private static Robot bot = null;

        public static void main(String[] args) {
            try {
                bot = new Robot();
            } catch (AWTException e) {
                e.printStackTrace();
            }
            klick(550, 600);
            pastee(600, 350, "Seafood");
            klick(600, 350);
            scrolle();
            klick(600, 820);
            klick(600, 820);
            klick(600, 820);
            pastee(740,720,"10");


        }

        public static void klick(int x, int y) {
            bot.mouseMove(x, y);
            bot.delay(5);
            bot.mousePress(MouseEvent.BUTTON1_MASK);
            bot.mouseRelease(MouseEvent.BUTTON1_MASK);
            bot.delay(10000);
        }

        public static void pastee(int x, int y, String cop) {
            bot.mouseMove(x, y);
            bot.delay(5);
            bot.mousePress(MouseEvent.BUTTON1_MASK);
            bot.mouseRelease(MouseEvent.BUTTON1_MASK);
            bot.delay(3000);

            //Copying

            String myString = cop;
            StringSelection stringSelection = new StringSelection(myString);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, null);

            try {
                Robot r = new Robot();
                r.keyPress(KeyEvent.VK_CONTROL);
                r.keyPress(KeyEvent.VK_V);
                r.keyRelease(KeyEvent.VK_CONTROL);
                r.keyRelease(KeyEvent.VK_V);
                bot.delay(2000);

            } catch (Exception e) {

            }
        }


        public static void scrolle() {
            bot.mouseWheel(15);
            bot.delay(3000);
            bot.mousePress(MouseEvent.BUTTON1_MASK);
            bot.mouseRelease(MouseEvent.BUTTON1_MASK);
            bot.delay(10000);

        }
    }






