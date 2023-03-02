package test;

public class Test {

    public static void main(String[] args) {
        String a = "/hello////";
        String b = "/hello/";
        String c = "/../";
        String d = "/home//foo/";
        System.out.println(simplifyPath(d));
    }

    public static String simplifyPath(String path) {

        if (path.contains("//")) {
            
        }
        return path.replaceAll("\\s+", "");

    }

}
