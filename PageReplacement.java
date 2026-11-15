 import java.util.Scanner;

public class PageReplacement {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of pages: ");
        int n = sc.nextInt();

        System.out.print("Enter the page reference string: ");
        int[] pages = new int[n];

        for (int i = 0; i < n; i++) {
            pages[i] = sc.nextInt();
        }

        System.out.print("Enter number of frames: ");
        int frames = sc.nextInt();

        int[] memory = new int[frames];
        int pointer = 0;
        int pageFaults = 0;
        int pageHits = 0;

        for (int i = 0; i < frames; i++) {
            memory[i] = -1;
        }

        System.out.println("\nPage\tFrames\t\tStatus");

        for (int i = 0; i < n; i++) {
            int page = pages[i];
            boolean found = false;

            for (int j = 0; j < frames; j++) {
                if (memory[j] == page) {
                    found = true;
                    break;
                }
            }

            if (found) {
                pageHits++;
                System.out.print(page + "\t");
                for (int j = 0; j < frames; j++) {
                    System.out.print((memory[j] == -1 ? "-" : memory[j]) + " ");
                }
                System.out.println("\tHit");
            } else {
                memory[pointer] = page;
                pointer = (pointer + 1) % frames;
                pageFaults++;

                System.out.print(page + "\t");
                for (int j = 0; j < frames; j++) {
                    System.out.print((memory[j] == -1 ? "-" : memory[j]) + " ");
                }
                System.out.println("\tPage Fault");
            }
        }

        System.out.println("\nTotal Page Faults: " + pageFaults);
        System.out.println("Total Page Hits: " + pageHits);

        sc.close();
    }
} 