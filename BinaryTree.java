import java.util.Scanner;

public class BinaryTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // parse the array representing the binary search tree
        int[] binaryTree;
        String input = sc.nextLine();
        if (input.equals("")) {
            binaryTree = new int[0];
        } else {    
            String[] binaryTreeStrings = input.split(" ");
            binaryTree = new int[binaryTreeStrings.length];
            for (int i = 0; i < binaryTreeStrings.length; i++) {
                binaryTree[i] = Integer.parseInt(binaryTreeStrings[i]);
            }
        }

        // check if this is a binary search tree; print the result
        System.out.println(isBinarySearchTree(binaryTree));
    }
    
    public static boolean isBinarySearchTree(int[] binaryTree) {
      int level = 1;
      boolean findlevel = false;
      int te = 1;
      
      while(!findlevel){
    	  te = 1;
       for(int z=0;z<level;z++)
         te *= 2;
         if(te-1 >=binaryTree.length)
         findlevel = true;
         else
         level++;
      }
       myTree mt= new myTree(binaryTree[0],level);
      for(int i=1;i<binaryTree.length;i++){
        boolean ef = mt.add(binaryTree[i]);
        if(!ef)
        return false;
      }
      int[] tree = mt.bfs();
      for(int t=0;t<tree.length;t++)
      System.out.print(tree[t]+"  ");
      return true;
    }
    
    
}



class myTreenode{
  public int value;
  public myTreenode left;
  public myTreenode right;
  public myTreenode(int v){
    this.value = v;
  }
}

class myTree{
  public myTreenode root;
  public int level;
  public int size = 1;
  public myTree(int rootvalue, int level){
    this.root = new myTreenode(rootvalue);
    this.level = level;
  }
  
  public int[] bfs(){
        int[] res= new int[size];
        myTreenode temp = this.root;
        bfsr(temp,res,0);
        return res;
  }
  
  public void bfsr(myTreenode temp,int[] res,int i){
       res[i] = temp.value;
       try {
       bfsr(temp.left,res,2*i+1);
       bfsr(temp.right,res,2*i+2);
       }catch(Exception ee) {};
  }
  
  public boolean add(int value1){
    myTreenode temp = root;
    for(int level0=1;level0<level;level0++){
    if(value1 > temp.value)
    if(temp.right==null)
    {
      temp.right = new myTreenode(value1);
      this.size++;
      return true;
    }
    if(temp.right!=null)
    temp = temp.right;
     if(value1 < temp.value)
    if(temp.left==null)
    {
      temp.left = new myTreenode(value1);
      this.size++;
      return true;
    }
    if(temp.left!=null)
    temp = temp.left;
    }
    return false;
  }
  
}