package net.codingme.feature.jdk10;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Java10NewApis {

    public static void main(String[] args) {
        var list = new ArrayList<String>();
        list.add("wechat");
        list.add("wn8398");
        List<String> copyList = List.copyOf(list);
        list.add("test");
        System.out.println(copyList);

        Optional<String> optional = Optional.ofNullable(null);
        String s = optional.orElseThrow();
        System.out.println(s);

        list.stream().collect(Collectors.toUnmodifiableList());
        list.stream().collect(Collectors.toUnmodifiableSet());
    }
}
