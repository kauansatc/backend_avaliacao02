package br.net.venson.produto.models;

public class Monster {
    private String name;
    private String size;
    private String type;
    private String subtype;
    private String alignment;
    private double cr;

    /** @return Nome do monstro */
    public String getName() {
        return name;
    }

    /** @return Tamanho do monstro */
    public String getSize() {
        return size;
    }

    /** @return Tipo do monstro */
    public String getType() {
        return type;
    }

    /** @return Subtipo do monstro */
    public String getSubtype() {
        return subtype;
    }

    /** @return Alinhamento do monstro */
    public String getAlignment() {
        return alignment;
    }

    /** @return Nível de Desafio do monstro */
    public double getCr() {
        return cr;
    }
}
