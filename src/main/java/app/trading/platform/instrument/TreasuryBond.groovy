package app.trading.platform.instrument

import app.trading.platform.instrument.def.Instrument
import app.trading.platform.instrument.def.InstrumentType
import app.trading.platform.instrument.def.Tenor
import groovy.transform.MapConstructor
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@MapConstructor
class TreasuryBond implements Instrument {

    static final Logger LOGGER = LoggerFactory.getLogger(TreasuryBond.class);

    final String name;
    final InstrumentType instrumentType;
    final Tenor tenor;

    @Override
    String getName() {
        return name
    }

    @Override
    InstrumentType getInstrumentType() {
        return instrumentType
    }

    @Override
    Tenor getTenor() {
        return tenor
    }

    @Override
    String toString() {
        return GSON.toJson(this)
    }
}