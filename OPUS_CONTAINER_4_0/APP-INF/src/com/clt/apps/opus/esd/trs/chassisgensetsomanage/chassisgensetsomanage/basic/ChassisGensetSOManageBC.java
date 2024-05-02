/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ChassisGensetSOManageBC.java
*@FileTitle : Service Order - Chassis or Genset
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.trs.chassisgensetsomanage.chassisgensetsomanage.basic;

import java.util.ArrayList;

import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;

/**
 * ESD-TRS Business Logic Command Interface<br>
 *
 * @author 
 * @see EsdTrs0014EventResponse 
 * @since J2EE 1.4
 */
public interface ChassisGensetSOManageBC  {

	/**
	 * Inquiry event process<br>
	 * ChassisGensetSOManage - Inquiry event process<br>
	 * 
	 * @param v
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchTrspSvcOrdList(ArrayList<String> v) throws EventException;
	
	/**
	 * Inquiry event process<br>
	 * ChassisGensetSOManage - Inquiry event process<br>
	 * 
	 * @param e ESD_TRS_014Event
	 * @return EventResponse ESD_TRS_014EventResponse
	 * @exception EventException
	 */
	public EventResponse removeChassisGensetList(Event e) throws EventException;
	
	/**
	 * Inquiry event process<br>
	 * ChassisGensetSOManage - Inquiry event process<br>
	 * 
	 * @param e ESD_TRS_014Event
	 * @return EventResponse ESD_TRS_014EventResponse
	 * @exception EventException
	 */
	public EventResponse searchVendorList(Event e) throws EventException;
	
	/**
	 * Inquiry event process<br>
	 * ChassisGensetSOManage - Inquiry event process<br>
	 * 
	 * @param e ESD_TRS_014Event
	 * @return EventResponse ESD_TRS_014EventResponse
	 * @exception EventException
	 */
	public EventResponse searchVendor(Event e) throws EventException;
	
	/**
	 * Inquiry event process<br>
	 * ChassisGensetSOManage - Inquiry event process<br>
	 * 
	 * @param e ESD_TRS_014Event
	 * @return EventResponse ESD_TRS_014EventResponse
	 * @exception EventException
	 */
	public EventResponse searchVendorChld(Event e) throws EventException;
	
	/**
	 * Inquiry event process<br>
	 * ChassisGensetSOManage - Inquiry event process<br>
	 * 
	 * @param e ESD_TRS_014Event
	 * @return EventResponse ESD_TRS_014EventResponse
	 * @exception EventException
	 */
	public EventResponse searchVendorPrnt(Event e) throws EventException;
	
	/**
	 * Inquiry event process<br>
	 * ChassisGensetSOManage - Inquiry event process<br>
	 * 
	 * @param e ESD_TRS_014Event
	 * @return EventResponse ESD_TRS_014EventResponse
	 * @exception EventException
	 */
	public EventResponse searchChassisCorrectionList(Event e) throws EventException;
	
	/**
	 * Inquiry event process<br>
	 * ChassisGensetSOManage - Inquiry event process<br>
	 * 
	 * @param e ESD_TRS_014Event
	 * @return EventResponse ESD_TRS_014EventResponse
	 * @exception EventException
	 */
	public EventResponse searchGensetCorrectionList(Event e) throws EventException;
	
	/**
	 * Inquiry event process<br>
	 * ChassisGensetSOManage - Inquiry event process<br>
	 * 
	 * @param e ESD_TRS_014Event
	 * @return EventResponse ESD_TRS_014EventResponse
	 * @exception EventException
	 */
	public EventResponse searchImportedChassis(Event e) throws EventException;
	
	/**
	 * Inquiry event process<br>
	 * ChassisGensetSOManage - Inquiry event process<br>
	 * 
	 * @param e ESD_TRS_014Event
	 * @return EventResponse ESD_TRS_014EventResponse
	 * @exception EventException
	 */
	public EventResponse searchImportedGenset(Event e) throws EventException;
	
	/**
	 * Inquiry event process<br>
	 * ChassisGensetSOManage - Inquiry event process<br>
	 * 
	 * @param e ESD_TRS_014Event
	 * @return EventResponse ESD_TRS_014EventResponse
	 * @exception EventException
	 */
	public EventResponse searchChassisSOManage(Event e) throws EventException;
	
	/**
	 * Inquiry event process<br>
	 * ChassisGensetSOManage - Inquiry event process<br>
	 * 
	 * @param e ESD_TRS_014Event
	 * @return EventResponse ESD_TRS_014EventResponse
	 * @exception EventException
	 */
	public EventResponse searchGensetSOManage(Event e) throws EventException;

	/**
	 * Modification event process<br>
	 * ESD_TRS_014<br>
	 * 
	 * @param e ESD_TRS_014Event
	 * @return EventResponse ESD_TRS_014EventResponse
	 * @exception EventException
	 */
	public EventResponse modifyChassisGensetSOManage(Event e) throws EventException;

	/**
	 * Inquiry event process<br>
	 * ChassisGensetSOManage - Inquiry event process<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchChassisGensetSOManageList(Event e) throws EventException;
	
	/**
	 * Inquiry event process<br>
	 * verifyChassisGensetSOManage - Inquiry event process<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse verifyEqNo(Event e) throws EventException;
	
	/**
	 * Inquiry event process<br>
	 * verifyChassisGensetSOManage - Inquiry event process<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse verifyChassisGensetSOManage(Event e) throws EventException;
	
	/**
	 * Inquiry event process<br>
	 * verifyChassisGensetSOManage - Inquiry event process<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public ArrayList<String> addTRS_TRSP_SVC_ORD(Event e) throws EventException;
	
	/**
	 * Inquiry event process<br>
	 * ChassisGensetSOManage - Inquiry event process<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchChassisTpSzCdList(Event e) throws EventException;
	
	/**
	 * Inquiry event process<br>
	 * ChassisGensetSOManage - Inquiry event process<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchGensetTpSzCdList(Event e) throws EventException;
	
	/**
	 * Inquiry event process<br>
	 * ChassisGensetSOManage - Inquiry event process<br>
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchContainerTpSzCdList(Event e) throws EventException;
	
	
}