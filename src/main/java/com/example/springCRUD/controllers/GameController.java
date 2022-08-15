package com.example.springCRUD.controllers;

import com.example.springCRUD.models.GameModel;
import com.example.springCRUD.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;


@Controller
public class GameController {

    private final GameRepository gameRepository;
    @Autowired
    public GameController(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @GetMapping("/game")
    public String gamePage(Model model){
        Iterable<GameModel> games = gameRepository.findAll();
        model.addAttribute("games", games);
        model.addAttribute("title", "Games");
        return "game";
    }

    @GetMapping("/game/{id}")
    public String showGameInfoPage(@PathVariable(value = "id") long id, Model model){
        if(!gameRepository.existsById(id)) return "redirect:/game";

        Optional<GameModel> game = gameRepository.findById(id);
        ArrayList<GameModel> result =new ArrayList<>();
        game.ifPresent(result :: add);
        model.addAttribute("game", result);
        return "gameBlog";
    }

    @GetMapping("/game/create")
    public String addGamePage(Model model){
        model.addAttribute("title", "Add new game");
        return "create";
    }

    @PostMapping("/game/create")
    public String createGame(@RequestParam(value = "name") String name,
                             @RequestParam(value = "description") String description,
                             @RequestParam(value = "img") String img,
                             @RequestParam(value = "price") Double price){
        GameModel game = new GameModel(name, description, img, price);
        gameRepository.save(game);
        return "redirect:/game";
    }
}
