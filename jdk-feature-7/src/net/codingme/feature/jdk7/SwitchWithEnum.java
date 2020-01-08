package net.codingme.feature.jdk7;

/**
 * switch 和 枚举类
 *
 * @author www.codingme.net
 */
public class SwitchWithEnum {
    public static void main(String[] args) {
        String user = "达西";
        int role = 1;
        switch (UserRoleEnum.getValue(role)) {
            case SUPER_ADMIN:
                System.out.println("你好，尊敬的超级管理员");
                break;
            case ADMIN:
                System.out.println("你好，尊敬的管理员");
                break;
            case VIP_USER:
                System.out.println("你好，尊敬的 Vip 用户");
                break;
            case USER:
                System.out.println("你好，尊敬的用户");
                break;
        }

    }
}

enum UserRoleEnum {
    SUPER_ADMIN(0),
    ADMIN(1),
    VIP_USER(2),
    USER(3);

    private Integer role;

    UserRoleEnum(Integer role) {
        this.role = role;
    }

    public Integer getRole() {
        return role;
    }

    public static UserRoleEnum getValue(int role) {
        UserRoleEnum[] values = values();
        for (UserRoleEnum value : values) {
            if (value.getRole() == role) {
                return value;
            }
        }
        return null;
    }
}

