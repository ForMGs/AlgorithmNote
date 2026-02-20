//package Collection;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//
//import java.util.*;
//
//import static java.util.Comparator.comparing;
//import static java.util.stream.Collectors.groupingBy;
//import static java.util.stream.Collectors.toList;
//
//public class Collection {
//
////    public static void main(String[] agrs) throws Exception{
//
//    }
//    Dish d1 = new Dish(400, "noodle",Dish.Type.RICE);
//    Dish d2 = new Dish(200,"salad",Dish.Type.VEGETABLE);
//    Dish d3 = new Dish(150,"salmon",Dish.Type.FISH);
//
//    List<Dish> menu = new ArrayList<>(List.of(d1,d2,d3));
//
//    List<String> lowCaloricDishesName =
//            menu.stream()
//                    .filter(d->d.getCalories() <400)
//                    .sorted(comparing(Dish::getCalories))
//                    .map(Dish::getName)
//                    .collect(toList());
//            ;
//
//
//            Map<Dish.Type, List<Dish>> dishesByType =
//                    menu.stream()
//                            .collect(groupingBy(Dish::getType));
//    @Getter
//    @AllArgsConstructor
//    public static class Dish{
//        Integer calories;
//        String name;
//        private Type type;
//        public enum Type { RICE, VEGETABLE, FISH  };
//    }
//}
//
