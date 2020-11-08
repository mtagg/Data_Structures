

public class AVL{

     public static int findHeight (AVL_NODE N){
          if (N == null)return 0;   
          else return N.Height;
     }

     public static int balance (AVL_NODE N){
          if (N == null) return 0;
          else return findHeight(N.left) - findHeight(N.right);
     }

     public static int MAX(int a, int b){
          return ((a > b) ? a : b);
     }

     public static AVL_NODE RightRotate(AVL_NODE node){
          //System.out.println("RR");

          AVL_NODE childR = node.left.right;     //will become the original node's left child
          node.left.right = node;                //copy root to left childs right child location
          node = node.left;                      //left child branch unchanged
          node.right.left = childR;              //the new right child recieves the old left childs right branch as its left child branch
          
          //update new child (old parent) height, and the new parent height afterwards:
          node.right.Height = 1 + MAX(findHeight(node.right.left),findHeight(node.right.right));
          node.Height = 1 + MAX(findHeight(node.left), findHeight(node.right));
          //return new parent node now that everything is adjusted
          return node;                            
     }
     public static AVL_NODE LeftRotate(AVL_NODE node){
          //System.out.println("LL");

          AVL_NODE childL = node.right.left;    //to become original node's right child
          node.right.left = node;               //parent node is left child of node's child
          node = node.right;                    //parent node is now the original right child - 
          node.left.right = childL;             //original node's right child recieves the old left child of new parent

          node.left.Height = 1 + MAX(findHeight(node.left.left),findHeight(node.left.right));
          node.Height = 1 + MAX(findHeight(node.left),findHeight(node.right));

          return node;
     }
     public static AVL_NODE INSERT(String Data, AVL_NODE node){

          if (node == null) return new AVL_NODE(Data);

          int compareData = Data.compareTo(node.Data);

          if (compareData == 0){
               node.frequency++;
               return node; //no change to tree, does not require rebalance
          }

          //insert and adjust tree:
          else{  
               if (compareData < 0){
                    node.left = INSERT(Data, node.left);//traverse left
               } 
               else if (compareData > 0){
                     node.right = INSERT(Data, node.right);//traverse right
               }

          //update node height
               node.Height = 1 + MAX(findHeight(node.left),findHeight(node.right));
               
          //balance AVL tree:   
               int temp;
               if (balance(node) > 1){                   
                    temp = Data.compareTo(node.left.Data);
                    if (temp < 0) {          // we inserted Data DownLeft(x2)
                         return RightRotate(node);
                    }
                    if (temp > 0){           //we inserted Data DownLeft then DownRight
                         node.left = LeftRotate(node.left);
                         return RightRotate(node);
                    }                   
               }
               if (balance(node) < -1){
                    temp = Data.compareTo(node.right.Data);
                    if (temp > 0){           // we inserted Data DownRight(x2)
                         return LeftRotate(node);
                    }
                    if (temp < 0){           // we inserted Data DownRight then DownLeft
                          node.right = RightRotate(node.right);
                         return LeftRotate(node);
                    }
               }  
          }return node; 
     }//end of INSERT
     
     
     public static AVL_NODE DELETE(String Data, AVL_NODE node){
          if (node == null) return node;
          int compare = Data.compareTo(node.Data);
          if (compare == 0){
               if (balance(node) >= 0){
                    if (node.left.right == null){
                         node.left.right = node.right;
                         return node.left;
                    }
                    else{
                         AVL_NODE temp = node.right; //to reatach to new root
                         node = newRootLeft(node.left.right); 
                         node.right = temp;
                    }
               }
               else{
                    
                    if (node.right.left == null){
                         node.right.left = node.left;
                         return node.right;
                    }
                    else{
                         AVL_NODE temp = node.left; 
                         node = newRootRight(node.right.left);
                         node.left = temp;
                    }
               }
          }else{
               if (compare < 0) {
                    node.left = DELETE(Data, node.left);
               }
               if (compare > 0) {
                    node.right = DELETE(Data, node.right);
               }
          }return node;
     }//end of DELETE

     public static AVL_NODE newRootLeft(AVL_NODE node){
          if (node == null) return node; //failsafe - should not be
          //find the next value with null children to 
          if (node.right == null){
               AVL_NODE newRoot = node; //root to replace deletion
               node = node.left;   //since the left child existed, takes nodes place
               return newRoot;         //the original end node is now returned
          }
          else return newRootLeft(node.right); //keep traversing right to find new root          
     }

     public static AVL_NODE newRootRight(AVL_NODE node){
          if (node == null) return node; //failsafe - should not be needed
          //find the next value with null children to 
          if (node.left == null){
               AVL_NODE newRoot = node; //root to replace deletion
               if (node.right != null){
                    node = node.right;   //since the right child existed, takes nodes place
               }return newRoot;         //the original end node is now returned
          }else{
               return newRootRight(node.left); //keep traversing right to find new root
          }
     }

}//end of AVL class