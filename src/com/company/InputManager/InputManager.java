package com.company.InputManager;

import java.util.Scanner;

public interface InputManager {

    Scanner scanner = new Scanner(System.in);

    int getInt();

    int getIntWithDescription(String description);

    String getString();

    String getStringWithDescription(String description);
}
