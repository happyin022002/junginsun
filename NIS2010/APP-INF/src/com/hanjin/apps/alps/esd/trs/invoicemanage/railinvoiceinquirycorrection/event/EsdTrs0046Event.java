/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EsdTrs0046Event.java
*@FileTitle : Service Provider로부터 W/O실행 이후 비용 지불을 위한 Invoice를 일괄 Confirm하거나, Confirmed or Interfaced Invoice를 취소하는 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2007-01-30
*@LastModifier : poong_yeon
*@LastVersion : 1.0 
* 2007-01-30 poong_yeon
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.invoicemanage.railinvoiceinquirycorrection.event;

import com.hanjin.apps.alps.esd.trs.invoicemanage.railinvoiceinquirycorrection.vo.SearchRailInvoiceInquiryCorrectionListConditionVO;
import com.hanjin.apps.alps.esd.trs.invoicemanage.railinvoiceinquirycorrection.vo.TrsTrspRailInvWrkVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;




/**
 * ESD_TRS_0046 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_0046HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author poong_yeon
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTrs0046Event extends EventSupport {
	
	private SearchRailInvoiceInquiryCorrectionListConditionVO inquiryConditionVO = null;

	/** trs_trsp_rail_inv_wrk Table  Value Object */
	private TrsTrspRailInvWrkVO   trsTrspRailInvWrkVO  = null;

	/** trs_trsp_rail_inv_wrk Multi Action을 위한 Collection */
	private TrsTrspRailInvWrkVO[] trsTrspRailInvWrkVOs = null;
	

	public EsdTrs0046Event(){}


	public SearchRailInvoiceInquiryCorrectionListConditionVO getInquiryConditionVO() {
		return inquiryConditionVO;
	}
	public void setInquiryConditionVO(SearchRailInvoiceInquiryCorrectionListConditionVO inquiryConditionVO) {
		this.inquiryConditionVO = inquiryConditionVO;
	}
	
	
	public TrsTrspRailInvWrkVO getTrsTrspRailInvWrkVO() {
		return trsTrspRailInvWrkVO;
	}
	public void setTrsTrspRailInvWrkVO(TrsTrspRailInvWrkVO trsTrspRailInvWrkVO) {
		this.trsTrspRailInvWrkVO = trsTrspRailInvWrkVO;
	}


	public TrsTrspRailInvWrkVO[] getTrsTrspRailInvWrkVOs() {
		return trsTrspRailInvWrkVOs;
	}
	public void setTrsTrspRailInvWrkVOs(TrsTrspRailInvWrkVO[] trsTrspRailInvWrkVOs) {
		this.trsTrspRailInvWrkVOs = trsTrspRailInvWrkVOs;
	}

	public String getEventName() {
		return "EsdTrs0046Event";
	}

	public String toString() {
		return "EsdTrs0046Event";
	}

}
