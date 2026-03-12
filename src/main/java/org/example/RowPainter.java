package org.example;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class RowPainter implements Runnable {

    private final BufferedImage image;
    private final int y;          // rækken der skal males
    private final Random random;

    public RowPainter(BufferedImage image, int y) {
        this.image = image;
        this.y = y;
        this.random = new Random();
    }

    @Override
    public void run() {
        int width = image.getWidth();
        for (int x = 0; x < width; x++) {
            int r = random.nextInt(256);
            int g = random.nextInt(256);
            int b = random.nextInt(256);
            int color = (r << 16) | (g << 8) | b;
            image.setRGB(x, y, color);
        }
    }
}

