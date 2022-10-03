package com.ogam.ogambot.ogamClient.enums;

public enum Buildings {
    KOP_METALU("&build=1&", "Kopalnia metalu"),
    KOP_KRYSZTALU("&build=2&", "Kopalnia kryształu"),
    KOP_DEUTERU("&build=3&", "Ekstraktor deuteru"),
    ELEKTROWNIA("&build=4&", "Elektrownia słoneczna"),
    FAKRYKA_ROBOTOW("&build=14&", "Fabryka robotów"),
    MAG_METALU("&build=22&", "Magazyn metalu"),
    MAG_KRYSZTALU("&build=23&", "Magazyn kryształu"),
    MAG_DEUTERU("&build=24&", "Zbiornik deuteru");

    public final String linkFragment;
    public final String name;

    private Buildings(String linkFragment, String name){

        this.linkFragment = linkFragment;
        this.name = name;
    }


}
