import java.util.Scanner;

public class Pesel {


    public static boolean check(String pesel){

        int[] number = {1, 3, 7, 9, 1, 3, 7 ,9 ,1 ,3};


        if (pesel.length() != 11) return false;

        int suma = 0;

        for (int i = 0; i < 10; i++)
            suma += Integer.parseInt(pesel.substring(i, i+1)) * number[i]; // obliczenie sumy iloczynów (1*a + 3*b + 7*c
        // + 9*d + 1*e + 3*f + 7*g + 9*h + 1*i + 3*j), gdzie litery od a do j oznaczają kolejne cyfry numeru PESEL.

        int cyfraKontrolna = Integer.parseInt(pesel.substring(10, 11)); // ostatnia cyfra numeru PESEL

        System.out.println("Cyfra kontrolna Twojego numeru PESEL to: " + (cyfraKontrolna));

        System.out.println("Sprawdzenie poprawności wprowadzonego numeru PESEL:");

        System.out.println("Suma iloczynów poszczególnych cyfr numeru PESEL: " + (suma));
        suma %= 10;
        System.out.println("Ostania cyfra iloczynu wynosi: " + (suma));
        suma = 10 - suma;
        System.out.println("Obliczona cyfra kontrolna podanego numeru PESEL (10 - ostatnia cyfra iloczynu): " + (suma));

        return (suma == cyfraKontrolna);

        // numer PESEL jest poprawny gdy rożnica liczby 10 i ostatniej cyfry sumy iloczynów oblicznej powyżej równa jest ostatnie cyfrze podanego numeru PESEL - cyfra kontrolna
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.print ("Podaj dowolny numer PESEL: " );

        String pesel = sc.nextLine();

        System.out.println("Twój PESEL jest " + ((check(pesel)) ? "poprawny." : "niepoprawny"));

    }
}
