package dev.java10x.CadastroDeNinjas.repository;

import dev.java10x.CadastroDeNinjas.entities.NinjaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NinjaRepository extends JpaRepository<NinjaModel, Long> {
}
