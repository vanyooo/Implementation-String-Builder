package com.zimin;

public class App 
{
    public static void main( String[] args ) {

        System.out.println("=== CREATE ===");

        MyStringBuilder builder = new MyStringBuilder("Rot");

        System.out.println(builder);



        System.out.println("\n=== APPEND ===");

        builder.append("serot");

        System.out.println(builder);



        System.out.println("\n=== UNDO APPEND ===");

        builder.undo();

        System.out.println(builder);



        System.out.println("\n=== INSERT ===");

        builder.insert(3, " is cool");

        System.out.println(builder);



        System.out.println("\n=== UNDO INSERT ===");

        builder.undo();

        System.out.println(builder);



        System.out.println("\n=== DELETE ===");

        builder.append("serot");

        builder.delete(3, 6);

        System.out.println(builder);



        System.out.println("\n=== UNDO DELETE ===");

        builder.undo();

        System.out.println(builder);



        System.out.println("\n=== REVERSE ===");

        builder.reverse();

        System.out.println(builder);



        System.out.println("\n=== UNDO REVERSE ===");

        builder.undo();

        System.out.println(builder);



        System.out.println("\n=== MULTIPLE UNDO ===");

        builder.append(" A");
        builder.append(" B");
        builder.append(" C");

        System.out.println(builder);

        builder.undo();
        System.out.println(builder);

        builder.undo();
        System.out.println(builder);

        builder.undo();
        System.out.println(builder);



        System.out.println("\n=== NULL APPEND ===");

        builder.append(null);

        System.out.println(builder);

        builder.undo();

        System.out.println(builder);



        System.out.println("\n=== CHAINING ===");

        builder.append("1")
                .append("2")
                .append("3");

        System.out.println(builder);



        System.out.println("\n=== UNDO CHAINING ===");

        builder.undo();
        System.out.println(builder);

        builder.undo();
        System.out.println(builder);

        builder.undo();
        System.out.println(builder);
    }
}
