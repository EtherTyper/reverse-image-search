package main;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class PopulateIndex {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // Either load or create a new index.
        boolean shouldUpdate = args.length >= 1 && args[0].equals("update");

        Index index;
        if (!shouldUpdate) {
            index = new Index();
        } else {
            FileInputStream indexFileIn = new FileInputStream("index.db");
            ObjectInputStream objIn = new ObjectInputStream(indexFileIn);

            index = (Index) objIn.readObject();
        }

        // Enumerate files in 'images' directory.
        List<Path> images = Files
                .list(Paths.get("images"))
                .filter(Files::isRegularFile)
                .collect(Collectors.toList());

        // Add data from each to the index.
        for (Path path : images) {
            File imageFile = path.toFile();

            // Check the image has been modified since the index was last updated.
            if (imageFile.lastModified() < index.lastModified) {
                BufferedImage image = ImageIO.read(path.toFile());
                index.addImage(image);
            }
        }

        index.lastModified = System.currentTimeMillis();

        // Save the index.
        FileOutputStream indexFileOut = new FileOutputStream("index.db");
        ObjectOutputStream objOut = new ObjectOutputStream(indexFileOut);

        objOut.writeObject(index);
    }
}
