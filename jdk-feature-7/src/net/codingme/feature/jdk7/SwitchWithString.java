package net.codingme.feature.jdk7;


/*
 * @author www.codingme.net
 */
public class SwitchWithString {

    public static void main(String[] args) {
        String gender = "男";
        System.out.println(gender.hashCode());
        switch (gender) {
            case "男":
                System.out.println("先生你好");
                break;
            case "女":
                System.out.println("女士你好");
                break;
            default:
                System.out.println("你好");
        }
    }
}

