package Lib;
/**
 * Classe RecursiveBinaryTree implements RBinaryTree
 * Authors : Christophe Deleval, Anne-Sophie Branders
 * Date : 13/10/2014
 */ 

public class RecursiveBinaryTree<E> implements RBinaryTree<E> {

    protected E root; //reference to the root
    protected int size; //number of nodes
    protected RecursiveBinaryTree<E> left; //left node of the root
    protected RecursiveBinaryTree<E> right; //right node of the root

    /**
     * Constructor of RecursiveBinaryTree
     */
    public RecursiveBinaryTree(){
        root 	= null;
        size 	= 0;
        left 	= null;
        right 	= null;
    }

    /**
     * @pre -
     * @post return true if this is empty, false otherwise.
     */
    public boolean isEmpty(){
        return (root==null);

    }

    /**
     * @pre -
     * @post return the number of nodes of this. 
     *       Note: the number of nodes of an empty tree is 0.
     */
    public int size(){
        return size;
    }

    /**
     * @pre this is not empty.
     * @post return a reference to the tree root.
     */
    public E root(){
        return root;
    }

    /**
     * @pre this is not empty
     * @post return true if this is reduced to a leaf (External Node), 
     *       false otherwise
     */
    public boolean isLeaf(){
        return(getRight()==null && getLeft() == null);
    }

    /**
     * @pre this is not empty.
     * @post return a reference to the left subtree.
     */
    public RecursiveBinaryTree<E> getLeft(){
        return left;
    }

    /**
     * @pre this is not empty.
     * @post return a reference to the right subtree.
     */
    public RecursiveBinaryTree<E> getRight(){
        return right;
    }
	
	/**
     * @pre this is not empty.
     * @post return true if there is a right subtree.
     */
    public boolean hasRight(){
        return (right!=null);
    }
	
	/**
     * @pre this is not empty.
     * @post return true if there is a left subtree.
     */
    public boolean hasLeft(){
        return (left!=null);
    }

    /**
     * @pre this is not empty.
     * @post o is the element stored at the root of this.
     */
    public void setElement (E o){
        root = o;
    } 

    /**
     * @pre this is not empty.
     * @post tree is the left subtree of this.
     */
    public void setLeft (RBinaryTree<E> tree){
        left = (RecursiveBinaryTree<E>) tree;
        size += left.size();
    }

    /**
     * @pre this is not empty.
     * @post tree is the right subtree of this.
     */
    public void setRight (RBinaryTree<E> tree){
        right = (RecursiveBinaryTree<E>) tree;
        size += right.size();
    }
}

