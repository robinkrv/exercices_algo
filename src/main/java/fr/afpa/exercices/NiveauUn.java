package fr.afpa.exercices;

import java.time.Year;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
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
        } else if (var2 >= var1 && var2 >= var3) {
            max = var2;
        } else {
            max = var3;
        }

        if (var1 <= var2 && var1 <= var3) {
            min = var1;
        } else if (var2 <= var1 && var2 <= var3) {
            min = var2;
        } else {
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
        } else {
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
            System.out.println("Vous pouvez acheter ! Il vous reste " + String.format("%.2f", (bankSum - price)) + " sur votre compte");
        } else {
            System.out.println("T'as pas de sous fréro");
        }
    }

    public static void calculTauxParticipation() {


        final double TAUX_CELIB = 20.0;
        final double TAUX_AUTRE = 25.0;
        final double MAJ_ENFANT_SUPPL = 15.0;
        final double SEUIL_SALAIRE = 1800.0;
        final double MAJORATION_SALAIRE = 10.0;
        final double PLAFOND_TAUX = 50.0;

        Scanner scanner = new Scanner(System.in);
        String continuer;

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
            } else {
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

        while (month < 24) {
            nbAbonnés *= 1.05;
            month += 1;
        }

        int result = (int) Math.round(nbAbonnés);
        System.out.println("Le nombre d'abonnés est de : " + nbAbonnés);
    }

    public static int subscribersCount(int nbSbscribrs, double growth) {

        for (int mois = 0; mois < 24; mois++) {
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

        for (int i = 1; i < n + 1; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("Fizz");
            } else if (i % 3 == 0) {
                System.out.println("Buzz");
            } else if (i % 5 == 0) {
                System.out.println("Fizzbuzz");
            } else {
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

    public static int rechercheFor(int[] array, int value) {

        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public static int rechercheWhile(int[] array, int value) {

        int i = 0;
        while (i < array.length) {
            if (array[i] == value) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static int rechercheDoWhile(int[] array, int value) {

        int i = 0;
        do {
            if (array[i] == value) {
                return i;
            }
            i++;

        } while (i < array.length);
        return -1;
    }

    public static int sommeIndex(int[] array, int i, int j) {

        int sum = 0;
        for (int k = i; k < j; k++) {
            sum += array[k];
        }
        return sum;
    }

    public static int[] findMinMaxIndexes(int[] array) {

        int[] arrayResult = new int[2];

        int indexMin = 0;
        int indexMax = 0;

        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[indexMin]) {
                indexMin = i;
            }
            if (array[i] > array[indexMax]) {
                indexMax = i;
            }

        }
        arrayResult[0] = indexMin;
        arrayResult[1] = indexMax;

        return arrayResult;
    }

    public static boolean swap(int[] array, int i, int j) {

        if (array == null || i < 0 || j < 0 || i > array.length || j > array.length) {
            return false;
        }

        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;

        return true;
    }

    public static double calculerMoyenne(int[] array) {

        int somme = 0;

        for (int i : array) {
            somme += i;
        }
        return (double) somme / array.length;
    }

    public static void tableManip() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Veuillez choisir un nombre de valeurs à saisir :");
        int arraySize = scanner.nextInt();

        int[] arrayToProcess = new int[arraySize];

        for (int i = 0; i < arraySize; i++) {
            System.out.println("Veuillez saisir le nombre " + (i + 1) + " :");
            arrayToProcess[i] = scanner.nextInt();
        }
        double moyenne = calculerMoyenne(arrayToProcess);
        System.out.println("Moyenne = " + (int) moyenne);  // ou garde en double si tu veux la virgule

        // Trouver min et max
        int[] minMaxIndexes = findMinMaxIndexes(arrayToProcess);
        int min = arrayToProcess[minMaxIndexes[0]];
        int max = arrayToProcess[minMaxIndexes[1]];

        System.out.println("Minimum = " + min);
        System.out.println("Maximum = " + max);
    }

    public static int[] invert(int[] array) {

        int[] newArray = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[array.length - 1 - i];
        }
        System.out.println(Arrays.toString(newArray));
        return newArray;
    }

    public static int sommeTableau2D(int[][] array2D) {

        int sum = 0;

        for (int i = 0; i < array2D.length; i++) {
            for (int j = 0; j < array2D[i].length; j++) {
                sum += array2D[i][j];
            }
        }
        System.out.println(sum);
        return sum;
    }

    public static int calculateDiagonal(int[][] array2D, int width, int height, int diagonalType) {
        int sum = 0;
        int i = 0;

        if (width != height) {
            System.out.println("Erreur : le tableau n'est pas carré.");
            return -1;
        }

        if (diagonalType == 1) {
            while (i < height) {
                sum += array2D[i][i];
                i++;
            }
        } else if (diagonalType == 2) {
            while (i < height) {
                sum += array2D[i][width - 1 - i];
                i++;
            }
        } else {
            System.out.println("Erreur : type de diagonale invalide.");
            return -1;
        }
        System.out.println(sum);
        return sum;
    }

    public static void doCharTriangle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez le nombre de lignes désirées :");
        int enteredNumber = scanner.nextInt();
        int i = 1;
        boolean descending = false;

        while (i <= enteredNumber) {
            System.out.println("*".repeat(i));

            if (!descending) {
                i++;
                if (i > enteredNumber) {
                    descending = true;
                    i -= 2;
                }
            } else {
                i--;
            }
            if (i == 0) {
                break;
            }
        }
    }

    public static void runPlusOuMoinsGame() {

        Scanner scanner = new Scanner(System.in);
        // instanciation d'un objet de la classe Random
        Random r = new Random();
        // génération d'un nombre >= 0 et < 100
        int secretNumber = r.nextInt(100);

        int nbTries = 10;

        System.out.println("Essayez de deviner le nombre secret entre 1 et 100 : ");


        for (int i = 0; i < nbTries; i++) {
            int userEntry = scanner.nextInt();

            if (userEntry < secretNumber) {
                System.out.println("le nombre secret est plus grand");
            }
                else if (userEntry < 0 || userEntry > 100) {
                    System.out.println("Le nombre entré n'est pas compris entre 1 et 100");
                    continue;
                } else if (userEntry > secretNumber) {
                    System.out.println("le nombre secret est plus petit");
                } else {
                    System.out.println("Vous avez trouvé le nombre secret !");
                    return;
                }

            }
        }
    }



