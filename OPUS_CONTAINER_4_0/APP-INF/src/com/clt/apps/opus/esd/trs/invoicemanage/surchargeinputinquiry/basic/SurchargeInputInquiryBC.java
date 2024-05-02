/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SurchargeInputInquiryBC.java
*@FileTitle : surcharge, enter / edit / delete screen
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.surchargeinputinquiry.basic;

import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.vo.TrsComScgMgmtTpSzVO;
import com.clt.apps.opus.esd.trs.workordermanage.workorderissue.vo.searchWorkOrderIssueListVO;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;

/**
 * ESD-TRS Business Logic Basic Command implementation<br>
 * - ESD-TRS business logic handling.<br>
 *
 * @author poong_yeon
 * @see EsdTrs0918EventResponse 
 * @since J2EE 1.4
 */
public interface SurchargeInputInquiryBC  {

	/**
	 * Multi-event processing<br>
	 * The multi-event processing ESD_TRS_918 screen<br>
	 * 
	 * @param e ESD_TRS_918Event
	 * @return EventResponse ESD_TRS_918EventResponse
	 * @exception EventException
	 */
//	public EventResponse multiSurchargeInputInquiry(Event e) throws EventException;

	/**
	 * retrieve event handling<br>
	 * SurchargeInputInquiry screen views for event handling<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_918EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTPBIfFlag(Event e) throws EventException;
	
	/**
	 * retrieve event handling<br>
	 * SurchargeInputInquiry screen views for event handling<br>
	 * 
	 * @param e
	 * @param singleVO
	 * @return response ESD_TRS_918EventResponse
	 * @exception EventException
	 * 2014.12.11    Modified by Hyungwook Choi
	 */
	public EventResponse searchSurchargeInputInquiryList(Event e, searchWorkOrderIssueListVO singleVO) throws EventException;

	
	/**
	 * insert processing<br>
	 * Surcharge Temp Table에 insert processing<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_918EventResponse
	 * @exception EventException
	 */
	public EventResponse addTempSurchargeList(Event e) throws EventException;
	
	/**
	 * retrieve event handling<br>
	 * SurchargeInputInquiry screen views for event handling<br>
	 * 
	 * @param e
	 * @return response ESD_TRS_918EventResponse
	 * @exception EventException
	 */
	public EventResponse searchSurchargeCodeNameList(Event e) throws EventException;

}