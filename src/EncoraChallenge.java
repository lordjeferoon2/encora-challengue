import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class EncoraChallenge {

    public static void main(String[] args) {
    	String[] pruebas = {"{}()", "(()", "{[()]}", "{[()]", "(", ")", "[[()]]", "((()))"};
        for (String prueba : pruebas) {
            System.out.println("Evaluando cadena " + prueba + ": " + validateString(prueba));
        }
    }

    public static boolean validateString(String text) {
        Deque<Character> pila = new LinkedList<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        for (char item : text.toCharArray()) {
            if (map.containsValue(item)) {
                pila.push(item);
            } else if (map.containsKey(item)) {
                if (pila.isEmpty() || pila.pop() != map.get(item)) {
                    return false;
                }
            }
        }
        return pila.isEmpty();
    }
}