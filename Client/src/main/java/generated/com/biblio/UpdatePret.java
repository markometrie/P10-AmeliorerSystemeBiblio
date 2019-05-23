
package com.biblio;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour updatePret complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="updatePret">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dureepret" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="prolonger" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="cloturationpret" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="refpret" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updatePret", propOrder = {
    "dureepret",
    "prolonger",
    "cloturationpret",
    "refpret"
})
public class UpdatePret {

    protected String dureepret;
    protected boolean prolonger;
    protected boolean cloturationpret;
    protected int refpret;

    /**
     * Obtient la valeur de la propriété dureepret.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDureepret() {
        return dureepret;
    }

    /**
     * Définit la valeur de la propriété dureepret.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDureepret(String value) {
        this.dureepret = value;
    }

    /**
     * Obtient la valeur de la propriété prolonger.
     * 
     */
    public boolean isProlonger() {
        return prolonger;
    }

    /**
     * Définit la valeur de la propriété prolonger.
     * 
     */
    public void setProlonger(boolean value) {
        this.prolonger = value;
    }

    /**
     * Obtient la valeur de la propriété cloturationpret.
     * 
     */
    public boolean isCloturationpret() {
        return cloturationpret;
    }

    /**
     * Définit la valeur de la propriété cloturationpret.
     * 
     */
    public void setCloturationpret(boolean value) {
        this.cloturationpret = value;
    }

    /**
     * Obtient la valeur de la propriété refpret.
     * 
     */
    public int getRefpret() {
        return refpret;
    }

    /**
     * Définit la valeur de la propriété refpret.
     * 
     */
    public void setRefpret(int value) {
        this.refpret = value;
    }

}
