import java.lang.System;

public class AVL_traversal {

     public static void preorder (AVL_NODE node){
          if (node == null) return;
          System.out.println(node.Data);
          preorder(node.left);
          preorder(node.right);
          return;     
     }
     public static void postorder(AVL_NODE node){
          if (node == null) return;
          postorder(node.left);
          postorder(node.right);
          System.out.println(node.Data);
          return;
     }
     public static void inorder  (AVL_NODE node){
          if (node == null) return;
          inorder(node.left);
          System.out.println(node.Data);
          inorder(node.right);
          return;
     }
     // public static void revorder (AVL_NODE node){
     //      if (node == null) return;
     //      inorder(node.right);
     //      System.out.println(node.Data);
     //      inorder(node.left);
     //      return;
     // }
}// end AVL_TRAVERSAL.JAVA
