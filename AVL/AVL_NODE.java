
public class AVL_NODE {
     public int frequency;
     public String Data;
     public int Height;
     public AVL_NODE left;
     public AVL_NODE right;

     public AVL_NODE(String D){
          Data = D;
          Height = 1;
          frequency = 1;
          left = null;
          right = null;
     }
     public AVL_NODE(){
          Data = null;
          frequency = 0;
          Height = 0;
          left = null;
          right = null;
     }   
}
