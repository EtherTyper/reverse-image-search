package main;

import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.net.URI;
import java.util.HashMap;

public class Index implements Serializable {
    long lastModified = System.currentTimeMillis();
    HashMap<String, ImageData> dataFor;

    public void addImage(URI location, BufferedImage image) {
        throw new UnsupportedOperationException();
    }
}

class ImageData {
    URI location;

    // Variable to store keypoints.
}