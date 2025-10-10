
public enum Valeur {
    AS("As"), ROI("Roi"), DAME("Dame"), VALET("Valet"), DIX("Dix"),
    NEUF("Neuf"), HUIT("Huit"), SEPT("Sept"), SIX("Six"), CINQ("Cinq"),
    QUATRE("Quatre"), TROIS("Trois"), DEUX("Deux");

    private final String désignation;

    private Valeur(String désignation) {
        this.désignation = désignation;
    }

    public String getDésignation() {
        return this.désignation;
    }
}
