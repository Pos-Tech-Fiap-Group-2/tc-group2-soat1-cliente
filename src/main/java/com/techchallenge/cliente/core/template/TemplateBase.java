package com.techchallenge.cliente.core.template;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;


public abstract class TemplateBase<T> {
	
	@Autowired
	private Configuration freemarkerConfig;
	
	protected abstract String getBasePath();
	
	protected abstract Map<String, Object> getVariaveis(T value);
	
	protected abstract String getFileName(T value);
	
	@PostConstruct
	private void init() throws IOException, URISyntaxException {
		URL url = this.getClass().getResource(getBasePath());
		freemarkerConfig.setDirectoryForTemplateLoading(new File(url.toURI()));
	}
	
	public String processarTemplate(T value) {
			
			try {
				Template template = freemarkerConfig.getTemplate(getFileName(value));
				return FreeMarkerTemplateUtils.processTemplateIntoString(template, getVariaveis(value));
			} catch (IOException | TemplateException e) {
				e.printStackTrace();
			}
			
			return null;
	}
}
