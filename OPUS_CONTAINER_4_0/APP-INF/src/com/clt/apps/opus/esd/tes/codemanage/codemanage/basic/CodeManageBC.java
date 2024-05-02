/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CodeManageBC.java
*@FileTitle : Cost Code Creation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.tes.codemanage.codemanage.basic;

import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;

/**
 * ESD Business Logic Command Interface<br>
 *
 * @author jongbaemoon
 * @see ESD_TES_027EventResponse 
 * @see ESD_TES_028EventResponse  
 * @since J2EE 1.4
 */
public interface CodeManageBC  {

	/**
	 * List retrieve event process
	 * CodeManage  retrieve event process
	 * 
	 * @param Event e
	 * @return EventResponse 
	 * @exception EventException
	 */
	public EventResponse searchCostCode(Event e) throws EventException;
	
	/**
	 * List retrieve event process
	 * CodeManage retrieve event process
	 * 
	 * @param e Event
	 * @return EventResponse 
	 * @exception EventException
	 */
	public EventResponse createCostCode(Event e) throws EventException;
	
	/**
	 * List retrieve event process
	 * CodeManage retrieve event process
	 * 
	 * @param Event e
	 * @return EventResponse 
	 * @exception EventException
	 */
	public EventResponse modifyCostCode(Event e) throws EventException;
	
	/**
	 * List retrieve event process
	 * CodeManage retrieve event process
	 * 
	 * @param e Event
	 * @return EventResponse 
	 * @exception EventException
	 */
	public EventResponse modifyCostCodeDelete(Event e) throws EventException;	

	/**
	 * retrieve event process
	 * ESD_TES_027 Add Event Process<br>
	 * 
	 * @param e Event
	 * @return EventResponse 
	 * @exception EventException
	 */
	public EventResponse searchCostCodeInfo(Event e) throws EventException;
	
	/**
	 * User Info retrieve event process
	 * ESD_TES_027 Add Event Process<br>
	 * 
	 * @param e ESD_TES_027Event
	 * @return EventResponse ESD_TES_027EventResponse
	 * @exception EventException
	 */
//	public EventResponse checkMandatory(Event e) throws EventException;	
	
	/**
	 * User Info retrieve event process
	 * ESD_TES_027 Add Event Process<br>
	 * 
	 * @param e ESD_TES_027Event
	 * @return EventResponse ESD_TES_027EventResponse
	 * @exception EventException
	 */
//	public EventResponse checkAgreementPassWord(Event e) throws EventException;		
		
	/**
	 * Add Update Delete Event Process<br>
	 * ESD_TES_028 Add Update Delete Event Process<br>
	 * 
	 * @param e Event
	 * @return EventResponse 
	 * @exception EventException
	 */	
	public EventResponse searchCostcdOption(Event e) throws EventException;

	/**
	 * Acct Code  retrieve event process
	 * ESD_TES_0027Event  retrieve event process
	 * 
	 * @return EventResponse 
	 * @exception EventException
	 */	
	public EventResponse searchAcctCodeList() throws EventException;	
	
	/**
	 * Carrier Code  retrieve event process
	 * ESD_TES_031  retrieve event process
	 * 
	 * @param e Event
	 * @return EventResponse 
	 * @exception EventException
	 */	
    public EventResponse searchCarrierCode(Event e) throws EventException;
    
    /**
	 * Terminal SO Cost Code retrieve event process<br>
	 * ESD_TES_0035 retrieve event process<br>
	 * 
	 * @param e Event
	 * @return EventResponse 
	 * @exception EventException
	 */	
    public EventResponse searchTmnlSoCostCode(Event e) throws EventException;
    
    /**
	 * Terminal Agreement Cost Code retrieve event process<br>
	 * ESD_TES_0036 retrieve event process<br>
	 * 
	 * @param e Event
	 * @return EventResponse 
	 * @exception EventException
	 */	
    public EventResponse searchTmnlAgmtCostCode(Event e) throws EventException;
      
    /**
	 * Terminal Agreement Verify Method retrieve event process<br>
	 * ESD_TES_0037 retrieve event process<br>
	 * 
	 * @param e Event
	 * @return EventResponse 
	 * @exception EventException
	 */	
    public EventResponse searchTmnlAgmtVrfyMzdCode(Event e) throws EventException;
  
//	/**
//	 * Add Update Delete Event Process<br>
//	 * ESD_TES_031 Add Update Delete Event Process<br>
//	 * 
//	 * @param e ESD_TES_031Event
//	 * @return EventResponse ESD_TES_031EventResponse
//	 * @exception EventException
//	 */
//    public EventResponse multiCarrierCode(Event e) throws EventException;	
}