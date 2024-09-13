/**
 * Binarnistrom
 */
public class Binarnistrom {
    Uzel koren;

    public Binarnistrom(){
        this.koren = null;
    }

    public void vlozUzel(int info){
        koren = vlozRekurze(koren, info);
    }
    private Uzel vlozRekurze(Uzel p, int info){
        if (p == null) {
            p = new Uzel(info);
            return p;
        }

        if (info < p.info) {
            p.levy = vlozRekurze(p.levy, info);
            
        }
        if (info > p.info) {
            p.pravy = vlozRekurze(p.pravy, info);
            
        }

        return p;
    }
//pocet uzlu v stromecku
    static public int pocetUzlu(Binarnistrom s){
        Uzel korenUzel = s.koren;
        System.out.print("Pocet Uzlu: ");
        return pocetUzluRekurze(korenUzel);
    }
     static public int pocetUzluRekurze(Uzel p){
        if (p == null) {
            return 0;
        }
        return pocetUzluRekurze(p.levy) + pocetUzluRekurze(p.pravy) + 1;
    }

    //vypise uzly ve stromecku
    static public void vypisStrom(Binarnistrom s){
        Uzel p = s.koren;
        vypisStromRekutze(p);
    }
    static public void vypisStromRekutze(Uzel p){
        if (p == null) {
            return;
        }

        vypisStromRekutze(p.levy);
        vypisStromRekutze(p.pravy);
        System.out.println(p.info);
        
    }

    public static void main(String[] args) {
        Binarnistrom strom = new Binarnistrom();

        strom.vlozUzel(5);
        strom.vlozUzel(3);
        strom.vlozUzel(7);
        strom.vlozUzel(2);
        strom.vlozUzel(4);
        strom.vlozUzel(6);
        strom.vlozUzel(8);

        int PocetUzliku = pocetUzlu(strom);
        System.out.println(PocetUzliku);
        vypisStrom(strom);
    }
}