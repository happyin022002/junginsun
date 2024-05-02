/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : WebDoLinkEvent.java
*@FileTitle : WebDoLinkEvent
*Open Issues :
*Change history :
*@LastModifyDate : 2011-10-20
*@LastModifier : Kwon Min
*@LastVersion : 1.0
* 2011-10-20 Kwon Min
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.webdo.event;

import java.util.HashMap;

import com.hanjin.apps.alps.ees.dmt.dmtclosing.webdo.vo.IfSchemaVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * WebDoLinkRSC 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - WebDoLinkIWSProxy에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author	Kwon Min
 * @see		참조
 * @since	J2EE 1.4
 */
public class WebDoLinkEvent extends EventSupport {
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unchecked")
	private HashMap parameterMap = null;
	String str = null;  
	private IfSchemaVO ifSchemaVO = null;
	/**
	 * Constructor 
	 */
	public WebDoLinkEvent(){}
	/**
	 * @param str_ String
	 */
	public WebDoLinkEvent(String str_){
		str = str_;
	}
	
	/**
	 * @param ifSchemaVO IfSchemaVO
	 */
	public WebDoLinkEvent(IfSchemaVO ifSchemaVO){
		this.ifSchemaVO = ifSchemaVO;
	}	
	/**
     * Evenct Name 을 반환한다.
     * @return "ReceiveEAIEvent"
     */
    public String getEventName() {
        return "WebDoLinkEvent";
    }
    /**
     * String Casting 된 Evenct Name 을 반환한다.
     * @return "CreateFlatFileEvent"
     */
    public String toString() {
        return "WebDoLinkEvent";
    }
    /** getStr
     * @param 
     * @return String
     */    
	public String getStr() {
		return str;
	}	

   /** setIfSchema setter function 
    * @param ifSchemaVO IfSchemaVO 
    * @return 
    */ 
   public void setIfSchema(IfSchemaVO ifSchemaVO){
	   this.ifSchemaVO = ifSchemaVO;
   }
   /** getIfSchema getter function 
    * @param 
    * @return IfSchemaVO
    */     
   public IfSchemaVO getIfSchema(){
	   return this.ifSchemaVO;
   }
	/**
	 * @return Returns the parameterMap.
	 */
	@SuppressWarnings("unchecked")
	public HashMap getParameterMap() {
		return parameterMap;
	}
	
	/** 
    * @param parameterMap
    */
	@SuppressWarnings("unchecked")
	public void setParameterMap(HashMap parameterMap) {
		this.parameterMap = parameterMap;
	}  
		
}
