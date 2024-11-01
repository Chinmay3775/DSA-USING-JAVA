import java.util.Scanner;

class Insertion_Array {
    public static void main(final String[] args) {
        int[] rollno = {23, 32, 45, 12, 15};
        
        System.out.println("Original Array:");
        for (int value : rollno) {
            System.out.println(value);
        }

        // Insert at position
        int num;
        int pos;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number you want to insert:");
        num = in.nextInt();
        System.out.println("Enter the position where you want to insert (0 to " + rollno.length + "):");
        pos = in.nextInt();

        if (pos < 0 || pos > rollno.length) {
            System.out.println("Invalid position. Position should be between 0 and " + rollno.length);
        } else {
            int[] newArray = new int[rollno.length + 1];
            
            for (int i = 0; i < pos; i++) {
                newArray[i] = rollno[i];
            }
            
            // Insert the new element
            newArray[pos] = num;
            
            // Copy remaining elements after the insertion point
            for (int i = pos; i < rollno.length; i++) {
                newArray[i + 1] = rollno[i];
            }
            
            System.out.println("Updated Array:");
            for (int value : newArray) {
                System.out.println(value);
            }
        }
        
        in.close();
    }
}
