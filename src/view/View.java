package view;

import java.util.Scanner;

public class View {
    public static Integer inputChoice() {
        System.out.println("=".repeat(160));
        System.out.print("[+] Insert option: ");
        return new Scanner(System.in).nextInt();
    }
    public static void menu(){
        System.out.println("=".repeat(160));
        System.out.println("1. Add new Course");
        System.out.println("2. List Courses");
        System.out.println("3. Find Course By ID");
        System.out.println("4. Find Course By Title");
        System.out.println("5. Remove Course By ID");
        System.out.println("0/99. Exit");
        System.out.println();
    }
}
