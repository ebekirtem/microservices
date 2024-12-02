package com.monitoring.tutuorial.hmap;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class HashMp {

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        String sId = UUID.randomUUID().toString();
        System.out.println(map.put(1, sId));
        System.out.println(map.get(1)); //It returns null
        //System.out.println(map.get(2)); //It returns null

        System.out.println(map.containsKey(1));

        System.out.println(map.containsValue(sId));

        System.out.println(map.put(1, UUID.randomUUID().toString()));

        map.put(1, UUID.randomUUID().toString());

        System.out.println(map.replace(1, "Replace value"));
        System.out.println(map);

        map.putIfAbsent(2, "PuIfAbsent");

        System.out.println(map.getOrDefault(5, "DEfault"));
        System.out.println(map);

        map.computeIfAbsent(4, key -> "Compute IfAbsent");
        map.computeIfPresent(4, (key, value) -> "dsdsd");
        System.out.println(map);


        String word = "Hello World";
        int length = word.length();
        int i = length - 1;
        StringBuffer buf = new StringBuffer();
        while (i >= 0) {
            buf.append(word.charAt(i));
            i = i - 1;
        }

        System.out.println(buf);

        String str = "MErhaba";
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);

        System.out.println(charArray);
        String[] wordList = {"koşmak", "şokmak", "okşmak", "eat", "ate", "tea", "aet", "eta", "ebubekir", "rikebube"};

        Map anagram = findAnagram(wordList);
        List<List<String>> listOfWord = new ArrayList<>(anagram.values());
        System.out.println(listOfWord);

        int[] numbers = {1, 5, 3, 5, 5};
        System.out.println(findMaxFrequent(numbers));

        System.out.println(findRecurrentChar("Kookom"));

        System.out.println(findSameChar("Ebubikir",""));


        String state="Ben okula giderken";


        List<String> listOfString=List.of("Merhaba","okula","gidiyorum");

        List<Character> collect = listOfString.stream().flatMap(s -> s.chars().mapToObj(c -> (char) c)).collect(Collectors.toList());


        List<Integer> lengthOfList = listOfString.stream().map(s -> s.length()).collect(Collectors.toList());

        System.out.println(collect);


        listOfString.stream().map(String::toUpperCase).collect(Collectors.toList());

        listOfString.stream().map(s->s.toUpperCase()).collect(Collectors.toList());


        calculateTotalInRange(1,6);

        countVowels("aaabbbeee",new char[]{'a','i','o','ö','ü','u','ı','e'});

        countVowels2("aaabbbeee",new char[]{'a','i','o','ö','ü','u','ı','e'});

        findMaxAndMin(new Integer []{});
        findMaxAndMin2(new Integer []{4545454,2323,11,887,455454534});



        Integer [] list={1, 2, 3, 4, 5, 6};
        List<Integer> filteredList = Arrays.stream(list).filter(n -> n % 2 == 0)
                .map(n -> n * 2)
                .toList();

        StringBuilder builder=new StringBuilder();
        builder.append("[");
        for (Integer a: filteredList){
            builder.append(a.toString()).append(",");
        }
        builder.delete(builder.length()-1,builder.length()).append("]");
        System.out.println(builder);


        Integer [][] nestedList={{1, 2, 3, 4, 5},{6,56,45,34},{7,5,2,4,9,45}};
      Arrays.stream(nestedList).flatMap(Arrays::stream)
                .distinct()
                .toList().forEach(System.out::println);



      countWordsInGivenString("BEn okula giderken bir yılan tıs tıs diye diye ses çıkarıyordu");

    }

    private static Map findAnagram(String[] words) {
        Map<String, ArrayList<String>> map = new HashMap<>();
        for (String w : words) {
            char[] charArray = w.toCharArray();
            Arrays.sort(charArray);
            String sortedString = new String(charArray);
            map.computeIfAbsent(sortedString, k -> new ArrayList<String>()).add(w);
        }

        return map;
    }

    private static int findMaxFrequent(int[] arr) {
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();

        for (int n : arr) {
            map.computeIfAbsent(Integer.valueOf(n), key -> new ArrayList<Integer>()).add(n);
        }

        List<List<Integer>> listOfNum = new ArrayList<>(map.values());

        for (List<Integer> l : listOfNum) {
            if (l.size() > ((float) arr.length / 2)) {
                return l.get(0);
            }
        }
        return -1;

    }

    private static Map<Character, Integer> findCharFrequency(String str) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        return map;
    }

    private static int findRecurrentChar(String str) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : str.toLowerCase().toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < str.length(); i++) {
            char c = str.toLowerCase().charAt(i);
            if (map.get(c) == 1) {
                return i;
            }
        }


        return -1;
    }


    private static Map<Character,Integer> findSameChar(String s1, String s2) {

        Map<Character, Integer> strMap1 = new HashMap<>();
        Map<Character, Integer> strMap2 = new HashMap<>();


        for (char c : s1.toCharArray()) {
            strMap1.put(c, strMap1.getOrDefault(c, 0) + 1);
        }

        for (char c : s2.toCharArray()) {
            strMap2.put(c, strMap2.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> sameCharMap = new HashMap<>();

        strMap1.forEach((character, count) -> {
            Integer val = strMap2.getOrDefault(character, 0);
            if (val != 0) {
                Integer sameNumber = Math.min(count, val);
                sameCharMap.put(character, sameNumber);
            }
        });

     return sameCharMap;
    }

    public static void calculateTotalInRange(int start, int end){
        int sum = IntStream.range(start, end).sum();
        System.out.printf("Total:%d%n",sum);

        sum=0;
        for (int i=start;i<end;i++){
            sum+=i;
        }

        System.out.println(String.format("Toplam:%d, !",sum));

    }


    public static void countVowels(String s,char[] vowelSet){
        int total=0;
        for (int i=0;i<s.length();i++){
            char c=s.toLowerCase().charAt(i);

            for (int j=0;j<vowelSet.length;j++){
                if(c==vowelSet[j]){
                    total++;
                }
            }
        }

        System.out.println(String.format("Total vowel count in %s:%d",s,total));
    }


    public static void countVowels2(String s,char[] vowelSet){
        int total=0;
        String vowels=new String(vowelSet);
        System.out.println(vowels);
        for (int i=0;i<s.length();i++){
            if(vowels.indexOf(s.charAt(i))!=-1){
                total++;
            }

        }

        System.out.println(String.format("Total vowel count in %s:%d",s,total));
    }

    public static void findMaxAndMin(Integer [] array){
        Optional<Integer> max = Arrays.stream(array).max(Comparator.naturalOrder());
        Optional<Integer> min = Arrays.stream(array).min(Comparator.naturalOrder());

        max.ifPresent(integer -> System.out.println("Max value:" + integer));
        min.ifPresent(integer -> System.out.println("Min value:" + integer));
    }


    public static void findMaxAndMin2(Integer [] array){

        Optional<Integer> max = Arrays.stream(array).max((o1, o2) -> (o1 - o2));

        max.ifPresent(v-> System.out.println("Max value: "+v));
    }

    //Write a program to count the frequency of words in a given string using HashMap.


    public static void countWordsInGivenString(String str){

        String[] words = str.split(" ");
        Map<String,Integer> wordMap=new HashMap<>();

        for (String w:words){
            wordMap.put(w,wordMap.getOrDefault(w,0)+1);
        }

        System.out.println(wordMap);
    }

}
