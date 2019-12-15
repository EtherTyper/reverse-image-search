package main;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.URI;
import java.util.Collection;

public class Server {
    ServerSocket socket;
    Index index;

    public Server() throws IOException, ClassNotFoundException {
        socket = new ServerSocket();
        populateIndex();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        new Server();
    }

    public void populateIndex() throws IOException, ClassNotFoundException {
        FileInputStream indexFileIn = new FileInputStream("index.db");
        ObjectInputStream objIn = new ObjectInputStream(indexFileIn);

        index = (Index) objIn.readObject();
    }

    public void render(Collection<URI> results) {
        StringBuilder output = new StringBuilder();

        // Render page.
        renderHeader(output);
        for (URI location : results) {
            renderImageResult(output, location, index.dataFor.get(location));
        }
        renderFooter(output);
    }

    public void renderHeader(StringBuilder output) {
        // TODO: Load CSS file.
        throw new UnsupportedOperationException();
    }

    public void renderFooter(StringBuilder output) {
        throw new UnsupportedOperationException();
    }

    public void renderImageResult(StringBuilder output, URI location, ImageData imageData) {
        output.append("<li>");
        output.append(String.format("<img src=\"%s\"></src>", location));
        output.append(String.format("<a href=\"%1$s\">%1$s</a>", location));
        output.append("</li>");
    }
}
