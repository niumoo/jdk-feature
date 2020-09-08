package net.codingme.feature.jdk11;

import java.io.IOException;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.List;

import jdk.jfr.consumer.RecordedEvent;
import jdk.jfr.consumer.RecordingFile;

/**
 * <p>
 * 飞行记录器监控模拟程序
 *
 * @author niujinpeng
 * @Date 2020/3/1 12:45
 */
public class Java11JFR {

    public static void main(String[] args) throws InterruptedException, IOException {
        readJFR();
    }

    public static void readJFR() throws IOException {
        List<RecordedEvent> recordedEvents = RecordingFile.readAllEvents(Paths.get("java11jfr.jfr"));
        for (RecordedEvent recordedEvent : recordedEvents) {
            Instant startTime = recordedEvent.getStartTime();
            Object message = recordedEvent.getValue("message");
            System.out.println(startTime);
            System.out.println(message);
        }

    }
}
