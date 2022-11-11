public class Item extends KeyedItem<String> {

    private boolean assocboolean;
    private int assocint;

    public Item(String key, boolean assocboolean, int assocint) {
        super(key);
        this.assocboolean = assocboolean;
        this.assocint = assocint;
    }

    /**
     * Getter method for assocboolean
     * @return assocboolean
     * */
    public boolean getAssocBoolean() {
        return assocboolean;
    }

    /**
     * Mutator method that sets value of assocboolean
     * @param bool
     * */
    public void setAssocBoolean(boolean bool) {
        assocboolean = bool;
    }

    /**
     * Getter method for assocint
     * @return assocint
     * */
    public int getAssocInt() {
        return assocint;
    }

    /**
     * Mutator method for setAssocInt
     * @param assocint
     * */
    public void setAssocInt(int assocint) {
        this.assocint = assocint;
    }

    /**
     * To String method
     * @return str.toString
     * */
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(getKey()+"/"+assocboolean+"/"+assocint);
        return str.toString();
    }

}

