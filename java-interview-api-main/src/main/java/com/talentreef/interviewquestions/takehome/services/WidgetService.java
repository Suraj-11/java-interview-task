package com.talentreef.interviewquestions.takehome.services;

import com.talentreef.interviewquestions.takehome.models.Widget;
import com.talentreef.interviewquestions.takehome.respositories.WidgetRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Slf4j
@Service
public class WidgetService {

	private final WidgetRepository widgetRepository;

	private WidgetService(WidgetRepository widgetRepository) {
		Assert.notNull(widgetRepository, "widgetRepository must not be null");
		this.widgetRepository = widgetRepository;
	}

	public List<Widget> getAllWidgets() {
		return widgetRepository.findAll();
	}

	public void addWidget(Widget widget) {
		widgetRepository.save(widget);
	}

	public void updateWidget(Widget widget) {
		widgetRepository.save(widget);
	}

	public List<Widget> deleteWidget(String widget) {
		return widgetRepository.deleteById(widget);
	}

}
