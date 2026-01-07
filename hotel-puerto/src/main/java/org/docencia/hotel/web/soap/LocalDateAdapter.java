package org.docencia.hotel.web.soap;

import java.time.LocalDate;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

public class LocalDateAdapter extends XmlAdapter<String, LocalDate>{

    @Override
    public String marshal(LocalDate fecha) throws Exception {
        return fecha.toString();
    }

    @Override
    public LocalDate unmarshal(String fecha) throws Exception {
        return LocalDate.parse(fecha);
    }

}
