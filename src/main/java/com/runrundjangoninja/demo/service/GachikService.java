package com.runrundjangoninja.demo.service;

import com.runrundjangoninja.demo.model.Gachik;

import java.util.List;

public interface GachikService {
    /**
     * Метод добавляет гачик
     *
     * @param gachik гачик который надо добавить
     */
    void add(Gachik gachik);

    /**
     * Метод возвращает список гачиков, отсортированный по рейтингу
     *
     * @return список гачиков, отсортированный по рейтингу
     */
    List<Gachik> getAllSortedByRating();
}
