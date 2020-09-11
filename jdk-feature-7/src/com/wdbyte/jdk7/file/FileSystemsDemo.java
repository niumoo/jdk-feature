package com.wdbyte.jdk7.file;

import java.io.IOException;
import java.net.URI;
import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;

/**
 * @author darcy
 * @date 2020/09/08
 */
public class FileSystemsDemo {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("/Users/darcy/git/jdk-feature/归档.zip");
        HashMap<String, String> env = new HashMap<>();
        env.put("create", "true");
        try (FileSystem fileSystem = FileSystems.newFileSystem(URI.create("jar:" + path.toFile().toURI()), env)) {
            Path newFilePath = fileSystem.getPath("/new_text.txt");
            Files.copy(Paths.get("test.txt"), newFilePath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println(newFilePath.toAbsolutePath().toString());
        }
    }
}
