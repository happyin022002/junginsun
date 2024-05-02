/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharIODeliveryScheduleBC.java
*@FileTitle : Ship Yard Select ? Pop up
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tchariodeliveryschedule.basic;

import java.util.List;

import com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tchariodeliveryschedule.vo.CondDeliveryScheduleVO;
import com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tchariodeliveryschedule.vo.CustomNewBldSkdVO;
import com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tchariodeliveryschedule.vo.CustomShpYdVO;
import com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tchariodeliveryschedule.vo.SearchDeliveryScheduleListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutfleetmanagement.tchariodeliveryschedule.vo.SearchShipYardNameListVO;
import com.clt.framework.core.layer.event.EventException;

/**
 * OPUS-Timecharterinoutfleetmanagement Business Logic Command Interface<br>
 * - OPUS-Timecharterinoutfleetmanagement Biz Logic Interface<br>
 *
 * @author
 * @see Esm_fms_0082EventResponse 
 * @since J2EE 1.4
 */

	public interface TCharIODeliveryScheduleBC {
		
	/**
	 * Retrieving Ship Yard Name<br>
	 * 
	 * @return List<SearchShipYardNameListVO>
	 * @exception EventException
	 */
	public List<SearchShipYardNameListVO> searchShipYardNameList() throws EventException;
	
	/**
	 * Creating, Modifying, Deleting Ship Yard Name<br>
	 * 
	 * @param customShpYdVOs CustomShpYdVO[]
	 * @param usrid String
	 * @exception EventException
	 */
	public void manageShipYardName(CustomShpYdVO[] customShpYdVOs, String usrid) throws EventException;
	
	/**
	 * Retrieving Vessel planning to be delivered<br>
	 * 
	 * @param condDeliveryScheduleVO CondDeliveryScheduleVO
	 * @return List<SearchDeliveryScheduleListVO>
	 * @exception EventException
	 */
	public List<SearchDeliveryScheduleListVO> searchDeliveryScheduleList(CondDeliveryScheduleVO condDeliveryScheduleVO) throws EventException;
	
	/**
	 * Creating, Modifying, Deleting data of Vessel planning to be delivered<br>
	 * 
	 * @param customNewBldSkdVOs CustomNewBldSkdVO[]
	 * @param usrid String
	 * @exception EventException
	 */
	public void manageDeliverySchedule(CustomNewBldSkdVO[] customNewBldSkdVOs, String usrid) throws EventException;
}