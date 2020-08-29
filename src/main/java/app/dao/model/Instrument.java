package app.dao.model;

import com.google.gson.Gson;

import java.io.Serializable;

public interface Instrument extends Serializable {

    Gson GSON = new Gson();

    String getName();

    InstrumentType getInstrumentType();

    Tenor getTenor();

}
