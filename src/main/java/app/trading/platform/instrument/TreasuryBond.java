package app.trading.platform.instrument;

import app.trading.platform.instrument.def.Instrument;
import app.trading.platform.instrument.def.InstrumentType;
import app.trading.platform.instrument.def.Tenor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TreasuryBond implements Instrument {

    private static final Logger LOGGER = LoggerFactory.getLogger(TreasuryBond.class);

    private final String name;
    private final InstrumentType instrumentType;
    private final Tenor tenor;

    public TreasuryBond(String name, InstrumentType instrumentType, Tenor tenor) {
        this.name = name;
        this.instrumentType = instrumentType;
        this.tenor = tenor;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public InstrumentType getInstrumentType() {
        return null;
    }

    @Override
    public Tenor getTenor() {
        return null;
    }
}
