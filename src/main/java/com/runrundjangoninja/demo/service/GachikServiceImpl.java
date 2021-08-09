package com.runrundjangoninja.demo.service;

import com.runrundjangoninja.demo.model.Gachik;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GachikServiceImpl implements GachikService {
    private final List<Gachik> gachiks = new ArrayList<>();

    /**
     * Метод добавляет гачик
     *
     * @param gachik гачик который надо добавить
     */
    @Override
    public void add(Gachik gachik) {
        gachiks.add(gachik);
    }

    /**
     * Метод возвращает список гачиков, отсортированный по рейтингу
     *
     * @return список гачиков, отсортированный по рейтингу
     */
    @Override
    public List<Gachik> getAllSortedByRating() {
        return gachiks
                .stream()
                .sorted(Comparator.comparingDouble(Gachik::getRating).reversed())
                .collect(Collectors.toList());
    }
}
