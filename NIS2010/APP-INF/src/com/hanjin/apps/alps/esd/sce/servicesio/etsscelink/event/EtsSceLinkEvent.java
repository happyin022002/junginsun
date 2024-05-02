/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EtsSceLinkEvent.java
*@FileTitle : EtsSceLinkEvent
*Open Issues :
*Change history :
*@LastModifyDate : 2009-12-16
*@LastModifier : 9009633
*@LastVersion : 1.0
* 2009-12-16 9009633
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.sce.servicesio.etsscelink.event;

import java.util.HashMap;

import com.hanjin.apps.alps.esd.sce.edi315send.vo.Edi315SendVO;
import com.hanjin.apps.alps.esd.trs.cydoorsomanage.singletransportationsomanage.vo.SingleTransportationVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * EtsSceLinkRSC 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - EtsSceLinkIWSProxy에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 9009633
 * @see  참조
 * @since J2EE 1.4
 */
public class EtsSceLinkEvent extends EventSupport {
	private static final long serialVersionUID = 1L;
	private HashMap parameterMap = null;
	String str = null;  
	private Edi315SendVO edi315SendVO = null;	
	private SingleTransportationVO singleTransportationVO = null;
	/**
	 * Constructor 
	 */
	public EtsSceLinkEvent(){}
	/**
	 * @param str_ String
	 */
	public EtsSceLinkEvent(String str_){
		str = str_;
	}
	/**
	 * @param edi315SendVO Edi315SendVO
	 */
	public EtsSceLinkEvent(Edi315SendVO edi315SendVO){
		this.edi315SendVO = edi315SendVO;
	}	
	/**
	 * @param singleTransportationVO SingleTransportationVO
	 */
	public EtsSceLinkEvent(SingleTransportationVO singleTransportationVO){
		this.singleTransportationVO = singleTransportationVO;
	}	
	/**
     * Evenct Name 을 반환한다.
     * @return "ReceiveEAIEvent"
     */
    public String getEventName() {
        return "EtsSceLinkEvent";
    }
    /**
     * String Casting 된 Evenct Name 을 반환한다.
     * @return "CreateFlatFileEvent"
     */
    public String toString() {
        return "EtsSceLinkEvent";
    }
    /** getStr
     * @param 
     * @return String
     */    
	public String getStr() {
		return str;
	}	

   /** setEdi315Send setter function 
    * @param edi315SendVo Edi315SendVO 
    * @return 
    */    
   public void setEdi315Send(Edi315SendVO edi315SendVo){
	   this.edi315SendVO = edi315SendVo;
   }
   /** getEdi315Send getter function 
    * @param 
    * @return Edi315SendVO
    */    
   public Edi315SendVO getEdi315Send(){
	   return this.edi315SendVO;
   }
   /** setSingleTransportation setter function 
    * @param singleTransportationVO SingleTransportationVO 
    * @return 
    */ 
   public void setSingleTransportation(SingleTransportationVO singleTransportationVO){
	   this.singleTransportationVO = singleTransportationVO;
   }
   /** getSingleTransportation getter function 
    * @param 
    * @return SingleTransportationVO
    */     
   public SingleTransportationVO getSingleTransportation(){
	   return this.singleTransportationVO;
   }
	/**
	 * @return Returns the parameterMap.
	 */
	public HashMap getParameterMap() {
		return parameterMap;
	}
	
	/** 
    * @param parameterMap
    */
	public void setParameterMap(HashMap parameterMap) {
		this.parameterMap = parameterMap;
	}  
		
}
