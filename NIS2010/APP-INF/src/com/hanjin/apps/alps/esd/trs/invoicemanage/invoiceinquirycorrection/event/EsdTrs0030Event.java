/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_030Event.java
*@FileTitle : Service Provider로부터 W/O실행 이후 비용 지불을 위한 Invoice를 일괄 Confirm하거나, Confirmed or Interfaced Invoice를 취소하는 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2007-01-26
*@LastModifier : poong_yeon
*@LastVersion : 1.0 
* 2007-01-26 poong_yeon
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceinquirycorrection.event;

import com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceinquirycorrection.vo.SearchInvoiceInquiryVO;
import com.hanjin.framework.support.layer.event.EventSupport;

import com.hanjin.syscommon.common.table.TrsTrspInvWrkVO;


/**
 * ESD_TRS_030 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_030HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author poong_yeon
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTrs0030Event extends EventSupport {

	/** trs_trsp_inv_wrk Table  Value Object */
	private TrsTrspInvWrkVO[] trsTrspInvWrkVOs = null;
	
	private SearchInvoiceInquiryVO searchInvoiceInquiryVO = null;

	public void setTrsTrspInvWrkVOs(TrsTrspInvWrkVO[] trsTrspInvWrkVOs) {
		this.trsTrspInvWrkVOs = trsTrspInvWrkVOs;
	}

	public TrsTrspInvWrkVO[] getTrsTrspInvWrkVOs() {
		return trsTrspInvWrkVOs;
	}

	public void setSearchInvoiceInquiryVO(SearchInvoiceInquiryVO searchInvoiceInquiryVO) {
		this.searchInvoiceInquiryVO = searchInvoiceInquiryVO;
	}

	public SearchInvoiceInquiryVO getSearchInvoiceInquiryVO() {
		return searchInvoiceInquiryVO;
	}
	


	

}
