package com.company.util.InputManager;

public class InputManagerImpl implements InputManager {

    @Override
    public int getInt() {
        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }

    @Override
    public int getIntWithDescription(String description) {
        System.out.println(description);
        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }

    @Override
    public String getString() {
        return scanner.nextLine();
    }

    @Override
    public String getStringWithDescription(String description) {
        System.out.println(description);
        return scanner.nextLine();
    }
}
