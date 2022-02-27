package com.github.kaushiknishant.URLFeederService.repository;

import com.github.kaushiknishant.URLFeederService.entity.URL;
import org.springframework.data.jpa.repository.JpaRepository;

public interface URLRepository extends JpaRepository<URL, String> {

}
