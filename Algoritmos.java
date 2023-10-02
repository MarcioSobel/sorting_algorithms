import java.util.Random;

public class Algoritmos
{
    static int compB = 0;
    static int swapB = 0;

    static int compS = 0;
    static int swapS = 0;
    
    static int compQ = 0;
    static int swapQ = 0;

    public static void main(String[] args)
    {
        int lista[] = generateList(10);
        int sortedList[] = copyArray(lista);

        shuffleArray(lista);
        int arrayBubble[] = copyArray(lista);
        int arraySelection[] = copyArray(lista);
        int arrayQuick[] = copyArray(lista);

        bubbleSort(arrayBubble);
        selectionSort(arraySelection);
        quickSort(arrayQuick, 0, arrayQuick.length - 1);

        if (!isSorted(arrayBubble))
        {
            System.out.println("ERRO NA LISTA BUBBLE: " + list(arrayBubble));
            return;
        }
        
        if (!isSorted(arraySelection))
        {
            System.out.println("ERRO NA LISTA SELECTION: " + list(arraySelection));
            return;
        }
        
        if (!isSorted(arrayQuick))
        {
            System.out.println("ERRO NA LISTA QUICK: " + list(arrayQuick));
            return;
        }
        
        System.out.println("Lista organizada:    " + list(sortedList));
        System.out.println("Lista desorganizada: " + list(lista) + "\n");

        System.out.println("Quantidade de trocas (BubbleSort): " + swapB);
        System.out.println("Quantidade de comparações (BubbleSort): " + compB + "\n");
        
        System.out.println("Quantidade de trocas (SelectionSort): " + swapS);
        System.out.println("Quantidade de comparações (SelectionSort): " + compS + "\n");
        
        
        System.out.println("Quantidade de trocas (QuickSort): " + swapQ);
        System.out.println("Quantidade de comparações (QuickSort): " + compQ + "\n");
    }

    private static String list(int[] array)
    {
        String sArray = "[";
        int i = 0;
        while (i < array.length - 1)
        {
            sArray += array[i++] + ", ";
        }
        return sArray + array[i] + "]";
    }
    
    private static void swap(int[] array, int i, int j)
    {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static int[] copyArray(int[] array)
    {
        int len = array.length;
        int copiedArray[] = new int[len];
        for (int i = 0; i < len; ++i)
        {
            copiedArray[i] = array[i];
        }
        return copiedArray;
    }

    private static int[] shuffleArray(int[] array)
    {
        Random rnd = new Random();
        int len = array.length;
        for (int i = 0; i < len; ++i)
        {
            for (int j = 0; j < len; ++j)
            {
                swap(array, j, rnd.nextInt(len));
            }
        }
        return array;
    }

    private static int[] generateList(int length)
    {
        int array[] = new int[length];
        for (int i = 0; i < length; ++i)
        {
            array[i] = i + 1;
        }
        return array;
    }

    private static void bubbleSort(int[] array)
    {
        int len = array.length;
        for (int i = 0; i < len; ++i)
        {   
            int totalSwaps = 0;
            for (int j = 0; j < len - i - 1; ++j)
            {
                if (array[j] > array[j + 1])
                {    
                    swap(array, j, j+1);
                    totalSwaps++;
                    swapB++;
                }
                compB++;
            }
            compB++;
            if (totalSwaps == 0) return; // Lista organizada
        }
    }

    private static void selectionSort(int[] array)
    {
        int len = array.length;
        for (int i = 0; i < len; ++i)
        {
            int smallest = i;
            for (int j = i; j < len; ++j)
            {
                if (array[j] < array[smallest])
                {
                    smallest = j;
                }
                compS++;
            }
            swap(array, i, smallest);
            swapS++;
        }
    }

    public static void quickSort(int[] array, int start, int end)
    {
        int i = start;
        int j = end;
        int pivot = array[(start + end) / 2];
        
        while (true)
        {
            while (array[i] < pivot)
            {
                i++;
            }
            
            while (pivot < array[j])
            {
                j--;
            }
            compQ += 2;

            if (i <= j)
            {
                swap(array, i, j);
                swapQ++;
                i++;
                j--;
            }
            
            compQ++;
            if (i > j) break;
        }
        compQ++;
        if (start < j)
        {
            quickSort(array, start, j);
        }
        if (i < end)
        {
            quickSort(array, i, end);
        }
    }

    private static boolean isSorted(int[] array)
    {
        for (int i = 0; i < array.length - 1; ++i)
        {
            if (array[i] > array[i + 1]) return false;
        }
        return true;
    }
}