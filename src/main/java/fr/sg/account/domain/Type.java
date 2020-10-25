package fr.sg.account.domain;

/**
 * @author fares.boulmali
 */
public enum Type {

    DEPOSIT("deposit"),
    WITHDRAW("withdraw");
    private final String libelle;

    Type(final String libelle) {
        this.libelle = libelle;
    }

    public String toString() {
        return libelle;
    }
}
