package hashcode;

/**
 * 2017/9/4 10:32.
 * <p>
 * Email: cheerUpPing@163.com
 */

/**
 * 要求：当对象的id相等的时候，那么就认为他们equl相等
 */
public class Name {

    private String id;

    public Name(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("equals...call");
        if (obj instanceof Name) {
            Name name = (Name) obj;
            return this.id.equals(name.id);
        }
        return false;
    }

    @Override
    public int hashCode() {
        System.out.println("hashcode...call");
        return this.id.hashCode();
    }
}
