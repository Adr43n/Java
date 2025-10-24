package examenrevision;

@FunctionalInterface
interface PrédicatRoboticusSportif {
    boolean vérif(RoboticusSportif rs);
    default PrédicatRoboticusSportif non() {
        return (rs) -> !this.vérif(rs);
    }
    
    default PrédicatRoboticusSportif et(PrédicatRoboticusSportif p) {
        return (rs) -> this.vérif(rs) && p.vérif(rs);
    }
}
