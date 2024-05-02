/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : OtherSOManageBC.java
 *@FileTitle : Other SO creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0

=========================================================*/
package com.clt.apps.opus.esd.trs.othersomanage.othersomanage.basic;

import java.util.List;

import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;

/**
 * ESD-OtherSOManage Business Logic Command Interface<br>
 * An interface to the business logic for OtherSOManage<br>
 * 
 * @author
 * @see Refer to EsdTrs0018EventResponse
 * @since
 */
public interface OtherSOManageBC {

	/**
	 * retrieve event process<br>
	 * OtherSOManage retrieve event process<br>
	 * 
	 * @param v
	 * @return EventResponse ESD_TRS_018EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTrspSvcOrdList(List<String> v) throws EventException;

	/**
	 * retrieve event process<br>
	 * OtherSOManage retrieve event process<br>
	 * 
	 * @param e ESD_TRS_018Event
	 * @return EventResponse ESD_TRS_018EventResponse
	 * @exception EventException
	 */
	public EventResponse searchContainerEqNo(Event e) throws EventException;

	/**
	 * retrieve event process<br>
	 * ESD_TRS_018 retrieve event process<br>
	 * 
	 * @param e ESD_TRS_018Event
	 * @return EventResponse ESD_TRS_018EventResponse
	 * @exception EventException
	 */
	public EventResponse searchGensetEqNo(Event e) throws EventException;

	/**
	 * retrieve event process<br>
	 * ESD_TRS_018 adding event process<br>
	 * 
	 * @param e ESD_TRS_018Event
	 * @return EventResponse ESD_TRS_018EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOtherSOCorrectionList(Event e) throws EventException;

	/**
	 * Rate Apply process<br>
	 * ESD_TRS_018 adding event process<br>
	 * 
	 * @param e ESD_TRS_018Event
	 * @return EventResponse ESD_TRS_018EventResponse
	 * @exception EventException
	 */
	public EventResponse searchRateApplyList(Event e) throws EventException;

	/**
	 * retrieve event process<br>
	 * ESD_TRS_018 retrieve event process<br>
	 * 
	 * @param e ESD_TRS_018Event
	 * @return EventResponse ESD_TRS_018EventResponse
	 * @exception EventException
	 */
	public EventResponse searchChassisEqNo(Event e) throws EventException;

	/**
	 * adding event process<br>
	 * ESD_TRS_018 adding event process<br>
	 * 
	 * @param e ESD_TRS_018Event
	 * @return EventResponse ESD_TRS_018EventResponse
	 * @exception EventException
	 */
	public List<String> addOtherSOManage(Event e) throws EventException;

	/**
	 * modify event process<br>
	 * ESD_TRS_018 modify event process<br>
	 * 
	 * @param e ESD_TRS_018Event
	 * @return EventResponse ESD_TRS_018EventResponse
	 * @exception EventException
	 */
	public EventResponse modifyOtherSOManage(Event e) throws EventException;

	/**
	 * delete event process<br>
	 * ESD_TRS_018 delete event process<br>
	 * 
	 * @param e ESD_TRS_018Event
	 * @return EventResponse ESD_TRS_018EventResponse
	 * @exception EventException
	 */
	public EventResponse removeOtherSOManage(Event e) throws EventException;

}