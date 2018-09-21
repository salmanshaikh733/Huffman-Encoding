/**
 * @author mshaikh52, Student number 250959996, this is the huffman coder class this class extends the huffman tree and implements the encode and decode methods responsible for compressing
 * and decompressing the text files.
 */
public class HuffmanCoder extends HuffmanTree {

    private HuffmanTree huffTree;
    private ArrayUnorderedList<EncodingData> encodingList= new ArrayUnorderedList<EncodingData>();

    /**
     * constructor for huffman coder
     * @param pairsList
     */
    public HuffmanCoder(ArrayOrderedList<HuffmanPair> pairsList){
     huffTree= new HuffmanTree(pairsList);
     buildEncodingList(huffTree.getRoot(),"");
    }

    /**
     * method to decode the code
     * @param code
     * @return
     */
    public char decode(String code ) {
        char target=(char)0;
        int i =0;
        //BinaryTreeNode<HuffmanPair> node;
        while (i< encodingList.size()){
            if (encodingList.getElement(i).getEncoding().equals(code)){
                target=encodingList.getElement(i).getSymbol();
                break;
            }
            else {
                i++;
            }
        }
        return target;
    }

    /**
     * method to encode the character
     * @param c
     * @return
     * @throws ElementNotFoundException
     */
    public String encode(char c) throws ElementNotFoundException{
        int i=0;
        String target=null;
        while (i<encodingList.size()){
            if (encodingList.getElement(i).equals(c)){
                target=encodingList.getElement(i).getEncoding();
                break;
            }
            else {
                i++;
            }
        }
        if (target==null){
            throw new ElementNotFoundException("ELEMENT NOT FOUND");
        }

        return target;
    }

    /**
     * build the encoding list
     * @param node
     * @param encoding
     */
    private void buildEncodingList(BinaryTreeNode<HuffmanPair> node, String encoding){
        EncodingData data = new EncodingData(node.getElement().getCharacter(), encoding);

        if (node.isLeaf()){
            encodingList.addToRear(data);
        }
        else {
            buildEncodingList(node.getLeft(),encoding+0);
            buildEncodingList(node.getRight(),encoding+1);
        }


    }

    /**
     * returns string representation of huffman coder
     * @return
     */
    public String toString(){
        int i=0;
        String s=null;
        while (i<encodingList.size()){
            s=encodingList.getElement(i)+s;
            i++;
        }
        return s;
    }




}
