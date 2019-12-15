package main;

import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.HashMap;

public class Index implements Serializable {
    long lastModified = System.currentTimeMillis();
    HashMap<String, ImageData> dataFor;

    public void addImage(BufferedImage image) {
        throw new UnsupportedOperationException();
    }
}

class ImageData {
    // Variable to store keypoints.
}