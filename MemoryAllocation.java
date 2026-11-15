import java.util.Scanner;

public class MemoryAllocation {

    static void firstFit(int[] blocks, int[] processes) {
        int[] memory = blocks.clone();

        System.out.println("\n--- First Fit Algorithm ---");

        for (int i = 0; i < processes.length; i++) {
            boolean allocated = false;

            for (int j = 0; j < memory.length; j++) {
                if (memory[j] >= processes[i]) {
                    System.out.println("Process " + (i + 1)
                            + " (" + processes[i] + " KB) allocated to Block "
                            + (j + 1));

                    memory[j] -= processes[i];
                    allocated = true;
                    break;
                }
            }

            if (!allocated) {
                System.out.println("Process " + (i + 1)
                        + " (" + processes[i] + " KB) not allocated");
            }
        }
    }

    static void bestFit(int[] blocks, int[] processes) {
        int[] memory = blocks.clone();

        System.out.println("\n--- Best Fit Algorithm ---");

        for (int i = 0; i < processes.length; i++) {
            int best = -1;

            for (int j = 0; j < memory.length; j++) {
                if (memory[j] >= processes[i]
                        && (best == -1 || memory[j] < memory[best])) {
                    best = j;
                }
            }

            if (best != -1) {
                System.out.println("Process " + (i + 1)
                        + " (" + processes[i] + " KB) allocated to Block "
                        + (best + 1));

                memory[best] -= processes[i];
            } else {
                System.out.println("Process " + (i + 1)
                        + " (" + processes[i] + " KB) not allocated");
            }
        }
    }

    static void worstFit(int[] blocks, int[] processes) {
        int[] memory = blocks.clone();

        System.out.println("\n--- Worst Fit Algorithm ---");

        for (int i = 0; i < processes.length; i++) {
            int worst = -1;

            for (int j = 0; j < memory.length; j++) {
                if (memory[j] >= processes[i]
                        && (worst == -1 || memory[j] > memory[worst])) {
                    worst = j;
                }
            }

            if (worst != -1) {
                System.out.println("Process " + (i + 1)
                        + " (" + processes[i] + " KB) allocated to Block "
                        + (worst + 1));

                memory[worst] -= processes[i];
            } else {
                System.out.println("Process " + (i + 1)
                        + " (" + processes[i] + " KB) not allocated");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of memory blocks: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Invalid number of blocks.");
            sc.close();
            return;
        }

        int[] blocks = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter size of Block " + (i + 1) + ": ");
            blocks[i] = sc.nextInt();

            if (blocks[i] <= 0) {
                System.out.println("Block size must be positive.");
                sc.close();
                return;
            }
        }

        System.out.print("Enter number of processes: ");
        int m = sc.nextInt();

        if (m <= 0) {
            System.out.println("Invalid number of processes.");
            sc.close();
            return;
        }

        int[] processes = new int[m];

        for (int i = 0; i < m; i++) {
            System.out.print("Enter memory required for Process "
                    + (i + 1) + ": ");
            processes[i] = sc.nextInt();

            if (processes[i] <= 0) {
                System.out.println("Process size must be positive.");
                sc.close();
                return;
            }
        }

        firstFit(blocks, processes);
        bestFit(blocks, processes);
        worstFit(blocks, processes);

        sc.close();
    }
}