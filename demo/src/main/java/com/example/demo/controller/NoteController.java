package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Note;
import com.example.demo.service.NoteService;

@RestController
@RequestMapping("/notas")
public class NoteController {
	@Autowired
	NoteService noteservice;
	
	@GetMapping("/todas")
	public List<Note> getAll(){
		return noteservice.getAllNotes();
	}
	
	@GetMapping("/{id}")
	public Optional<Note> getNoteById(@PathVariable long id){
		Optional<Note> note = noteservice.getNoteById(id);
		return note;
	}
	
	@PostMapping()
	public Note saveNote(@RequestBody Note note) {
		return noteservice.saveNote(note);
	}
	
	@DeleteMapping("/{id}")
	public void deleteNote(@PathVariable long id) {
		noteservice.deleteNote(id);
	}
	
	@GetMapping("/nome/{name}")
	public ResponseEntity<Note> getNoteByName(@PathVariable String name){
		Optional<Note> note = noteservice.getNoteByName(name);
		return note.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}
	
	@GetMapping("/count")
	public ResponseEntity<Long> getNoteQuantity(){
		long notesQuantity = noteservice.noteQuantity();
		return ResponseEntity.ok(notesQuantity);
	} 
	
}
