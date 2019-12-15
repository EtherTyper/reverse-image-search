package main;

import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.net.URI;
import java.util.HashMap;

public class Index implements Serializable {
    long lastModified = System.currentTimeMillis();
    HashMap<URI, ImageData> dataFor;

    public void addImage(URI location, BufferedImage image) {
        throw new UnsupportedOperationException();
    }
}

class ImageData {
    // Variable to store keypoints.
}