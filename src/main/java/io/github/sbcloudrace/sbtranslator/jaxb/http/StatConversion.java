
package io.github.sbcloudrace.sbtranslator.jaxb.http;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for StatConversion.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="StatConversion">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="FromMillisecondsToMinutes"/>
 *     &lt;enumeration value="FromSecondsToMinutes"/>
 *     &lt;enumeration value="FromCentimetersPerSecondToSpeed"/>
 *     &lt;enumeration value="FromMetersToDistance"/>
 *     &lt;enumeration value="FromNumberToCurrency"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "StatConversion")
@XmlEnum
public enum StatConversion {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("FromMillisecondsToMinutes")
    FROM_MILLISECONDS_TO_MINUTES("FromMillisecondsToMinutes"),
    @XmlEnumValue("FromSecondsToMinutes")
    FROM_SECONDS_TO_MINUTES("FromSecondsToMinutes"),
    @XmlEnumValue("FromCentimetersPerSecondToSpeed")
    FROM_CENTIMETERS_PER_SECOND_TO_SPEED("FromCentimetersPerSecondToSpeed"),
    @XmlEnumValue("FromMetersToDistance")
    FROM_METERS_TO_DISTANCE("FromMetersToDistance"),
    @XmlEnumValue("FromNumberToCurrency")
    FROM_NUMBER_TO_CURRENCY("FromNumberToCurrency");
    private final String value;

    StatConversion(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static StatConversion fromValue(String v) {
        for (StatConversion c: StatConversion.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}