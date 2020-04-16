package de.ccd.nback.adapter;

import lombok.SneakyThrows;

import java.nio.file.Files;
import java.nio.file.Path;

public class FileSystemImpl implements FileSystem {

    @Override
    @SneakyThrows
    public void writeFile(Path path, String content) {
        Files.writeString(path, content);
    }
}
