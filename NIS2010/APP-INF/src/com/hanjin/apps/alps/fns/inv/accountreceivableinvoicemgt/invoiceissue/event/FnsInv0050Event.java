/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0050Event.java
*@FileTitle : Customer Preferable Report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.18
*@LastModifier : 한동훈
*@LastVersion : 1.0
* 2009.08.18 한동훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.event;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.CPRTInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.CPRTInvoiceVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.TemplateVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * FNS_INV_0050 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0050HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Han Dong Hoon
 * @see FNS_INV_0050HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsInv0050Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CPRTInvoiceVO cPRTInvoiceVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CPRTInvoiceVO[] cPRTInvoiceVOs = null;
		
	private CPRTInputVO cPRTInputVO = null;
	
	private String rptItmId = null;
	
	private String rptTmpltNm = null;
	
	private String custNm = null;
	
	private String blNo = null;
	private String scNo = null;
	private String rfaNo = null;
		
	private TemplateVO templateVO = null;
	private String ofcCd = null;

	public FnsInv0050Event(){}
	
	public void setCPRTInvoiceVO(CPRTInvoiceVO cPRTInvoiceVO){
		this. cPRTInvoiceVO = cPRTInvoiceVO;
	}

	public void setCPRTInvoiceVOS(CPRTInvoiceVO[] cPRTInvoiceVOs){
		this. cPRTInvoiceVOs = cPRTInvoiceVOs;
	}

	public CPRTInvoiceVO getCPRTInvoiceVO(){
		return cPRTInvoiceVO;
	}

	public CPRTInvoiceVO[] getCPRTInvoiceVOS(){
		return cPRTInvoiceVOs;
	}

	public CPRTInputVO getCPRTInputVO() {
		return cPRTInputVO;
	}

	public void setCPRTInputVO(CPRTInputVO inputVO) {
		cPRTInputVO = inputVO;
	}

	public String getRptItmId() {
		return rptItmId;
	}

	public void setRptItmId(String rptItmId) {
		this.rptItmId = rptItmId;
	}

	public String getCustNm() {
		return custNm;
	}

	public void setCustNm(String custNm) {
		this.custNm = custNm;
	}

	public String getRptTmpltNm() {
		return rptTmpltNm;
	}

	public void setRptTmpltNm(String rptTmpltNm) {
		this.rptTmpltNm = rptTmpltNm;
	}

	public String getBlNo() {
		return blNo;
	}

	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	public String getScNo() {
		return scNo;
	}

	public void setScNo(String scNo) {
		this.scNo = scNo;
	}
	public String getrfaNo() {
		return rfaNo;
	}

	public void setrfaNo(String rfaNo) {
		this.rfaNo = rfaNo;
	}

	public TemplateVO getTemplateVO() {
		return templateVO;
	}

	public void setTemplateVO(TemplateVO templateVO) {
		this.templateVO = templateVO;
	}

	public String getOfcCd() {
		return ofcCd;
	}

	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	
	
	
}