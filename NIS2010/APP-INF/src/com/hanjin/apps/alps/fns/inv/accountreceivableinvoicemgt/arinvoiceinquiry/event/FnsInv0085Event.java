/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0085Event.java
*@FileTitle : (India) Freight and Charge List
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.09
*@LastModifier : 정휘택
*@LastVersion : 1.0
* 2009.06.09 정휘택
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceInquiryInPutVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * FNS_INV_0085 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0085HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jung Hwi Taek
 * @see FNS_INV_0085HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsInv0085Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private ARInvoiceInquiryInPutVO indBkgVO = null;
	
//	private String vvd = "";
//	private String bnd = "";
//	private String port = "";
//	private String saDt1 = "";
//	private String saDt2 = "";
	
//	public String getVvd() {
//		return vvd;
//	}
//	public void setVvd(String vvd) {
//		this.vvd = vvd;
//	}
//	public String getBnd() {
//		return bnd;
//	}
//	public void setBnd(String bnd) {
//		this.bnd = bnd;
//	}
//	public String getPort() {
//		return port;
//	}
//	public void setPort(String port) {
//		this.port = port;
//	}
	// 2010.09.06 추가 KHH
	public ARInvoiceInquiryInPutVO getIndBkgVO() {
		return indBkgVO;
	}

	public void setIndBkgVO(ARInvoiceInquiryInPutVO indBkgVO) {
		this.indBkgVO = indBkgVO;
	}
	

}