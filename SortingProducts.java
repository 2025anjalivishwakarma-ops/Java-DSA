import java.util.Scanner;
public class SortingProducts {
// Merge Sort
static void mergeSort(double arr[], int low, int high) {
if (low < high) {
int mid = (low + high) / 2;
mergeSort(arr, low, mid);
mergeSort(arr, mid + 1, high);
merge(arr, low, mid, high); } }
// Merge two sorted subarrays
static void merge(double arr[], int low, int mid, int high) {
int n1 = mid - low + 1;
int n2 = high - mid;
double left[] = new double[n1];
double right[] = new double[n2];
for (int i = 0; i < n1; i++)
left[i] = arr[low + i];
for (int j = 0; j < n2; j++)
right[j] = arr[mid + 1 + j];
int i = 0, j = 0, k = low;
while (i < n1 && j < n2) {
if (left[i] <= right[j])
arr[k++] = left[i++];
else
arr[k++] = right[j++]; }
while (i < n1)
arr[k++] = left[i++];
while (j < n2)
arr[k++] = right[j++]; }
// Quick Sort
static void quickSort(double arr[], int low, int high) {
if (low < high) {
int pi = partition(arr, low, high);
quickSort(arr, low, pi - 1);
quickSort(arr, pi + 1, high); } }
// Partition method
static int partition(double arr[], int low, int high) {
double pivot = arr[high];
int i = low - 1;
for (int j = low; j < high; j++) {
if (arr[j] <= pivot) {
i++;
double temp = arr[i];
arr[i] = arr[j];
arr[j] = temp; } }
double temp = arr[i + 1];
arr[i + 1] = arr[high];
arr[high] = temp;
return i + 1; }
// Display product prices
static void display(double arr[]) {
System.out.println("Sorted Product Prices:");
for (int i = 0; i < arr.length; i++) {
System.out.printf("%.2f ", arr[i]); }
System.out.println(); }
public static void main(String args[]) {
Scanner sc = new Scanner(System.in);
System.out.print("Enter number of products: ");
int n = sc.nextInt();
if (n <= 0) {
System.out.println("Invalid number of products.");
sc.close();
return; }
double prices[] = new double[n];
System.out.println("Enter product prices:");
for (int i = 0; i < n; i++) {
prices[i] = sc.nextDouble(); }
System.out.println("\n----- SORTING MENU -----");
System.out.println("1. Merge Sort");
System.out.println("2. Quick Sort");
System.out.print("Enter your choice: ");
int choice = sc.nextInt();
switch (choice) {
case 1:
mergeSort(prices, 0, n - 1);
System.out.println("\nMerge Sort Selected.");
display(prices);
break;
case 2:
quickSort(prices, 0, n - 1);
System.out.println("\nQuick Sort Selected.");
display(prices);
break;
default:
System.out.println("Invalid Choice!");
}
sc.close();
}
}