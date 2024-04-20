package br.net.venson.produto.models;

public class Monster {
    private String name;
    private String size;
    private String type;
    private String subtype;
    private String alignment;
    private double cr;

    public String getName() {
        return name;
    }

    public String getSize() {
        return size;
    }

    public String getType() {
        return type;
    }

    public String getSubtype() {
        return subtype;
    }

    public String getAlignment() {
        return alignment;
    }

    /** Challenge Rating */
    public double getCr() {
        return cr;
    }
}
