/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ReceivableRentalCostBC.java
*@FileTitle : EQ Receivable Charge Summary By Charge Type
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.17
*@LastModifier : 진준성
*@LastVersion : 1.0
* 2009.08.17 진준성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerrentalcost.receivablerentalcost.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.lse.containerrentalcost.receivablerentalcost.vo.ReceivableChargeVO;
import com.hanjin.apps.alps.ees.lse.containerrentalcost.receivablerentalcost.vo.ReceivableInvoiceCostVO;
import com.hanjin.apps.alps.ees.lse.containerrentalcost.receivablerentalcost.vo.ReceivableInvoiceInquiryVO;
import com.hanjin.apps.alps.ees.lse.containerrentalcost.receivablerentalcost.vo.ReceivableInvoiceVO;
import com.hanjin.apps.alps.ees.lse.containerrentalcost.receivablerentalcost.vo.ReportSearchReceivableVO;
import com.hanjin.apps.alps.ees.lse.containerrentalcost.receivablerentalcost.vo.SearchParamVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.ARInterfaceCreationVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-Containerrentalcost Business Logic Command Interface<br>
 * - ALPS-Containerrentalcost에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Jin Jun Sung
 * @see Ees_lse_0074EventResponse 참조
 * @since J2EE 1.6
 */

public interface ReceivableRentalCostBC {

	/**
	 * Receivable Invoice 한 결과에 대하여 Charge Type별로 실적을 조회<br>
	 *
	 * @param  ReportSearchReceivableVO reportSearchReceivableVO
	 * @return List<ReportSearchReceivableVO>
	 * @exception EventException
	 */
	public List<ReportSearchReceivableVO> searchReceivableRentalReportBasic(ReportSearchReceivableVO reportSearchReceivableVO) throws EventException;

	/**
	 * 입력 월에 대한 Receivable Rental Charge 작업 실행여부를 확인합니다.<br>
	 *
	 * @param  SearchParamVO searchParamVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean isExecuteReceivableRentalChargeBasic(SearchParamVO searchParamVO) throws EventException;

	/**
	 * 입력 월에 대한 Receivable Rental Charge 작업 현황목록을 조회합니다.<br>
	 *
	 * @param  SearchParamVO searchParamVO
	 * @return List<ReceivableChargeVO>
	 * @exception EventException
	 */
	public List<ReceivableChargeVO> searchReceivableRentalChargeListBasic(SearchParamVO searchParamVO) throws EventException;

	/**
	 * 입력 월에 대한 Receivable Rental Preparation 일괄작업을 수행합니다.<br>
	 *
	 * @param SearchParamVO searchParamVO
	 * @param SignOnUserAccount userAccount
	 * @exception EventException
	 */
	public void createReceivableRentalPreparationListBasic(SearchParamVO searchParamVO, SignOnUserAccount userAccount) throws EventException;

	/**
	 * 계약번호별 Receivable Rental Charge Creation 일괄작업을 수행합니다.<br>
	 *
	 * @param ReceivableChargeVO[] receivableChargeVOs
	 * @param SignOnUserAccount userAccount
	 * @exception EventException
	 */
	public void manageReceivableChargeCreationListBasic(ReceivableChargeVO[] receivableChargeVOs, SignOnUserAccount userAccount) throws EventException;

	/**
	 * 계약번호별 Receivable Rental Charge Recreation 일괄작업을 수행합니다.<br>
	 *
	 * @param ReceivableChargeVO[] receivableChargeVOs
	 * @param SignOnUserAccount userAccount
	 * @exception EventException
	 */
	public void manageReceivableChargeRecreationListBasic(ReceivableChargeVO[] receivableChargeVOs, SignOnUserAccount userAccount) throws EventException;

	/**
	 * Receivable Rental Charge Creation 처리된 내역을 조회합니다.<br>
	 *
	 * @param  SearchParamVO searchParamVO
	 * @return List<ReceivableChargeVO>
	 * @exception EventException
	 */
	public List<ReceivableChargeVO> searchReceivableRentalChargeInfoBasic(SearchParamVO searchParamVO) throws EventException;

	/**
	 * 신규 Receivable Rental Invoice Number를 조회합니다.<br>
	 *
	 * @param  String qtyYrmon
	 * @return String
	 * @exception EventException
	 */
	public String searchNewReceivableInvoiceNumberBasic(String qtyYrmon) throws EventException;

	/**
	 * 입력받은 AGMT No.에 대한 Receivable Charge 허용여부를 조회합니다.<br>
	 *
	 * @param  String agmtSeq
	 * @param  String qtyYrmon
	 * @return List<ReceivableChargeVO>
	 * @exception EventException
	 */
	public List<ReceivableChargeVO> searchReceivableAgreementAvailInfoBasic(String agmtSeq, String qtyYrmon) throws EventException;

