package fr.afpa.exercices;

import java.time.Year;
import java.time.YearMonth;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class NiveauUn {

    public static boolean isAdult(int birthYear) {
        int thisYear = Year.now().getValue();
        int age = thisYear - birthYear;
        return age >= 18;
    }

    public static void checkAge() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Entrez votre année de naissance :");

                String input = scanner.next();

                if (input.equalsIgnoreCase("exit")) {
                    System.out.println("A +");
                    break;
                }
                int birthYear = Integer.parseInt(input);

                if (isAdult(birthYear)) {
                    System.out.println("Vous etes majeur");
                } else {
                    System.out.println("Vous etes mineur");
                }
            } catch (InputMismatchException e) {
                System.out.println("Vous devez entrer un nombre");
                scanner.next();
            }

        }
    }

    public static void isMinMax(int var1, int var2, int var3) {

        int min;
        int max;

        if (var1 == var2 && var2 == var3) {
            System.out.println("Les 3 chiffres sont égaux");
            return;
        }

        if (var1 >= var2 && var1 >= var3) {
            max = var1;
        } else if (var2 >= var1 && var2 >= var3){
            max = var2;
        }
        else {
            max = var3;
        }

        if (var1 <= var2 && var1 <= var3) {
            min = var1;
        } else if (var2 <= var1 && var2 <= var3) {
            min = var2;
        }
        else {
            min = var3;
        }
        System.out.println("Le chiffre le plus petit est : " + min);
        System.out.println("Le chiffre le plus grand est : " + max);
    }
    public static void checkMinMax() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Entrez un premier nombre : ");
        int var1 = scanner.nextInt();

        System.out.println("Entrez un deuxième nombre : ");
        int var2 = scanner.nextInt();

        System.out.println("Entrez un troisième nombre : ");
        int var3 = scanner.nextInt();

        isMinMax(var1, var2, var3);
    }

    public static void isVowelOrConsonant(char c) {

    if (!Character.isAlphabetic(c)) {
        System.out.println("Vous n'avez pas entré une lettre");
        return;
    }

    if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'y') {
        System.out.println("Votre lettre est une voyelle");
    }
    else {
        System.out.println("Votre lettre est une console");
    }
    }

    public static void checkVowelConsonant() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Entrez une lettre : ");
        char c = scanner.next().charAt(0);

        isVowelOrConsonant(c);
    }

    public static void doYouHaveEnuff() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Entrez le montant sur votre compte bancaire : ");
        double bankSum = scanner.nextDouble();

        System.out.println("Entrez le prix du produit souhaité : ");
        double price = scanner.nextDouble();

        if (bankSum > price) {
            System.out.println("Vous pouvez acheter ! Il vous reste " + String.format("%.2f", (bankSum - price)) + " sur votre compte" );
        }
        else {
            System.out.println("T'as pas de sous fréro");
        }
    }

    public static void calculTauxParticipation() {

        //Constantes
        final double TAUX_CELIB = 20.0;
        final double TAUX_AUTRE = 25.0;
        final double MAJ_ENFANT_SUPPL = 15.0;
        final double SEUIL_SALAIRE = 1800.0;
        final double MAJORATION_SALAIRE = 10.0;
        final double PLAFOND_TAUX = 50.0;

        Scanner scanner = new Scanner(System.in);
        String continuer;
        // Déclaration des variables
        String statut;
        int nbEnfants;
        double salaire;
        double tauxParticipation;

        do {
            System.out.println("--- Saisie d'informations sur l'employé ---");
            System.out.println("État matrimonial (C pour célibataire, A pour autre situation) :");
            statut = scanner.next();

            System.out.print("Nombre d'enfants à charge : ");
            nbEnfants = scanner.nextInt();

            System.out.print("Salaire mensuel : ");
            salaire = scanner.nextDouble();

            if (statut.equalsIgnoreCase("C")) {
                tauxParticipation = TAUX_CELIB;
            }
            else {
                tauxParticipation = TAUX_AUTRE;
            }

            tauxParticipation += nbEnfants * MAJ_ENFANT_SUPPL;

            if (salaire < SEUIL_SALAIRE) {
                tauxParticipation += MAJORATION_SALAIRE;
            }

            if (salaire > SEUIL_SALAIRE) {
                tauxParticipation = PLAFOND_TAUX;
            }
            System.out.printf("Le taux de participation est de %.2f%%.%n", tauxParticipation);

            // Étape 6 : Continuer ou arrêter
            System.out.print("Souhaitez-vous effectuer le calcul pour un autre employé ? (O/N) : ");
            continuer = scanner.next();
        }
        while (continuer.equalsIgnoreCase("O"));


            scanner.close();
            System.out.println("Fin du programme.");
        }

        public static void calculAbonnés() {

        int nbAbonnés = 2500;
        int month = 0;

        while(month < 24){
            nbAbonnés *= 1.05;
            month += 1;
        }

            int result =  (int) Math.round(nbAbonnés);
            System.out.println("Le nombre d'abonnés est de : " + nbAbonnés);
    }

        public static int subscribersCount(int nbSbscribrs, double growth) {

        for (int mois = 0; mois <24; mois++) {
            nbSbscribrs *= growth;
        }
        int result = (int) Math.round(nbSbscribrs);
            System.out.println("Votre nombre d'abonnés sera : " + result);
        return nbSbscribrs;
        }

        public static void sommeNb() {

        Scanner scanner = new Scanner(System.in);

            System.out.println("Entrez un nombre : ");
            int nbFinal = scanner.nextInt();
            int somme = 0;
            for (int i = 0; i < nbFinal; i++) {
                somme += i;
            }
            System.out.println(somme);
        }

        public static void fizzBuzzing() {

        Scanner scanner = new Scanner(System.in);
            System.out.println("Entrez un nombre : ");
            int n = scanner.nextInt();

            for (int i = 1; i < n+1; i++) {
                if (i % 3 == 0 && i % 5 == 0) {
                    System.out.println("Fizz");
                } else if (i % 3 == 0) {
                    System.out.println("Buzz");
                } else if (i % 5 == 0 ) {
                    System.out.println("Fizzbuzz");
                }
                else {
                    System.out.println(i);
                }
            }

        }

        public static long calculFactoriel(int n) {

        long f = 1;

            for (int i = 1; i < n; i++) {
                f *= n;
            }
            System.out.println(f);
            return f;
        }

        public static void tableauReel() {

        double[] array = {12.2, 11.3, 4.4, 2.0};
            System.out.println(Arrays.toString(array));
        }
    }


