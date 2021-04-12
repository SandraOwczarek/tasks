package com.crud.tasks.controller;

import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.trello.client.TrelloClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TrelloController {

    private TrelloClient trelloClient;

    @Autowired
    public void setTrelloClient(TrelloClient trelloClient) {
        this.trelloClient = trelloClient;
    }
    @GetMapping(value = "getTrelloBoards")
    public void getTrelloBoards() {
        List<TrelloBoardDto> trelloBoards = trelloClient.getTrelloBoards();
        trelloBoards.forEach(trelloBoardDto -> System.out.println(trelloBoardDto.getId() + " " + trelloBoardDto.getName()));
        /* Optional<TrelloBoardDto[]> boardsResponse = Optional.ofNullable(restTemplate.getForObject(url,TrelloBoardDto[].class));
        return Arrays.asList(boardsResponse.orElse(new TrelloBoardDto[0]));
        if (isNotEmpty) {
        return new ArrayList<>(); */
    }

    @GetMapping(value = "getTrelloBoardsContainsIdAndName")
    public void getTrelloBoardsContainsIdAndName() {
        List<TrelloBoardDto> trelloBoards = trelloClient.getTrelloBoards();
        trelloBoards.stream().filter(e -> e.getName() != null && e.getId() != null &&
                e.getName().contains("Kodilla")).forEach(e -> System.out.println(e.getId() + " " + e.getName()));
    }
}