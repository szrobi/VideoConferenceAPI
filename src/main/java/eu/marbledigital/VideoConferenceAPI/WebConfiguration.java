package eu.marbledigital.VideoConferenceAPI;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
// ez csak a Spring MVC konfigurációját végzi
public class WebConfiguration extends WebMvcConfigurationSupport {
	@Override
	protected void addArgumentResolvers(
			List<HandlerMethodArgumentResolver> argumentResolvers) {
		super.addArgumentResolvers(argumentResolvers);
		// az ArgumentResolveHandler-ek adják meg, hogy hogyan konvertáljunk
		// webes request-ekből
		// metódus paramétereket (itt pl a Controller index metódusában a
		// Pageable
		argumentResolvers.add(new PageableHandlerMethodArgumentResolver());
	}
}
