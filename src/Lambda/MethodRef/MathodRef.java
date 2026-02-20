//package Lambda.MethodRef;
//
//import java.util.ArrayList;
//import java.util.Comparator;
//import java.util.List;
//import java.util.function.Function;
//import java.util.function.Predicate;
//
//public class MathodRef {
//    static List<Apple> inventory;
//    public static void main(String[] args)throws Exception{
//
//        inventory= new ArrayList<>();
//
//        Apple a1 = new Apple(100,"korea","red");
//        Apple a2 = new Apple(150,"USA","red");
//        Apple a3 = new Apple(200,"korea","green");
//        Apple a4= new Apple(150 , "korea","green");
//        inventory.add(a1);
//        inventory.add(a2);
//        inventory.add(a3);
//        inventory.sort(new AppleComparator());
//
//        //AppleComparator 를 쓰지 않고 무게만 비교
//        inventory.sort(Comparator.comparing(Apple::getWeight));
//
//        inventory.sort(Comparator.comparing(Apple::getWeight).reversed()
//                .thenComparing(Apple::getCountry));
//
//        Predicate<Apple> redApple = apple -> apple.getColor().equals("red");
//        Predicate<Apple> nonRedApple = redApple.negate();
//        Predicate<Apple> redAndHeavyApple = redApple.and(apple->apple.getWeight()>150);
//        Predicate<Apple> redAndHeavyAppleOrGreen =
//                redApple.and(apple->apple.getWeight()>150)
//                        .or(apple -> "green".equals(apple.getColor()));
//
//        //Function
//        Function<Integer, Integer> f = x-> x+1;
//        Function<Integer, Integer> g = x->x*2;
//        Function<Integer ,Integer>h = f.andThen(g);
//        int result = h.apply(1);
//
//    }
//    public static class AppleComparator implements Comparator<Apple> {
//        public int compare(Apple a1, Apple a2){
//            return a1.getWeight().compareTo(a2.getWeight());
//
//        }
//    }
//}
