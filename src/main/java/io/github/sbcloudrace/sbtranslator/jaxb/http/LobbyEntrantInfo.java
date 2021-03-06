
package io.github.sbcloudrace.sbtranslator.jaxb.http;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LobbyEntrantInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LobbyEntrantInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GridIndex" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Heat" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="Level" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="PersonaId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="State" type="{}LobbyEntrantState"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LobbyEntrantInfo", propOrder = {
    "gridIndex",
    "heat",
    "level",
    "personaId",
    "state"
})
@XmlSeeAlso({
    LobbyEntrantAdded.class
})
public class LobbyEntrantInfo {

    @XmlElement(name = "GridIndex")
    protected int gridIndex;
    @XmlElement(name = "Heat")
    protected float heat;
    @XmlElement(name = "Level")
    protected int level;
    @XmlElement(name = "PersonaId")
    protected long personaId;
    @XmlElement(name = "State", required = true)
    @XmlSchemaType(name = "string")
    protected LobbyEntrantState state;

    /**
     * Gets the value of the gridIndex property.
     * 
     */
    public int getGridIndex() {
        return gridIndex;
    }

    /**
     * Sets the value of the gridIndex property.
     * 
     */
    public void setGridIndex(int value) {
        this.gridIndex = value;
    }

    /**
     * Gets the value of the heat property.
     * 
     */
    public float getHeat() {
        return heat;
    }

    /**
     * Sets the value of the heat property.
     * 
     */
    public void setHeat(float value) {
        this.heat = value;
    }

    /**
     * Gets the value of the level property.
     * 
     */
    public int getLevel() {
        return level;
    }

    /**
     * Sets the value of the level property.
     * 
     */
    public void setLevel(int value) {
        this.level = value;
    }

    /**
     * Gets the value of the personaId property.
     * 
     */
    public long getPersonaId() {
        return personaId;
    }

    /**
     * Sets the value of the personaId property.
     * 
     */
    public void setPersonaId(long value) {
        this.personaId = value;
    }

    /**
     * Gets the value of the state property.
     * 
     * @return
     *     possible object is
     *     {@link LobbyEntrantState }
     *     
     */
    public LobbyEntrantState getState() {
        return state;
    }

    /**
     * Sets the value of the state property.
     * 
     * @param value
     *     allowed object is
     *     {@link LobbyEntrantState }
     *     
     */
    public void setState(LobbyEntrantState value) {
        this.state = value;
    }

}
