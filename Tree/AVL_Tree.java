//Node creation
public class AVL_Node
{
	int key;
	int height;
	AvlNode left;
	AvlNode right;
	AvlNode(int key)
	{
		this.key=key;
		left=null;
		right=null;
		height=0;
	}
}
//Avl operations
public class AVL
{
	//Height
	public static int height(AVL_NODE node)
	{
		return (node==null ? -1 : node.height);
	}
	//LL rotation
	public static AVL_NODE LL(AVL_NODE k2)
	{
		AVL_NODE k1=k2.left;
		k2.left=k1.right;
		k1.right=k2;
		k1.height=Math.max(height(k1.left),height(k1.right))+1;
		k2.height=Math.max(height(k2.left),height(k2.right))+1;
		return k1;
	}
	//RR rotation
	public static AVL_NODE RR(AVL_NODE k1)
	{
		AVL_NODE k2=k1.right;
		k1.right=k2.left;
		k2.left=k1;
		k1.height=Math.max(height(k1.left),height(k1.right))+1;
		k2.height=Math.max(height(k2.left),height(k2.right))+1;
		return k2;
	}
	//LR rotation
	public static AVL_NODE LR(AVL_NODE k3)
	{
		k3.left=RR(k3.left);
		return (LL(k3));
	}
	//RL rotation
	public static AVL_NODE RL(AVL_NODE k1)
	{
		k1.right=LL(K1.right);
		return (RR(k1));
	}
	//Insertion 
	public static AVL_NODE Insert(int key,AVL_NODE node)
	{
		if(node==null)
			return (new AVL_NODE(key));
		else if(key<node.key)
		{
			node.left=insert(key,node.left);
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
					node==RL(node);
			}
		}
		node.height=Math.max(height(node.left),height(node.right))+1;
		return node;
	}
	public static AVL_NODE findmin(AVL_NODE node)
	{
		if(node==null|| node.left==null)
			return node;
		return (findmin(node.left));
	} 
	public static AVL_NODE(int key,AVL_NODE node)
	{
		
	}
	
}
public class AVL_TREE
{
	
}
