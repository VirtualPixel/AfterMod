package net.id.after.util;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AfterDataFixers {
    private static final String NAMESPACE = "the_after";


    private static final Map<String, String> BIOMES = createMap(
            "after_biome"
    );



    @SafeVarargs
    private static <T> Map<T, T> createMap(T... values){
        if((values.length & 1) != 0){
            throw new IllegalArgumentException("Odd number of values");
        }
        Map<T, T> map = new HashMap<>();
        for(int i = 0; i < values.length; i += 2){
            map.put(values[i], values[i + 1]);
        }
        return Collections.unmodifiableMap(map);
    }

    @SafeVarargs
    private static <K, V> Map<K, V> mergeMaps(Map<K, V>... maps){
        return Stream.of(maps)
                .map(Map::entrySet)
                .flatMap(Collection::stream)
                .collect(Collectors.toUnmodifiableMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
