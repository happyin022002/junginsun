/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ARInvoiceCorrectionBackEndBCImpl.java
*@FileTitle : Unmatched Revenue VVD Inquiry BackEndJob
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.22
*@LastModifier : 정휘택
*@LastVersion : 1.0
* 2009.10.22 정휘택
* 1.0 Creation
* --------------------------------------------------------
* History
* 2011.08.04 오요한 [CHM-201111930] Invoice Issue 프로그램 개선  
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.basic;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.basic.BookingARCreationBC;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.basic.BookingARCreationBCImpl;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.integration.InvoiceIssueDBDAO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.GeneralInvoiceVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvoiceIssueSndToErpVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvIssVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;

/**
 * ALPS-AccountReceivableInvoiceMgt Business Logic Basic Command implementation<br>
 * - ALPS-AccountReceivableInvoiceMgt 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Jung Hwi Taek
 * @see InvoiceIssueDBDAO 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class InvoiceIssueBackEndJob extends BackEndCommandSupport {
	
	private static final long serialVersionUID = -8569053557386320221L;
	
	GeneralInvoiceVO genInvVo = null;
	
	@SuppressWarnings("unused")
	private String userId = "";
	
	/**
	 * @param genInvVo
	 */
	public void setGenInvVo(GeneralInvoiceVO genInvVo) {
		this.genInvVo = genInvVo;
	}

	/**
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * FNS_INV_0034_01 : Paper Issue, Goto Send <br>
	 * 구주지역, 서남아 일부지역, 북중국지역의 Invoice 를 발행함.(BackEndJob) <br>
	 * 
	 * @return InvoiceIssueSndToErpVO 
	 * @exception EventException
	 */
	@Override
	public InvoiceIssueSndToErpVO doStart() throws Exception {
		
		InvoiceIssueBC command = new InvoiceIssueBCImpl();
		BookingARCreationBC command2 = new BookingARCreationBCImpl();

		try {
			/*
			invoice no 채번	searchInvoiceMaxSequence			
			ISSUE TEMP 테이블 INSERT	addInvoiceIssueFilter
			INV_AR_ISS 테이블 INSERT	addInvoiceIssue
			INV_AR_CHG 테이블 UPDATE	modifyInvoiceCharge
			INV_AR_ISS_DTL 테이블 INSERT	addInvoiceIssueDetail			
			INV_AR_MN 테이블 UPDATE (ISSUE FLAG, CLEAR FLAG, INV REF NO, TEU, FEU)	modifyInvoiceMainByBkgNo			
			INV_AR_MN 테이블 UPDATE(DUE DATE 재계산)	modifyDuedateInvoiceMainByIfNo			
			INV_AR_CNTR 테이블 DELETE	removeInvoiceContainer			
			INV_AR_CNTR 테이블 INSERT	addInvoiceContainer			
			ISSUE TEMP 테이블 DELETE	removeInvoiceIssueTemp
			*/
			log.error("InvoiceIssueBackEndJob========================>>>>>>>>>>>>>>>start");			
			InvIssVO invIssVO = new InvIssVO();
			//Invoice issue 실행
			// CHM-201111930 - Invoice Issue 프로그램 개선  
			//invIssVO = command.searchInvoiceMaxSequence(genInvVo);
			invIssVO = command.manageIssueTargetMgt(genInvVo);
			log.error("InvoiceIssueBackEndJob========================>>>>>>>>>>>>>>>1");
			//INV_AR_CHG 테이블 UPDATE
			command2.modifyInvoiceCharge(invIssVO);

			log.error("InvoiceIssueBackEndJob========================>>>>>>>>>>>>>>>2");
			//INV_AR_ISS_DTL 테이블 INSERT
			command.addInvoiceIssueDetail(invIssVO);
			log.error("InvoiceIssueBackEndJob========================>>>>>>>>>>>>>>>3");
			//INV_AR_MN 테이블 UPDATE
			command2.modifyInvoiceMain(invIssVO);
			log.error("InvoiceIssueBackEndJob========================>>>>>>>>>>>>>>>4");
			//inv_no 조회, ISSUE TEMP 테이블 DELETE 한다.
			
			// CHM-201111930 - Invoice Issue 프로그램 개선  
			InvoiceIssueSndToErpVO vo = command.manageArMainForInvoiceIssue(invIssVO);						

			//2017.11.15 인도이외 지역 Taxable Charge 의 GST 정보 update
			if(("BOMSC").equals(invIssVO.getOfcCd())) {
				command2.modifyNoINDTaxableChg(vo, invIssVO);
			}
			
			log.error("InvoiceIssueBackEndJob========================>>>>>>>>>>>>>>>end");
			return vo;
		} catch (EventException de) {
			log.error("err2=============>> " + de.toString(), de);
			throw new EventException(de.getMessage(),de);
		} catch (Exception de) {
			log.error("err3=============>> " + de.toString(), de);
			throw new EventException(de.getMessage(),de);
		}
	}
}