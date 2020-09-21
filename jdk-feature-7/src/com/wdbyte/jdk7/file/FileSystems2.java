package com.wdbyte.jdk7.file;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
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
 * @date 2020/09/14
 */
public class FileSystems2 {

    public static void main(String[] args) throws URISyntaxException, IOException {
        Path path = Paths.get("/Users/darcy/git/jdk-feature/归档.zip");
        HashMap<String, String> env = new HashMap<>();
        env.put("create", "true");
        try (FileSystem fileSystem = FileSystems.newFileSystem(URI.create("jar:" + path.toFile().toURI()), env)) {
            //Iterable<FileStore> fileStores = fileSystem.getFileStores();

            //for (FileStore fileStore : fileStores) {
            //    System.out.println(fileStore.name());
            //}
            Iterable<Path> rootDirectories = fileSystem.getRootDirectories();
            for (Path rootDirectory : rootDirectories) {
                System.out.println(rootDirectory.getFileName());
            }
            //Path newFilePath = fileSystem.getPath("/new_text.txt");
            //Files.copy(Psaths.get("test.txt"), newFilePath, StandardCopyOption.REPLACE_EXISTING);
            //System.out.println(newFilePath.toAbsolutePath().toString());
        }
    }

}
