/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdLea0015Event.java
*@FileTitle : Expense Report Invoice Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.22
*@LastModifier : 전재홍
*@LastVersion : 1.0
* 2009.09.22 전재홍
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.SearchAccrualBatchResultInvoiceInquiryVO;


/**
 * ESD_LEA_0015 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_LEA_0015HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jeon Jae Hong
 * @see ESD_LEA_0015HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdLea0015Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchAccrualBatchResultInvoiceInquiryVO searchAccrualBatchResultInvoiceInquiryVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchAccrualBatchResultInvoiceInquiryVO[] searchAccrualBatchResultInvoiceInquiryVOs = null;

	public EsdLea0015Event(){}
	
	public void setSearchAccrualBatchResultInvoiceInquiryVO(SearchAccrualBatchResultInvoiceInquiryVO searchAccrualBatchResultInvoiceInquiryVO){
		this. searchAccrualBatchResultInvoiceInquiryVO = searchAccrualBatchResultInvoiceInquiryVO;
	}

	public void setSearchAccrualBatchResultInvoiceInquiryVOS(SearchAccrualBatchResultInvoiceInquiryVO[] searchAccrualBatchResultInvoiceInquiryVOs){
		this. searchAccrualBatchResultInvoiceInquiryVOs = searchAccrualBatchResultInvoiceInquiryVOs;
	}

	public SearchAccrualBatchResultInvoiceInquiryVO getSearchAccrualBatchResultInvoiceInquiryVO(){
		return searchAccrualBatchResultInvoiceInquiryVO;
	}

	public SearchAccrualBatchResultInvoiceInquiryVO[] getSearchAccrualBatchResultInvoiceInquiryVOS(){
		return searchAccrualBatchResultInvoiceInquiryVOs;
	}

}