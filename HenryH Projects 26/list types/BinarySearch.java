public class BinarySearch {
    public static int findLocation(int n, int[] l, int s, int e){
        if (s > e){
            return -1;
        }
        if (l[(s + e) / 2] == n){
            return (s + e) / 2;
        }
        if (l[(s + e) / 2] < n){
            return findLocation(n, l, ((s + e) / 2) + 1, e);
        }
        if (l[(s + e) / 2] > n){
            return findLocation(n, l, s, ((s + e) / 2) - 1);
        }
        else{
            return -1;
        }
    }
    public static void main(String[] args) {
        int[] list = {1, 5, 7, 8, 9, 9, 15, 33, 35, 190};
        System.out.println(findLocation(190, list, 0, list.length - 1));
    }
}