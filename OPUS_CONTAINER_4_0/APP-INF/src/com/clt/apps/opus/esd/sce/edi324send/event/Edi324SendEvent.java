/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : Edi324SendEvent.java
*@FileTitle :Edi324SendEvent
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.01
*@LastModifier : 전병석
*@LastVersion : 1.0
* 2009.11.17 전병석 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.edi324send.event;

import java.util.HashMap;

import com.clt.apps.opus.esd.sce.edi324send.vo.Edi324SendVO;
import com.clt.framework.support.layer.event.EventSupport;
/**
 * ENIS-SCE Business Logic ServiceCommand<br>
 * - ENIS-SCE에 대한 비지니스 트랜잭션을 처리한다.<br>
 * 
 * @author YJLEE
 * @see Edi324SendBCImpl 참조
 * @since J2EE 1.4
 */
@SuppressWarnings({ "rawtypes" })
public class Edi324SendEvent extends EventSupport{
	private static final long serialVersionUID = 1L;
	private HashMap parameterMap = null;
	String str = null;  
	public Edi324SendEvent(){}
	/**
	 * Edi324SendEvent
	 * @param str_
	 */
	public Edi324SendEvent(String str_){
		str = str_;
	}
	
	/**
     * Evenct Name 을 반환한다.
     * @return "ReceiveEAIEvent"
     */
    public String getEventName() {
        return "Edi324SendEvent";
    }
    /**
     * String Casting 된 Evenct Name 을 반환한다.
     * @return String
     */
    public String toString() {
        return "Edi324SendEvent";
    }
    /** getStr
     * @param 
     * @return String
     */    
	public String getStr() {
		return str;
	}	
    private Edi324SendVO edi324SendVo = null;
   /** setEdi324Send setter function 
    * @param edi324SendVo Edi324SendVO 
    */    
   public void setEdi324Send(Edi324SendVO edi324SendVo){
	   this.edi324SendVo = edi324SendVo;
   }
   /** getEdi324Send getter function 
    * @return Edi324SendVO
    */    
   public Edi324SendVO getEdi324Send(){
	   return this.edi324SendVo;
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
