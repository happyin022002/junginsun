/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : PreDispatchSentHistoryBC.java
*@FileTitle : Pre-Dispatch Sent History Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-13
*@LastModifier : kim_sang_geun
*@LastVersion : 1.0
* 2006-12-13 kim_sang_geun
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.workordermanage.predispatchsenthistory.basic;

import java.util.ArrayList;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.syscommon.common.table.BkgPkupNtcPkupNoVO;

/**
 * ESD-TRS Business Logic Command Interface<br>
 * - ESD-TRS에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author kim_sang_geun
 * @see EsdTrs0021EventResponse 참조
 * @since J2EE 1.4
 */
public interface PreDispatchSentHistoryBC  {

	/**
	 * 조회 이벤트 처리<br>
	 * PreDispatchSentHistory화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_021Event
	 * @return EventResponse ESD_TRS_021EventResponse
	 * @exception EventException
	 */
	public EventResponse searchPreDispatchSentHistory(Event e) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * PreDispatchSentHistory화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_021Event
	 * @return EventResponse ESD_TRS_021EventResponse
	 * @exception EventException
	 */
	public EventResponse search01PreDispatchSentHistory(Event e) throws EventException;

	/**
	 * 멀티 이벤트 처리<br>
	 * PreDispatchSentHistory화면에 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_021Event
	 * @return EventResponse ESD_TRS_021EventResponse
	 * @exception EventException
	 */
//	public EventResponse batchPreDispatchSentHistory(Collection models) throws EventException;
	
	/**
	 * 멀티 이벤트 처리<br>
	 * PreDispatchSentHistory화면에 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param faxresponse_array
	 * @param emlresponse_array
	 * @return
	 * @throws EventException
	 */
	public EventResponse updatePreDispatchSentHistory(ArrayList faxresponse_array, ArrayList emlresponse_array) throws EventException;
	
	/**
	 * 조회 <br>
	 * searchPickupNoticeBasicManage 대한 조회<br>
	 * 
	 * @param bkgPkupNtcNoVO
	 * @throws EventException
	 */
	public void searchPickupNoticeBasicManage(ArrayList<BkgPkupNtcPkupNoVO> bkgPkupNtcNoVO) throws EventException;
}