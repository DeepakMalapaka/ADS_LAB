class AvlNode
{
    int key,height;
    AvlNode left;
    AvlNode right;
    AvlNode(int key)
    {
        this.key=key;
        left=right=null;
        height=0;
    }
}
public class AvlTree
{
    public static int height(AvlNode node)
    {
        if(node==null)
            return -1;
        return node.height;
    }
    public static AvlNode LL(AvlNode k2)
    {
        AvlNode k1=k2.left;
        k2.left=k1.right;
        k1.right=k2;
        k1.height=Math.max(height(k1.left),height(k1.right))+1;
        k2.height=Math.max(height(k2.left),height(k2.right))+1;
        return k1;
    }
    public static AvlNode RR(AvlNode k1)
    {
        AvlNode k2=k1.right;
        k1.right=k2.left;
        k2.left=k1;
        k1.height=Math.max(height(k1.left),height(k1.right))+1;
        k2.height=Math.max(height(k2.left),height(k2.right))+1;
        return k1;
    }
    public static AvlNode LR(AvlNode k3)
    {
        k3.left=RR(k3.left);
        return k3;
    }
    public static AvlNode RL(AvlNode k1)
    {
        k1.right=LL(k1.right);
        return k1;
    }
    public static AvlNode insert(int key,AvlNode node)
    {
        if(node==null)
            return new AvlNode(key);
        else if(key<node.key)
        {
            node.left=insert(key, node.left);
            if(height(node.left)-height(node.right)==2)
            {
                if(key<node.left.key)
                    node=LL(node);
                else 
                    node=LR(node);
            }
            
        }
        else 
        {
            node.right=insert(key,node.right);
            if(height(node.left)-height(node.right)==-2)
            {
                if(key>node.right.key)
                    node=RR(node);
                else
                    node=RL(node);
            }
        }
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return node;
    }
    public static AvlNode findMin(AvlNode node)
    {
        if(node==null || node.left==null)
            return node;
        return findMin(node.left);
    }
    public static AvlNode delete(int key ,AvlNode node)
    {
        if(node==null)
            return node;
        if(key<node.key)
            node.left=delete(key,node.left);
        else if(key>node.key)
            node.right=delete(key,node.right);
        else 
        {
            if(node.left!=null && node.right!=null)
            {
                AvlNode minNode=findMin(node.right);
                node.key=minNode.key;
                node.right=delete(minNode.key,node.right);     
            }
            else 
            {
                node=(node.left!=null)?node.left:node.right;
            }
        }   
        if(node!=null)
        {
            node.height=Math.max(height(node.left),height(node.right))+1;
            if(height(node.left)-height(node.right)==2)
            {
                if(height(node.left.left)>=height(node.left.right))
                    node=LL(node);
                else
                    node=LR(node);
            }
            else if(height(node.left)-height(node.right)==-2) 
            {
                if(height(node.right.right)>=height(node.right.left))
                    node=RR(node);
                else
                    node=RL(node);
            }
        }
        return node;
        
    }
    public static void inOrder(AvlNode node)
    {
        if(node!=null)
        {
            inOrder(node.left);
            System.out.println(node.key+" ");
            inOrder(node.right);
        }
    }
    public static void main(String args[])
    {
        AvlNode root=null;
        int []arr={3, 2, 1, 4, 5, 6, 7, 16, 15, 14, 13, 12, 11, 10, 8, 9};
        for(int x:arr)
        {
            root=insert(x,root);
            System.out.println("The height of Avl tree after inserting "+x+" is "+height(root));
        }
        System.out.println("Inoder traversal of Avl tree is:");
        inOrder(root);
        delete(13,root);
        System.out.println("The Avl tree after deleting the 13 is:");
        inOrder(root);
    }    
}
