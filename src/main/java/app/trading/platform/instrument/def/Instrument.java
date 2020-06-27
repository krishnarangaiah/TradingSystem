package app.trading.platform.instrument.def;

import app.core.platform.nut.BaseNut;
import com.google.gson.Gson;

public interface Instrument extends BaseNut {

    Gson GSON = new Gson();

    String getName();

    InstrumentType getInstrumentType();

    Tenor getTenor();

}
