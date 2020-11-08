import java.util.*;

public class AVLmain {
     
     public static AVL_NODE root = new AVL_NODE("Hi");
     
     public static void main(String [] args){ 
          
          ArrayList <String>  dataStrings = new ArrayList<String>();
          dataStrings.add("0Hello");
          dataStrings.add("1Hello");
          dataStrings.add("2Hello");
          dataStrings.add("3Hello");
          dataStrings.add("4Hello");
          dataStrings.add("ZZZZZ");
          for (int i = 0; i < dataStrings.size();i++){
               //System.out.println(dataStrings.get(i));
               root = AVL.INSERT(dataStrings.get(i), root);
          }
          //post-initialization traversal
          System.out.println("\n");
          System.out.println("PRE");
          AVL_traversal.preorder(root);
          System.out.println("\n");
          System.out.println("IN");
          AVL_traversal.inorder(root);
          System.out.println("\n");
          System.out.println("POST");
          AVL_traversal.postorder(root);
          //deletion
          root = AVL.DELETE("Hi", root);
          //post-deletion traversal
          System.out.println("\n");
          System.out.println("PRE");
          AVL_traversal.preorder(root);
          System.out.println("\n");
          System.out.println("IN");
          AVL_traversal.inorder(root);
          System.out.println("\n");
          System.out.println("POST");
          AVL_traversal.postorder(root);
          return;
     }
}
