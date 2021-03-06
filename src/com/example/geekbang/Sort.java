package com.example.geekbang;

public class Sort {

    // 冒泡排序，a表示数组，n表示数组大小
    public static void bubbleSort(int[] a, int n) {
        if (n <= 1) return;

        for (int i = 0; i < n; ++i) {
            // 提前退出冒泡循环的标志位
            boolean flag = false;
            for (int j = 0; j < n - i - 1; ++j) {
                if (a[j] > a[j + 1]) { // 交换
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    flag = true;  // 表示有数据交换
                }
            }
            if (!flag) break;  // 没有数据交换，提前退出
        }
    }


    // 插入排序，a表示数组，n表示数组大小
    public static void insertionSort(int[] a, int n) {
        if (n <= 1) return;

        for (int i = 1; i < n; ++i) {
            int value = a[i];
            int j = i - 1;
            // 查找插入的位置
            for (; j >= 0; --j) {
                if (a[j] > value) {
                    a[j + 1] = a[j];  // 数据移动
                } else {
                    break;
                }
            }
            a[j + 1] = value; // 插入数据
        }
    }

    // 选择排序，a表示数组，n表示数组大小
    public static void selectionSort(int[] a, int n) {
        if (n <= 1) return;

        for (int i = 0; i < n - 1; ++i) {
            int index = i;
            for (int j = i + 1; j < n; ++j) {
                if (a[j] < a[index]) {
                    index = j;
                }
            }
            int tmp = a[i];
            a[i] = a[index];
            a[index] = tmp;
        }
    }

    public static void mergeSort(int[] list) {
        mergeSortRec(list, 0, list.length - 1);
    }

    private static void mergeSortRec(int[] list, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSortRec(list, left, mid);
        mergeSortRec(list, mid + 1, right);
        merge(list, left, mid, right);
    }

    private static void merge(int[] list, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right) {
            if (list[i] <= list[j]) {
                temp[k++] = list[i++];
            } else {
                temp[k++] = list[j++];
            }
        }
        int start = i;
        int end = mid;
        if (i > mid) {
            start = j;
            end = right;
        }
        while (start <= end) {
            temp[k++] = list[start++];
        }
        for (int p = 0; p <= right - left; p++) {
            list[left + p] = temp[p];
        }
    }

    public static void quickSort(int[] list) {
        quickSortRec(list, 0, list.length - 1);
    }

    private static void quickSortRec(int[] list, int left, int right) {
        if (left > right) {
            return;
        }
        int p = partition(list, left, right);
        quickSortRec(list, left, p - 1);
        quickSortRec(list, p + 1, right);
    }

    private static int partition(int[] list, int left, int right) {
        int mid = list[right];
        int i = left;
        for (int j = left; j < right; j++) {
            if (list[j] < mid) {
                int temp1 = list[i];
                list[i] = list[j];
                list[j] = temp1;
                i++;
            }
        }
        int temp2 = list[i];
        list[i] = list[right];
        list[right] = temp2;
        return i;
    }

    public static int findKItem(int[] list, int k) {
        int index = findKItemHelper(list, 0, list.length - 1, k);
        return list[index];
    }

    private static int findKItemHelper(int[] list, int left, int right, int k) {
        int p = partition(list, left, right);
        if (p > k - 1) {
            return findKItemHelper(list, left, p - 1, k);
        } else if (p < k - 1) {
            return findKItemHelper(list, p + 1, right, k);
        } else {
            return p;
        }
    }

    // 计数排序
    public static void countingSort(int[] list) {
        int n = list.length;
        int max = list[0];
        for (int i = 1; i < n; i++) {
            if (list[i] > max) {
                max = list[i];
            }
        }

        int[] countList = new int[max + 1];
        for (int j = 0; j <= max; j++) {
            countList[j] = 0;
        }

        for (int i = 0; i < n; i++) {
            countList[list[i]]++;
        }

        for (int j = 1; j <= max; j++) {
            countList[j] = countList[j] + countList[j - 1];
        }

        int[] tempList = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int item = list[i];
            tempList[countList[item] - 1] = item;
            countList[item]--;
        }

        for (int i = 0; i < n; i++) {
            list[i] = tempList[i];
        }
    }

    public static void main(String[] args) {
        int[] testArray = {4, 2, 6, 8, 1, 3, 0};
        selectionSort(testArray, testArray.length);
        for (int i = 0; i < testArray.length; i++) {
            System.out.println(testArray[i]);
        }
    }
}
