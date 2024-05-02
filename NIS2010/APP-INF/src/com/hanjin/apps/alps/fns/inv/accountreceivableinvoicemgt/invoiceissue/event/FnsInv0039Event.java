/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsInv0039Event.java
*@FileTitle : (Korea) Invoice Issue
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 김세일
*@LastVersion : 1.0
* 2009.05.04 김세일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.KORInvoiceVO;


/**
 * FNS_INV_0039 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_INV_0039HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author saeil kim
 * @see FNS_INV_0039HTMLAction 참조
 * @since J2EE 1.4
 */

public class FnsInv0039Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private KORInvoiceVO kORInvoiceVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private KORInvoiceVO[] kORInvoiceVOs = null;
	
	/* Column Info */
	private String blSrcNo = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String arOfcCd = null;
	/* Column Info */
	private String emailSubject = null;
	/* Column Info */
	private String sendFlg = null;
	/* Column Info */
	private String pageType = null;
	
	public FnsInv0039Event(){}
	
	public void setKORInvoiceVO(KORInvoiceVO kORInvoiceVO){
		this. kORInvoiceVO = kORInvoiceVO;
	}

	public void setKORInvoiceVOS(KORInvoiceVO[] kORInvoiceVOs){
		this. kORInvoiceVOs = kORInvoiceVOs;
	}

	public KORInvoiceVO getKORInvoiceVO(){
		return kORInvoiceVO;
	}

	public KORInvoiceVO[] getKORInvoiceVOS(){
		return kORInvoiceVOs;
	}

	public String getBlSrcNo() {
		return blSrcNo;
	}

	public void setBlSrcNo(String blSrcNo) {
		this.blSrcNo = blSrcNo;
	}

	public String getInvNo() {
		return invNo;
	}

	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}

	public String getArOfcCd() {
		return arOfcCd;
	}

	public void setArOfcCd(String arOfcCd) {
		this.arOfcCd = arOfcCd;
	}

	public String getEmailSubject() {
		return emailSubject;
	}

	public void setEmailSubject(String emailSubject) {
		this.emailSubject = emailSubject;
	}

	public String getSendFlg() {
		return sendFlg;
	}

	public void setSendFlg(String sendFlg) {
		this.sendFlg = sendFlg;
	}

	public String getPageType() {
		return pageType;
	}

	public void setPageType(String pageType) {
		this.pageType = pageType;
	}

}