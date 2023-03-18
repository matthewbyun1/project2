package prj2;

import java.util.Arrays;

/**
 * In this class, we want to implement the Kruskal's algorithm
 * 
 * @author Matthew Byun
 *
 */
public class Kruskal {
    
    private int n;
    private int[] u;
    private int[] v;
    private int[] weights;
    private int[] clusters;
    /**
     * Constructor
     * 
     * @param n
     *            number of nodes
     * @param edges
     *            the set of edges of the graph
     */
    public Kruskal(int n, int[][] edges) {
        this.n = n;
        weights = new int[edges.length];
        u = new int[edges.length];
        v = new int[edges.length];
        for(int i = 0; i < edges.length; i++) {
            u[i] = edges[i][0];
            v[i] = edges[i][1];
            weights[i] = edges[i][2];
        }
        clusters = new int[n];
    }
   
    /**
     * Computes the cost of the minimum spanning tree on the graph
     * 
     * @return the MST cost
     */
    public int MST() {
        Arrays.sort(weights);
        this.createCluster();
        return 0;
    }
    
    
    
    /**
     * This method runs the find clustering algorithm
     * 
     * @param k
     *            the number of desired clusters
     * @return an array where the i-th element (element at index i-1) is the id
     *         of the cluster containing node i
     */
    public int[] findClustering(int k) {
        // TODO complete
        return null;
    }


    /**
     * This method gets the id of a node from input and returns the id of the
     * cluster containing it
     * 
     * @param id
     *            the id of a node, a value between 1 and n
     * @return the id of the cluster containing the node
     */
    public int getCluster(int id) {
        // TODO Complete
        return -1;
    }
    
    /**
     * Recursive function that splits array into sub-arrays to sort array
     * 
     * @return
     */
    public static void mergeSort(int[] a, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(a, l, r, mid, n - mid);
    }
    
    /**
     * Merges the sub-arrays in a sorted manner
     * 
     * @return
     */
    public static void merge(
        int[] a, int[] l, int[] r, int left, int right) {
       
          int i = 0, j = 0, k = 0;
          while (i < left && j < right) {
              if (l[i] <= r[j]) {
                  a[k++] = l[i++];
              }
              else {
                  a[k++] = r[j++];
              }
          }
          while (i < left) {
              a[k++] = l[i++];
          }
          while (j < right) {
              a[k++] = r[j++];
          }
      }
    
    /**
     * Creates a cluster for each vertex in the graph
     * 
     * @return
     */
    public void createCluster() {
        // These two for loops get all the vertices from the edges in the graph.
        int[] vertex = new int[u.length*2];
        for(int i = 0; i < u.length; i++) {
            vertex[i] = u[i];
        }
        for(int i = u.length; i < u.length*2;i++) {
            vertex[i] = v[i-u.length];
        }
        
        // This sorts the vertices.
        Arrays.sort(vertex);
        
        //This removes all the duplicate vertices, so there is only one cluster for each vertex.
        int l = this.removeDuplicates(vertex, vertex.length);
        for(int i = 0; i < l; i++) {
            clusters[i] = vertex[i];
        }
    }
    
    /**
     * Removes duplicates from an array
     * 
     * @return the length of the updated array
     */
    private int removeDuplicates(int arr[], int n)
    {
        int[] temp = new int[n];
  
        // Start traversing elements
        int j = 0;
        for (int i = 0; i < n - 1; i++)
            // If current element is not equal to next
            // element then store that current element
            if (arr[i] != arr[i + 1])
                temp[j++] = arr[i];
  
        // Store the last element as whether it is unique or
        // repeated, it hasn't stored previously
        temp[j++] = arr[n - 1];
  
        // Modify original array
        for (int i = 0; i < j; i++)
            arr[i] = temp[i];
  
        return j;
    }
}
