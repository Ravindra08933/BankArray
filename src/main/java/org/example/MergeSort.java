package org.example;
public class MergeSort {

    static void mergeSort(int[] arr,int l,int m,int r)
    {
        int n1 = m-l+1;
        int n2 = r-m;
        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];
        for (int i=0; i<n1; ++i)
            arr1[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            arr2[j] = arr[m + 1+ j];
        int i=0,j=0;
        int k = l;
        while(i<n1 && j<n2)
        {
            if(arr1[i]<=arr2[j])
            {
                arr[k] = arr1[i];
                i = i+1;
            }
            else {
                arr[k] = arr2[j];
                j = j+1;
            }
            k = k+1;
        }
        while(i<n1)
        {
            arr[k] = arr1[i];
            i++;
            k++;
        }
        while(j<n2)
        {
            arr[k] = arr2[j];
            j++;
            k++;
        }
    }

    static void merge(int[] arr,int l,int r)
    {
        if(l<r)
        {
            int m = l + (r - l) / 2;
            merge(arr, l, m);
            merge(arr, m + 1, r);
            mergeSort(arr,l,m,r);
        }
    }
    public static void main(String[] args) {
        int[] arr = new int[5];

        arr[0] = 4;
        arr[1] = 5;
        arr[2] = 2;
        arr[3] = 1;
        arr[4] = 3;

        merge(arr,0,arr.length-1);
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}
