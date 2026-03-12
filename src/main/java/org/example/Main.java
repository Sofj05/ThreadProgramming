package org.example;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    /* Opgave 1
    public static void main(String[] args) throws InterruptedException {
        runThreadsInOrder();
    }

    public static void runThreadsInOrder() throws InterruptedException {

        Thread t1 = new Thread(new NumberPrinter(8));
        Thread t2 = new Thread(new NumberPrinter(1));
        Thread t3 = new Thread(new NumberPrinter(2));
        Thread t4 = new Thread(new NumberPrinter(5));

        t1.start();
        t1.join(); // Vent til tråd 1 er færdig

        t2.start();
        t2.join(); // Vent til tråd 2 er færdig

        t3.start();
        t3.join(); // Vent til tråd 3 er færdig

        t4.start();
        t4.join(); // Vent til tråd 4 er færdig
     */

    /* Opgave 2
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Indtast et positivt heltal n: ");
        int n = scanner.nextInt();

        for (int i = 1; i <= n; i++) {
            Thread t = new Thread(new MyThreadTask(i));
            t.start();
        }
    }
}
     */

    public static void main(String[] args) throws InterruptedException, IOException {
        int width = 784;
        int height = 1168;

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        Thread[] threads = new Thread[height];

        // én tråd pr. række
        for (int y = 0; y < height; y++) {
            threads[y] = new Thread(new RowPainter(image, y));
            threads[y].start();
        }

        // vent på alle tråde
        for (int y = 0; y < height; y++) {
            threads[y].join();
        }

        // gem billedet
        ImageIO.write(image, "JPEG", new File("TestPictureThread.JPEG"));
        System.out.println("Færdig – billede gemt som TestPictureThread.JPEG");
    }
}




