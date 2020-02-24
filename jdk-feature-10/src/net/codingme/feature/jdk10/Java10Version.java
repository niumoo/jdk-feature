package net.codingme.feature.jdk10;

import java.lang.Runtime.Version;
import java.util.Optional;

public class Java10Version {
    public static void main(String[] args) {
        Version version = Runtime.version();
        int feature = version.feature();
        int interim = version.interim();
        int update = version.update();
        int patch = version.patch();

        System.out.println(feature);
        System.out.println(interim);
        System.out.println(update);
        System.out.println(patch);
    }
}
