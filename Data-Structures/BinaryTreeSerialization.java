/**
* You're given the root node of a binary tree - TreeNode root in the method serializeTree.
* This method should serialize the binary tree and output a String str,
* which is then used as an input parameter for the method restoreTree.
* restoreTree should create a Binary Tree that is structurally identical
* to the one you serialized and return the root node of the tree. Limit the time complexity of both methods to O(n).
*/
public String serializeTree(TreeNode root){
    if(root == null) return "";
    
    LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
    queue.add(root);
    StringBuilder sb = new StringBuilder();
    
    while(!queue.isEmpty()){
        TreeNode node = queue.removeFirst();
        if(node == null)   sb.append("n");
        else{ 
          sb.append(node.data);
          if(node.left!=null) queue.add(node.left);
          else                queue.add(null);
          if(node.right!=null)queue.add(node.right);
          else                queue.add(null);
        }
    }
    
    return sb.toString();
}

public TreeNode restoreTree(String str){
    if(str.equals("")) return null;
    
    TreeNode head;
    TreeNode root = new TreeNode();
    root.data = Integer.parseInt(str.substring(0,1));
    head = root;

    LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
    queue.add(root);
    int leavesP=1;
    
    while(!queue.isEmpty()){
        root = queue.removeFirst();
        
        if(root!=null){
            TreeNode leave1 = new TreeNode();
            if(leavesP<str.length() && str.charAt(leavesP)!='n'){
                leave1.data = Integer.parseInt(str.charAt(leavesP)+"");
                queue.add(leave1);
            }else{ 
                leave1 = null;
                queue.add(null);
            }
            root.left = leave1;
            leavesP++;
            
            TreeNode leave2 = new TreeNode();
            if(leavesP<str.length() && str.charAt(leavesP)!='n'){
                leave2.data = Integer.parseInt(str.charAt(leavesP)+"");
                queue.add(leave2);
            }else{ 
                leave2 = null;
                queue.add(null);
            }
            root.right = leave2;
            leavesP++;
        }
    }
    
    return head;
}
