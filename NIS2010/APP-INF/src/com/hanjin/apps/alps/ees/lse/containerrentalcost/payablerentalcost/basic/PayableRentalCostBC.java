/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PayableRentalCostBC.java
*@FileTitle : EQ Payable Charge Summary
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.25
*@LastModifier : 진준성
*@LastVersion : 1.0
* 2009.08.25 진준성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.vo.PayableRentalCostAuditVO;
import com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.vo.PayableRentalCostVO;
import com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.vo.PayableRentalInvoiceCostVO;
import com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.vo.ReportSearchPayableVO;
import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrRequestAgmtVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.ApPayInvDtlVO;
import com.hanjin.syscommon.common.table.ApPayInvVO;

/**
 * ALPS-Containerrentalcost Business Logic Command Interface<br>
 * - ALPS-Containerrentalcost에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Jin Jun Sung
 * @see Ees_lse_0060EventResponse 참조
 * @since J2EE 1.6
 */

public interface PayableRentalCostBC {

	/**
	 * Payable Invoice 한 결과에 대하여 실적을 조회<br>
	 * 
	 * @param ReportSearchPayableVO reportSearchPayableVO
	 * @return List<ReportSearchPayableVO>
	 * @exception EventException
	 */
	public List<ReportSearchPayableVO> searchPayableRentalReportBasic(ReportSearchPayableVO reportSearchPayableVO) throws EventException;

