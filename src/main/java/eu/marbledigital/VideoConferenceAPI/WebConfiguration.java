package eu.marbledigital.VideoConferenceAPI;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;

/**
 * A configuration class for the Spring MVC
 *
 * @author Robert Szabados
 *
 */
@Configuration
public class WebConfiguration extends WebMvcConfigurationSupport {

    /**
     * {@inheritDoc}
     */
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

    /**
     * Creates a message converter for type JSON
     *
     * @return a messageConverter that can read and write JSON
     */
    public MappingJackson2HttpMessageConverter createJacksonMessageConverter() {
        MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();

        ObjectMapper mapper = new ObjectMapper();

        mapper.registerModule(new Hibernate4Module());

        messageConverter.setObjectMapper(mapper);

        return messageConverter;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void configureMessageConverters(
            List<HttpMessageConverter<?>> converters) {
        converters.add(createJacksonMessageConverter());
        super.configureMessageConverters(converters);
    }

}
