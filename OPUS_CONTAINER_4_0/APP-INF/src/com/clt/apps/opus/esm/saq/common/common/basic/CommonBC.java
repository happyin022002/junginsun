/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName       : CommonBC.java
 *@FileTitle      : Common
 *Open Issues     :
 *Change history  :
 *@LastModifyDate : 
 *@LastModifier   : 
 *@LastVersion    : 
=========================================================*/

package com.clt.apps.opus.esm.saq.common.common.basic;

import java.util.List;

import com.clt.apps.opus.esm.saq.common.common.vo.QuotaConditionVO;
import com.clt.apps.opus.esm.saq.common.common.vo.ReturnVO;
import com.clt.apps.opus.esm.saq.common.common.vo.SearchMonthlyQuotaAdjustmentVVD0116ListVO;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;

/**
 * Common Business Logic Command Interface<br>
 * 
 * @author
 * @see ComboxEventResponse
 * @since J2EE 1.4
 */

public interface CommonBC {

	// /**
	// *
	// * @param String del
	// * @param Boolean isRepTrade
	// * @return EventResponse
	// * @throws EventException
	// */
	// public EventResponse searchTradeComboList(String del, Boolean isRepTrade) throws EventException;

	// /**
	// *
	// * @param String del
	// * @param Boolean isRepTrade
	// * @param Boolean isAll
	// * @return EventResponse
	// * @throws EventException
	// */
	// public EventResponse searchSubTradeComboList(String del, Boolean isRepTrade, Boolean isAll)
	// throws EventException;

	// /**
	// *
	// * @param String del
	// * @return EventResponse
	// * @throws EventException
	// */
	// public EventResponse searchRLaneComboList(String del) throws EventException;
	//
	// /**
	// *
	// * @param String del
	// * @param Boolean ipc
	// * @return EventResponse
	// * @throws EventException
	// */
	// public EventResponse searchRLaneComboList(String del, Boolean ipc) throws EventException;

	/**
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCommonCodeList(Event e) throws EventException;

	// /**
	// *
	// * @param String method
	// * @param String del
	// * @return EventResponse
	// * @throws EventException
	// */
	// public EventResponse searchCodeList(String method, String del) throws EventException;

	// /**
	// *
	// * @param String method
	// * @param String del
	// * @return EventResponse
	// * @throws EventException
	// */
	// public EventResponse searchCommonCodeList(String method, String del) throws EventException;

	// /**
	// *
	// * @param String del
	// * @return EventResponse
	// * @throws EventException
	// */
	// public EventResponse searchRHQComboList(String del) throws EventException;

	// /**
	// *
	// * @param String module
	// * @param String rhq
	// * @param String del
	// * @return EventResponse
	// * @throws EventException
	// */
	// public EventResponse searchAQComboList(String module, String rhq, String del)
	// throws EventException;
	//
	// /**
	// *
	// * @param String module
	// * @param String rhq
	// * @param String del
	// * @return EventResponse
	// * @throws EventException
	// */
	// public EventResponse searchRgnOfcComboList(String module, String rhq, String del)
	// throws EventException;

	// /**
	// *
	// * @param String ofc
	// * @param String del
	// * @return EventResponse
	// * @throws EventException
	// */
	// public EventResponse searchTargetGroupComboList(String ofc, String del) throws EventException;

	// /**
	// *
	// * @param String del
	// * @return EventResponse
	// * @throws EventException
	// */
	// public EventResponse searchKAMerComboList(String del) throws EventException;

	/**
	 * 
	 * @param Event e
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyQuotaTradeRemarkList(Event e) throws EventException;

	/**
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse addMonthlyQuotaTradeRemark(Event e) throws EventException;

	/**
	 * 
	 * @param Event e
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyQuotaRHQRemarkList(Event e) throws EventException;

	/**
	 * 
	 * @param Event e
	 * @return ReturnVO
	 * @exception EventException
	 */
	public ReturnVO searchMonthlyQuotaSlsRHQRemarkList(Event e) throws EventException;

	/**
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse addMonthlyQuotaRHQRemark(Event e) throws EventException;

	/**
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse addMonthlyQuotaSlsRHQRemark(Event e) throws EventException;

	/**
	 * 
	 * @param QuotaConditionVO quotaConditionVO
	 * @return List<SearchMonthlyQuotaAdjustmentVVD0116ListVO>
	 * @exception EventException
	 */
	public List<SearchMonthlyQuotaAdjustmentVVD0116ListVO> searchMonthlyQuotaAdjustmentVVD0116List(QuotaConditionVO quotaConditionVO) throws EventException;

}