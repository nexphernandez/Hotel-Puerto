package org.docencia.hotel.config;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.docencia.hotel.web.soap.impl.GuestSoapServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jakarta.xml.ws.Endpoint;

@Configuration
public class CxfConfig {

    @Bean
    public Endpoint guestEndpoint(Bus bus, GuestSoapServiceImpl impl) {
        EndpointImpl endpoint = new EndpointImpl(bus, impl);
        endpoint.publish("/guest");
        return endpoint;
    }
}
