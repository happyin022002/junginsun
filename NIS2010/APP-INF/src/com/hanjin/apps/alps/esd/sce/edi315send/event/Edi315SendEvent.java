/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : Edi315SendEvent.java
*@FileTitle :Edi315SendEvent
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.01
*@LastModifier : 전병석
*@LastVersion : 1.0
* 2009.11.17 전병석 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.edi315send.event;


import java.util.HashMap;

import com.hanjin.apps.alps.esd.sce.edi315send.vo.Edi315PrefixBkgVvdVO;
import com.hanjin.apps.alps.esd.sce.edi315send.vo.Edi315PrefixIrgInfoVO;
import com.hanjin.apps.alps.esd.sce.edi315send.vo.Edi315PrefixMainVO;
import com.hanjin.apps.alps.esd.sce.edi315send.vo.Edi315SendOptionsVO;
import com.hanjin.apps.alps.esd.sce.edi315send.vo.Edi315SendVO;
import com.hanjin.framework.support.layer.event.EventSupport;
/**
 * ENIS-SCE Business Logic ServiceCommand<br>
 * - ENIS-SCE에 대한 비지니스 트랜잭션을 처리한다.<br>
 * 
 * @author YJLEE
 * @see Edi315SendBCImpl 참조
 * @since J2EE 1.4
 */
public class Edi315SendEvent extends EventSupport{
	private static final long serialVersionUID = 1L;
	private HashMap parameterMap = null;
	String str = null;  
	public Edi315SendEvent(){}
	/**
	 * Edi315SendEvent
	 * @param str_
	 */
	public Edi315SendEvent(String str_){
		str = str_;
	}
	
	/**
     * Evenct Name 을 반환한다.
     * @return "ReceiveEAIEvent"
     */
    public String getEventName() {
        return "Edi315SendEvent";
    }
    /**
     * String Casting 된 Evenct Name 을 반환한다.
     * @return "CreateFlatFileEvent"
     */
    public String toString() {
        return "Edi315SendEvent";
    }
    /** getStr
     * @param 
     * @return String
     */    
	public String getStr() {
		return str;
	}	
   private Edi315PrefixMainVO  edi315SMain = null;
   /** setEdi315SMain setter function 
    * @param edi315SMain Edi315PrefixMainVO 
    * @return 
    */    
   public void setEdi315SMain(Edi315PrefixMainVO edi315SMain){
	   this.edi315SMain = edi315SMain;
   }
   /** getEdi315SMain getter function 
    * @param
    * @return Edi315PrefixMainVO
    */       
   public Edi315PrefixMainVO getEdi315SMain(){
	   return this.edi315SMain;
   }
   
   private Edi315PrefixBkgVvdVO  edi315SBkg = null;
   /** setEdi315SBkg setter function 
    * @param edi315SBkg Edi315PrefixBkgVvdVO 
    * @return 
    */   
   public void setEdi315SBkg(Edi315PrefixBkgVvdVO edi315SBkg){
	   this.edi315SBkg = edi315SBkg;
   }
   /** getEdi315SBkg getter function 
    * @param 
    * @return Edi315PrefixBkgVvdVO
    */      
   public Edi315PrefixBkgVvdVO getEdi315SBkg(){
	   return this.edi315SBkg;
   }
   private Edi315PrefixIrgInfoVO  edi315SIrg = null;
   /** setEdi315SIrg setter function 
    * @param edi315SIrg Edi315PrefixIrgInfoVO 
    * @return 
    */     
   public void setEdi315SIrg(Edi315PrefixIrgInfoVO edi315SIrg){
	   this.edi315SIrg = edi315SIrg;
   }
   /** getEdi315SIrg getter function 
    * @param 
    * @return Edi315PrefixIrgInfoVO
    */    
   public Edi315PrefixIrgInfoVO getEdi315SIrg(){
	   return this.edi315SIrg;
   }   
   private Edi315SendOptionsVO edi315SOpts = null;
   /** setEdi315SOpts setter function 
    * @param edi315SOpts Edi315SendOptionsVO 
    * @return 
    */    
   public void setEdi315SOpts(Edi315SendOptionsVO edi315SOpts){
	   this.edi315SOpts = edi315SOpts;
   }
   /** getEdi315SOpts getter function 
    * @param 
    * @return Edi315SendOptionsVO
    */   
   public Edi315SendOptionsVO getEdi315SOpts(){
	   return this.edi315SOpts;
   }
   private Edi315SendVO edi315SendVo = null;
   /** setEdi315Send setter function 
    * @param edi315SendVo Edi315SendVO 
    * @return 
    */    
   public void setEdi315Send(Edi315SendVO edi315SendVo){
	   this.edi315SendVo = edi315SendVo;
   }
   /** getEdi315Send getter function 
    * @param 
    * @return Edi315SendVO
    */    
   public Edi315SendVO getEdi315Send(){
	   return this.edi315SendVo;
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