	/**
	 * Receivable Rental Invoice Summary 내역을 조회합니다.<br>
	 *
	 * @param  SearchParamVO searchParamVO
	 * @return List<ReceivableInvoiceVO>
	 * @exception EventException
	 */
	public List<ReceivableInvoiceVO> searchReceivableInvoiceSummaryListBasic(SearchParamVO searchParamVO) throws EventException;

	/**
	 * Receivable Rental Invoice Amount 정보를 확인합니다.<br>
	 *
	 * @param  SearchParamVO searchParamVO
	 * @return List<ReceivableInvoiceVO>
	 * @exception EventException
	 */
	public List<ReceivableInvoiceVO> searchReceivableInvoiceAmountInfoBasic(SearchParamVO searchParamVO) throws EventException;

	/**
	 * Invoice 정보를 조회하여 Account Receivable I/F 요청자료로 변환한다.<br>
	 *
	 * @param  SearchParamVO searchParamVO
	 * @return List<ARInterfaceCreationVO>
	 * @exception EventException
	 */
	public List<ARInterfaceCreationVO> searchGeneralARInterfaceCreationBasic(SearchParamVO searchParamVO) throws EventException;

	/**
	 * 계약번호별 Receivable Rental Invoice Creation 일괄작업을 수행합니다.<br>
	 *
	 * @param  ReceivableInvoiceVO[] receivableInvoiceVOs
	 * @param  SearchParamVO searchParamVO
	 * @param  SignOnUserAccount userAccount
	 * @exception EventException
	 */
	public void createReceivableInvoiceCreationListBasic(ReceivableInvoiceVO[] receivableInvoiceVOs, SearchParamVO searchParamVO, SignOnUserAccount userAccount) throws EventException;

	/**
	 * 계약번호별 Receivable Rental Invoice Confirm 일괄작업을 수행합니다.<br>
	 *
	 * @param  ReceivableInvoiceVO[] receivableInvoiceVOs
	 * @param  SearchParamVO searchParamVO
	 * @param  SignOnUserAccount userAccount
	 * @exception EventException
	 */
	public void createReceivableInvoiceConfirmListBasic(ReceivableInvoiceVO[] receivableInvoiceVOs, SearchParamVO searchParamVO, SignOnUserAccount userAccount) throws EventException;

	/**
	 * Receivable Rental Invoice Cost 목록을 조회합니다.<br>
	 *
	 * @param  SearchParamVO searchParamVO
	 * @return List<ReceivableInvoiceCostVO>
	 * @exception EventException
	 */
	public List<ReceivableInvoiceCostVO> searchReceivableInvoiceCostListBasic(SearchParamVO searchParamVO) throws EventException;

	/**
	 * Receivable Rental Invoice Cost 내역에 대한 일괄작업을 수행합니다.<br>
	 *
	 * @param ReceivableInvoiceCostVO[] receivableInvoiceCostVOs
	 * @param SignOnUserAccount userAccount
	 * @exception EventException
	 */
	public void manageReceivableInvoiceCostListBasic(ReceivableInvoiceCostVO[] receivableInvoiceCostVOs, SignOnUserAccount userAccount) throws EventException;

	/**
	 * Receivable Rental Invoice Charge I/F 현황을 조회합니다.<br>
	 *
	 * @param SearchParamVO searchParamVO
	 * @return List<ReceivableInvoiceInquiryVO>
	 * @exception EventException
	 */
	public List<ReceivableInvoiceInquiryVO> searchReceivableInvoiceInquiryListBasic(SearchParamVO searchParamVO) throws EventException;

	/**
	 * Invoice Cancel 정보를 조회하여 Account Receivable I/F 요청자료로 변환한다.<br>
	 *
	 * @param  ReceivableInvoiceInquiryVO receivableInvoiceInquiryVO
	 * @return List<ARInterfaceCreationVO>
	 * @exception EventException
	 */
	public List<ARInterfaceCreationVO> searchGeneralARInterfaceCancelBasic(ReceivableInvoiceInquiryVO receivableInvoiceInquiryVO) throws EventException;

	/**
	 * Receivable Rental Invoice Charge I/F 처리내역을 취소합니다.<br>
	 *
	 * @param ReceivableInvoiceInquiryVO receivableInvoiceInquiryVO
	 * @param SignOnUserAccount userAccount
	 * @exception EventException
	 */
	public void cancelReceivableInvoiceInquiryBasic(ReceivableInvoiceInquiryVO receivableInvoiceInquiryVO, SignOnUserAccount userAccount) throws EventException;

}