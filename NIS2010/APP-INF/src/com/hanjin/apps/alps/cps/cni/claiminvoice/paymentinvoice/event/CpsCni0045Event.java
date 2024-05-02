/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CpsCni0045Event.java
 *@FileTitle : [CPS_CNI_0045] Invoice Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.05
 *@LastModifier : 진윤오
 *@LastVersion : 1.0
 * 2009.10.05 진윤오 
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.claiminvoice.paymentinvoice.event;


import com.hanjin.apps.alps.cps.cni.claiminvoice.paymentinvoice.vo.PaymentInvoiceInfoVO;
import com.hanjin.apps.alps.cps.cni.codemgt.codemgt.event.CPS_CNI_0042HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * [CPS_CNI_0045] Invoice Creation
 * @author 진윤오
 * @see CPS_CNI_0042HTMLAction 참조
 * @since J2EE 1.4
 */

public class CpsCni0045Event extends EventSupport  {

	private static final long serialVersionUID = 1L;
	
	private PaymentInvoiceInfoVO paymentInvoiceInfoVO = null;


	public PaymentInvoiceInfoVO getPaymentInvoiceInfoVO() {
		return paymentInvoiceInfoVO;
	}

	public void setPaymentInvoiceInfoVO(PaymentInvoiceInfoVO paymentInvoiceInfoVO) {
		this.paymentInvoiceInfoVO = paymentInvoiceInfoVO;
	}

	private String cgoClmNo = null;
	
	private String hdlrUsrId = null;
	
	private String cgoClmPayNo = null;

	public String getCgoClmNo() {
		return cgoClmNo;
	}

	public void setCgoClmNo(String cgoClmNo) {
		this.cgoClmNo = cgoClmNo;
	}

	public String getHdlrUsrId() {
		return hdlrUsrId;
	}

	public void setHdlrUsrId(String hdlrUsrId) {
		this.hdlrUsrId = hdlrUsrId;
	}

	public String getCgoClmPayNo() {
		return cgoClmPayNo;
	}

	public void setCgoClmPayNo(String cgoClmPayNo) {
		this.cgoClmPayNo = cgoClmPayNo;
	}
	


}