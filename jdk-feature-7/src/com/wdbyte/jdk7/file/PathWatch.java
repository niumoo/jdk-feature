package com.wdbyte.jdk7.file;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchEvent.Kind;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

/**
 * 目录内容监视
 *
 * @author darcy
 * @date 2020/09/07
 */
public class PathWatch {
    public static void main(String[] args) throws IOException, InterruptedException {

        WatchService watchService = FileSystems.getDefault().newWatchService();
        Path path = Paths.get("/Users/darcy/git/jdk-feature/jdk-feature-7/src/com/wdbyte/jdk7");
        path.register(watchService,
            StandardWatchEventKinds.ENTRY_CREATE,
            StandardWatchEventKinds.ENTRY_DELETE,
            StandardWatchEventKinds.ENTRY_MODIFY);

        while (true) {
            WatchKey watchKey = watchService.take();
            // 获取事件类型
            for (WatchEvent<?> pollEvent : watchKey.pollEvents()) {
                // 具体的事件上下文信息
                Path tempPath = (Path)pollEvent.context();
                Kind<?> kind = pollEvent.kind();
                if (kind.name().equals(StandardWatchEventKinds.ENTRY_CREATE.name())) {
                    System.out.println("创建了一个文件：" + tempPath.toString());
                }
                if (kind.name().equals(StandardWatchEventKinds.ENTRY_DELETE.name())) {
                    System.out.println("删除了一个文件：" + tempPath.toString());
                }
                if (kind.name().equals(StandardWatchEventKinds.ENTRY_MODIFY.name())) {
                    System.out.println("修改了一个文件：" + tempPath.toString());
                }
            }
            // 事件处理完毕后要进行 reset 才能继续监听事件
            watchKey.reset();
            // 取消监视
            // watchKey.cancel();
        }

    }
}
