package hajzus;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Uloha1 {
    public static int[] pole;
    public static int[] oldpole;
    public static long pocetvymeny;
    public static long pocetporovnani;
    public static void vypisMenu(){
        System.out.println("1. Nove Data");
        System.out.println("2. Linearne vyhladavanie");
        System.out.println("3. Binárne vyhladavanie");
        System.out.println("4. Bubble sort");
        System.out.println("5. Shake sort");
        System.out.println("6. Select sort");
        System.out.println("7. Insertion sort");
        System.out.println("8. Shell sort");
        System.out.println("9. Quicksort");
        System.out.println("10. Insert sort + Binary Search");

    }
    public static int Hladanie(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Čo hladate ?");
        int a = sc.nextInt();
        return a;
    }
    public static void BinarneVyhladavanie(int a){
        System.out.println(binarySearch(0, pole.length-1, a));
    }
    public static int binarySearch(int lavyIndex,int pravyIndex, int a){
        pocetporovnani++;
        if(lavyIndex == pravyIndex && pole[lavyIndex] != a) return (-lavyIndex)-2;

        int middleIndex = lavyIndex + (pravyIndex - lavyIndex)/2;
        pocetporovnani++;
        if(pole[middleIndex] == a) return middleIndex;
        else {
            pocetporovnani++;
            if (pole[middleIndex] < a)
                return binarySearch(middleIndex + 1, pravyIndex, a);
            else return binarySearch(lavyIndex, Math.max(lavyIndex, middleIndex - 1), a);
        }
    }
    public static void bubbleSort(int[] array){
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                pocetporovnani++;
                if(array[j] < array[j+1]){
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                    pocetvymeny+=3;
                }
            }
        }
    }
    public static void bubbleSortSw(int[] array){
        boolean swaped;
        for (int i = 0; i < array.length - 1; i++) {
            swaped = false;
            for (int j = 0; j < array.length - i - 1; j++) {
                pocetporovnani++;
                if(array[j] < array[j+1]){
                    swaped = true;
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                    pocetvymeny+=3;
                }
            }
            if (!swaped){
                break;
            }
        }
    }
    public static void shakerSort(int[] array) {
        for (int i = 0; i < array.length/2; i++) {
            for (int j = i; j < array.length - i - 1; j++) {
                pocetporovnani++;
                if (array[j] < array[j+1]) {
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                    pocetvymeny+=3;
                }
            }
            for (int j = array.length - 2 - i; j > i; j--) {
                pocetporovnani++;
                if (array[j] > array[j-1]) {
                    int tmp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = tmp;
                    pocetvymeny+=3;
                }
            }
        }
    }
    public static void shakerSortSw(int[] array) {
        for (int i = 0; i < array.length/2; i++) {
            boolean swapped = false;
            for (int j = i; j < array.length - i - 1; j++) {
                pocetporovnani++;
                if (array[j] < array[j+1]) {
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                    swapped = true;
                    pocetvymeny+=3;
                }
            }
            for (int j = array.length - 2 - i; j > i; j--) {
                pocetporovnani++;
                if (array[j] > array[j-1]) {
                    int tmp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = tmp;
                    pocetvymeny+=3;
                    swapped = true;
                }
            }
            if(!swapped) break;
        }
    }
    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                pocetporovnani++;
                if (array[j] > array[maxIndex]) maxIndex = j;
            }
            int tmp = array[i];
            array[i] = array[maxIndex];
            array[maxIndex] = tmp;
            pocetvymeny+=3;
        }
    }
    public static void insertionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int j = i + 1;
            int tmp = array[j];
            pocetporovnani++;
            while (j > 0 && tmp > array[j - 1]) {
                pocetvymeny++;
                array[j] = array[j - 1];
                j--;
                pocetporovnani++;
            }
            pocetvymeny++;
            array[j] = tmp;
        }
    }
    public static int[] shellSort(int[] array) {
        int gap = array.length / 2;
        pocetporovnani++;
        while (gap > 0) {
            pocetporovnani++;
            pocetporovnani++;
            for (int i = 0; i < array.length - gap; i++) {
                pocetporovnani++;
                int j = i + gap;
                int tmp = array[j];
                pocetporovnani++;
                while (j >= gap && tmp > array[j - gap]) {
                    pocetporovnani++;
                    pocetvymeny++;
                    array[j] = array[j - gap];
                    j -= gap;
                }
                array[j] = tmp;
                pocetvymeny++;
            }
            pocetporovnani++;
            if (gap == 2) {
                gap = 1;
            } else {
                gap /= 2.2;
            }
        }
        return array;
    }
    public static void quicksort(int[] array, int left, int right){
        pocetporovnani++;
        if(left < right){
            pocetporovnani++;
            int boundary = left;
            for(int i = left + 1; i < right; i++){
                pocetporovnani+=2;
                if(array[i] > array[left]){
                    swap(array, i, ++boundary);
                }
            }
            swap(array, left, boundary);
            quicksort(array, left, boundary);
            quicksort(array, boundary + 1, right);
        }
    }
    private static void swap(int[] array, int left, int right){
        int tmp = array[right];
        array[right] = array[left];
        array[left] = tmp;
        pocetvymeny+=3;
    }
    static void InsertionSortBinary() {
                for (int i = 1; i < pole.length; i++)
                {
                    int x = pole[i];

                    pocetporovnani++;
                    int j = Math.abs(Arrays.binarySearch(pole, 0, i, x) + 1);

                    pocetvymeny++;
                    System.arraycopy(pole, j, pole, j + 1, i - j);

                    pocetvymeny++;
                    pole[j] = x;
                }
        }
        /*
        int i, loc, j, selected;

        for (i = 1; i < pole.length; ++i) {
            j = i - 1;
            pocetvymeny++;
            selected = pole[i];

            loc = binarySearch(selected, 0, j);
            pocetporovnani++;
            System.arraycopy(pole,j,pole,loc,i-j);
            /*while (j >= loc) {
                pocetvymeny++;
                pole[j + 1] = pole[j];
                j--;
                pocetporovnani++;
            }
            pocetvymeny++;
            pole[j + 1] = selected;
        }*/
        public static void generatePartiallySorted()
        {
            for (int i = 0; i < pole.length; i++)
            {
                if (i == 0)
                    pole[i] = (int) (Math.random() * 10);
                else
                    pole[i] = pole[i - 1] + ((int) (Math.random() * 50) - 20);
            }
        }
    public static void NeveData() throws IOException {
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();
        String a = "";
        int pomoc = 0;
        while (!a.equals("a") && !a.equals("b")) {
            if (pomoc != 0) {
                System.out.println("Zle si zadal");
            }
            System.out.println("a: Nahodne");
            System.out.println("b: Zoradene");
            a = sc.nextLine();
            pomoc = 1;
        }
        System.out.println("Zadaj pocet");
        int pocet = sc.nextInt();
        pole = new int[pocet];
        switch (a) {
            case "a":
                /*for (int i = 0; i < pocet; i++) {
                    pole[i] = ((int) (Math.random() * pocet*10) + 1);
                    //pole[i+1] = pole[i] + rd.nextInt(50)-20;
                }*/
                generatePartiallySorted();
                oldpole = new int[pole.length];
                System.arraycopy(pole, 0, oldpole, 0, pole.length);
                System.out.println(Arrays.toString(pole));
                break;
            case "b":
                for (int i = 0; i < pocet; i++) {
                    pole[i] = (int) (Math.random() * pocet * 10) + 1;
                }
                oldpole = new int[pole.length];
                if (pole.length >= 0) System.arraycopy(pole, 0, oldpole, 0, pole.length);
                Arrays.sort(pole);
                break;
        }
        BufferedWriter bw = new BufferedWriter(new FileWriter("Cisla.txt"));
        for (int i = 0; i < pole.length; i++) {
            bw.write(Integer.toString(pole[i])+" ");
        }
        bw.close();
    }
    public static void LinearneVyhladavanie(int a){
        int i =0;
        while (i !=-1){
            pocetporovnani++;
            if (a == pole[i]){
                System.out.println("Pozicia "+i);
                i=-2;
            }
            else {
                pocetporovnani++;
                if (i + 1 == pole.length) {
                    System.out.println("Pozicia -1");
                    i = -2;
                }
            }
            i++;
        }
    }
    public static int overenie(){
        if (pole == null){
            System.out.println("Musíš prv nahodiť dáta");
            return 1;
        }else return 0;
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Zoradovacie a Vyhladavacie Algoritmy");
        System.out.println("____________________________________");
        int a = 0;
        while (a==0) {
            vypisMenu();
            int menu = sc.nextInt();
            switch (menu) {
                case 1:
                    NeveData();
                    break;
                case 2:
                    if (overenie()==0) {
                        pocetporovnani=0;
                        int v = Hladanie();
                        long startTime = System.currentTimeMillis();
                        LinearneVyhladavanie(v);
                        long stopTime = System.currentTimeMillis();
                        System.out.println("Vyhladavanie trvalo " + (stopTime - startTime) + "ms");
                        System.out.println("Pocet porovnani "+pocetporovnani);
                    }
                    break;
                case 3:
                    if (overenie()==0) {
                        pocetporovnani=0;
                        int v = Hladanie();
                        long startTime = System.currentTimeMillis();
                        BinarneVyhladavanie(v);
                        long stopTime = System.currentTimeMillis();
                        System.out.println("Vyhladavanie trvalo " + (stopTime - startTime) + "ms");
                        System.out.println("Pocet porovnani "+pocetporovnani);
                    }
                    break;
                case 4:
                    if (overenie()==0) {
                        pocetvymeny=0;
                        pocetporovnani=0;
                        long startTime = System.currentTimeMillis();
                        bubbleSort(pole);
                        long stopTime = System.currentTimeMillis();
                        System.out.println("sortovanie trvalo " + (stopTime - startTime) + "ms");
                        System.out.println("Pocet výmien "+pocetvymeny);
                        System.out.println("Pocet porovnani "+pocetporovnani);
                        System.arraycopy(oldpole, 0, pole, 0, oldpole.length);
                    }
                    break;
                case 5:
                    if (overenie()==0) {
                        pocetvymeny=0;
                        pocetporovnani=0;
                        long startTime = System.currentTimeMillis();
                        shakerSort(pole);
                        long stopTime = System.currentTimeMillis();
                        //System.out.println(Arrays.toString(pole));
                        System.out.println("sortovanie trvalo " + (stopTime - startTime) + "ms");
                        System.out.println("Pocet výmien "+pocetvymeny);
                        System.out.println("Pocet porovnani "+pocetporovnani);
                        System.arraycopy(oldpole, 0, pole, 0, oldpole.length);
                    }
                    break;
                case 6:
                    if (overenie()==0) {
                        pocetvymeny=0;
                        pocetporovnani=0;
                        long startTime = System.currentTimeMillis();
                        insertionSort(pole);
                        long stopTime = System.currentTimeMillis();
                        //System.out.println(Arrays.toString(pole));
                        System.out.println("sortovanie trvalo " + (stopTime - startTime) + "ms");
                        System.out.println("Pocet výmien "+pocetvymeny);
                        System.out.println("Pocet porovnani "+pocetporovnani);
                        System.arraycopy(oldpole, 0, pole, 0, oldpole.length);
                    }
                    break;
                case 7:
                    if (overenie()==0) {
                        pocetvymeny=0;
                        pocetporovnani=0;
                        long startTime = System.currentTimeMillis();
                        selectionSort(pole);
                        long stopTime = System.currentTimeMillis();
                        //System.out.println(Arrays.toString(pole));
                        System.out.println("sortovanie trvalo " + (stopTime - startTime) + "ms");
                        System.out.println("Pocet výmien "+pocetvymeny);
                        System.out.println("Pocet porovnani "+pocetporovnani);
                        System.arraycopy(oldpole, 0, pole, 0, oldpole.length);
                    }
                    break;
                case 8:
                    if (overenie()==0) {
                        pocetvymeny=0;
                        pocetporovnani=0;
                        long startTime = System.currentTimeMillis();
                        shellSort(pole);
                        long stopTime = System.currentTimeMillis();
                        //System.out.println(Arrays.toString(pole));
                        System.out.println("sortovanie trvalo " + (stopTime - startTime) + "ms");
                        System.out.println("Pocet výmien "+pocetvymeny);
                        System.out.println("Pocet porovnani "+pocetporovnani);
                        System.arraycopy(oldpole, 0, pole, 0, oldpole.length);
                    }
                    break;
                case 9:
                    if (overenie()==0) {
                        pocetvymeny=0;
                        pocetporovnani=0;
                        long startTime = System.currentTimeMillis();
                        quicksort(pole,0, pole.length);
                        long stopTime = System.currentTimeMillis();
                       // System.out.println(Arrays.toString(pole));
                        System.out.println("sortovanie trvalo " + (stopTime - startTime) + "ms");
                        System.out.println("Pocet výmien "+pocetvymeny);
                        System.out.println("Pocet porovnani "+pocetporovnani);
                        System.arraycopy(oldpole, 0, pole, 0, oldpole.length);
                    }
                    break;
                case 10:
                    if (overenie()==0) {
                        pocetvymeny=0;
                        pocetporovnani=0;
                        long startTime = System.currentTimeMillis();
                        InsertionSortBinary();
                        long stopTime = System.currentTimeMillis();
                        System.out.println("sortovanie trvalo " + (stopTime - startTime) + "ms");
                        System.out.println("Pocet výmien "+pocetvymeny);
                        System.out.println("Pocet porovnani "+pocetporovnani);
                        System.arraycopy(oldpole, 0, pole, 0, oldpole.length);
                    }
                    break;
                case 11:
                    if (overenie()==0) {
                        pocetvymeny=0;
                        pocetporovnani=0;
                        long startTime = System.currentTimeMillis();
                        bubbleSortSw(pole);
                        long stopTime = System.currentTimeMillis();
                        System.out.println("sortovanie trvalo " + (stopTime - startTime) + "ms");
                        System.out.println("Pocet výmien "+pocetvymeny);
                        System.out.println("Pocet porovnani "+pocetporovnani);
                        System.arraycopy(oldpole, 0, pole, 0, oldpole.length);
                    }
                    break;
                case 12:
                    if (overenie()==0) {
                        pocetvymeny=0;
                        pocetporovnani=0;
                        long startTime = System.currentTimeMillis();
                        shakerSortSw(pole);
                        long stopTime = System.currentTimeMillis();
                        System.out.println("sortovanie trvalo " + (stopTime - startTime) + "ms");
                        System.out.println("Pocet výmien "+pocetvymeny);
                        System.out.println("Pocet porovnani "+pocetporovnani);
                        System.arraycopy(oldpole, 0, pole, 0, oldpole.length);
                    }
                    break;
                default:
                    System.out.println("Zle si zadal");
                    break;
            }
        }

    }
}
