package fr.dauphine.javaavance.td4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import static java.nio.file.Files.newDirectoryStream;

public class DirMonitor {
    private Path path;
    private ArrayList<Files> files;

    public DirMonitor(Path path) throws IOException {
        // If the path is not a directory or not readable, throw an exception
        if (!Files.isDirectory(path) || !Files.isReadable(path)) {
            throw new IOException();
        }
        this.path = path;
        this.files = new ArrayList<>();
    }

    // A method which can display all the files in the directory
    public void displayFiles() throws IOException {
        System.out.println("Files in the directory: ");
        for (Path path : newDirectoryStream(path)) {
            System.out.println(path.getFileName());
        }
    }

    // A method which return sum of the size of all the files in the directory
    public long sizeOfFiles() throws IOException {
        long size = 0;
        for (Path path : newDirectoryStream(path)) {
            size += Files.size(path);
        }
        return size;
    }

    // Return the most recent file in the directory
    public Path mostRecent() throws IOException {
        Path mostRecent = null;
        for (Path path : newDirectoryStream(path)) {
            if (mostRecent == null) {
                mostRecent = path;
            } else if (Files.getLastModifiedTime(path).compareTo(Files.getLastModifiedTime(mostRecent)) > 0) {
                mostRecent = path;
            }
        }
        return mostRecent;
    }
}
