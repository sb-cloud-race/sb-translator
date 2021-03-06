
package io.github.sbcloudrace.sbtranslator.jaxb.http;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfLuckyDrawBox complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfLuckyDrawBox">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LuckyDrawBox" type="{}LuckyDrawBox" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfLuckyDrawBox", propOrder = {
    "luckyDrawBox"
})
public class ArrayOfLuckyDrawBox {

    @XmlElement(name = "LuckyDrawBox", nillable = true)
    protected List<LuckyDrawBox> luckyDrawBox;

    /**
     * Gets the value of the luckyDrawBox property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the luckyDrawBox property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLuckyDrawBox().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LuckyDrawBox }
     * 
     * 
     */
    public List<LuckyDrawBox> getLuckyDrawBox() {
        if (luckyDrawBox == null) {
            luckyDrawBox = new ArrayList<LuckyDrawBox>();
        }
        return this.luckyDrawBox;
    }

}
