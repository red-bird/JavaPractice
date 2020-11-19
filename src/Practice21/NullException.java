package Practice21;

public class NullException {
    public static void main(String[] args) {
        // Такое происходит из-за стандарта IEEE 754, определенная последовательнсоть
        // битов обозначает бесконечность, такое в других типах не доступно
        System.out.println(2.0 / 0.0);
        Exception2 exep = new Exception2();
        try {
            exep.exceptionDemo();
        }
        catch (Exception ex){
            System.out.println("Error: " + ex);
        }
        finally {
            System.out.println("Program stop");
        }
        // блок try выполняет код и в случае исключения ловит его и отправляет нас в блок
        // catch, там уже выполняется другая написанная нами логика, а блок finally
        // выполняется после работы try/catch, т.е. в любом случае
    }
}