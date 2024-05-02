/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EDISetupEvent.java
*@FileTitle : EDISetupEvent 
*Open Issues :
*Change history :
*@LastModifyDate : 2009-09-01
*@LastModifier : yongcheon_shin
*@LastVersion : 1.0
* 2009-09-01 JunbyoungSuk
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.sce.edisetup.event;

import org.apache.xmlbeans.XmlObject;
import com.hanjin.framework.support.layer.event.EventSupport;
/**
 * ReceiveEAI에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Yong-cheon Shin
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EDISetupEvent  extends EventSupport{
	
	private static final long serialVersionUID = 1L;
	public XmlObject xmlObject = null;
	String str = null;  
	/** Constructor
	 * 
	 */
	public EDISetupEvent(){
		
	}
	
	/** Constructor
	 * @param String str_
	 */
	public EDISetupEvent(String str_){
		str = str_;
	}
	/**
     * Evenct Name 을 반환한다.
     * @param 
     * @throws
     * @return "ReceiveEAIEvent" String
     */
    public String getEventName() {
        return "EDISetupEvent";
    }
    /**
     * String Casting 된 Evenct Name 을 반환한다.
     * @param
     * @return "ReceiveEAIEvent"
     * @throws
     */
    public String toString() {
        return "ReceiveEAIEvent";
    }
    /**
     * @param
     * @return String
     * @throws
     */
	public String getStr() {
		return str;
	}
    /**
     * @param xmlObject XmlObject 
     * @return 
     * @throws
     */
	public void setXmlObject(XmlObject xmlObject) {
		this.xmlObject = xmlObject;
	}

	public String massage = null;
    /**
     * @param  
     * @return String 
     * @throws
     */
	public String getMessage() {
		return massage;
	}
    /**
     * @param  massage String 
     * @return 
     * @throws
     */
	public void setMessage(String massage) {
		this.massage = massage;
	}
}
