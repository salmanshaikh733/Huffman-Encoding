/**
 * @author Mshaik52 studnet number 250959996, This is the class huffman tree, this class consutructs the huffman tree and extends the
 * Linked Binary class and implements the comparable interface.
 *
 */
//import jdk.nashorn.internal.ir.BinaryNode;

import java.util.Iterator;

public class HuffmanTree extends LinkedBinaryTree<HuffmanPair> implements Comparable<HuffmanTree> {

    /**
     * constructor to make empty huffman tree
     */
    public HuffmanTree() {
        super();
    }

    /**
     * constructor to make huffman tree that has 1 node, and element being root
     * @param element
     */


    public HuffmanTree(HuffmanPair element) {
        super(element);
    }

    /**
     * huffman tree that has root as element and left and right child as leftsubtree and rightsubtree,
     * @param element
     * @param leftSubtree
     * @param rightSubtree
     */
    public HuffmanTree(HuffmanPair element, HuffmanTree leftSubtree, HuffmanTree rightSubtree) {
        super(element);
        this.getRoot().setLeft(leftSubtree.getRoot());
        this.getRoot().setRight(rightSubtree.getRoot());

    }

    /**
     * creates a huffman tree in ascending order, with a list of huffman pairs sent as arguments.
     * @param pairsList
     */
    public HuffmanTree(ArrayOrderedList<HuffmanPair> pairsList) {

        ArrayOrderedList<HuffmanTree> buildList = new ArrayOrderedList<HuffmanTree>();
        if (pairsList.size() > 1) {

            for (int i = 0; i < pairsList.size(); i++) {
                HuffmanTree newTree = new HuffmanTree(pairsList.getElement(i));
                buildList.add(newTree);
            }

            while (buildList.size() > 1) {
                HuffmanTree leftTree;
                HuffmanTree rightTree;
                leftTree = buildList.removeFirst();
                rightTree = buildList.removeFirst();
                int totalFreq = leftTree.getRoot().getElement().getFrequency() + rightTree.getRoot().getElement().getFrequency();
                HuffmanPair root = new HuffmanPair(totalFreq);
                HuffmanTree FINALHTREE = new HuffmanTree(root, leftTree, rightTree);
                buildList.add(FINALHTREE);
            }
            this.setRoot(buildList.removeFirst().getRoot());
        } else {
            new HuffmanTree(pairsList.removeFirst());

        }

    }

    /**
     * compare method that is used by the add method, this method ensures that the add method places node in correct order.
     * @param otherTree
     * @return
     */
    public int compareTo(HuffmanTree otherTree) {

        if (otherTree.getRoot().getElement().getFrequency() > getRoot().getElement().getFrequency()) {
            return -1;
        } else if (otherTree.getRoot().getElement().getFrequency() == getRoot().getElement().getFrequency()) {
            return 0;
        } else {
            return 1;
        }

    }

    /**
     * returns string representation of huffman tree
     * @return
     */

    public String toString() {
        String s = "";

        Iterator<HuffmanPair> list;

        list = iteratorPreOrder();
        while (list.hasNext()) {
            s += list.next().toString();
        }
        return s;
    }


}
