package assigenmet1;

import com.sun.xml.internal.bind.v2.model.core.ID;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Weichen Wang
 * @date 2019/2/18 - 12:18 PM
 * @description: Bordering extends Cities, 可用 id, name
 */
public class Bordering {

    private Countries countries;

    public Bordering() {
    }

    public Bordering(Countries countries) {
        this.countries = countries;
    }

    public Countries getCountries() {
        return countries;
    }

    public Countries setCountries(Countries countries) {
        this.countries = new Countries();
        return countries;

    }
}
