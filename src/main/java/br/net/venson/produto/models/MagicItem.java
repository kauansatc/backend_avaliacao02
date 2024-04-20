package br.net.venson.produto.models;

public class MagicItem {
    private String name;
    private String type;
    private String desc;
    private String rarity;

    /** @return Nome do item mágico */
    public String getName() {
        return name;
    }

    /** @return Tipo do item mágico */
    public String getType() {
        return type;
    }

    /** @return Descrição do item mágico */
    public String getDesc() {
        return desc;
    }

    /** @return Raridade do item mágico */
    public String getRarity() {
        return rarity;
    }
}
