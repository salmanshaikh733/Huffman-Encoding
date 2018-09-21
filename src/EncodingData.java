/**
 * @author Mshaik52, Student Number 250959996, this is the encoding data class which contains the symbol and the encoding string.
 * this is class is later used for decoding and encoding.
 */
public class EncodingData {

    private char symbol;
    private String encoding;

    /**
     * consutructor for making the encoding data
     * @param symbol
     * @param encoding
     */
    public EncodingData(char symbol, String encoding) {
        this.symbol = symbol;
        this.encoding = encoding;
    }

    /**
     * gets the symbol
     * @return
     */
    public char getSymbol() {
        return this.symbol;

    }

    /**
     * get the encoding
     * @return
     */
    public String getEncoding() {
        return this.encoding;
    }

    /**
     * set the encoding
     * @param encoding
     */

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    /**
     * is the object equal
     * @param obj
     * @return
     */
    public boolean equals(Object obj) {
        if (obj.equals(this.symbol)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * returns string representation of the encoding data
     * @return
     */
    public String toString() {
        return this.symbol + encoding;
    }


}
