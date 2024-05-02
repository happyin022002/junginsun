/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharterIOSettlementBC.java
*@FileTitle : Owner's Account to Expenses
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriosettlement.basic;

import java.util.List;

import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriosettlement.vo.CondSearchPrepaymentSettleVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriosettlement.vo.CondSearchPrepaymentSettleVvdVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriosettlement.vo.SearchPrepaymentSettleListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriosettlement.vo.SearchPrepaymentSettleVvdListVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-Timecharterinoutaccounting Business Logic Command Interface<br>
 * - OPUS-Timecharterinoutaccounting Biz Logic Interface<br>
 *
 * @author 
 * @see Esm_fms_0039EventResponse 
 * @since J2EE 1.6
 */

public interface TCharterIOSettlementBC {
	
	/**
	 * Retrieving unsorted Prepayment Slip<br>
	 * 
	 * @param condSearchPrepaymentSettleVO CondSearchPrepaymentSettleVO
	 * @param account SignOnUserAccount
	 * @return List<SearchPrepaymentSettleListVO>
	 * @throws EventException
	 */
	public List<SearchPrepaymentSettleListVO> searchPrepaymentSettleList(CondSearchPrepaymentSettleVO condSearchPrepaymentSettleVO, SignOnUserAccount account) throws EventException ;
	
	/**
	 * Separating unsorted Prepayment Slip by Voyage<br>
	 * 
	 * @param condSearchPrepaymentSettleVvdVO CondSearchPrepaymentSettleVvdVO
	 * @return List<SearchPrepaymentSettleVvdListVO>
	 * @throws EventException
	 */
	public List<SearchPrepaymentSettleVvdListVO> searchPrepaymentSettleVvdList(CondSearchPrepaymentSettleVvdVO condSearchPrepaymentSettleVvdVO) throws EventException ;
}