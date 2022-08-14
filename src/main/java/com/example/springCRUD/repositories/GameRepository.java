package com.example.springCRUD.repositories;

import com.example.springCRUD.models.GameModel;
import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository<GameModel, Long> {
}
