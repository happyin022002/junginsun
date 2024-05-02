/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PayableRentalCostBC.java
*@FileTitle : EQ Payable Charge Summary
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.lse.containerrentalcost.payablerentalcost.basic;

import java.util.List;

import com.clt.apps.opus.ees.lse.containerrentalcost.payablerentalcost.vo.PayableRentalCostAuditVO;
import com.clt.apps.opus.ees.lse.containerrentalcost.payablerentalcost.vo.PayableRentalCostVO;
import com.clt.apps.opus.ees.lse.containerrentalcost.payablerentalcost.vo.PayableRentalInvoiceCostVO;
import com.clt.apps.opus.ees.lse.containerrentalcost.payablerentalcost.vo.ReportSearchPayableVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.ApPayInvDtlVO;
import com.clt.syscommon.common.table.ApPayInvVO;

/**
 * Containerrentalcost Business Logic Command Interface<br>
 *
 * @author 
 * @see Ees_lse_0060EventResponse
 * @since J2EE 1.6
 */

public interface PayableRentalCostBC {

	/**
	 * retrieving for Payable Invoice<br>
	 * 
	 * @param ReportSearchPayableVO reportSearchPayableVO
	 * @return List<ReportSearchPayableVO>
	 * @exception EventException
	 */
	public List<ReportSearchPayableVO> searchPayableRentalReportBasic(ReportSearchPayableVO reportSearchPayableVO) throws EventException;

