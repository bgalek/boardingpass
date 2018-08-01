package it.detektywi.boardingpass;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.pdf417.PDF417Writer;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    private static final int WIDTH = 520;
    private static final int HEIGHT = 200;

    public static void main(String[] args) {
        var flight = new Flight("1111", AirportCode.valueOf("ZRH"), AirportCode.valueOf("WAW"), new FlightOperator("LO"), LocalDate.now());
        var passenger = new Passenger("Rick", "Sanchez");
        var ticket = new Ticket("ABC123", TicketClass.FIRST, new SeatNumber(34, SeatNumber.Column.B), 12);
        var boardingData = new BoardingPassData(flight, passenger, ticket).generate();
        logger.info(boardingData);
        render(boardingData);
    }

    private static void render(String data) {
        try {
            var pdf417Image = getPdf417Image(data);
            var window = singleFrame(imagePane(pdf417Image));
            window.setVisible(true);
        } catch (WriterException e) {
            logger.log(Level.SEVERE, e, () -> "could not write pdf417 image");
        }
    }

    private static BufferedImage getPdf417Image(String boardingData) throws WriterException {
        var pdf417Writer = new PDF417Writer();
        var bitMatrix = pdf417Writer.encode(boardingData, BarcodeFormat.PDF_417, WIDTH, HEIGHT);
        var width = bitMatrix.getWidth();
        var height = bitMatrix.getHeight();
        var image = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_BINARY);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, bitMatrix.get(x, y) ? Color.BLACK.getRGB() : Color.WHITE.getRGB());
            }
        }
        return image;
    }

    private static JFrame singleFrame(JComponent component) {
        var frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(component);
        frame.setSize(new Dimension(WIDTH, HEIGHT));
        return frame;
    }

    private static JPanel imagePane(BufferedImage image) {
        return new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, null);
            }
        };
    }
}
