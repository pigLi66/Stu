import java.util.ArrayList;
import java.util.List;

import sun.security.jca.GetInstance;

public class Unchecked {

  public static void main(String[] args) {
    List<Integer> list = getInstance(ArrayList.class);
    list.add(1);
    list.forEach(System.out::println);
  }

  private static<T> T getInstance(Class<T> clazz) {
    return (T)newInstance(clazz);
  }

  private static Object newInstance(Class clazz) {
    try {
      return clazz.newInstance();
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

}
