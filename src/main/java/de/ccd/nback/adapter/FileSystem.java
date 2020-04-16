package de.ccd.nback.adapter;

import java.nio.file.Path;

public interface FileSystem {
    void writeFile(Path path, String content);
}
