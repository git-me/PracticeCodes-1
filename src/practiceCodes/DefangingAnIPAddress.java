public class DefangingAnIPAddress {
    public static String defangIPaddr(String address) {
       // address.replaceAll("\\." ,"[.]");

        return  address.replaceAll("\\." ,"[.]");
    }

    public static void main(String[] args) {
        String add="255.0.9.8";
        String output=defangIPaddr(add);
        System.out.println(output);
    }
}
