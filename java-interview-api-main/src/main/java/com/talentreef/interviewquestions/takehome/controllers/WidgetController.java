package com.talentreef.interviewquestions.takehome.controllers;

import com.talentreef.interviewquestions.takehome.models.Widget;
import com.talentreef.interviewquestions.takehome.services.WidgetService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000") // Temporary fix - allow frontend to call backend -> We can add Spring Boot config Class
@Slf4j
@RestController
@Validated
@RequestMapping(value = "/v1/widgets", produces = MediaType.APPLICATION_JSON_VALUE)
public class WidgetController {

	private final WidgetService widgetService;

	public WidgetController(WidgetService widgetService) {
		Assert.notNull(widgetService, "widgetService must not be null");
		this.widgetService = widgetService;
	}

	@GetMapping
	public ResponseEntity<List<Widget>> getAllWidgets() {
		return ResponseEntity.ok(widgetService.getAllWidgets());
	}

	@PostMapping
	public ResponseEntity<Void> addWidget(@Valid @RequestBody Widget widget) {
		widgetService.addWidget(widget);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@PutMapping
	public ResponseEntity<Void> updateWidget(@Valid @RequestBody Widget widget) {
		widgetService.updateWidget(widget);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping
	public List<Widget> deleteWidget(@RequestParam String widget) {
		return widgetService.deleteWidget(widget);
	}
}