	/**
	 * saving Payable Rental Lessor Invoice File import<br>
	 * 
	 * @param PayableRentalCostVO payableRentalCostVO
	 * @param SignOnUserAccount account
	 * @return String[]
	 * @exception EventException
	 */
	public String[] importPayableLessorInvoiceBasic(PayableRentalCostVO payableRentalCostVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * retrieving for Payable Rental Lessor Invoice File import<br>
	 * 
	 * @param PayableRentalCostVO payableRentalCostVO
	 * @return PayableRentalCostVO
	 * @exception EventException
	 */
	public PayableRentalCostVO searchPayableLessorInvoiceBasic(PayableRentalCostVO payableRentalCostVO) throws EventException;

	/**
	 * retrieving for Payable Charge Creation target Agreement<br>
	 * 
	 * @param String costMonth
	 * @param String lessorNo
	 * @param String lstmCd
	 * @param String lsePayTpCd
	 * @return PayableRentalCostVO
	 * @exception EventException
	 */
	public PayableRentalCostVO searchPayableRentalBasic(String costMonth, String lessorNo, String lstmCd, String lsePayTpCd) throws EventException;

	/**
	 * creating Payable Rental Charge Creation(BackEndJob)<br>
	 * 
	 * @param PayableRentalCostVO payableRentalCostVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String createPayableRentalChargeBasic(PayableRentalCostVO payableRentalCostVO, SignOnUserAccount account) throws EventException;

	/**
	 * retrieving for Payable Rental Charge Creation (BackEndJob))<br>
	 * 
	 * @param PayableRentalCostVO payableRentalCostVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String removePayableRentalChargeBasic(PayableRentalCostVO payableRentalCostVO, SignOnUserAccount account) throws EventException;

	/**
	 * retrieving for BackEndJob result<br>
	 * 
	 * @param String key
	 * @return String
	 * @exception EventException
	 */
	public String searchBakEndJobResultBasic(String key) throws EventException;

	/**
	 * saving Invoice No of Charge Creation data<br>
	 * 
	 * @param PayableRentalCostVO payableRentalCostVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyPayableRentalChargeMasterInvoiceNoBasic(PayableRentalCostVO payableRentalCostVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * retrieving for Payable Charge Audit<br>
	 * 
	 * @param PayableRentalCostVO payableRentalCostVO
	 * @return PayableRentalCostVO
	 * @exception EventException
	 */
	public PayableRentalCostVO searchPayableRentalAuditBasic(PayableRentalCostVO payableRentalCostVO) throws EventException;

	/**
	 * loading BackEndJob result file.<br>
	 * 
	 * @param List<PayableRentalCostAuditVO> rowSetList
	 * @return PayableRentalCostVO
	 * @exception EventException
	 */
	public PayableRentalCostVO searchPayableRentalAuditBasic(List<PayableRentalCostAuditVO> rowSetList) throws EventException;

	/**
	 * saving Payable Charge Audit to Audit complete<br>
	 * 
	 * @param PayableRentalCostVO payableRentalCostVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createPayableRentalAuditBasic(PayableRentalCostVO payableRentalCostVO, SignOnUserAccount account) throws EventException;

	/**
	 * back up Payable Charge Audit<br>
	 * 
	 * @param PayableRentalCostVO payableRentalCostVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void rejectPayableRentalAuditBasic(PayableRentalCostVO payableRentalCostVO, SignOnUserAccount account) throws EventException;

	/**
	 * retrieving for Audit complete Charge Creation data<br>
	 * 
	 * @param PayableRentalCostVO payableRentalCostVO
	 * @return PayableRentalCostVO
	 * @exception EventException
	 */
	public PayableRentalCostVO searchPayableRentalInvoiceCreateBasic(PayableRentalCostVO payableRentalCostVO) throws EventException;
	
	/**
	 * retrieving for Rental payable invoice<br>
	 * 
	 * @param PayableRentalInvoiceCostVO payableRentalInvoiceCostVO
	 * @return List<PayableRentalInvoiceCostVO>
	 * @exception EventException
	 */
	public List<PayableRentalInvoiceCostVO> searchPayableRentalInvoiceBasic( PayableRentalInvoiceCostVO  payableRentalInvoiceCostVo ) throws EventException;

	/**
	 * etrieving for Operation lease Invoice Creation<br>
	 * 
	 * @param String lessorNo
	 * @param String effectiveDate
	 * @param String expireDate
	 * @param String agmtSeq
	 * @return PayableRentalCostVO
	 * @exception EventException
	 */
	public PayableRentalCostVO searchOperatingPayableRentalBasic(String lessorNo, String effectiveDate, String expireDate, String agmtSeq) throws EventException;

	/**
	 * saving Operation lease Invoice Creation<br>
	 * 
	 * @param PayableRentalCostVO payableRentalCostVO
	 * @param  SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageOperatingPayableRentalBasic(PayableRentalCostVO payableRentalCostVO, SignOnUserAccount account) throws EventException;

	/**
	 * Payable Rental Invoice Creation : creating Master Data Model for regstering AP<br>
	 * 
	 * @param String invNo
	 * @param PayableRentalCostVO payableRentalCostVO
	 * @param SignOnUserAccount account
	 * @return ApPayInvVO
	 * @exception EventException
	 */
	public ApPayInvVO makePayableRentalInvoiceCreateMainBasic(String invNo, PayableRentalCostVO payableRentalCostVO, SignOnUserAccount account) throws EventException;

	/**
	 * Payable Rental Invoice Creation : creating Detail Data Model for regstering AP<br>
	 * 
	 * @param String invNo
	 * @param PayableRentalCostVO payableRentalCostVO
	 * @param SignOnUserAccount account
	 * @return ApPayInvDtlVO[]
	 * @exception EventException
	 */
	public ApPayInvDtlVO[] makePayableRentalInvoiceCreateDetailBasic(String invNo, PayableRentalCostVO payableRentalCostVO, SignOnUserAccount account) throws EventException;

	/**
	 * Payable Rental Invoice Creation : updating Register No. after registering AP<br>
	 * 
	 * @param String invNo
	 * @param String invRgstNo
	 * @param PayableRentalCostVO payableRentalCostVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyPayableRentalInvoiceBasic(String invNo, String invRgstNo, PayableRentalCostVO payableRentalCostVO, SignOnUserAccount account) throws EventException;

	/**
	 * Payable Rental Invoice Creation : sanving Invoice Creation Data on CSR Temp Table(BackEndJob)<br>
	 * 
	 * @param PayableRentalCostVO payableRentalCostVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String createPayableRentalInvoiceBasic(PayableRentalCostVO payableRentalCostVO, SignOnUserAccount account) throws EventException;

	/**
	 * Operating Payable Rental Invoice Creation : creating Invoice Creation Data on CSR Temp Table<(BackEndJob)<br>
	 * 
	 * @param PayableRentalCostVO payableRentalCostVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String createOperatingPayableRentalInvoiceBasic(PayableRentalCostVO payableRentalCostVO, SignOnUserAccount account) throws EventException;

	/**
	 * Operating Payable Rental Invoice Creation : creating Master Data Model for regstering AP<br>
	 * 
	 * @param String invNo
	 * @param PayableRentalCostVO payableRentalCostVO
	 * @param SignOnUserAccount account
	 * @return ApPayInvVO
	 * @exception EventException
	 */
	public ApPayInvVO makeOperatingPayableRentalInvoiceCreateMainBasic(String invNo, PayableRentalCostVO payableRentalCostVO, SignOnUserAccount account) throws EventException;

	/**
	 * Operating Payable Rental Invoice Creation : creating Detail Data Model for regstering AP<br>
	 * 
	 * @param String invNo
	 * @param PayableRentalCostVO payableRentalCostVO
	 * @param SignOnUserAccount account
	 * @return ApPayInvDtlVO[]
	 * @exception EventException
	 */
	public ApPayInvDtlVO[] makeOperatingPayableRentalInvoiceCreateDetailBasic(String invNo, PayableRentalCostVO payableRentalCostVO, SignOnUserAccount account) throws EventException;

	/**
	 * Operating Payable Rental Invoice Creation : updating Register No. after registering AP<br>
	 * 
	 * @param String invNo
	 * @param String invRgstNo
	 * @param PayableRentalCostVO payableRentalCostVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyOperatingPayableRentalInvoiceBasic(String invNo, String invRgstNo, PayableRentalCostVO payableRentalCostVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * modifying Payable invoice to Cancel <br>
	 * 
	 * @param PayableRentalInvoiceCostVO[] payableRentalInvoiceCostVOS
	 * @exception EventException
	 */
	public void modifyPayableRentalChargeBasic(PayableRentalInvoiceCostVO[] payableRentalInvoiceCostVOS) throws EventException;
	
	/**
	 * retrieving for Audit target(BackEndJob)<br>
	 * 
	 * @param PayableRentalCostVO payableRentalCostVO
	 * @param SignOnUserAccount userAccount
	 * @return String
	 * @exception EventException
	 */
	public String searchPayableRentalChargeAuditBackEndBasic(PayableRentalCostVO payableRentalCostVO, SignOnUserAccount userAccount) throws EventException;
	
	
	/**
	 * Charge Creation Batch
	 * 
	 * @param PayableRentalCostVO payableRentalCostVO
	 * @param SignOnUserAccount userAccount
	 * @return String
	 * @throws EventException
	 */
	public String createPayableRentalChargeCreationBatchService(PayableRentalCostVO payableRentalCostVO, SignOnUserAccount userAccount) throws EventException;
	
	
	
}