public class Test {

    public static void main(String[] args) {

        try {
            int x = 0;
            int y = 5 / x;
        }
        catch (Exception e){
            System.out.println("Exception");
        } catch (Throwable e){
            System.out.println("Arithmetic Exception");
        }

    }

}
