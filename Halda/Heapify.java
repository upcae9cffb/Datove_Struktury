import java.util.Scanner;

public class Heapify{

    int velikost;
    int Maxkapacita;
    int[] halda;

    public Heapify(int Maxkapacita){
        this.Maxkapacita = Maxkapacita;
        this.velikost = 0;
        halda = new int[Maxkapacita];

    }

  public void heapify(int[] arr){
    this.velikost = arr.length;
    this.halda = arr;
    for(int j = velikost / 2 - 1; j >= 0;j--){
        porovnej(j);
    }
    
  }

  public void porovnej(int j){
    int otecko = j;
    int levySyn;
    int pravySyn;

    while (true) {
        levySyn = 2 * j + 1;  
        pravySyn = 2 * j + 2;
        otecko = j;  
       
        if (levySyn < velikost && halda[levySyn] > halda[otecko]) {
            otecko = levySyn;
        }
        
        if (pravySyn < velikost && halda[pravySyn] > halda[otecko]) {
            otecko = pravySyn;
        }
       
        if (otecko == j) {
            break;
        }

        prohod(j, otecko);

        j = otecko;
    }
  }

  public void prohod(int prvni, int druhe){
    int pamatovak = halda[prvni];
    halda[prvni] = halda[druhe];
    halda[druhe] = pamatovak;
  }

  public void VypisHaldu(){
    for(int i = 0; i < velikost;i++){
        System.out.print(halda[i] + " ");
    }
  }

   
    public static void main(String[] args) {
        int[] pole;
        int velikotPole;
        int[] setridenePole;
         
        Scanner scanner = new Scanner(System.in);
        velikotPole = scanner.nextInt();
        pole = new int[velikotPole];
        setridenePole = new int[velikotPole];

        for(int i = 0; i <velikotPole;i++){
            int prvek = scanner.nextInt();
            pole[i] = prvek;
        }
    
            Heapify haldickaDoPIci = new Heapify(velikotPole);
            haldickaDoPIci.heapify(pole);
            haldickaDoPIci.VypisHaldu();

    }
}