	/**
	 * Payable Creation Lessor Invoice File Import 신규 저장<br>
	 * 
	 * @param PayableRentalCostVO payableRentalCostVO
	 * @param SignOnUserAccount account
	 * @return String[]
	 * @exception EventException
	 */
	public String[] importPayableLessorInvoiceBasic(PayableRentalCostVO payableRentalCostVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Payable Creation Lessor Invoice File Data 조회<br>
	 * 
	 * @param PayableRentalCostVO payableRentalCostVO
	 * @return PayableRentalCostVO
	 * @exception EventException
	 */
	public PayableRentalCostVO searchPayableLessorInvoiceBasic(PayableRentalCostVO payableRentalCostVO) throws EventException;

	/**
	 * Payable Charge Creation 대상 Agreement를 조회<br>
	 * 
	 * @param String costMonth
	 * @param String lessorNo
	 * @param String lstmCd
	 * @return PayableRentalCostVO
	 * @exception EventException
	 */
	public PayableRentalCostVO searchPayableRentalBasic(String costMonth, String lessorNo, String lstmCd) throws EventException;

	/**
	 * Payable Rental Charge Creation 생성 일괄작업(BackEndJob)을 수행<br>
	 * 
	 * @param PayableRentalCostVO payableRentalCostVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String createPayableRentalChargeBasic(PayableRentalCostVO payableRentalCostVO, SignOnUserAccount account) throws EventException;

	/**
	 * Payable Rental Charge Creation 삭제 일괄작업(BackEndJob)을 수행<br>
	 * 
	 * @param PayableRentalCostVO payableRentalCostVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String removePayableRentalChargeBasic(PayableRentalCostVO payableRentalCostVO, SignOnUserAccount account) throws EventException;

	/**
	 * BackEndJob의 실행결과를 조회<br>
	 * 
	 * @param String key
	 * @return String
	 * @exception EventException
	 */
	public String searchBakEndJobResultBasic(String key) throws EventException;

	/**
	 * Charge Creation 데이터의 Invoice No 를 저장<br>
	 * 
	 * @param PayableRentalCostVO payableRentalCostVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyPayableRentalChargeMasterInvoiceNoBasic(PayableRentalCostVO payableRentalCostVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Payable Charge Audit 할 대상을 조회<br>
	 * 
	 * @param PayableRentalCostVO payableRentalCostVO
	 * @return PayableRentalCostVO
	 * @exception EventException
	 */
	public PayableRentalCostVO searchPayableRentalAuditBasic(PayableRentalCostVO payableRentalCostVO) throws EventException;

	/**
	 * Payable Charge Audit 할 대상을 Back End Job 으로 조회한 결과를 UI에 맞는 VO 배열 형대로 변환합니다.<br>
	 * 
	 * @param List<PayableRentalCostAuditVO> rowSetList
	 * @return PayableRentalCostVO
	 * @exception EventException
	 */
	public PayableRentalCostVO searchPayableRentalAuditBasic(List<PayableRentalCostAuditVO> rowSetList) throws EventException;

	/**
	 * Payable Charge Audit 대상을 Audit 완료로 저장함.<br>
	 * 
	 * @param PayableRentalCostVO payableRentalCostVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createPayableRentalAuditBasic(PayableRentalCostVO payableRentalCostVO, SignOnUserAccount account) throws EventException;

	/**
	 * Payable Charge Audit 대상을 백업하고 Audit 이전으로 저장함.<br>
	 * 
	 * @param PayableRentalCostVO payableRentalCostVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void rejectPayableRentalAuditBasic(PayableRentalCostVO payableRentalCostVO, SignOnUserAccount account) throws EventException;

	/**
	 * Payable Charge Audit 완료 된 Charge Creation 데이터를 선택하여 Invoice 생성을 위한 Data 조회<br>
	 * 
	 * @param PayableRentalCostVO payableRentalCostVO
	 * @return PayableRentalCostVO
	 * @exception EventException
	 */
	public PayableRentalCostVO searchPayableRentalInvoiceCreateBasic(PayableRentalCostVO payableRentalCostVO) throws EventException;
	
	/**
	 * Rental payable invoice 처리에 대한 진행 상황을  조회<br>
	 * 
	 * @param PayableRentalInvoiceCostVO payableRentalInvoiceCostVO
	 * @return List<PayableRentalInvoiceCostVO>
	 * @exception EventException
	 */
	public List<PayableRentalInvoiceCostVO> searchPayableRentalInvoiceBasic( PayableRentalInvoiceCostVO  payableRentalInvoiceCostVo ) throws EventException;

	/**
	 * Operation Lease Payable Invoice Creation Data 조회<br>
	 * 
	 * @param String lessorNo
	 * @param String effectiveDate
	 * @param String expireDate
	 * @return PayableRentalCostVO
	 * @exception EventException
	 */
	public PayableRentalCostVO searchOperatingPayableRentalBasic(String lessorNo, String effectiveDate, String expireDate) throws EventException;

	/**
	 * Operation Lease Payable Invoice Creation Data 조회<br>
	 * 
	 * @param PayableRentalCostVO payableRentalCostVO
	 * @param  SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageOperatingPayableRentalBasic(PayableRentalCostVO payableRentalCostVO, SignOnUserAccount account) throws EventException;

	/**
	 * Payable Rental Invoice Creation : AP 등록을 위한 Master Data Model 생성<br>
	 * 
	 * @param String invNo
	 * @param PayableRentalCostVO payableRentalCostVO
	 * @param SignOnUserAccount account
	 * @return ApPayInvVO
	 * @exception EventException
	 */
	public ApPayInvVO makePayableRentalInvoiceCreateMainBasic(String invNo, PayableRentalCostVO payableRentalCostVO, SignOnUserAccount account) throws EventException;

	/**
	 * Payable Rental Invoice Creation : AP 등록을 위한 Detail Data Model 생성<br>
	 * 
	 * @param String invNo
	 * @param PayableRentalCostVO payableRentalCostVO
	 * @param SignOnUserAccount account
	 * @return ApPayInvDtlVO[]
	 * @exception EventException
	 */
	public ApPayInvDtlVO[] makePayableRentalInvoiceCreateDetailBasic(String invNo, PayableRentalCostVO payableRentalCostVO, SignOnUserAccount account) throws EventException;

	/**
	 * Payable Rental Invoice Creation : AP 등록 후 Register No. Update<br>
	 * 
	 * @param String invNo
	 * @param String invRgstNo
	 * @param PayableRentalCostVO payableRentalCostVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyPayableRentalInvoiceBasic(String invNo, String invRgstNo, PayableRentalCostVO payableRentalCostVO, SignOnUserAccount account) throws EventException;

	/**
	 * Payable Rental Invoice Creation : Invoice Create 생성 일괄작업(BackEndJob) 수행<br>
	 * 
	 * @param PayableRentalCostVO payableRentalCostVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String createPayableRentalInvoiceBasic(PayableRentalCostVO payableRentalCostVO, SignOnUserAccount account) throws EventException;

	/**
	 * Operating Payable Rental Invoice Creation : Invoice Create 생성 일괄작업(BackEndJob) 수행<br>
	 * 
	 * @param PayableRentalCostVO payableRentalCostVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String createOperatingPayableRentalInvoiceBasic(PayableRentalCostVO payableRentalCostVO, SignOnUserAccount account) throws EventException;

	/**
	 * Operating Payable Rental Invoice Creation : AP 등록을 위한 Master Data Model 생성<br>
	 * 
	 * @param String invNo
	 * @param PayableRentalCostVO payableRentalCostVO
	 * @param SignOnUserAccount account
	 * @return ApPayInvVO
	 * @exception EventException
	 */
	public ApPayInvVO makeOperatingPayableRentalInvoiceCreateMainBasic(String invNo, PayableRentalCostVO payableRentalCostVO, SignOnUserAccount account) throws EventException;

	/**
	 * Operating Payable Rental Invoice Creation : AP 등록을 위한 Detail Data Model 생성<br>
	 * 
	 * @param String invNo
	 * @param PayableRentalCostVO payableRentalCostVO
	 * @param SignOnUserAccount account
	 * @return ApPayInvDtlVO[]
	 * @exception EventException
	 */
	public ApPayInvDtlVO[] makeOperatingPayableRentalInvoiceCreateDetailBasic(String invNo, PayableRentalCostVO payableRentalCostVO, SignOnUserAccount account) throws EventException;

	/**
	 * Operating Payable Rental Invoice Creation : AP 등록 후 Register No. Update<br>
	 * 
	 * @param String invNo
	 * @param String invRgstNo
	 * @param PayableRentalCostVO payableRentalCostVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyOperatingPayableRentalInvoiceBasic(String invNo, String invRgstNo, PayableRentalCostVO payableRentalCostVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Payable invoice 를 Cancel 처리함<br>
	 * 
	 * @param PayableRentalInvoiceCostVO[] payableRentalInvoiceCostVOS
	 * @exception EventException
	 */
	public void modifyPayableRentalChargeBasic(PayableRentalInvoiceCostVO[] payableRentalInvoiceCostVOS) throws EventException;
	
	/**
	 * Payable Charge Audit 할 대상을 조회하는 Back End Job 실행.<br>
	 * 
	 * @param PayableRentalCostVO payableRentalCostVO
	 * @param SignOnUserAccount userAccount
	 * @return String
	 * @exception EventException
	 */
	public String searchPayableRentalChargeAuditBackEndBasic(PayableRentalCostVO payableRentalCostVO, SignOnUserAccount userAccount) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * CSR Agreement Info List
	 * @param String csrNo
	 * @return List<ComCsrRequestAgmtVO>
	 */
	public List<ComCsrRequestAgmtVO> printComCsrLseAgmtInfo(String csrNo) throws EventException;
	
	
	/**
	 * 조회 이벤트 처리<br>
	 * CSR Agreement Info List2
	 * @param String csrNo
	 * @return List<ComCsrRequestAgmtVO>
	 */
	public List<ComCsrRequestAgmtVO> printComCsrAgmtInfo2(String csrNo) throws EventException;
}