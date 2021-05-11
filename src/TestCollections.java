import java.util.*;

public class TestCollections {
    public static void listTest(){
        List<Integer> linkedList = new LinkedList<>();
        List<Integer> arrayList = new ArrayList<>();
        long timeAdd1 = 0;
        long timeAdd2 = 0;
        long timeGet1 = 0;
        long timeGet2 = 0;
        long timeRemove1 = 0;
        long timeRemove2 = 0;
        long timeSet1 = 0;
        long timeSet2 = 0;
        long start = 0;
        long end = 0;
        for (int i = 0; i < 100; i++) {
            start = System.nanoTime();
            for (int j = 0;j < 10000; j++){
                linkedList.add(0, j);
            }
            end = System.nanoTime();
            timeAdd1 += end - start;

            start = System.nanoTime();
            for (int j = 0;j < 10000; j++){
                arrayList.add(0, j);
            }
            end = System.nanoTime();
            timeAdd2 += end - start;

            start = System.nanoTime();
            for (int j = 0;j < 10000; j++){
                linkedList.get(j);
            }
            end = System.nanoTime();
            timeGet1 += end - start;
            start = System.nanoTime();
            for (int j = 0;j < 10000; j++){
                arrayList.get(j);
            }
            end = System.nanoTime();
            timeGet2 += end - start;

            start = System.nanoTime();
            for (int j = 0;j < 10000; j++){
                linkedList.set(j, j);
            }
            end = System.nanoTime();
            timeSet1 += end - start;
            start = System.nanoTime();
            for (int j = 0;j < 10000; j++){
                arrayList.set(j, j);
            }
            end = System.nanoTime();
            timeSet2 += end - start;

            start = System.nanoTime();
            for (int j = 0;j < linkedList.size(); j++){
                linkedList.remove(0);
            }
            end = System.nanoTime();
            timeRemove1 += end - start;
            start = System.nanoTime();
            for (int j = 0;j < arrayList.size(); j++){
                arrayList.remove(0);
            }
            end = System.nanoTime();
            timeRemove2 += end - start;

            linkedList.clear();
            arrayList.clear();

        }
        System.out.println("Add time: linkedList - " + timeAdd1/100 + "; arrayList - " + timeAdd2/100);
        System.out.println("Get time: linkedList - " + timeGet1/100 + "; arrayList - " + timeGet2/100);
        System.out.println("Set time: linkedList - " + timeSet1/100 + "; arrayList - " + timeSet2/100);
        System.out.println("Remove time: linkedList - " + timeRemove1/100 + "; arrayList - " + timeRemove2/100);

    }
    private static long testSetAdd(Set<Integer> set){
        long start = 0;
        long end = 0;
        start = System.nanoTime();
        for (int j = 0;j < 10000; j++){
            set.add(j);
        }
        end = System.nanoTime();
        return (end - start);
    }

    private static long testSetContains(Set<Integer> set){
        long start = 0;
        long end = 0;
        start = System.nanoTime();
        for (int j = 0;j < 10000; j++){
            set.contains(j);
        }
        end = System.nanoTime();
        return (end - start);
    }

    private static long testSetRemove(Set<Integer> set){
        long start = 0;
        long end = 0;
        start = System.nanoTime();
        for (int j = 0;j < 10000; j++){
            set.remove(j);
        }
        end = System.nanoTime();
        return (end - start);
    }

    public static void setTest(){
        HashSet<Integer> hashSet = new HashSet<Integer>();
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<Integer>();
        TreeSet<Integer> treeSet = new TreeSet<Integer>();

        long timeAdd1 = 0;
        long timeAdd2 = 0;
        long timeAdd3 = 0;
        long timeCont1 = 0;
        long timeCont2 = 0;
        long timeCont3 = 0;
        long timeRemove1 = 0;
        long timeRemove2 = 0;
        long timeRemove3 = 0;


        for (int i = 0; i < 100; i++) {
            timeAdd1 += testSetAdd(hashSet);
            timeAdd2 += testSetAdd(linkedHashSet);
            timeAdd3 += testSetAdd(treeSet);
        }
        System.out.println("Add time: hashSet - " + timeAdd1/100 + "; linkedHashSet - " + timeAdd2/100 + "; treeSet - " + timeAdd3/100);
        for(int i = 0; i < 10000; i++){
            hashSet.add(i);
            linkedHashSet.add(i);
            treeSet.add(i);
        }
        for (int i = 0; i < 100; i++) {
            timeCont1 += testSetContains(hashSet);
            timeCont2 += testSetContains(linkedHashSet);
            timeCont3 += testSetContains(treeSet);

            timeRemove1 += testSetRemove(hashSet);
            timeRemove2 += testSetRemove(linkedHashSet);
            timeRemove3 += testSetRemove(treeSet);

        }
        System.out.println("Cont time: hashSet - " + timeCont1/100 + "; linkedHashSet - " + timeCont2/100 + "; treeSet - " + timeCont3/100);
        System.out.println("Remove time: hashSet - " + timeRemove1/100 + "; linkedHashSet - " + timeRemove2/100 + "; treeSet - " + timeRemove3/100);

    }

    private static long testMapGet(Map<Integer, Integer> map){
        long start = 0;
        long end = 0;
        start = System.nanoTime();
        for (int j = 0;j < 10000; j++){
            map.get(j);
        }
        end = System.nanoTime();
        return (end - start);
    }

    private static long testMapPut(Map<Integer, Integer> map){
        long start = 0;
        long end = 0;
        start = System.nanoTime();
        for (int j = 0;j < 10000; j++){
            map.put(j, j);
        }
        end = System.nanoTime();
        return (end - start);
    }

    private static long testMapRemove(Map<Integer, Integer> map){
        long start = 0;
        long end = 0;
        start = System.nanoTime();
        for (int j = 0;j < 10000; j++){
            map.remove(j);
        }
        end = System.nanoTime();
        return (end - start);
    }

    public static void mapTest(){
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        long timeGet1 = 0;
        long timeGet2 = 0;
        long timeGet3 = 0;
        long timePut1 = 0;
        long timePut2 = 0;
        long timePut3 = 0;
        long timeRemove1 = 0;
        long timeRemove2 = 0;
        long timeRemove3 = 0;


        for (int i = 0; i < 100; i++) {
            timePut1 += testMapPut(hashMap);
            timePut2 += testMapPut(linkedHashMap);
            timePut3 += testMapPut(treeMap);
        }
        System.out.println("Put time: hashMap - " + timePut1/100 + "; linkedHashMap - " + timePut2/100 + "; treeMap - " + timePut3/100);
        for(int i = 0; i < 10000; i++){
            hashMap.put(i, i);
            linkedHashMap.put(i, i);
            treeMap.put(i, i);
        }
        for (int i = 0; i < 100; i++) {
            timeGet1 += testMapGet(hashMap);
            timeGet2 += testMapGet(linkedHashMap);
            timeGet3 += testMapGet(treeMap);

            timeRemove1 += testMapRemove(hashMap);
            timeRemove2 += testMapRemove(linkedHashMap);
            timeRemove3 += testMapRemove(treeMap);

        }
        System.out.println("Get time: hashMap - " + timeGet1/100 + "; linkedHashMap - " + timeGet2/100 + "; treeMap - " + timeGet3/100);
        System.out.println("Remove time: hashMap - " + timeRemove1/100 + "; linkedHashMap - " + timeRemove2/100 + "; treeMap - " + timeRemove3/100);

    }
}
