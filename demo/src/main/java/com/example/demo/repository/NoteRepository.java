package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Note;

public interface NoteRepository extends JpaRepository<Note, Long>{
	Optional<Note> findByName(String name);
}
