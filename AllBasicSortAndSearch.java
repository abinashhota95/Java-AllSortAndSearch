package com.dotpe;

import java.util.Scanner;

public class AllBasicSortAndSearch {

    static int[] tempArray=new int[100000];

    public static void printArray(int[] array)
    {
        int arrayLength= array.length;
        for(int i=0;i<arrayLength;i++)
            System.out.print(array[i]+" ");
        System.out.println(" ");
    }


    public static void selectionSort(int[] array)
    {
        int i,j,len,min,temp;
        len=array.length;
        for(i=0;i<len;i++)
        {
            min=i;
            for(j=i+1;j<len;j++)
            {
                if(array[j]<array[min])
                    min=j;
            }

            temp=array[i];
            array[i]=array[min];
            array[min]=temp;

        }

    }


    public static void insertionSort(int[] array)
    {
        int i,j,length,temp;
        length= array.length;
        for(i=1;i<length;i++)
        {
            temp=array[i];
            for(j=i-1;j>=0;j--)
            {
                if(temp<array[j])
                {
                    array[j+1]=array[j];
                }else break;
            }
            array[j+1]=temp;
        }
    }

    public static void bubbleSort(int[] array)
    {
        int i,j,temp,length;
        length= array.length;
        for(i=0;i<length;i++)
        {
            for(j=1;j<length-i;j++)
            {
                if(array[j-1]>array[j])
                {
                    temp=array[j-1];
                    array[j-1]=array[j];
                    array[j]=temp;
                }
            }
        }
    }


    public static void mergeSort(int[] array)
    {
        mergeSortUtil(array,0,array.length-1);
    }


    public static void mergeSortUtil(int[] array,int left,int right)
    {
       if(left<right)
       {
           int mid;
           mid=left+(right-left)/2;
           mergeSortUtil(array,left,mid);
           mergeSortUtil(array,mid+1,right);
           merge(array,left,mid,right);
       }
    }
    public static void merge(int[] array,int left,int mid,int right)
    {

        int i,j,k;
        i=left;
        j=mid+1;
        k=0;
        while(i<=mid && j<=right)
        {
            if(array[i]<array[j])
                tempArray[k++]=array[i++];
            else tempArray[k++]=array[j++];
        }
        while(i<=mid)
            tempArray[k++]=array[i++];
        while(j<=right)
            tempArray[k++]=array[j++];

        k=0;
        for(i=left;i<=right;i++)
            array[i]=tempArray[k++];



    }





    public static void quickSort(int[] array)
    {
        quickSortUtil(array,0,array.length-1);
    }

    public static void quickSortUtil(int[] array,int left,int right)
    {
        if(left<right)
        {
            int pivot;
            pivot=partittionWithLastElementAsPivot(array,left,right);
            quickSortUtil(array,left,pivot-1);
            quickSortUtil(array,pivot+1,right);
        }
    }
    public static int partittionWithLastElementAsPivot(int[] array,int left,int right)
    {
      int point,i,temp;
      point=left;
      for(i=left;i<right;i++)
      {
       if(array[i]<array[right])
       {
           temp=array[point];
           array[point]=array[i];
           array[i]=temp;

           point++;
       }
      }
        temp=array[point];
        array[point]=array[right];
        array[right]=temp;

        return point;
    }



    public static void linearSearch(int[] array,int searchElement)
    {
        int index;
        for(index=0;index< array.length;index++)
            if(array[index]==searchElement)
            {
                System.out.println(searchElement+"found at "+index+"th index");
                return;
            }
        System.out.println(searchElement+"not found in Array ");

    }



    public static void binarySearch(int[] array,int l,int r ,int searchNo)
    {
        if(l<=r)
        {
            int mid=l+(r-l)/2;
            if(searchNo==array[mid])
                System.out.println("Found at index "+mid);
            else if(searchNo>array[mid])
                binarySearch(array,mid+1,r,searchNo);
            else binarySearch(array,l,mid-1,searchNo);



        }
        else System.out.println("Not found");

    }

    public static void main(String[] args) {
	// write your code here


        Scanner sc =new Scanner(System.in);
        int noOfElement,i;
        System.out.println("Enter the No of element You want to insert in Array ");
        noOfElement=sc.nextInt();
        int[] array=new int[noOfElement];
        for(i=0;i<noOfElement;i++)
            array[i]=sc.nextInt();



        printArray(array);

   /*     while (true){
            System.out.println("Enter the array element you want to search by linear search");
            int searchElement,input;
            searchElement=sc.nextInt();
            linearSearch(array,searchElement);
            System.out.println("if you want to move out of Linear Search press 1");
            input=sc.nextInt();
            if(input==1)break;
        }
*/
        //BinarySearch , first need to sort the array
        //insertionSort(array);
        //mergeSort(array);
        quickSort(array);
        printArray(array);
        while (true){
            System.out.println("Enter the array element you want to search by Binary search");
            int searchElement,input;
            searchElement=sc.nextInt();

            binarySearch(array,0, array.length-1,searchElement );
            System.out.println("if you want to move out  press 1");
            input=sc.nextInt();
            if(input==1)break;
        }




    }
}
