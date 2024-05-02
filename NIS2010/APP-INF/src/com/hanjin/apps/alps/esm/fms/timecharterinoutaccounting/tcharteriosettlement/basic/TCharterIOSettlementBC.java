/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharterIOSettlementBC.java
*@FileTitle : Owner's Account to Expenses
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.05.25 윤세영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriosettlement.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CondSearchSlipApprovalVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchSlipApprovalListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriosettlement.vo.CondOwnerAccountExpenseVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriosettlement.vo.CondSearchPrepaymentSettleListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriosettlement.vo.CondSearchPrepaymentSettleVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriosettlement.vo.CondSearchPrepaymentSettleVvdVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriosettlement.vo.SearchInvoiceByOwnerAccountSlipVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriosettlement.vo.SearchMultiPrepaymentSettlementInquiryListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriosettlement.vo.SearchOwnerAccountExpenseListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriosettlement.vo.SearchPrepaymentSettleListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriosettlement.vo.SearchPrepaymentSettleVvdAmountByAccountListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriosettlement.vo.SearchPrepaymentSettleVvdAmountVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriosettlement.vo.SearchPrepaymentSettleVvdListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * NIS2010-Timecharterinoutaccounting Business Logic Command Interface<br>
 * - NIS2010-Timecharterinoutaccounting에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Yoon, Seyeong
 * @see Esm_fms_0039EventResponse 참조
 * @since J2EE 1.6
 */

public interface TCharterIOSettlementBC {
	
	/**
	 * Owner's Account Expense List 내용을 조회한다<br>
	 * 
	 * @param condOwnerAccountExpenseVO CondOwnerAccountExpenseVO
	 * @return List<SearchOwnerAccountExpenseListVO>
	 * @exception EventException
	 */
	public List<SearchOwnerAccountExpenseListVO> searchOwnerAccountExpenseList(CondOwnerAccountExpenseVO condOwnerAccountExpenseVO) throws EventException;
	
	/**
	 * Invoice By Owner's Account Slip 내용을 조회한다<br>
	 * 
	 * @param fletCtrtNo String
	 * @return List<SearchInvoiceByOwnerAccountSlipVO>
	 * @exception EventException
	 */

	public List<SearchInvoiceByOwnerAccountSlipVO> searchInvoiceByOwnerAccountSlip(String fletCtrtNo) throws EventException ;

	/**
	 * 미 정리된 선급금 전표를 조회한다<br>
	 * 
	 * @param condSearchPrepaymentSettleVO   CondSearchPrepaymentSettleVO
	 * @param SignOnUserAccount account
	 * @return List<SearchPrepaymentSettleListVO>
	 * @exception EventException
	 */
	public List<SearchPrepaymentSettleListVO> searchPrepaymentSettleList(CondSearchPrepaymentSettleVO condSearchPrepaymentSettleVO, SignOnUserAccount account) throws EventException ;
	
	/**
	 * 조건에 해당하는 모든 미 정리된 선급금 전표를 조회한다<br>
	 * 
	 * @param condSearchPrepaymentSettleListVO   CondSearchPrepaymentSettleListVO
	 * @param SignOnUserAccount account
	 * @return List<SearchPrepaymentSettleListVO>
	 * @exception EventException
	 */
	public List<CondSearchPrepaymentSettleListVO> searchPrepaymentSettleListAll(CondSearchPrepaymentSettleListVO condSearchPrepaymentSettleListVO, SignOnUserAccount account) throws EventException ;
	
	/**
	 * 미 정리된 선급금 전표를 항차별로 분리한다<br>
	 * 
	 * @param condSearchPrepaymentSettleVvdVO CondSearchPrepaymentSettleVvdVO
	 * @return List<SearchPrepaymentSettleVvdListVO>
	 * @exception EventException
	 */
	public List<SearchPrepaymentSettleVvdListVO> searchPrepaymentSettleVvdList(CondSearchPrepaymentSettleVvdVO condSearchPrepaymentSettleVvdVO) throws EventException ;
	
	/**
	 * 미 정리된 선급금 전표에서 계정별 비용 합계를 가져온다 (FMS_INV_DTL)<br>
	 * 
	 * @param condSearchPrepaymentSettleVvdVO CondSearchPrepaymentSettleVvdVO
	 * @return List<SearchPrepaymentSettleVvdAmountVO>
	 * @exception EventException
	 */
	public List<SearchPrepaymentSettleVvdAmountVO> searchPrepaymentSettleVvdAmount(CondSearchPrepaymentSettleVvdVO condSearchPrepaymentSettleVvdVO) throws EventException ;
	
	/**
	 * 미 정리된 선급금 전표를 항차별로 분리한 목록 중 계정별 csr_amt합계를 가져온다<br>
	 * 
	 * @param condSearchPrepaymentSettleVvdVO CondSearchPrepaymentSettleVvdVO
	 * @return List<SearchPrepaymentSettleVvdAmountByAccountListVO>
	 * @exception EventException
	 */
	public List<SearchPrepaymentSettleVvdAmountByAccountListVO> searchPrepaymentSettleVvdAmountByAccount(CondSearchPrepaymentSettleVvdVO condSearchPrepaymentSettleVvdVO) throws EventException ;
	
	/**
	 * Multi Prepayment Settlement 에서 Inquiry 조건에 해당하는 전표 목록을 가져온다<br>
	 * 
	 * @param condSearchPrepaymentSettleListVO CondSearchPrepaymentSettleListVO
	 * @param SignOnUserAccount account
	 * @return List<SearchMultiPrepaymentSettlementInquiryListVO>
	 * @exception EventException
	 */
	public List<SearchMultiPrepaymentSettlementInquiryListVO> searchPrepaymentSettlementInquiryList(CondSearchPrepaymentSettleListVO condSearchPrepaymentSettleListVO, SignOnUserAccount account) throws EventException;
}